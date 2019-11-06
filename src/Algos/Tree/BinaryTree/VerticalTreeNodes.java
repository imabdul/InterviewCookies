package Algos.Tree.BinaryTree;

import java.util.*;

/**
 * 987. Vertical Order Traversal of a Binary Tree
 * https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
 *
 * Given a binary tree, return the vertical order traversal of its nodes values.
 *
 * For each node at position (X, Y), its left and right children respectively will be at positions (X-1, Y-1) and (X+1, Y-1).
 *
 * Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes, we report the values of the nodes in order from top to bottom (decreasing Y coordinates).
 *
 * If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.
 *
 * Return an list of non-empty reports in order of X coordinate.  Every report will have a list of values of nodes.
 *
 *
 * Example 1:
 *
 * Input: [3,9,20,null,null,15,7]
 * Output: [[9],[3,15],[20],[7]]
 * Explanation:
 * Without loss of generality, we can assume the root node is at position (0, 0):
 * Then, the node with value 9 occurs at position (-1, -1);
 * The nodes with values 3 and 15 occur at positions (0, 0) and (0, -2);
 * The node with value 20 occurs at position (1, -1);
 * The node with value 7 occurs at position (2, -2).
 *
 * Example 2:
 *
 * Input: [1,2,3,4,5,6,7]
 * Output: [[4],[2],[1,5,6],[3],[7]]
 * Explanation:
 * The node with value 5 and the node with value 6 have the same position according to the given scheme.
 * However, in the report "[1,5,6]", the node value of 5 comes first since 5 is smaller than 6.
 *
 *
 * Note:
 *
 * The tree will have between 1 and 1000 nodes.
 * Each node's value will be between 0 and 1000.
 *
 *
 * Approach HashMap & BFS
 * ---------------------------
 * Have custom class Pair consisting node and it's position x & y.
 * Use Map to store horizontal as key and List of Pairs
 * Use Queue to apply BFS and fill this Map.
 *      - While running BFS, make sure to preserve min and max key values of map
 * Iterate over Map from min key to max key
 *      - sort the List of pairs based on node val when height (y) is same, else do nothing
 *      - iterate over list of pair and fill in the node val to the list
 *      - add the list to result(list of list of Integer)
 *
 * return result
 */


public class VerticalTreeNodes {


    /**
     * custom class to track nodes with their position
     * x & y will tell the position column and depth
     */
    class Pair{
        int x;  //horizontal
        int y;  //depth
        TreeNode node;
        public Pair(TreeNode node, int x, int y) {
            this.node = node;
            this.x = x;
            this.y = y;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer,List<Pair>> map = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0,0));
        int min=0, max=0;
        while (!q.isEmpty()){
            Pair p = q.poll();
            min = Math.min(min,p.x);
            max = Math.max(max,p.x);

            if(!map.containsKey(p.x)){
                map.put(p.x,new ArrayList<>());
            }
            map.get(p.x).add(p);
            if(p.node.left!=null)q.add(new Pair(p.node.left,p.x-1,p.y+1));
            if(p.node.right!=null)q.add(new Pair(p.node.right,p.x+1,p.y+1));
        }

        for(int i=min; i<=max;i++){
            Collections.sort(map.get(i), new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    if(o1.y==o2.y)return o1.node.val-o2.node.val; //only compare nodes val when the height is same
                    else return 0; // if height is different, no need
                }
            });

            List<Integer> list= new ArrayList<>();

            for(int j=0;j<map.get(i).size(); j++){
                list.add(map.get(i).get(j).node.val);
            }
            result.add(list);
        }
        return result;
    }


    public static void main(String[] args){

        TreeNode leaf1 = new TreeNode(15,null,null);
        TreeNode leaf2 = new TreeNode(7,null,null);
        TreeNode parent1 = new TreeNode (9, null, null);
        TreeNode parent2 = new TreeNode(20,leaf1,leaf2);
        TreeNode root1 = new TreeNode(3,parent1,parent2);
        VerticalTreeNodes v = new VerticalTreeNodes();
        List<List<Integer>> result1 = v.verticalTraversal(root1);
        for (List<Integer> list: result1){
            System.out.print(Arrays.asList(list) + " ");  // expected : [[9],[3,15],[20],[7]]
        }
        System.out.println();

        TreeNode lf1 = new TreeNode(4,null,null);
        TreeNode lf2 = new TreeNode(5,null,null);
        TreeNode lf3 = new TreeNode(6,null,null);
        TreeNode lf4 = new TreeNode(7,null,null);
        TreeNode prnt1 = new TreeNode (2, lf1, lf2);
        TreeNode prnt2 = new TreeNode(3,lf3,lf4);
        TreeNode root2 = new TreeNode(1,prnt1,prnt2);
        List<List<Integer>> result2 = v.verticalTraversal(root2);
        for (List<Integer> list: result2){
            System.out.print(Arrays.asList(list) + " "); //expected : [[4],[2],[1,5,6],[3],[7]]
        }


    }

}

class TreeNode{
    TreeNode left, right;
    int val;
    public TreeNode(int val, TreeNode left, TreeNode right){
        this.val=val;
        this.left=left;
        this.right=right;
    }
}
