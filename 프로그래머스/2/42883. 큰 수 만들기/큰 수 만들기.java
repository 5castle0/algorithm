import java.util.*;

class Solution {
    public String solution(String number, int k) {
        
        Stack<Integer> stack = new Stack();
        int c = 0; // 제거 횟수
        
        for(int i=0; i<number.length(); i++){
            int n = number.charAt(i) - '0';
            
            while(!stack.isEmpty() && c<k){
                if(stack.peek() < n){
                    stack.pop();
                    c++;
                }else{
                    break;
                }
            }
            
            stack.push(n);
        }
        
        // 다 제거하지 못 했을 때
        while(c<k){
            stack.pop();
            c++;
        }
        
        String answer = "";
    
        while(!stack.isEmpty()){
            answer = stack.pop() + answer;
        }
        
        return answer;
    }
}