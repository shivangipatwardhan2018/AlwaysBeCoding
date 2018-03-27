package BinaryTrees;


import model.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MostFrequentBinaryTreeSum {

    List<Integer> ls = new ArrayList<>();
    int max = -1;

    private int[] findFrequentTreeSum(TreeNode root) {

        HashMap<Integer, Integer> frequency = new HashMap<>();
        findFrequentTreeSumHelper(root, frequency);
        int[] res = new int[ls.size()];
        for (int i = 0; i < res.length; i++)
            res[i] = ls.get(i);
        return res;
    }


    public int findFrequentTreeSumHelper(TreeNode root, HashMap<Integer, Integer> frequency) {
            if(root == null){
                return 0;
            }
            int leftTotal = findFrequentTreeSumHelper(root.getLeft(), frequency);
            int rightTotal = findFrequentTreeSumHelper(root.getRight(), frequency);
            int total = root.getValue() + leftTotal + rightTotal;
            int count =  (frequency.containsKey(total)) ? frequency.get(total) + 1 : 1;
            frequency.put(total, count);
            if(count > max){
                ls.clear();
                ls.add(total);
                max = count;
            }else if( count == max){
                 ls.add(total);
            }
            return total;
        }

        public static void main(String[] args){
            MostFrequentBinaryTreeSum fd = new MostFrequentBinaryTreeSum();

            System.out.println(" Printing Sums ");
            TreeNode root = new TreeNode(5);
            root.setLeft(new TreeNode(2));
            root.setRight(new TreeNode(-3));
            fd.findFrequentTreeSum(root);

            System.out.println(" Printing Sums ");
            TreeNode root2 = new TreeNode(5);
            root2.setLeft(new TreeNode(2));
            root2.setRight(new TreeNode(-5));
            fd.findFrequentTreeSum(root2);
        }


}
