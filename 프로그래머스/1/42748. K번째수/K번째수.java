import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int n = commands.length;
        
        int[] answer = new int[n];
        
        for(int i=0; i<n; i++){
            int start = commands[i][0];
            int end = commands[i][1];
            int key = commands[i][2];
            
            int[] arr = new int[end-start+1];
            
            for(int j=start; j<=end; j++){
                arr[j-start] = array[j-1];
            }
            
            Arrays.sort(arr);
            
            answer[i] = arr[key-1];
        }
    
        return answer;
    }
}