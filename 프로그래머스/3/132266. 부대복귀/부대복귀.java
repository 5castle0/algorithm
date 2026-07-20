import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        
        List<Integer>[] graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] road : roads) {
            graph[road[0]].add(road[1]);
            graph[road[1]].add(road[0]);
        }
        
        int[] distance = new int[n+1];
        Arrays.fill(distance, -1);
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(destination);
        distance[destination] = 0;
        
        while(!queue.isEmpty()){
            int now = queue.poll();
            
            for(int i : graph[now]){
                if(distance[i]==-1){
                    distance[i] = distance[now] + 1;
                    queue.add(i);
                }
            }
            
        }
        
        int[] answer = new int[sources.length];
        
        for(int i=0; i<sources.length; i++){
            answer[i] = distance[sources[i]];
        }
        
        return answer;
    }
}