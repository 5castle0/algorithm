class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<s.length(); i++){
            int now = (int) s.charAt(i);
            
            if(now == 32){
                
            }else if(64 < now && now < 91){ // 대문자인 경우 
                now += n;
                
                if(now >= 91) now -= 26;
            }else{ // 소문자인 경우 
                now += n;
                
                if(now >= 123) now -= 26;
            }
            
            sb.append((char) now);
        }
        
        return sb.toString();
    }
}