class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        
        int left = 9;
        int right = 11;
        
        for(int n : numbers){
            int num = n-1; // index화
            if(n==0) num = 10;
            
            if(num%3 == 0){
                sb.append("L");
                left = num;
            }else if(num%3 == 2){
                sb.append("R");
                right = num;
            }else{
                int leftDistance = calculate(left, num);
                int rightDistance = calculate(right, num);
                
                if(leftDistance == rightDistance){
                    if(hand.equals("right")){
                        sb.append("R");
                        right = num;
                    }else{
                        sb.append("L");
                        left = num;
                    }
                }else if(leftDistance < rightDistance){
                    sb.append("L");
                    left = num;
                }else{
                    sb.append("R");
                    right = num;
                }
            }
        }
        
        return sb.toString();
    }
    
    private int calculate(int x, int y){
        int x1 = x%3; // x
        int x2 = x/3; // y
        
        int y1 = y%3;
        int y2 = y/3;
        
        return Math.abs(y2-x2) + Math.abs(y1-x1);
    }
}