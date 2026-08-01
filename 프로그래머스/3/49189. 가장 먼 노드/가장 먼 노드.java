import java.util.*;

class Solution {
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int max = 0;
        
        boolean[][] arr = new boolean[n+1][n+1]; // 연결 정보
        boolean[] visited = new boolean[n+1]; // 방문 정보
        int[] count = new int[n+1]; // 간선 갯수
        
        for(int[] e : edge){
            int a = e[0];
            int b = e[1];
            
            arr[a][b] = arr[b][a] = true;
        }
        
        
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        
        while(!queue.isEmpty()){
            int now = queue.remove();
            
            for(int i=1; i<=n; i++){
                if(!visited[i] && arr[i][now]){
                    visited[i] = true;
                    queue.add(i);
                    count[i] = count[now] + 1;
                }
            }
        }
        
        for(int i : count){
            if(max < i){
                max = i;
                answer = 1;
            }else if(max==i){
                answer++;
            }
        }
        
        return answer;
    }
    
}