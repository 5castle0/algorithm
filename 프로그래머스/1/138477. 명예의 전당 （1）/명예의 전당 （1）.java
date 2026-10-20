import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int days = score.length;
        int[] answer = new int[days];
        
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        Queue<Integer> temp = new LinkedList();
        
        for(int i=0; i<days; i++){
            pq.add(score[i]);
            
            if(i<k-1){
                for(int j=0; j<i; j++){
                    temp.add(pq.remove());
                }
                answer[i] = pq.peek();
                
                while(!temp.isEmpty()){
                    pq.add(temp.remove());
                }
                
            }else{
                for(int j=0; j<k-1; j++){
                    temp.add(pq.remove());
                }
                
                answer[i] = pq.peek();
                
                while(!temp.isEmpty()){
                    pq.add(temp.remove());
                }
            }
        }
        
        return answer;
    }
}