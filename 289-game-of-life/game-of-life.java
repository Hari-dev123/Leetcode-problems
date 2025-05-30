class Solution {
    public void gameOfLife(int[][] b) {
          int m = b.length , n = b[0].length;
          int arr[][] = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};

          for(int i=0;i<m;i++){
              for(int j=0;j<n;j++){
                  int near1 = 0;
                 for(int [] pos : arr){
                      int r = i + pos[0];
                      int c = j + pos[1];
                        if(r >= 0 && r < m && c >= 0 && c < n){
                             if(b[r][c] == 1 || b[r][c] == 2){
                                  near1++;
                             }
                        }
                 }
                 if(b[i][j] == 1 && (near1 < 2 || near1 > 3)){
                       b[i][j]= 2;
                 }else if(b[i][j] == 0 && near1 == 3){
                       b[i][j] = 3;
                 }
              }
          }

          for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                 if(b[i][j] == 2){
                      b[i][j] = 0;
                 }
                 if(b[i][j] == 3){
                    b[i][j] = 1;
                 }
            }
          }
    }
}