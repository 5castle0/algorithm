class Solution {
    public static int count = 0;
    public static int[][] arr;
    public static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        
        arr = new int[n][n];
        visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            int[] temp = computers[i];
            
            for(int j=0; j<temp.length; j++){
                if(temp[j]==1){
                    arr[i][j]= arr[j][i] = 1;
                }
            }
        }
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i]=true;
                dfs(i, n);
                count++;
            }
        }
        
        return count;
    }
    
    public static void dfs(int a, int n){
        for(int i=0; i<n; i++){
            if(arr[a][i]==1 && !visited[i]){
                visited[i] = true;
                dfs(i, n);
            }
        }
    }
}