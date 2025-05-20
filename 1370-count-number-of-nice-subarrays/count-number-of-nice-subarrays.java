class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
         return findMax(nums,k) - findMax(nums,k-1);
    }
    static int findMax(int arr[],int k){
        if(k < 0 ) return 0;
         int c = 0 ,max = 0,   l=0;
         for(int r=0;r<arr.length;r++){
              if(arr[r]%2 == 1){
                 c++;
              }
              while(c > k){
                 if(arr[l]%2 == 1){
                     c--;
                     
                 }
                 l++;
              }
            max += r-l + 1;

         }
         return max;
    }
}