class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ll = new ArrayList<>();
        if (s.length() == 0 || words.length == 0) {
            return ll;
        }

        int wordLen = words[0].length();
        int wordC = words.length;
        

        HashMap<String, Integer> originalC = new HashMap<>();
        for (String str : words) {
            originalC.put(str, originalC.getOrDefault(str, 0) + 1);
        }

        for (int offset = 0; offset < wordLen; offset++) {
            HashMap<String, Integer> currC = new HashMap<>();
            int start = offset;
            int count = 0;

            for (int end = offset; end + wordLen <= s.length(); end += wordLen) {
                String currS = s.substring(end, end + wordLen); 

                if (originalC.containsKey(currS)) {
                    currC.put(currS, currC.getOrDefault(currS, 0) + 1);
                    count++;

                    while (currC.get(currS) > originalC.get(currS)) {
                        String startWord = s.substring(start, start + wordLen);
                        currC.put(startWord, currC.get(startWord) - 1);
                        start += wordLen;
                        count--;
                    }

                    if (count == wordC) {
                        ll.add(start);
                    }

                } else {
                    currC.clear();
                    count = 0;
                    start = end + wordLen;
                }
            }
        }

        return ll;
    }
}
