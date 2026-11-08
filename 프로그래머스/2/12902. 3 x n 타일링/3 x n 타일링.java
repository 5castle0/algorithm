class Solution {
    
    static int M = 1000000007;
    
    public int solution(int n) {
        long[] dp = new long[n+1];
        dp[2] = 3;
        
        for(int i=4; i<=n; i+=2){
            dp[i] = (dp[i-2] * dp[2] + 2) % M; // + edge case
            
            for(int j=i-4; j>=2; j-=2){
                dp[i] = (dp[i] + dp[j] * 2) % M;
            }
        }
        
        return (int) dp[n];
    }
}