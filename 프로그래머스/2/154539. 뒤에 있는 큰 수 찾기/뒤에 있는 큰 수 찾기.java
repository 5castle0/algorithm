import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int len = numbers.length;
        int[] answer = new int[len];
        Stack<Integer> stack = new Stack();
        
        for(int i=0; i<len; i++){
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]){
                int popIndex =  stack.pop();
                
                answer[popIndex] = numbers[i];
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
            answer[stack.pop()] = -1;
        }
        
        return answer;
    }
}