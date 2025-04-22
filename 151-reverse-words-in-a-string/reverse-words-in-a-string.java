class Solution {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int n =  chars.length;
        rev( chars,0  , n-1);
        revWord(chars);
        return removeSpace(chars);
    }
    static void rev(char arr[] , int st ,int end){
        while(st < end){
            char temp = arr[st];
            arr[st] = arr[end];
            arr[end] = temp;
            st++;
            end--;
        }
    }
    static void revWord(char arr[]){
         int st = 0 ,end = 0 , n = arr.length;
        while(end < n){
             while(st < n && arr[st] == ' '){
                  st++;
             }
             end = st;
             while(end < n && arr[end] != ' '){
                end++;
             }
             rev(arr,st,end-1);
            st = end + 1;
        }
    }
    static String removeSpace(char arr[]){
        StringBuilder str = new StringBuilder();
        int i = 0;
        while(i < arr.length){
            while(i < arr.length && arr[i] == ' '){
              i++;
            }
        while(i < arr.length && arr[i] != ' '){
             str.append(arr[i]);
             i++;
        }
        while(i < arr.length && arr[i] == ' '){
             i++;
         }
         if(i < arr.length){
             str.append(' ');
         }
        }
        return str.toString();
    }
}