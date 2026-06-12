class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(String a : arr){
            int i = Integer.parseInt(a);
            if(max < i) max = i;
            if(min > i) min = i;
        }
        
        return min + " " + max;
    }
}