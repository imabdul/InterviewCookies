package Algos.Tree;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize an N-ary tree. An N-ary tree is a rooted tree in which each node has no more than N children. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that an N-ary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 * For example, you may serialize the following 3-ary tree
 *
 * as [1 [3[5 6] 2 4]]. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 *
 * Note:
 * N is in the range of [1, 1000]
 * Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 */

import java.util.*;
public class SerializeDeserializeNaryTree {

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if (root==null) return null;
        Queue<Node> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        sb.append("#");
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                Node curr = q.poll();
                if(curr!=null) {
                    List<Node> children = curr.children;
                    if(children==null || children.size()==0){
                        sb.append("n");
                    }
                    else {
                        for(Node child: children){
                            sb.append(child.val);
                            sb.append(",");
                            q.add(child);
                        }
                    }
                    sb.append("#");
                }
            }
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data == null)   return null;
        Queue<Node> parents = new LinkedList<>();
        String[] elements = data.split("#");
        Node root = new Node(Integer.valueOf(elements[0]), null);
        parents.offer(root);
        for (int i = 1; i < elements.length; i++) {
            Node parent = parents.poll();
            String[] kids = elements[i].split(",");
            List<Node> c = new ArrayList<>();
            for (String kid : kids) {
                if (kid.length() == 0)  continue;
                if (kid.equals("n")) continue;
                Node k = new Node(Integer.valueOf(kid), null);
                c.add(k);
                parents.offer(k);
            }
            parent.children = c;
        }
        return root;
    }


    public static void main(String[] Args){
        SerializeDeserializeNaryTree sdnt = new SerializeDeserializeNaryTree();
        Node root = new Node(1,null);
        Node node3 = new Node(3,null);
        Node node2 = new Node(2,null);
        Node node4 = new Node(4,null);
        Node node5 = new Node(5,null);
        Node node6 = new Node(6,null);

        List<Node> rootList = new ArrayList<>();
        rootList.add(node3);
        rootList.add(node2);
        rootList.add(node4);

        List<Node> val3List = new ArrayList<>();
        val3List.add(node5);
        val3List.add(node6);

        root.children=rootList;
        node3.children=val3List;

        sdnt.serialize(root);
        //sdnt.deserialize(sdnt.serialize(root));

        Queue<Node> q = new LinkedList<>();
        q.add(sdnt.deserialize(sdnt.serialize(root)));
        while(!q.isEmpty()){
            Node node = q.poll();
            System.out.print(node.val + " "); // expected: 1 3 2 4 5 6
            if(node.children!=null || node.children.size()>0){
                for(Node child: node.children){
                    q.add(child);
                }
            }
        }
    }
}


class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}
