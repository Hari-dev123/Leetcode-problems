class Solution {
    public boolean isValid(String s) {
         Stack<Character> st = new Stack<>();
         for(char c : s.toCharArray()){
            char ch = c;
             if(ch == '(' || ch == '[' || ch == '{'){
                st.push(ch);
             }else{
                if(st.isEmpty()) return false;
                char val = st.pop();
                if( ( ch == '}' && val != '{' ) || ( ch == ']' && val != '[' ) || ( ch == ')' && val != '(' )  ){
                    return false;
                }
             }
         }
         return st.isEmpty();
    }
}