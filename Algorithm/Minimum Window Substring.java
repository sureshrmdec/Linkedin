/*

Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the empty string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
*/

public class Solution {
    public String minWindow(String s, String t) {
        
        
        int[] map = new int[256];
        
        
        for(int i = 0; i < t.length(); i++){
            map[t.charAt(i)]++;
        }
        
        
        int st = 0;
        int ed = 0;
        
        int head = 0;
        
        int len = Integer.MAX_VALUE;
        
        int count = t.length();
        
        while(ed < s.length()){
            
            if(map[s.charAt(ed)] > 0){
                
                count--;
            }
            
            map[s.charAt(ed)]--;
            ed++;
            
            
            while(count == 0){


                if(map[s.charAt(st)] == 0){
                    count++;
                }
                
                
                if(ed - st < len){
                    len = ed - st;
                    head = st;
                }

                
                map[s.charAt(st)]++;
                st++;
            }
            
        }
        
        return len == Integer.MAX_VALUE ? "" : s.substring(head, head + len);
        
    }
}
