class Solution {
    
    public int[] solution(String[] park, String[] routes) {
        
        // 공원 크기 구하기
        int y = park.length;
        int x = park[0].length();
        
        // 시작점 찾기
        int[] now = new int[2];
        for(int i=0; i<y; i++){
            for(int j=0; j<x; j++){
                if(park[i].charAt(j) == 'S'){
                    now[0] = i;
                    now[1] = j;
                    break;
                }
            }
        }
        
        int[] dy = {0,0,1,-1};
        int[] dx = {1,-1,0,0};
        
        for(String r : routes){
            String[] op = r.split(" ");
            
            int dis = Integer.parseInt(op[1]); // 거리
            
            int dir = 0;
            if(op[0].equals("E")) dir = 0;
            else if(op[0].equals("W")) dir = 1;
            else if(op[0].equals("S")) dir = 2;
            else dir = 3;
            
            int ny = now[0] + (dy[dir] * dis);
            int nx = now[1] + (dx[dir] * dis); 
            
            // 공원을 벗어나는지 확인
            if(0 > ny || y <= ny || 0 > nx || x <=nx) continue;
            
            // 이동 중 장애물을 만나는지 확인
            boolean flag = true;
            for(int i=1; i<= dis; i++){
                int ty = now[0] + (dy[dir] * i);
                int tx = now[1] + (dx[dir] * i); 
                
                if(park[ty].charAt(tx) == 'X') {
                    flag = false; 
                    break;
                }
            }
            
            if(!flag) continue;
            
            now[0] = ny;
            now[1] = nx;
            
        }
        
        return now;
    }
}