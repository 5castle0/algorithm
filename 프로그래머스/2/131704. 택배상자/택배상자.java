import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack();
        int idx = 0; // order 배열 index
        
        for(int i=1; i<=order.length; i++){
            
            boolean flag = false;
            
            if(order[idx]==i){
                answer++;
                idx++;
                flag = true;
            }
            
            while(!stack.isEmpty()){
                if(stack.peek()==order[idx]){
                    stack.pop();
                    answer++;
                    idx++;
                }else{
                    break;
                }
            }
            
            if(!flag) stack.add(i);              
        }
        
        return answer;
    }
}