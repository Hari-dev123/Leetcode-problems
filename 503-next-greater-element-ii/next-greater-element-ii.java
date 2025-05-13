class Solution {
    public int[] nextGreaterElements(int[] arr) {
        int res[] = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        for(int i=2*n-1;i>=0;i--){
             int idx = i % n;
             int num = arr[idx];
             while(!st.isEmpty() && st.peek() <= num){
                st.pop();
             }

             if(i < n ){
                res[i] = st.isEmpty() ? -1 : st.peek();
             }
             st.push(num);
        }
        return res;
    }
}