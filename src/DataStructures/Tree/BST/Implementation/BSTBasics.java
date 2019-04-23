package DataStructures.Tree.BST.Implementation;

import javax.swing.text.MutableAttributeSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BSTBasics {
    private TreeNode root;

    public void insertNode(int val){
        //TreeNode root = new TreeNode(val);
        root = insertNode(root, val);
    }

    public TreeNode insertNode(TreeNode root, int val){ // insertion and search is O(h) where h is height of the tree, it degrades in case skewed tree, time complexity turns into O(N).
        if(root==null){
            root = new TreeNode(val);
            return root;
        }
        if(val<root.val) root.left = insertNode(root.left,val);
        else if (val > root.val) root.right = insertNode(root.right, val);
        return root;
    }
    public void inOrderTraversal(){
        inOrderTraversal(root);
    }

    private void inOrderTraversal(TreeNode root){  // inOrder gives you sorted result when it's BST.
        if (root==null) return;
        inOrderTraversal(root.left);
        System.out.print(root.val + " ");
        inOrderTraversal(root.right);
    }

    public void preOrderTraversal(){
        preOrderTraversal(root);
    }

    private void preOrderTraversal(TreeNode root){  // First val is root in preOrderTraversal.
        if (root==null) return;
        System.out.print(root.val + " ");
        inOrderTraversal(root.left);
        inOrderTraversal(root.right);
    }

    public boolean search(int val){
        return search(root, val);
    }
    private boolean search(TreeNode root, int val){
        if(root==null) return false;
        if(root.val ==val) return true;
        if(val > root.val) return search(root.right,val);
        else return search(root.left,val);
    }

    public int countNodes(){
        return countNodes(root);
    }

    private int countNodes(TreeNode root){
        if(root==null) return 0;
        int result=0;
        result +=countNodes(root.left);
        result +=countNodes(root.right);
        return result+1;
    }

    public int findMinimum(){
        TreeNode minNode = findMinimum(root);
        if(minNode==null) return -1;
        else return minNode.val;
    }

    private TreeNode findMinimum(TreeNode root){
        if (root==null) return null;
        else{
            while (root.left!=null) root=root.left;
        }
        return root;
    }


    public int findMaximum(){
        TreeNode maxNode = findMaximum(root);
        if(maxNode==null) return -1;
        else return maxNode.val;
    }

    private TreeNode findMaximum(TreeNode root){
        if(root==null) return null;
        else{
            while (root.right!=null) root= root.right;
        }
        return root;
    }

    public int findHeight(){
        return findHeight(root);

    }
    private int findHeight(TreeNode root){
        if(root == null) return -1;
        int left = findHeight(root.left);
        int right = findHeight(root.right);
        return Math.max(left,right)+1;
    }

    public void levelOrder(){
        levelOrder(root);
    }

    private void levelOrder(TreeNode root){
        if (root==null) return;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            TreeNode current = que.poll();
            System.out.print(current.val + " ");
            if(current.left!=null) que.add(current.left);
            if(current.right!=null) que.add(current.right);
        }
    }

    public void zigzagLevelOrder(){
        zigzagLevelOrder(root);
    }

    private void zigzagLevelOrder(TreeNode root){
        Stack<TreeNode> stk1 = new Stack<>();
        Stack<TreeNode> stk2 = new Stack<>();
        stk1.push(root);
        while(!stk1.isEmpty()|| !stk2.isEmpty()){
            while(!stk1.isEmpty()){
                TreeNode curr = stk1.pop();
                System.out.print(curr.val + " ");
                if(curr.right!=null){
                    stk2.push(curr.right);
                }
                if(curr.left!=null){
                    stk2.push(curr.left);
                }
            }

            while(!stk2.isEmpty()){
                TreeNode curr = stk2.pop();
                System.out.print(curr.val + " ");
                if(curr.left!=null){
                    stk1.push(curr.left);
                }
                if(curr.right!=null){
                    stk1.push(curr.right);
                }
            }
        }

    }

}
