package DataStructures.Tree.BST.Implementation;

public class BSTMain {

    public static void main(String [] Args){
        BSTBasics bst = new BSTBasics();
        bst.insertNode(10);
        bst.insertNode(4);
        bst.insertNode(13);
        bst.insertNode(12);
        bst.insertNode(2);
        bst.insertNode(16);
        bst.insertNode(6);

        bst.inOrderTraversal();
        System.out.println();
        bst.preOrderTraversal();
        System.out.println();
        System.out.println(bst.search(13));
        System.out.println(bst.search(20));
        System.out.println(bst.countNodes());
        System.out.println(bst.findMinimum());
        System.out.println(bst.findMaximum());
        System.out.println(bst.findHeight());
        bst.levelOrder();
        System.out.println();
        bst.zigzagLevelOrder();
        System.out.println();



    }

}
