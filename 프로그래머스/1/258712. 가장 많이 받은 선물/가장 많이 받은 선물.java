import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        int count = friends.length;
        HashMap<String, Integer> name = new HashMap();
        for(int i=0; i<count; i++){
            name.put(friends[i], i);
        }
        
        int[][] history = new int[count][count];
        int[] index = new int[count];
        
        for(String gift : gifts){
            String[] g = gift.split(" ");
            String g1 = g[0]; 
            String g2 = g[1];
            
            int from = name.get(g1);
            int to = name.get(g2);
            
            // history 갱신
            history[from][to]++;
            
            // index 갱신
            index[from]++;
            index[to]--;
        }
        
        for(int i=0; i<count; i++){
            int result = 0;
            
            for(int j=0; j<count; j++){
                if(i==j) continue;
                
                int from = history[i][j];
                int to = history[j][i];
                
                if(from>to){
                    result++;
                }else if(from==to){
                    if(index[i]>index[j]){
                        result++;
                    }
                }
            }

            answer = Math.max(answer, result);
        }
        
        return answer;
    }
}