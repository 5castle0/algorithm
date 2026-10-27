import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        
        Set<Integer> set = new HashSet();
        for(int i : win_nums){
            set.add(i);
        }
        
        int zero = 0;
        int correct = 0;
        
        for(int i : lottos){
            if(i==0){
                zero++;
            }else if(set.contains(i)){
                correct++;
            }
        }
        
        int[] rank = {6,6,5,4,3,2,1};
        
        return new int[]{rank[zero+correct], rank[correct]};
    }
}