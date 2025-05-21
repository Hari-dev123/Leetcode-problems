class Solution {
    public int[] dailyTemperatures(int[] nums) {
          Stack<Integer> st = new Stack<>();
          int arr[] = new int[nums.length];
          for(int i=nums.length-1; i>= 0;i--){
              
              while(!st.isEmpty() && nums[i] >= nums[st.peek()]){
                  st.pop();
              }
              arr[i] = st.isEmpty() ? 0 : st.peek() - i;
              st.push(i);

          }
           return arr;
    }
}