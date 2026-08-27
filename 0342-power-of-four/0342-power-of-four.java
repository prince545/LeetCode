class Solution {
    public boolean isPowerOfFour(int n) {
        return (n>0 && isPowerOfTwo(n) && isSquare(n));
    }
    public boolean isPowerOfTwo(int n){
        return ((n&(n-1))==0);
    }
    public boolean isSquare(int n){
        int root = (int)Math.sqrt(n);
        return (root*root==n);

    }
}