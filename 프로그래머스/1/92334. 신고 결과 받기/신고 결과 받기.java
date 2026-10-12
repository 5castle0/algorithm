import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int n = id_list.length;

        // 이름과 id 매칭
        HashMap<String, Integer> nameList = new HashMap();
        for(int i=0; i<n; i++){
            nameList.put(id_list[i], i);
        }
        
        // 신고 기록 저장
        HashMap<String, Integer> reported = new HashMap();
        Set<String> set = new HashSet(Arrays.asList(report));
        for(String s : set){
            String[] name = s.split(" ");
            
            reported.put(name[1], reported.getOrDefault(name[1], 0) + 1);
        }
        
        // 메일 받는 사람 찾기
        int[] answer = new int[n];
        for(String s : set){
            String[] name = s.split(" ");
            
            if(reported.get(name[1])>=k){
                answer[nameList.get(name[0])]++;
            }
        }
        
        return answer;
    }
}