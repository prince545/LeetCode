
class Solution {
     class Triplet{
    int node;
    int cost;
    int stops;
    Triplet(int node, int cost, int stops){
        this.node = node;
        this.cost = cost;
        this.stops = stops;
    }
    

}

     class Pair{
    int node;
    int cost;
    Pair(int node, int cost){
        this.node = node;
        this.cost = cost;
    }

}

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<flights.length;i++){
            int u = flights[i][0], v = flights[i][1], cost = flights[i][2];
            adj.get(u).add(new Pair(v,cost));
        }
        int[] ans = new int[n];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[src] = 0;

        Queue<Triplet> q = new LinkedList<>();
        q.add(new Triplet(src,0,0));
        while(q.size()>0){
            Triplet top = q.remove();
            int node = top.node, cost = top.cost, stops = top.stops;

            if(stops == k+1) continue;
            for(Pair p : adj.get(node)){
                int totalCost = cost + p.cost;
                if(totalCost < ans[p.node]){
                    ans[p.node] = totalCost;
                    q.add(new Triplet(p.node,totalCost,stops+1));
                }
            }

        }
        if(ans[dst] == Integer.MAX_VALUE) return -1; 
        return ans[dst];

        
    }
}