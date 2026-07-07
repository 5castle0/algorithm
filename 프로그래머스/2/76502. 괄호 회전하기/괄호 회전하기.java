import java.util.*;

class Solution {
    public int solution(String s) {

        int answer = 0;
        
        for(int i=0; i<s.length(); i++){
            if(isValid(s)){
                answer++;
            }
            s = s.substring(1)+s.substring(0,1);
        }
        
        return answer;
    }
    
    private static boolean isValid(String s){
        Stack<Character> stack = new Stack();
            
        for(int i=0; i<s.length(); i++){
            Character now = s.charAt(i);
                
            if(now=='(' || now=='{' || now=='['){
                stack.push(now);
            }else{
                
                if(stack.isEmpty()){
                    return false;
                }
                
                if(now==')' && stack.pop()=='(') {}
                else if(now=='}' && stack.pop()=='{') {}
                else if(now==']' && stack.pop()=='[') {}
                else{
                    return false;
                }
            }
        }   
        
        if(!stack.isEmpty()){
            return false;
        }
        
        return true;
    }

}