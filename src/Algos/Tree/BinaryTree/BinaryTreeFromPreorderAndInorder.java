/* Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
*/

package Algos.Tree.BinaryTree;

import java.util.HashMap;
import DataStructures.Tree.BST.Implementation.TreeNode;

public class BinaryTreeFromPreorderAndInorder {
    private HashMap<Integer, Integer> inOrderMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inOrderMap = new HashMap<Integer, Integer>();
        for (int i=0; i<inorder.length;i++){
            inOrderMap.put(inorder[i],i);
        }
        return helper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    private TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
        if(preStart>preEnd || inStart> inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRootIndex = inOrderMap.get(root.val);
        int numsLeft = inRootIndex - inStart;

        root.left= helper(preorder, preStart+1 , preStart+numsLeft, inorder, inStart, inRootIndex-1);
        root.right= helper(preorder, preStart+numsLeft+1 , preEnd, inorder, inRootIndex+1, inEnd);
        return root;
    }


    public static void main(String [] Args){
        int[] preOrder =  new int[] {3,9,20,15,7};
        int[] inOrder = new int[] {9,3,15,20,7};

        BinaryTreeFromPreorderAndInorder preToIn = new BinaryTreeFromPreorderAndInorder();
        TreeNode node = preToIn.buildTree(preOrder,inOrder);
        preToIn.helperTest(node);


    }

    private void helperTest(TreeNode root){
        if(root == null) return;
        helperTest(root.left);
        System.out.print(root.val + " ");
        helperTest(root.right);
    }

}
