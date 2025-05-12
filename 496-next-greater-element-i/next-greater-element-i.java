class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
         int arr[] = new int[nums1.length];
         Map<Integer,Integer> map = new HashMap<>();
         for(int i=0;i<nums2.length;i++){
            map.put(nums2[i],i);
         }
         for(int i=0;i<nums1.length;i++){
              int idx = map.get(nums1[i]);
              arr[i] =  -1;
              for(int j=idx;j<nums2.length;j++){
                if(nums2[j] > nums1[i]){
                    arr[i] =  nums2[j];
                    break;
                }
              }
              
         }
         return arr;
    }
}