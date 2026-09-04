class Solution {
    public String solution(int a, int b) {
        String[] day = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        int[] days = {0,31,29,31,30,31,30,31,31,30,31,30,31};
        
        int total = b;
        
        for(int i=1; i<a; i++){
            total += days[i];
        }
        
        total %= 7;

        return day[total];
    }
}