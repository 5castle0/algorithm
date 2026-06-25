class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int[] arr = new int[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = i;
        }
        
        int left = 1; 
        int right = 1;
        int total = 1;
        
        while(left<=right){
            if(total < n){
                right++;
                total+=arr[right];
            }else if(total>n){
                total-=arr[left];
                left++;
            }else{
                answer++;
                total-=arr[left];
                left++;
            }
        }
        
        return answer;
    }
}