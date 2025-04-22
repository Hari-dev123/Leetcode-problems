class Solution {
    public String longestPalindrome(String s) {
          int n = s.length();
          String res  = "";
          for(int i=0;i<n;i++){
             String ans =  check(s,i,i);
             if(ans.length()  > res.length() ){
                  res = ans;
             }
             String ans1 = check(s , i , i+1);
             if(ans1.length() > res.length()){
                   res = ans1;
             }

          }
          return res;
    }
    static String check(String s,int i , int j ){
          while( i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
              i--;
              j++;
          }
          return s.substring(i+1 , j);
    }
}