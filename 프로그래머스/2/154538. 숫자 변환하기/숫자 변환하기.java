import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        Queue<Move> q = new LinkedList();
        boolean[] visited = new boolean[y+1];
        
        q.add(new Move(x, 0));
        visited[x] = true;
        
        while(!q.isEmpty()){
            Move now = q.poll();
            
            if(now.point > y){
                continue;
            }
            
            if(now.point == y){
                return now.count;
            }
            
            int[] nexts = {now.point + n, now.point * 2, now.point * 3};
            
            for(int next : nexts){
                if(next <= y && !visited[next]){
                    q.add(new Move(next, now.count + 1));
                    visited[next] = true;
                }
            }
        }
        
        return -1;
    }
    
    public class Move{
        int point;
        int count;
        
        public Move(int point, int count){
            this.point = point;
            this.count = count;
        }
    }
}