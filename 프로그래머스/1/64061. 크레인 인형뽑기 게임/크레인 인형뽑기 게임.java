import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        int n = board.length;
        
        // 높이 측정
        int[] height = new int[n];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]!=0 && n-i > height[j]){
                    height[j] = n - i;
                }
            }
        }
        
        // 바구니에 넣기
        Stack<Integer> stack = new Stack();
        
        for(int i=0; i<moves.length; i++){
            
            int picked = 0;
            int moveIndex = moves[i] - 1;
            
            if(height[moveIndex] > 0){
                picked = board[n-height[moveIndex]][moveIndex];
                height[moveIndex]--;
            }
            
            if(picked != 0){
                if(!stack.isEmpty() && stack.peek()==picked){
                    stack.pop();
                    answer++;
                }else{
                    stack.add(picked);
                }
            }
        }
        
        // 스택에 남아있는 인형 확인
        while(!stack.isEmpty()){
            int doll = stack.pop();
            
            if(!stack.isEmpty() && stack.peek()==doll){
                stack.pop();
                answer++;
            }
        }
        
        return answer * 2;
    }
}