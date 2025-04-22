class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
              map.put(ch , map.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>(
            (a , b) -> map.get(b) - map.get(a)
        );
        pq.addAll(map.keySet());
        StringBuilder str = new StringBuilder();
        while(!pq.isEmpty()){
            char h = pq.poll();
             int c = map.get(h);
             for(int i=0;i<c;i++){
                str.append(h);
             }
        }
       return str.toString();
    }
}