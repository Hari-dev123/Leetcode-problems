class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<tokens.length;i++){
              String ch = tokens[i];
              if(ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/") ){
                   int operand1 = st.pop();
                   int operand2 = st.pop();
                   int num = 0;
                   switch(ch){
                    case "+":
                       num = operand2 + operand1;
                       break;
                    case "-":
                       num = operand2 - operand1;
                       break;
                    case "*":
                       num = operand2 * operand1;
                       break;
                    case "/":
                       num = operand2 / operand1;
                       break;
                    
                   }
                   st.push(num);
              }else{
                 st.push(Integer.parseInt(ch));
              }
        }
        return st.peek();
    }
}