/*

Total Accepted: 26526
Total Submissions: 51682
Difficulty: Easy
Contributors: Admin
Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.

Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.

Show Company Tags
Show Tags
Show Similar Problems

*/
public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        
        int i = -1;
        int j = -1;
        
        int min = Integer.MAX_VALUE;
        
        for(int k = 0; k < words.length; k++){
            
            if(words[k].equals(word1)){
                i = k;
            }
            
            if(words[k].equals(word2)){
                j = k;
            }
            
            if(i != -1 && j != -1){
                
                min = Math.min(Math.abs(i - j), min);
            }
        }
        
        return min;
        
    }
}
