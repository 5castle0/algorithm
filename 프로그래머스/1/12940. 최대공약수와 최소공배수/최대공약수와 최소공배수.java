class Solution {
    public int[] solution(int n, int m) {
        
        int a = gcd(n, m);
        int b = (n * m) / a;
        
        int[] answer = {a,b};
        
        return answer;
    }
    
    private int gcd(int a, int b){
        if(b==0) return a;
        
        return gcd(b, a%b);
    }
}