import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        
        List<String> spoiler = new ArrayList();
        Set<String> notSpoiler = new HashSet();
        
        String[] words = message.split(" ");
        int idx = 0;
        
        for(String word : words){
            // 검사할 단어 범위
            int start = idx;
            int end = idx + word.length() - 1;
            
            boolean isSpoiler = false;
            for(int[] range : spoiler_ranges){
                if(start<=range[1] && end>=range[0]){
                    spoiler.add(word);
                    isSpoiler = true;
                    break;
                }
            }
            
            if(!isSpoiler){
                notSpoiler.add(word);
            }
            
            // 다음 단어 인덱스 (띄어쓰기 포함)
            idx += word.length() + 1; 
        }
        
        Set<String> important = new HashSet();
        for(String s : spoiler){
            if(!important.contains(s) && !notSpoiler.contains(s)){
                important.add(s);
                System.out.println(s);
            }
        }
        
        return important.size();
    }
}