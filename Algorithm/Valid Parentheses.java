/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  

*/

public class Solution {
    public boolean isValid(String s) {

        Stack<Character> st = new Stack<Character>();

        for(int i =0 ;i !=s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i)  == '[' || s.charAt(i) == '{')
                st.add(s.charAt(i));
            else{
                if(st.empty()) return false;
                if(s.charAt(i) ==')' && st.peek() != '(' ) return false;
                if(s.charAt(i) =='}' && st.peek() != '{' ) return false;
                if(s.charAt(i) ==']' && st.peek() != '[' ) return false;
                st.pop();
            }
        }
        
        return st.empty();
        
        

    }
}
