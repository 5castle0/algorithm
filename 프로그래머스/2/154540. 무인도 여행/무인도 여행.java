import java.util.*;

class Solution {
    
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[][] map;
    static boolean[][] visited;
    static int count = 0;
    static int y, x;
    
    public int[] solution(String[] maps) {
        y = maps.length;
        x = maps[0].length();
        
        map = new int[y][x];
        for(int i=0; i<y; i++){
            for(int j=0; j<x; j++){
                map[i][j] = maps[i].charAt(j) - '0';
            }
        }
        
        visited = new boolean[y][x];
        List<Integer> list = new ArrayList();
        for(int i=0; i<y; i++){
            for(int j=0; j<x; j++){
                if(map[i][j] != 40 && !visited[i][j]){
                    count = 0;
                    dfs(i, j);
                    list.add(count);
                }
            }
        }
        
        Collections.sort(list);
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] =  list.get(i);
        }
        
        return (answer.length==0) ? new int[]{-1} : answer;
    }
    
    private void dfs(int i, int j){
        visited[i][j] = true;
        count += map[i][j];
        
        for(int k=0; k<4; k++){
            int cy = i + dy[k];
            int cx = j + dx[k];
            
            if(0<=cy && cy<y && 0<=cx && cx<x && map[cy][cx]!=40 && !visited[cy][cx]){
                dfs(cy, cx);
            }
        }
    }
}