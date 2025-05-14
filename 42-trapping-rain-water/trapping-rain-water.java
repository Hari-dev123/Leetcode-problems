class Solution {
    public int trap(int[] height) {
        int total =0;
        int lMax  = 0;
        int rMax =0 ;
        int  l = 0 ;
        int n = height.length;
        int r = n -1;
        while( l <= r){
              if(height[l] <= height[r]){
                    if(height[l] > lMax){
                        lMax = height[l];
                    }else{
                         total += lMax - height[l];
                    }
                    l++;
              }else{
                     if(height[r] > rMax){
                        rMax = height[r];
                    }else{
                         total += rMax - height[r];
                    }
                    r--;
              }
        }
        return total;
}

}