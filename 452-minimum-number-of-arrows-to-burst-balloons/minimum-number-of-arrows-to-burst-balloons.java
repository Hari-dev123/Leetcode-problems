class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int arrows = 1;
        int nextEl = points[0][1];
        for(int i=1;i<points.length;i++){
              if(points[i][0] > nextEl){
                 nextEl = points[i][1];
                 arrows++;
              }
        }
        return arrows;
    }
}