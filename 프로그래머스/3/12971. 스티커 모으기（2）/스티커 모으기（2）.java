class Solution {
    public int solution(int sticker[]) {

        int len = sticker.length;
        
        if(len==1){
            return sticker[0];
        }
        
        if(len==2){
            return Math.max(sticker[0], sticker[1]);
        }
        
        int[] dp0 = new int[len]; // 0번째 스티커 포함
        int[] dp1 = new int[len]; // 1번째 스티커 포함
        
        dp0[0] = sticker[0];
        dp0[1] = sticker[0];
        for(int i=2; i<len-1; i++){
            dp0[i] = Math.max(dp0[i-2] + sticker[i], dp0[i-1]);
        }
        
        dp1[0] = 0;
        dp1[1] = sticker[1];
        for(int i=2; i<len; i++){
            dp1[i] = Math.max(dp1[i-2] + sticker[i], dp1[i-1]);
        }
        
        return Math.max(dp0[len-2], dp1[len-1]);
    }
}