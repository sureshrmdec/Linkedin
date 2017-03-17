/*

Total Accepted: 34613
Total Submissions: 91765
Difficulty: Easy
Contributors: Admin
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Returns: True
Example 2:

Input: 14
Returns: False
Credits:
Special thanks to @elmirap for adding this problem and creating all test cases.

*/

public class Solution {
    public boolean isPerfectSquare(int num) {
        
        
        for(int i = 0; i <= nums / i; i++){
            
            if(i * i == num){
                return true;
            }
        }
        
        return false;
        
    }
}
