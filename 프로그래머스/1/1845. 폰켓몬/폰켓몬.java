import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        HashSet<Integer> set = new HashSet();
        
        for(int i : nums){
            set.add(i);
        }
        
        int size = set.size();
        int len = nums.length;
        
        return (size>=len/2) ? len/2 : size;
    }
}