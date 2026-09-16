class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int idx = 0; // 마지막으로 칠해진 구역
        
        for(int i : section){
            if(idx<i){
              answer++;
              idx = i + m - 1;
            }
        }
        
        return answer;
    }
}