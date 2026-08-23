import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue();
        
        for(int food : scoville){
            pq.add(food);
        }
        
        while(!pq.isEmpty()){
            if(pq.size()==1){
                if(pq.peek() < K){
                    answer = -1;
                }
                
                break;
            }
            
            int a = pq.poll();
            
            if(a >= K){
                break;
            }
            
            int b = pq.poll();
            
            pq.add(a+b*2);
            answer++;
        }
        
        return answer;
    }
}