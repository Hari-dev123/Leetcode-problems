class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return findMax(nums,k)  - findMax(nums,k-1);
    }
    static int findMax(int arr[],int k){
          if(k < 0) return 0;
          int left = 0 , count = 0;
          Map<Integer,Integer> map = new HashMap<>();
          for(int right = 0;right < arr.length;right++){
               map.put(arr[right],map.getOrDefault(arr[right],0)+1);
               
               while(map.size() > k){
                   map.put(arr[left],map.get(arr[left])-1);
                   if(map.get(arr[left]) == 0){
                     map.remove(arr[left]);
                   }
                   left++;
               }
               count += right - left + 1;
          }
          return count;
    }
}