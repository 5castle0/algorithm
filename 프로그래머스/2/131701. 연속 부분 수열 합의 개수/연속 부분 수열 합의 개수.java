import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int len = elements.length;
        
        // 배열 이어붙이기 
        int[] arr = new int[len * 2];
        for(int i=0; i<len*2; i++){
            arr[i] = elements[i%len];
        }
        
        // 연속 부분 수열 합 구하기
        Set<Integer> set = new HashSet();
        for(int i=1; i<=len; i++){ // i는 연속수열의 길이 
            int sum = 0;
            
            for(int j=0; j<i; j++){ // 초기값
                sum += arr[j];
            }
            
            set.add(sum);
            
            for(int j=0; j<len*2 - i; j++){
                sum -= arr[j];
                sum += arr[j + i];
                set.add(sum);
            }
        }
        
        return set.size();
    }
}