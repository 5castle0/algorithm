import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        Queue<String> queue = new LinkedList();
        
        for(String city : cities){
            String now = city.toUpperCase();
            
            if(queue.contains(now)){
                answer += 1;
                queue.remove(now);
                queue.add(now);
            }else{
                answer += 5;
                
                if(queue.size() >= cacheSize && queue.size() > 0){
                    queue.remove();
                }
                
                if(queue.size() < cacheSize){
                    queue.add(now);
                }
            }
        }
        
        return answer;
    }
}