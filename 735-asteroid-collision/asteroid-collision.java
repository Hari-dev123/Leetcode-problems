class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> c = new Stack<>();

        for (int num : asteroids) {
            boolean alive = true;
             while(!c.isEmpty() && num < 0 && c.peek()  > 0){
                   if(Math.abs(num) > c.peek()){
                      c.pop();

                   }else if(Math.abs(num) == c.peek()){
                       c.pop();
                       alive = false;
                       break;
                   }else{
                      alive = false;
                      break;
                   }
             }
            




            if(alive){
                c.push(num);
            }
        }

       
        int[] arr = new int[c.size()];
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = c.pop();
        }

        return arr;
    }
}
