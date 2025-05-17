class LFUCache {
     private class Node{
          int key;
          int val;
          int freq;
          Node(int key,int val){
            this.key = key;
            this.val = val;
            freq = 1;
          }
     }
     private final int capacity  ;
     Map<Integer,Node> keysToNode;
     int minfreq;
     Map<Integer,LinkedHashSet<Integer>> freqNode;
   
    public LFUCache(int capacity) {
        this.capacity = capacity;
        minfreq = 0;
        freqNode = new HashMap<>();
        keysToNode   = new HashMap<>();
    }
    
    public int get(int key) {
         if(!keysToNode.containsKey(key)) return -1;
         Node temp = keysToNode.get(key);
         updateFreq(temp);
         return temp.val;
    }

    private void updateFreq(Node node){
         int cFreq = node.freq;
         LinkedHashSet<Integer> lhs = freqNode.get(cFreq);
         lhs.remove(node.key);
         if(lhs.isEmpty()){
             freqNode.remove(cFreq);
             if(minfreq == cFreq){
                  minfreq++;
             }
         } 
         node.freq++;
         if(!freqNode.containsKey(node.freq)){
            freqNode.put(node.freq,new LinkedHashSet());
         }

         freqNode.get(node.freq).add(node.key);
    }
    
    public void put(int key, int value) {
         if(capacity == 0) return ;
         if(keysToNode.containsKey(key)){
             Node temp =  keysToNode.get(key);
             temp.val = value;
             updateFreq(temp);
         }else{
            if(capacity  ==  keysToNode.size()){
                 removeNode();
            }
            Node newNode = new Node(key,value);
            keysToNode.put(key,newNode);
            if(freqNode.containsKey(newNode.freq)){
               freqNode.get(newNode.freq).add(newNode.key);
                 
            }else{
                 freqNode.put(newNode.freq,new LinkedHashSet());
                  LinkedHashSet<Integer> lhs =  freqNode.get(newNode.freq);
                 lhs.add(newNode.key);
            }
            minfreq = 1;
         }
    }
    private void removeNode(){
        LinkedHashSet<Integer> lhs = freqNode.get(minfreq);
        int removingNode = lhs.iterator().next();
        lhs.remove(removingNode);
        if(lhs.isEmpty()){
            freqNode.remove(minfreq);
        }
        keysToNode.remove(removingNode);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */