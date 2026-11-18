import java.util.*;

class Solution {
    public int solution(String dirs) {
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        
        int x = 0;
        int y = 0;
        
        Set<String> set = new HashSet();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        
        int answer = 0;
        
        for(int i=0; i<dirs.length(); i++){
            int dir = getDir(dirs.charAt(i));
            
            int cx = x + dx[dir];
            int cy = y + dy[dir];
            
            if(-5 > cx || 5 < cx || -5 > cy || 5 < cy){
                continue;
            }
            
            sb1.setLength(0);
            sb2.setLength(0);
            sb1.append(x).append(y).append(cx).append(cy);
            sb2.append(cx).append(cy).append(x).append(y);
            
            if(!set.contains(sb1.toString())){
                set.add(sb1.toString());
                set.add(sb2.toString());
                answer++;
            }
            
            x = cx;
            y = cy;
        }
        
        return answer;
    }
    
    private int getDir(char s){
        switch(s){
            case 'R': 
                return 0;
            case 'L':
                return 1;
            case 'U':
                return 2;
            default:
                return 3;
        }
    }
}