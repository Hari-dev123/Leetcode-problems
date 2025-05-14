class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        StringBuilder str = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        for(char ch : num.toCharArray()){
             int nums = ch - '0';
             while(!st.isEmpty() && st.peek() > nums && k > 0 ){
                  st.pop();
                  k--;
             }
             st.push(nums);
        }
        while(k > 0 && !st.isEmpty()){
             st.pop();
             k--;
        }
        
        for(int i=st.size()-1;i>=0;i--){
            str.insert(0,st.pop());
        }
       while(str.length() > 0 && str.charAt(0) == '0' ){
            str.deleteCharAt(0);
       }
        return str.length() == 0 ? "0" : str.toString();
    }
}