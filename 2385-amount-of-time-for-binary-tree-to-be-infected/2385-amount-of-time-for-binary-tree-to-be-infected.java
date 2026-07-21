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
 class Pair{
    TreeNode node;
    int dist;
    Pair(TreeNode node,int dist){
        this.node = node;
        this.dist = dist;
    }
 }
class Solution {
    static TreeNode start;
    static HashMap<TreeNode,TreeNode> parent;
    public int amountOfTime(TreeNode root, int target) {
        start = null;
        parent = new HashMap<>();
        dfs(root,target);
      HashSet<TreeNode> burned = new HashSet<>();
      Queue<Pair> q = new LinkedList<>();
      q.add(new Pair(start,0));
      burned.add(start);
      int time=0;
      while(q.size()>0){
        Pair front = q.remove();
        int dist = front.dist;
        TreeNode node = front.node;
        time = Math.max(dist,time);
        if(node.left!=null && !burned.contains(node.left)) {
            q.add(new Pair(node.left,dist+1));
            burned.add(node.left);
        }
        if(node.right!=null && !burned.contains(node.right)) {
            q.add(new Pair(node.right,dist+1));
            burned.add(node.right);
        }
          if(parent.containsKey(node) && !burned.contains(parent.get(node))) {
            q.add(new Pair(parent.get(node),dist+1));
            burned.add(parent.get(node));
        }
        
        


      
    } 
    return time;
       
    }
        public void dfs(TreeNode root,int target){
            if(root==null) return ;
            if(root.val==target) start = root;
            if(root.left!=null) parent.put(root.left,root);
                        if(root.right!=null) parent.put(root.right,root);
                        dfs(root.left,target);
                        dfs(root.right,target);

        }
    
}