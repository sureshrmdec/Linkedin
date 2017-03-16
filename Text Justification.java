/*
Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.

Return the formatted lines as:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Note: Each word is guaranteed not to exceed L in length.

click to show corner cases.

Show Company Tags
Show Tags
Have you met this question in a real interview? Yes  

*/

public class Solution {
    public List<String> fullJustify(String[] words, int L) {
        
        List<String> res = new ArrayList<>();
        
        
        if(words == null || words.length == 0){
            return res;
        }
        
        int preIndex = 0;
        int curLen = 0;
        
        int count = words.length;
        
        for(int i = 0; i <= count; i++){
            
            
            if(i == count || curLen + i - preIndex + words[i].length() > L){
                StringBuilder sb = new StringBuilder();
                
                int space = L - curLen;
                int spaceCount = i - preIndex - 1;
                
                if(i == count || spaceCount == 0){
                    
                    for(int j = preIndex; j < i; j++){
                        
                        sb.append(words[j]);
                        
                        if(j != i - 1){
                            addSpace(sb, 1);
                        }
                    }
                    
                    
                    addSpace(sb, L - sb.length());
                }else{
                    
                    int spaceEach = space / spaceCount;
                    int spaceRemain = space % spaceCount;
                    
                    for(int j = preIndex; j < i ; j++){
                        
                        sb.append(words[j]);
                        
                        
                        if(j != i - 1){
                            addSpace(sb, spaceEach + (j - preIndex < spaceRemain ? 1 : 0));
                        }
                    }
                }
                res.add(sb.toString());
                preIndex = i;
                curLen = 0;
                
            }
            
            if(i < count){
                curLen += words[i].length();
            }
        }
        
        return res;
        
    }
    
    private void addSpace(StringBuilder sb, int count){
        
        while(count > 0){
            
            sb.append(" ");
            count--;
        }
    }
}
