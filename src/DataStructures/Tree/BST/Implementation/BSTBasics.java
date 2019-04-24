package DataStructures.Tree.BST.Implementation;

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

    public void postOrderTraversal(){
        postOrderTraversal(root);
    }

    private void postOrderTraversal(TreeNode root){  // First val is root in preOrderTraversal.
        if (root==null) return;
        inOrderTraversal(root.left);
        inOrderTraversal(root.right);
        System.out.print(root.val + " ");
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

    private void zigzagLevelOrder(TreeNode node){
        Stack<TreeNode> stk1 = new Stack<>();
        Stack<TreeNode> stk2 = new Stack<>();
        stk1.push(node);
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

    public int countDeepestLevelLeafNodes(){
        int counter=0;

        return countDeepestLevelLeafNodes(root,findHeight());
    }

    private int countDeepestLevelLeafNodes(TreeNode node, int depth){
        if (node==null) return 0;
        if(depth==0) return 1;
        int result=0;
        result +=countDeepestLevelLeafNodes(node.left, depth-1);
        result +=countDeepestLevelLeafNodes(node.right , depth-1);
        return result;
    }

    private int countLeaf=0;
    public int countLeafNodes(){
        countLeaf=0;
        return countLeafNodes(root);
    }

    private int countLeafNodes(TreeNode node){
        if(node==null) return 0;
        if(node.left==null && node.right==null) countLeaf++;
        countLeafNodes(node.left);
        countLeafNodes(node.right);
        return countLeaf;
    }

    public void delete(int val){
        root = delete(root,val);
    }

    private TreeNode delete(TreeNode node, int val){
        if(node == null ) return null;

        //check whether node to be deleted is in left or right
        else if (val < node.val) node.left = delete(node.left, val);
        else if (val > node.val) node.right = delete(node.right,val);
        else{
            //if no childs of the node to be deleted
            if(node.left==null && node.right==null) node =null;
            //if no left child
            else if (node.left==null) node=node.right;
            //if no right child
            else if (node.right==null) node= node.left;
            else{ // case 3: two children
                TreeNode tmp = findMaximum(node.left);  //find maximum node of the left subtree
                node.val=tmp.val;                       //copy its data to the target node;
                node.left=delete(node.left,tmp.val);    //delete the node

            }


        }
        return node;
    }


    public boolean isValidBST(){
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max ){
        if(root==null) return true;
        if((min!=null && root.val<min.val) || (max!=null && root.val>max.val))return false;
        return isValidBST(root.left,min,root) && isValidBST(root.right,root,max);
    }

    public boolean isMirror(){            //applicable to any binary tree
        return isMirror(root,root);
    }
    private boolean isMirror(TreeNode node1, TreeNode node2){
        if (node1==null && node2==null) return true;
        if (node1==null || node2==null ) return false;
        return (node1.val==node2.val) && isMirror(node1.left,node2.right)
                && isMirror(node1.right,node2.left);
    }



}
