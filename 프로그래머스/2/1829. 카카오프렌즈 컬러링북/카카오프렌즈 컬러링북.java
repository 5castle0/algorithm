class Solution {
    
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int size = 0;
    static boolean[][] isVisited;
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        isVisited = new boolean[m][n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!isVisited[i][j]){
                    isVisited[i][j] = true;
                    
                    // 아무것도 칠해져 있지 않은 경우
                    if(picture[i][j] == 0) {
                        continue;
                    }
                    
                    numberOfArea++;
                    size = 1;
                    dfs(i, j, picture, m, n);
                    
                    if(maxSizeOfOneArea < size) maxSizeOfOneArea = size;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    private void dfs(int y, int x, int[][] picture, int m, int n){
        for(int i=0; i<4; i++){
            int cy = y + dy[i];
            int cx = x + dx[i];
            
            if(0<=cy && cy<m && 0<=cx && cx<n) {
                if(!isVisited[cy][cx] && picture[y][x] == picture[cy][cx]){
                    isVisited[cy][cx] = true;
                    size++;
                    dfs(cy, cx, picture, m, n);
                }
            }
        }
    }
}