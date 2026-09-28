import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
    
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        
        for(int i : score){
            pq.add(i);
        }
        
        while(m <= pq.size()){
            int low = 0;
            for(int i=0; i<m; i++){
                low = pq.remove();
            }
            
            answer += low*m;
        }
        
        return answer;
    }
}