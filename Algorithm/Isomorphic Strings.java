/*
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.

Note:
You may assume both s and t have the same length.

Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  
*/

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        if(s == null && t == null){
            return true;
        }
        
        if((s == null && t != null) || (s != null && t == null) || (s.length() != t.length())){
            return false;
        }
        
        Map<Character, Character> map = new HashMap<>();
        
        Set<Character> set = new HashSet<>();
        
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                if(map.get(s.charAt(i)) != t.charAt(i)){
                    return false;
                }
            }else if(set.contains(t.charAt(i))){
                return false;
            }
            
            map.put(s.charAt(i), t.charAt(i));
            set.add(t.charAt(i));
        }
        
        return true;
        
    }
}
