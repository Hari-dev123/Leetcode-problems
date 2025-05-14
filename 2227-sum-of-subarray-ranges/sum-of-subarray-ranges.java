class Solution {
    public long subArrayRanges(int[] arr) {
     long max = findMax(arr);
         long min = findMin(arr);
         return max - min;
    }

    static long findMax(int arr[]){
         int n = arr.length;
        int l[] = new int[n];
        int r[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            l[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            r[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        long total = 0;
        for (int i = 0; i < n; i++) {
            int left = i - l[i];
            int right = r[i] - i;
            total +=  (long) left * right * arr[i];   
        }
        return total;
    }

    static long findMin(int arr[]){
           int n = arr.length;
        int l[] = new int[n];
        int r[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            l[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            r[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        long total = 0;
        
        for (int i = 0; i < n; i++) {
            int left = i - l[i];
            int right = r[i] - i;
            total += (long) left * right * arr[i];   
        }
        return total;
    }
}