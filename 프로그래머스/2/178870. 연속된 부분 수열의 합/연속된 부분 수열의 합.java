class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0, sequence.length};
        
        int left = 0;
        int right = 0;
        int sum = sequence[0];
        
        while(left <= right && right < sequence.length){
            if(sum > k){
                sum -= sequence[left++]; 
            }else if(sum==k){
                if(answer[1]-answer[0] > right-left){
                    answer[0] = left;
                    answer[1] = right;
                }
                
                sum -= sequence[left++]; 
            }else{
                if(right+1 < sequence.length){
                     sum += sequence[++right]; 
                }else{
                    break;
                }
            }
        }
        
        return answer;
    }
}