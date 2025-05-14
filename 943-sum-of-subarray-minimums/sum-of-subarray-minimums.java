class Solution {
    public int sumSubarrayMins(int[] arr) {
         int n = arr.length;
         int l[] = new int[n];
         int r[] = new int[n];
         Stack<Integer> st = new Stack<>();
         for(int i=0;i<n;i++){
             while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                  st.pop();
             }
             l[i] = st.isEmpty() ? -1 : st.peek();
             st.push(i);
         }
         st.clear();
         for(int i=n-1;i>=0;i--){
             while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                  st.pop();
             }
             r[i] = st.isEmpty() ? n : st.peek();
             st.push(i);
         }
         long total = 0;
int mod = 1_000_000_007;
         for(int i=0;i<n;i++){
             int left = i - l[i];
             int right = r[i] - i;
              long contrib = (arr[i] * left) % mod;
    contrib = (contrib * right) % mod;
    total = (total + contrib) % mod;
         }
         return (int) total;
    }
}