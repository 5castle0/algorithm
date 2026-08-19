class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        // 빈 병 a개를 가져다 주면 b개를 새로 준다
        // n 은 지금 가지고 있는 병의 개수
        
        while(n>=a && n>=2){
            int count = n/a;
            
            n -= count * a;
            n += count * b;
            answer += count * b;
        }
        
        return answer;
    }
}