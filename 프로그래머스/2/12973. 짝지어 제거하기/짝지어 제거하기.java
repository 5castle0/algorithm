import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;

        Stack<Character> stack = new Stack();
        
        for(int i=0; i<s.length(); i++){
            char now = s.charAt(i);
            
            if(stack.isEmpty()){
                stack.add(now);
            }else{
                if(stack.peek()==now){
                    stack.pop();
                }else{
                    stack.add(now);
                }
            }
        }

        if(stack.isEmpty()){
            answer = 1;
        }else{
            answer = 0;
        }
        
        return answer;
    }
}