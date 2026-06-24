class Solution {
    public int[] solution(int brown, int yellow) {
        
        int[] answer = new int[2];
        int total = brown + yellow;
        
        for(int i=2; i<=total/2; i++){
            if(total%i==0){
                int y = i;
                int x = total / i;
                
                if(2*x + 2*y - 4 == brown){
                    answer[0] = x;
                    answer[1] = y;
                    
                    break;
                }
            }
        }
        
        return answer;
    }
}