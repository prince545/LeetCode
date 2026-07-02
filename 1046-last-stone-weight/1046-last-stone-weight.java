class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++){
            pq.add(stones[i]);
        }
        while(pq.size()>1){
            int y = pq.remove();
            int x = pq.remove();
            if(x!=y) pq.add(y-x); 
        }
         return pq.isEmpty() ? 0 : pq.peek();
    }
    
}