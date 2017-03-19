/*

151. Reverse Words in a String   Add to List QuestionEditorial Solution  My Submissions
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

*/
public class Solution {
	public String reverseWords(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
 
		// split to words by space
		String[] arr = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = arr.length - 1; i >= 0; --i) {
			if (!arr[i].equals("")) {
				sb.append(arr[i]).append(" ");
			}
		}
		return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
	}
}



public class Solution {
    public void reverseWords(char[] s) {
        if (s.length == 0) return;
        reverse(s, 0, s.length-1);
        int last = 0;
        for (int i=0; i<s.length; i++) {
            if (s[i] == ' ') {
                reverse(s, last, i-1);
                last = i + 1;
            }
        }
    }
    
    public void reverse(char[] s, int l, int r) {
        while (l <= r) {
            int temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }
}
