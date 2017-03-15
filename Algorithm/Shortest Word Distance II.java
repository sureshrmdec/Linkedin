/*

This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words and your method will be called repeatedly many times with different parameters. How would you optimize it?

Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.

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

public class WordDistance {


    Map<String, List<Integer>> map;
    public WordDistance(String[] words) {
        map = new HashMap<>();
        
        for(int i = 0; i < words.length; i++){
            
            String s = words[i];
            
            if(!map.containsKey(s)){
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(s, list);
            }
            map.get(s).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        
        int i = 0;
        int j = 0;
        
        int min = Integer.MAX_VALUE;
        
        while(i < l1.size() && j < l2.size()){
            
            min = Math.min(l1.get(i) < l2.get(j) ? l2.get(j) - l1.get(i++) : l1.get(i) - l2.get(j++), min);
            
        }
        
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
