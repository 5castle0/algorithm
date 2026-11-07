import java.util.*;

class Solution {
    public int solution(int[] cards) {
    
        List<Integer> list = new ArrayList();
        
        int len = cards.length;
        boolean[] visited = new boolean[len];
        for(int i=0; i<len; i++){
            if(!visited[i]){
                int j = i;
                int count = 0;
                
                while(!visited[j]){
                    visited[j] = true;
                    count++;
                    
                    j = cards[j] - 1; 
                }
                
                list.add(count);
            }
        }
        
        list.sort(Collections.reverseOrder());
        
        return (list.size()>1) ? list.get(0) * list.get(1) : 0;
    }
}