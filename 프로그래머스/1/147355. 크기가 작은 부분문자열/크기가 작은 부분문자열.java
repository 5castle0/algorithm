class Solution {
    public int solution(String t, String p) {
        int len = p.length();
        
        int answer = 0;
        
        for(int i=0; i<t.length()-len+1; i++){
            Long a = Long.parseLong(t.substring(i, i+len));
            Long b = Long.parseLong(p);
            
            if(a<=b) answer++;
      
        }
        
        return answer;
    }
}