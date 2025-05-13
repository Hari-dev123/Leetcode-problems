class Solution {
    public int[] nextGreaterElements(int[] arr) {
        int res[] = new int[arr.length];
        for(int i=0;i<res.length;i++){
            res[i] = -1;
        }
        for(int i=0;i<arr.length;i++){
            boolean flag = true;
             int num = arr[i];
             for(int j=i+1;j<arr.length;j++){
                  if(arr[j] > num){
                      res[i] = arr[j];
                      flag = false;
                      break;
                  }
             }
             if(flag){
                 for(int k = 0; k< i;k++){
                      if(arr[k] > num){
                          res[i] = arr[k];
                          break;
                      }
                 }
             }
        }
        
        return  res;
    }
}