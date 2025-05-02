class RandomizedSet {
    List<Integer> list;
    Map<Integer,Integer> map;
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {
         if(map.containsKey(val)) return false;
         list.add(val);
         map.put(val , list.size()-1);
         return true;
    }
    
    public boolean remove(int val) {
         if(!map.containsKey(val)) return false;
         int index = map.get(val);
         int lastVal = list.get(list.size()-1);
         list.set(index ,  lastVal);
         map.put(lastVal,index);
        map.remove(val);
        list.remove(list.size()-1);
        return true;
    }
    
    public int getRandom() {
        Random ran = new Random();
        return list.get(ran.nextInt(0,list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */