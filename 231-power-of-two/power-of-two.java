class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n == 1) return true;
        for(int i= 1;i<=n;i++){
              double powVal = Math.pow(2,i);
              if(powVal == n) return true;
              if(powVal > n) return false;
        }
        return false;
    }
}