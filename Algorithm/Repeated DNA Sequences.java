/*
All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].
Show Company Tags
Show Tags
Have you met this question in a real interview? Yes  

*/

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        
        
        Set<String> one = new HashSet<>();
        
        Set<String> two = new HashSet<>();
        
        for(int i = 0 ; i + 9 < s.length(); i++){
            
            String sub = s.substring(i, i + 10);
            
            if(!one.add(sub)){
                two.add(sub);
            }
        }
        
        return new ArrayList(two);
        
        
    }
}
