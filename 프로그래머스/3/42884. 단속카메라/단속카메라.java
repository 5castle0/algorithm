import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        
        int answer = 0;
        int last = -30001;
        
        Arrays.sort(routes, (o1 ,o2) -> {
            return o1[1] - o2[1];
        });
            
        for(int[] a : routes){
            if(a[0]<=last && last<=a[1]){
                continue;
            }
            
            answer++;
            last = a[1];
        }
        
        return answer;
    }
}