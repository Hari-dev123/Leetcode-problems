class Solution {
    public boolean wordPattern(String p, String s) {
         Map<Character , String > map1 = new HashMap<>();
         Map<String , Character > map2 = new HashMap<>();
         String[] ws = s.split(" ");
         if(ws.length != p.length()) return false;
         for(int i=0;i<p.length();i++){
              if(map1.containsKey(p.charAt(i))){
                  if(!map1.get(p.charAt(i)).equals(ws[i])){
                    return false;
                  }
              }else{
                map1.put(p.charAt(i),ws[i]);
              }
              if(map2.containsKey(ws[i])){
                  if(!map2.get(ws[i]).equals(p.charAt(i))){
                    return false;
                  }
              }else{
                map2.put(ws[i], p.charAt(i));
              }


         }

         return true;
    }
}