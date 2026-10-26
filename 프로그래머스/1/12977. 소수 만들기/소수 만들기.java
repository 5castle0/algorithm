import java.util.*;

class Solution {
    
    static int max = 3000;
    
    public int solution(int[] nums) {
        int answer = 0;

        // 소수 판별
        boolean[] isPrime = new boolean[max+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for(int i=2; i<=Math.sqrt(max); i++){
            for(int j=2; j*i<=max; j++){
                isPrime[i*j] = false;
            }
        }
        
        // 만들 수 있는 수 구하기
        int len = nums.length;
        for(int i=0; i<len; i++){
            for(int j=i+1; j<len; j++){
                for(int k=j+1; k<len; k++){
                    int sum = nums[i] + nums[j] + nums[k];
                    if(isPrime[sum]) answer++;
                }
            }
        }

        return answer;
    }
}