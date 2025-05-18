class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
         return findGoal(nums,goal) - findGoal(nums,goal-1);
    }
    static int findGoal(int arr[],int g){
          int l = 0 , r = 0 , c = 0 , sum = 0;
          if(g < 0) return 0;
          while(r < arr.length){
              sum += arr[r];
              while(sum > g){
                   sum -= arr[l];
                   l++;
              }
              c += r - l + 1;
              r++;
          }
          return c;
    }
}