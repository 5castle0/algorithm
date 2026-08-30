class Solution {
    public int[] solution(int[][] arr) {
        return dfs(arr, 0, 0, arr.length);
    }
    
    private static int[] dfs(int[][] arr, int y, int x, int size){
        
        if(isSame(arr, y, x, size)){
            if(arr[y][x] == 0) {
                return new int[]{1,0};
            }else{
                return new int[]{0,1};
            }
        }
        
        int newSize = size/2;
        
        int[] a = dfs(arr, y, x, newSize);
        int[] b = dfs(arr, y+newSize, x, newSize);
        int[] c = dfs(arr, y, x+newSize, newSize);
        int[] d = dfs(arr, y+newSize, x+newSize, newSize);
        
        int[] answer = new int[2];
        
        answer[0] = a[0] + b[0] + c[0] + d[0];
        answer[1] = a[1] + b[1] + c[1] + d[1];
        
        return answer;
    }
    
    private static boolean isSame(int[][] arr, int y, int x, int size){
        
        int standard = arr[y][x];
        
        for(int i=y; i<y+size; i++){
            for(int j=x; j<x+size; j++){
                if(standard != arr[i][j]){
                    return false;
                }
            }
        }
        
        return true;
    }
}