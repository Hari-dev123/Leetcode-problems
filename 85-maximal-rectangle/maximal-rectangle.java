class Solution {
    public int maximalRectangle(char[][] matrix) {
         int m = matrix[0].length;
         int n = matrix.length;
         int h[] = new int[m];
         int max = 0;
         for(int j=0;j<n;j++){
             for(int i = 0; i < m;i++){
                  h[i] = matrix[j][i]  == '0' ? 0 : h[i] + 1;
             }
            max = Math.max(max , largestRectangleArea(h));
         }
         return max;
    }

     public static int largestRectangleArea(int[] arr) {
        int max = 0;
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                 int el = st.peek();
                 st.pop();
                 int nextS = i;
                 int preS = st.isEmpty() ? -1 : st.peek();
                 max = Math.max(max , arr[el] * (nextS - preS - 1));
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int el = arr[st.peek()];
            st.pop();
            int nextS = n;
            int preS = st.isEmpty() ? -1 : st.peek();
            max = Math.max(max , el* (nextS - preS - 1));
        }
        return max;
    }
}