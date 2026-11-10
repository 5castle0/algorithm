import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int shortL = 0;
        int longL = 0;
        
        for(int[] card : sizes){
            Arrays.sort(card);
            
            int s = card[0];
            int l = card[1];
            
            if(shortL < s) shortL = s;
            if(longL < l) longL = l;
            
        }
        
        return shortL * longL;
    }
}