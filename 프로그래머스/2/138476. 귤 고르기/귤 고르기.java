import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
         
        int answer = 0;
        
        int max = 0;
        for(int i : tangerine){
            max = Math.max(max, i);
        }
        
        int[] count = new int[max+1];
        
        for(int i : tangerine){
            count[i]++;
        }
    
        Arrays.sort(count);
        
        int total = 0;
        for(int i=max; i>0; i--){
            total += count[i];
            answer++;
            
            if(total >= k){
                break;
            }
        }
        
        return answer;
    }
}