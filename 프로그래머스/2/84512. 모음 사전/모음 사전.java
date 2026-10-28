import java.util.*;

class Solution {
    
    static List<String> list = new ArrayList();
    static String[] s = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        dfs("", 0);
        
        return list.indexOf(word);
    }
    
    static void dfs(String str, int depth){
        list.add(str);
        if(depth==5) return;
        
        for(int i=0; i<5; i++){
            dfs(str+s[i], depth+1);
        }
    }
}