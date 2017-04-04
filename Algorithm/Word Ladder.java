/*
Total Accepted: 114284
Total Submissions: 593961
Difficulty: Medium
Contributors: Admin
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
UPDATE (2017/1/20):
The wordList parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.
*/

public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
         if(wordList == null){
            return 0;
        }
        
        if(beginWord.equals(endWord)){
            return 1;
        }
        
        Queue<String> q = new LinkedList<>();
        
        Set<String> words = new HashSet<>();
        
        Set<String> set = new HashSet<>();
        
        words.add(beginWord);
        
        for(String s: wordList){
            words.add(s);
        }
        
        q.add(beginWord);
        
        int count = 1;
        
        while(!q.isEmpty()){

            count++;
            
            int size = q.size();
            
            for(int i = 0; i < size; i++){
                String s = q.poll();
                for(int j = 0; j < s.length(); j++){
                    char[] arr = s.toCharArray();
                    for(char c = 'a'; c <= 'z'; c++){
                        arr[j] = c;
                    
                        String temp = new String(arr);
                    
                        if(words.contains(temp)){
                        
                            if(temp.equals(endWord)){
                                return count;
                            }else if (!set.contains(temp)) {
				    
			 	q.add(temp);
				set.add(temp);
				    
			    }
				
                        }
                  
                    }
                }
            }
            
        }
        
        return 0;
        
    }
}
