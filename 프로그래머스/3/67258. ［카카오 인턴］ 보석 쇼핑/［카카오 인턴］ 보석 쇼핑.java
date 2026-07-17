import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        
        int start = 0;
        int end = 0;
        
        Set<String> set = new HashSet();
        
        for(String gem : gems){
            set.add(gem);
        }
        
        int size = set.size();
        
        HashMap<String, Integer> hash = new HashMap();
        
        int[] answer = new int[2];
        answer[0] = 0;
        answer[1] = gems.length-1;
        
        while(end < gems.length){
            String currentGem = gems[end];

            if (!hash.containsKey(currentGem)) {
                hash.put(currentGem, 1);
            } else {
                hash.put(currentGem, hash.get(currentGem) + 1);
            }
            
            while(size == hash.size()){
                if(answer[1] - answer[0] + 1 > end - start + 1){
                    answer[0] = start;
                    answer[1] = end;
                }
                
                hash.put(gems[start], hash.get(gems[start])-1);
                
                if(hash.get(gems[start])==0){
                    hash.remove(gems[start]);
                }
                
                start++;
            }
            
            end++;
        }
     
        answer[0]++;
        answer[1]++;
        
        return answer;
    }
}