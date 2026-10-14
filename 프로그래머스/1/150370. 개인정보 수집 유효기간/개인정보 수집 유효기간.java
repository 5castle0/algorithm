import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList();
    
        HashMap<String, Integer> map = new HashMap();
        for(String t : terms){
            String[] term = t.split(" ");
            
            map.put(term[0], Integer.parseInt(term[1]));
        }
        
        // today date
        String[] now = today.split("\\.");
        int y = Integer.parseInt(now[0]);
        int m = Integer.parseInt(now[1]);
        int d = Integer.parseInt(now[2]);
        int value = y * 12 * 28 + m * 28 + d;
        
        for(int i=1; i<=privacies.length; i++){
            String[] temp = privacies[i-1].split(" ");
            
            String[] date = temp[0].split("\\.");
            int ny = Integer.parseInt(date[0]);
            int nm = Integer.parseInt(date[1]);
            int nd = Integer.parseInt(date[2]);
            
            int total = ny * 12 * 28 + nm * 28 + nd + map.get(temp[1]) * 28;    
            if(value >= total){
                list.add(i);
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}