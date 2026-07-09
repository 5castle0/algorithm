import java.util.*;

class Solution {
    
    static HashMap<String, Integer> buy = new HashMap();
    
    public int solution(String[] want, int[] number, String[] discount) {
        
        int answer = 0;
        
        // 10개 채우기 
        for(int i=0; i<10; i++){
            if(buy.containsKey(discount[i])){
                buy.put(discount[i], buy.get(discount[i]) + 1);
            }else{
                buy.put(discount[i], 1);
            }
        }
        
        if(isValid(want, number)){
            answer++;
        }
        
        for(int i=0; i<discount.length-10; i++){
            buy.put(discount[i], buy.get(discount[i])-1);
            
            int idx = i+10;
            buy.put(discount[idx], buy.getOrDefault(discount[idx], 0)+1);
            
            if(isValid(want, number)){ answer++; }
        }
        
        return answer;
    }
    
    private static boolean isValid(String[] want, int[] number){
        
        boolean flag = true;
        
        for(int i=0; i<want.length; i++){
            if(!buy.containsKey(want[i]) || buy.get(want[i]) != number[i]){
                flag = false;
                break;
            }    
        }
        
        return flag;
    }
}