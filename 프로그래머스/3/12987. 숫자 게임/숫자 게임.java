import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int pointer = 0; // a's
        int answer = 0;
        
        for(int i=0; i<B.length; i++){
            if(A[pointer] < B[i]){
                pointer++;
                answer++;
            }   
        }
        
        return answer;
    }
}