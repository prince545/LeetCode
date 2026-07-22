/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    static boolean check;
    static int size;
      private static int size(TreeNode root) {
      if(root==null) return 0;
       return 1+size(root.left)+size(root.right);
    }
    public boolean isCompleteTree(TreeNode root) {
        check = true;
         size = size(root);
        int levels = 1;
         dfs(root,levels);
         return check;
        
    }
    public void dfs(TreeNode root,int levels){
        if(root==null || !check) return;
        if(levels>size) check = false;
        dfs(root.left,2*levels);
        dfs(root.right,2*levels+1);

    }
}