class Solution {
    public int[] solution(String[] wallpaper) {
        int y = wallpaper.length;
        int x = wallpaper[0].length();
        
        int[] answer = {y+1,x+1,0,0};
        
        for(int i=0; i<y; i++){
            String s = wallpaper[i];
            
            for(int j=0; j<x; j++){
                if(s.charAt(j)=='#'){
                    if(answer[0]>i) answer[0] = i;
                    if(answer[1]>j) answer[1] = j;
                    
                    if(answer[2]<=i) answer[2] = i+1;
                    if(answer[3]<=j) answer[3] = j+1;
                }
            }
        }
        
        return answer;
    }
}