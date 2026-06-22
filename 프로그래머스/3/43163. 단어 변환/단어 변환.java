class Solution {
    
    static int answer = 51;
    
    public int solution(String begin, String target, String[] words) {
        
        boolean[] visited = new boolean[words.length];
        
        dfs(begin, target, words, visited, 0);
        
        if(answer==51){
            return 0;
        }else{
            return answer;
        }
    }
    
    private void dfs(String begin, String target, String[] words, 
                     boolean[] visited, int count){
        
            if(begin.equals(target)){
                answer = Math.min(answer, count);
                return;
            }
        
            for(int i=0; i<words.length; i++){
                if(!visited[i] && isVaild(begin, words[i])){
                    visited[i] = true;
                    count++;
                    dfs(words[i], target, words, visited, count);
                    visited[i] = false;
                    count--;
                }
            }
    }
    
    private boolean isVaild(String a , String b){
        int count = 0;
        
        for(int i=0; i<a.length(); i++){
            if(a.charAt(i)!=b.charAt(i)){
                count++;
            }
        }
        
        return count==1 ;
    }
}