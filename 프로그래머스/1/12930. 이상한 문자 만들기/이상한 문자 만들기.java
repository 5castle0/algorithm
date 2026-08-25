class Solution {
    public String solution(String s) {
        String answer = "";
        
        boolean isOdd = true;
        
        for(int i=0; i<s.length(); i++){
            char now = s.charAt(i);
            
            if(now==' '){
                isOdd = true;
                answer += " ";
                continue;
            }else if(isOdd){
                isOdd = false;
                answer += String.valueOf(now).toUpperCase();
            }else{
                isOdd = true;
                answer += String.valueOf(now).toLowerCase();
            }
        }
        return answer;
    }
}