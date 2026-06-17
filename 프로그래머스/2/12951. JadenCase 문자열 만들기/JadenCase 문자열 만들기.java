class Solution {
    public String solution(String s) {
        
        String answer = "";
        String words = s.toLowerCase();
        
        boolean isFirst = true;
        
        for(int i=0; i<s.length(); i++){
            String now = String.valueOf(words.charAt(i));
            if(isFirst && !now.equals(" ")){
                answer += now.toUpperCase();
                isFirst = false;
                continue;
            }
            
            if(now.equals(" ")){
                isFirst = true;
            }
            
            answer += now;
        }
        
        return answer;
    }
}