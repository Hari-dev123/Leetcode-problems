class Solution {
    public String minWindow(String s, String t) {
        int left = 0 , right = 0 ,count = 0 , minLen = Integer.MAX_VALUE , startIdx = -1;
        int arr[] = new int[128];
        for(char c : t.toCharArray()){
              arr[c]++;
        }
        while(right < s.length()){
             char ch = s.charAt(right);
             if(arr[ch ] > 0){
                 count++;
             }
             arr[ch ]--;
             while(count == t.length()){
                if(right - left +1 < minLen){
                     minLen = right -left +1;
                     startIdx = left;
                }
                arr[s.charAt(left) ]++;
                 if(arr[s.charAt(left) ] > 0){
                 count--;
                }
                left++;
             }
             right++;
        }
        return startIdx == -1 ? "" : s.substring(startIdx, startIdx + minLen);
    }
}   