import java.util.*;

class Solution {
    public int[] solution(String msg) {
        
        HashMap<String, Integer> map = new HashMap();
        for(int i=65; i<91; i++){
            map.put(String.valueOf((char) i), map.size()+1);
        }
            
        List<Integer> list = new ArrayList();
        int len = msg.length();
        for(int i=0; i<len;){
            int last = i+1;
            
            while(last<=len && map.containsKey(msg.substring(i, last))){
                last++;
            }
            
            // 새 단어 등록
            if(last<=len){
                String word = msg.substring(i, last);
                map.put(word, map.size()+1);
            }
            
            // list에 색인 번호 추가
            list.add(map.get(msg.substring(i, last-1)));
            
            i = last - 1;
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}