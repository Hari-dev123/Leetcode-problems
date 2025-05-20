public class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int count = 0;
         int a = -1, b = -1, c = -1;
        for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                if (ch == 'a') a = i;
                else if (ch == 'b') b = i;
                else if (ch == 'c') c = i;

                if (a > -1 && b > -1 && c > -1) {
                    count += ( minInd(a,b,c) + 1);
                }
            
        }

        return count;
    }
    static int minInd(int a , int b,int c){
          return Math.min(a,Math.min(b,c));
    }
}

