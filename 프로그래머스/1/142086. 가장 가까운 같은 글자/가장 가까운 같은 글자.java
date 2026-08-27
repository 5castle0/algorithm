import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        HashMap<Character, Integer> map = new HashMap();
        
        for(int i=1; i<=s.length(); i++){
            char c = s.charAt(i-1);
            
            if(map.containsKey(c)){
                answer[i-1] = i - map.get(c);
            }else{
                answer[i-1] = -1;
            }
            
            map.put(c, i);
        }
        
        return answer;
    }
}