import java.util.*;

class Solution {
    
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    
    public int solution(int[][] maps) {
        int answer = Integer.MAX_VALUE;
        
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<Point> q = new LinkedList();
        boolean[][] visited = new boolean[n][m];
        
        visited[0][0] = true;
        q.add(new Point(0,0,1));
        
        while(!q.isEmpty()){
            Point now = q.remove();
            
            if(now.y == n-1 && now.x == m-1){
                answer = Math.min(answer, now.distance);
                continue;
            }
            
            for(int i=0; i<4; i++){
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];
                
                if(0<=nextX && nextX<m && 0<=nextY && nextY<n 
                   && !visited[nextY][nextX] && maps[nextY][nextX]==1){
                    q.add(new Point(nextX, nextY, now.distance+1));
                    visited[nextY][nextX] = true;
                }
            }
        }
        
        answer = (answer==Integer.MAX_VALUE) ? -1 : answer;
        
        return answer;
    }
    
    class Point{
        int x;
        int y;
        int distance;
        
        Point(int x, int y, int distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}