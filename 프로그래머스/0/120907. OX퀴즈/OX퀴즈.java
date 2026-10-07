class Solution {
    public String[] solution(String[] quiz) {
        
        int len = quiz.length;
        String[] answer = new String[len];
        
        for(int i=0; i<len; i++){
            String[] arr = quiz[i].split(" ");
            
            boolean valid = true;
            
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[2]);
            int c = Integer.parseInt(arr[4]);
            
            if(arr[1].equals("+")){
                if(a+b!=c) valid = false;
            }else{
                if(a-b!=c) valid = false;
            }
          
            if(valid){
                answer[i] = "O";
            }else{
                answer[i] = "X";
            }
            
        }
        
        return answer;
    }
}