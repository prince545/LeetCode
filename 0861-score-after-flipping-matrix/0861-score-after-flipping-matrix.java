class Solution {
    public int matrixScore(int[][] arr) {
        int n = arr.length, m = arr[0].length;
        for(int i=0;i<n;i++){
            if(arr[i][0]==0){
                for(int j=0;j<m;j++){
                    arr[i][j] ^=1;
                }
            }
        }
        for(int j=0;j<m;j++){
                    int zeroes = 0,ones = 0;

            for(int i=0;i<n;i++){
                if(arr[i][j]==0) zeroes++;
                else ones++;
            }
            if(zeroes>ones){
                for(int i=0;i<n;i++){
                    arr[i][j]^=1;
                }
            }
        }
        int sum = 0;
        int pow = 1;
        for(int j=m-1;j>=0;j--){
            int ones = 0;
            for(int i=0;i<n;i++){
                if(arr[i][j]==1) ones++;
            }
            sum +=pow*ones;
            pow*=2;
        }
        return sum;
    }
}