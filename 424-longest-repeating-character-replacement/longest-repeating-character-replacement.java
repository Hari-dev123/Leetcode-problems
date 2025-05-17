class Solution {
    public int characterReplacement(String s, int k) {
       int left = 0;
        int maxCount = 0;
        int maxLength = 0;
        int arr[] = new int[26];

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            arr[ch - 'A']++;
            maxCount = Math.max(maxCount, arr[ch- 'A']);  

            
            while ((right - left + 1) - maxCount > k) {
                 arr[s.charAt(left) - 'A']--;
                 for(int i=0;i<arr.length;i++){
                    maxCount = Math.max(maxCount,arr[i]);
                 }
                 left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}