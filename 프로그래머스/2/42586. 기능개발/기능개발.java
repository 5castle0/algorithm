import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        int len = progresses.length;
        List<Integer> list = new ArrayList();
        
        int[] time = new int[len];
        
        for(int i=0; i<len; i++){
            time[i] = (int) Math.ceil((double)(100-progresses[i]) / speeds[i]);
        }
        
        int count = 1;
        int prior = time[0];
        
        for(int i=1; i<len; i++){
            if(time[i] <= prior){
                count++;
            }else{
                list.add(count);
                count = 1;
                prior = time[i];
            }
        }
        
        list.add(count);
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}