import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack();
        
        for(int i=0; i<s.length(); i++){
            Character a = s.charAt(i);
            
            if(a=='('){
                stack.add(a);
            }else{
                if(!stack.isEmpty() && stack.peek()=='('){
                    stack.pop();
                }else{
                    answer = false;
                    break;
                }
            }
        }
        
        if(!stack.empty()){
            answer = false;
        }
      

        return answer;
    }
}