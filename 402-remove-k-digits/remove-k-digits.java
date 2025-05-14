class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        StringBuilder str = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for(char ch : num.toCharArray()){
             
             while(!st.isEmpty() && st.peek() > ch && k > 0 ){
                  st.pop();
                  k--;
             }
             st.push(ch);
        }
        while(k > 0 && !st.isEmpty()){
             st.pop();
             k--;
        }
        
        for(char c : st){
            str.append(c);
        }
       while(str.length() > 0 && str.charAt(0) == '0' ){
            str.deleteCharAt(0);
       }
        return str.length() == 0 ? "0" : str.toString();
    }
}