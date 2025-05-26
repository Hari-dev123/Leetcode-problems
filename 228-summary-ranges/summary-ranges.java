class Solution {
    public List<String> summaryRanges(int[] nums) {
         List<String> ll = new ArrayList<>();
         int  l = 0 , r = 0;
         int n = nums.length;
         while(l < n){

            while(r + 1 < n && nums[r]+1 == nums[r+1] ){
                   r++;
                   continue;
            }
            if(l != r){
                String res = ""+nums[l]+"->"+nums[r]+"";
                ll.add(res);
            }else{
                 String res = ""+nums[l]+"";
                 ll.add(res);
            }
            l = r + 1;
            r++;
         }
         return ll;
    }
}