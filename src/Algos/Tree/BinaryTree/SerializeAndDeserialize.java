
/*
https://www.youtube.com/watch?v=suj1ro8TIVY
https://github.com/bephrem1/backtobackswe/blob/master/Trees%2C%20Binary%20Trees%2C%20%26%20Binary%20Search%20Trees/serializeDeserializeBinaryTree.java
 */

package Algos.Tree.BinaryTree;

import DataStructures.Tree.BST.Implementation.TreeNode;
import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;
import java.io.*;

public class SerializeAndDeserialize {
    /**
     * Iterative/BFS Approach
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return null;
        StringBuilder codec = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        codec.append(root.val + " ");
        q.add(root);

        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.left != null ) {
                q.add(curr.left);
                codec.append(curr.left.val + " ");
            }
            if(curr.left == null ) codec.append("N ");
            if(curr.right != null ) {
                q.add(curr.right);
                codec.append(curr.right.val + " ");
            }
            if(curr.right == null ) codec.append("N ");
        }
        //System.out.println(codec);
        return codec.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data == "N" ) return null;
        String[] dataArr = data.split(" ");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(dataArr[0]));
        q.add(root);
        for(int i=1 ; i<dataArr.length ; i++){
            TreeNode parent = q.poll();
            if(!dataArr[i].equals("N")){
                parent.left=new TreeNode(Integer.parseInt(dataArr[i]));
                q.add(parent.left);
            }
            if(!dataArr[++i].equals("N")){
                parent.right=new TreeNode(Integer.parseInt(dataArr[i]));
                q.add(parent.right);
            }
        }
        return root;
    }

    /**
     * Recursive/DFS Approach
     */

    /*public String serialize(TreeNode root) {
        if (root==null) return "#,";

        String leftSerialize = serialize(root.left);
        String rightSerialize = serialize(root.right);

        return root.val+ ","  + leftSerialize + rightSerialize ;
    }

    public TreeNode deserialize(String s) {
        Queue<String> nodesLeft = new LinkedList<>();
        nodesLeft.addAll(Arrays.asList(s.split(",")));
        return deSerializeHelper(nodesLeft);
    }

    private TreeNode deSerializeHelper(Queue<String> nodesLeft){
        String valueForNode = nodesLeft.poll();
        if(valueForNode.equals("#")) return null;

        TreeNode newNode = new TreeNode(Integer.valueOf(valueForNode));
        newNode.left = deSerializeHelper(nodesLeft);
        newNode.right = deSerializeHelper(nodesLeft);

        return newNode;
    }*/

    /**
     * Driver Program
     */

    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            SerializeAndDeserialize snd = new SerializeAndDeserialize();

            String ret = snd.serialize(root);

            String out = (ret);

            System.out.print(out);

            TreeNode node = snd.deserialize(out);
            System.out.println();

            snd.preOrderHelper(node);
        }
    }

    private void preOrderHelper(TreeNode root){
        if (root == null) return;

        System.out.print(root.val + " ");
        preOrderHelper(root.left);
        preOrderHelper(root.right);

    }

}
