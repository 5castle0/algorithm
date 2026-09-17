class Solution {
    public int solution(int n) {
        int answer = 0;
        
        boolean[] notPrime = new boolean[n+1];
        
        for(int i=2; i<=Math.sqrt(n); i++){
            for(int j=2; i*j<=n; j++){
                notPrime[i*j] = true;
            }
        }
        
        for(int i=2; i<=n; i++){
            if(!notPrime[i]){
                answer++;
            }
        }
        
        return answer;
    }
}