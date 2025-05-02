class Solution {
    public int hIndex(int[] citations) {
           sort(citations);
           int idx = 0;
           for(int i=0;i<citations.length;i++){
                if(citations[i] >= i+1){
                    idx++;
                }else{
                    break;
                }
           }
           return idx;

    }
    static void sort(int arr[]){
        for(int i=0;i<arr.length-1;i++){
              for(int j=i+1;j<arr.length;j++){
                 if(arr[j] > arr[i]){
                       int temp = arr[i];
                       arr[i] = arr[j];
                       arr[j] = temp;
                 }
              }
        }
    }
}