class Solution {
    public int solution(int[][] triangle) {
        int size = triangle.length;
        
        int[][] dp = new int[size][size];
        
        int answer = 0;
        
        dp[0][0] = triangle[0][0];
        
        for(int i=1; i<size; i++){
            dp[i][0] = dp[i-1][0] + triangle[i][0];
            
            for(int j=1; j<triangle[i].length; j++){
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
                if(answer < dp[i][j]) answer = dp[i][j];
            }
        }
        
        return answer;
    }
}