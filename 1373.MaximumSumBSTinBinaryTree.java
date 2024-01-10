//leetcode link:https://leetcode.com/problems/maximum-sum-bst-in-binary-tree
//1373. Maximum Sum BST in Binary Tree


///**
// * Definition for a binary tree node.
// * public class TreeNode {
// *     int val;
// *     TreeNode left;
// *     TreeNode right;
// *     TreeNode() {}
// *     TreeNode(int val) { this.val = val; }
// *     TreeNode(int val, TreeNode left, TreeNode right) {
// *         this.val = val;
// *         this.left = left;
// *         this.right = right;
// *     }
// * }
// */
//class Solution {
//    int maxsum=0;
//    public int maxSumBST(TreeNode root)
//    {
//
//        if(root == null) return 0;
//
//        if(isValidBST(root))
//            maxsum = Math.max(maxsum, sumTree(root));
//
//        maxSumBST(root.left);
//        maxSumBST(root.right);
//
//        return maxsum;
//    }
//
//    public boolean isValidBST(TreeNode root) {
//        return isValidBSTUtil(root, Long.MIN_VALUE, Long.MAX_VALUE);
//    }
//
//    private boolean isValidBSTUtil(TreeNode root, long minRange, long maxRange) {
//        if(root == null) return true;
//
//        if(root.val <= minRange || root.val >= maxRange) return false;
//
//        return isValidBSTUtil(root.left, minRange, root.val) && isValidBSTUtil(root.right, root.val, maxRange);
//    }
//
//    public int sumTree(TreeNode root) {
//        if(root == null) return 0;
//
//        return root.val + sumTree(root.left) + sumTree(root.right);
//    }
//}