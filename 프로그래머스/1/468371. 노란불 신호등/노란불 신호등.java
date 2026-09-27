class Solution {
    public int solution(int[][] signals) {
        int answer = 0;
        
        int lights = signals.length;
        int[] times = new int[lights];
        for(int i=0; i<lights; i++){
            for(int j=0; j<signals[i].length; j++){
                times[i] += signals[i][j];
            }
        }
        
        int deadline = 1;
        for(int i : times){
            deadline *= i; // 공배수
        }
    
        for(int i=1; i<=deadline; i++){
            int yellow = 0;
            
            for(int[] signal : signals){
                int g = signal[0];
                int y = signal[1];
                int r = signal[2];
                
                int cycle = g+y+r;
                
                if(g<i%cycle && i%cycle<=g+y){
                    yellow++;
                }
            }
            
            if(yellow==lights){
                return i;
            }
        }
        
        return -1;
    }
}