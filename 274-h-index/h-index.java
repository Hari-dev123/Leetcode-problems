class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
          int [] newArr = new int[n + 1];
          for(int c : citations){
               if(c >= n){
                newArr[n]++;
               }else{
                  newArr[c]++;
               }

          }
          int total = 0;
        n = newArr.length;
          for(int i = n-1 ; i >=0;i--){
               total += newArr[i];
               if(total >= i){
                  return i;
               }
          }
          return 0;

    }
    
    
}