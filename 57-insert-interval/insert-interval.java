class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
          List<int[]> ll = new ArrayList<>();
          for(int interval[] : intervals ){
              if(newInterval[1] < interval[0]){
                   ll.add(newInterval);
                   newInterval = interval;
              }else if(newInterval[0] > interval[1]){
                    ll.add(interval);
              }else{
                  newInterval[0] = Math.min(newInterval[0],interval[0]);
                  newInterval[1] = Math.max(newInterval[1],interval[1]);
              }
          }
          ll.add(newInterval);
          return ll.toArray(new int[ll.size()][]);
    }
}