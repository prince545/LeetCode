class Triplet implements Comparable<Triplet>{
    int ele;
    int row;
    int col;
    Triplet(int ele,int row,int col){
        this.ele = ele;
        this.row = row;
        this.col = col;

    }
    @Override
public int compareTo(Triplet t) {
    return Integer.compare(this.ele, t.ele);
}
}
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        int currMax = Integer.MIN_VALUE;
        int currMin = Integer.MAX_VALUE;
        for(int i=0;i<nums.size();i++){
            pq.add(new Triplet(nums.get(i).get(0),i,0));
            currMax = Math.max(currMax,nums.get(i).get(0));
            currMin = Math.min(currMin,nums.get(i).get(0));

        }
        int a =currMin,b=currMax;
        while(true){
            Triplet top = pq.remove();
            int ele = top.ele,row = top.row, col = top.col;
            if ((currMax - ele < b - a) ||
    (currMax - ele == b - a && ele < a)) {
    a = ele;
    b = currMax;
}
            if(col+1 == nums.get(row).size()) break;
            int next = nums.get(row).get(col+1);
            currMax = Math.max(currMax,next);
            pq.add(new Triplet(next,row,col+1));
        }
      int[] ans = new int[2];
      ans[0] = a;
      ans[1] = b;
      return ans;
    }
}