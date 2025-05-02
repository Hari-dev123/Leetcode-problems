class Solution {
    public boolean isValidSudoku(char[][] b) {
        Set<Character>[] row = new HashSet[9] ;
        Set<Character>[] col = new HashSet[9] ;
        Set<Character>[] box = new HashSet[9] ;
        for(int i=0;i<9;i++){
            row[i] = new HashSet<>();
            col[i] = new HashSet<>();
            box[i] = new HashSet<>();
        }
        for(int r = 0;r < b.length;r++){
            for(int s = 0;s < b[0].length;s++){
                 if(b[r][s] == '.') continue;
                  int boxIdx =  (r / 3) * 3 + (s / 3);
                 if(row[r].contains(b[r][s]) || col[s].contains(b[r][s]) || box[boxIdx].contains(b[r][s])) return false;
                 row[r].add(b[r][s]);
                 col[s].add(b[r][s]);
                 box[boxIdx].add(b[r][s]);
            }
        }
        return true;
    }
}