import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        HashSet<String> set = new HashSet<>();
        
        for(int i=1; i<words.length; i++){
            char last = words[i-1].charAt(words[i-1].length()-1);
            char now = words[i].charAt(0);
            
            set.add(words[i-1]);
            if(set.contains(words[i]) || last!=now){
                System.out.println("i : " + i);
                answer = calFail(i, n);
                break;
            }
        }
        
        return answer;
    }
    
    private static int[] calFail(int i, int n){
        int[] answer = new int[2];
        
        int temp = (i+1)%n;
        if(temp==0){
            answer[0] = n;
        }else{
            answer[0] = temp;
        }
        
        answer[1] = i/n + 1;
        
        return answer;
    }
}