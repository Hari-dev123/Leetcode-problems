class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        Map<Character, Integer> count = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            
           while (count.getOrDefault(c , 0) > 0) {
                char leftChar = s.charAt(left);
                count.put(leftChar, count.get(leftChar) - 1);
                left++;
            }
            
            
            count.put(c, count.getOrDefault(c, 0) + 1);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;       
    }
}