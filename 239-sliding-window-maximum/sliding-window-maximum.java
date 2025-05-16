class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
         int n = nums.length;
        int arr[] = new int[n-k+1];
        Deque<Integer> dq = new ArrayDeque<>();
        for(int r=0;r < n;r++){

            while(!dq.isEmpty() && dq.peekFirst() <= r - k ){
                 dq.pollFirst();
            }
            
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[r]){
                  dq.pollLast();
            }
            dq.offerLast(r);
            if(r >= k- 1){
                 arr[r-k+1] = nums[dq.peekFirst()];
            }
        }
       
        return arr;
    }
}