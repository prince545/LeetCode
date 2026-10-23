class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;
        List<List<Integer>> revAdj = new ArrayList<>();
        for(int i=0;i<n;i++) revAdj.add(new ArrayList<>());
        int[] indegree = new int[n];
        // reverse the graph
        for(int i=0;i<n;i++){
            for(int ele : graph[i]){
            // in original graph , edge is from i -> ele
            // in reverse graph , edge is from ele -> i
            revAdj.get(ele).add(i);
            indegree[i]++;
        }
        }
        // kahn's algo.
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0) q.add(i);
         }
         
         List<Integer> ans = new ArrayList<>();
         while(q.size()>0){
            int front = q.remove();
            ans.add(front);
            for(int ele : revAdj.get(front)){
                indegree[ele]--;
                if(indegree[ele]==0) q.add(ele);
            }

         }
         Collections.sort(ans);
         return ans;

    }
}