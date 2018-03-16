package BinaryTrees;
import model.TreeNode;

/**
 * Reconstruct a binary tree from its inorder and preorder traversals.
 *
 * Signature of expected method:
 *
 *    public static <T> TreeNode<T> reconstruct(T[] inorder, T[] preorder,
 *			                                    Comparator<T> comparator) {...}
 *
 	Algorithm: buildTree()
     1) Pick an element from Preorder. Increment a Preorder Index Variable (preIndex in below code) to pick next element in next recursive call.
     2) Create a new tree node tNode with the data as picked element.
     3) Find the picked element’s index in Inorder. Let the index be inIndex.
     4) Call buildTree for elements before inIndex and make the built tree as left subtree of tNode.
     5) Call buildTree for elements after inIndex and make the built tree as right subtree of tNode.
     6) return tNode.
 *
 */
public class ReconstructBinaryTree {


    private static int preIndex = 0;

    public static <T> TreeNode reconstruct(int[] inorder, int[] preorder) {
        return reconstruct(inorder, preorder, 0, inorder.length-1);
    }

    private static TreeNode reconstruct(int[] inorder, int[] preorder, int start, int end) {


        if (start > end){
            return null;
        }

        int rootNode = preorder[preIndex];
        preIndex++;
        TreeNode root = new TreeNode(rootNode);

        if (start == end){
            return root;
        }

        int inIndex = 0;
        for(int i = start; i <= end; i++){
            if(inorder[i] == rootNode){
                inIndex = i;
                break;
            }
        }


        root.setLeft(reconstruct(inorder, preorder, start, inIndex - 1));
        root.setRight(reconstruct(inorder, preorder, inIndex+1, end));
        return root;
    }

    public static void main(String args[])
    {

        int in[] = new int[]{4, 2, 5, 1, 6, 3};
        int pre[] = new int[]{1, 2, 4, 5, 3, 6};
        int len = in.length;
        TreeNode soln = reconstruct(in, pre, 0, len - 1);

        System.out.println("Inorder traversal of constructed tree is : ");
        BinaryTreeTraversal.inorderTraversal(soln);
    }

}
