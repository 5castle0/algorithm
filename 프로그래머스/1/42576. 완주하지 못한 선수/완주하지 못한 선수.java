import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        for(int i=0; i<participant.length; i++){
            if(participant.length-1==i || !participant[i].equals(completion[i])){
                System.out.println(i);
                answer = participant[i];
                break;
            }
        }

        return answer;
    }
}