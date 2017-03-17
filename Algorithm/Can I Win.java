/*

In the "100 game," two players take turns adding, to a running total, any integer from 1..10. The player who first causes the running total to reach or exceed 100 wins.

What if we change the game so that players cannot re-use integers?

For example, two players might take turns drawing from a common pool of numbers of 1..15 without replacement until they reach a total >= 100.

Given an integer maxChoosableInteger and another integer desiredTotal, determine if the first player to move can force a win, assuming both players play optimally.

You can always assume that maxChoosableInteger will not be larger than 20 and desiredTotal will not be larger than 300.

Example

Input:
maxChoosableInteger = 10
desiredTotal = 11

Output:
false

Explanation:
No matter which integer the first player choose, the first player will lose.
The first player can choose an integer from 1 up to 10.
If the first player choose 1, the second player can only choose integers from 2 up to 10.
The second player will win by choosing 10 and get a total = 11, which is >= desiredTotal.
Same with other integers chosen by the first player, the second player will always win.

*/
public class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        
        
        if(maxChoosableInteger >= desiredTotal){
            
            return true;
        }
        
        if((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal){
            
            return false;
        }
        
        
        char[] check = new char[maxChoosableInteger];
        for(int i = 0; i < maxChoosableInteger; i++) {
            check[i] = '0';
        }
                
        Map<String, Boolean> map = new HashMap<>();
        
        return helper(desiredTotal, check , map);
        
    }
    
    private boolean helper(int desiredTotal, char[] check, Map<String, Boolean> map){
        
        String s = new String(check);
        
        if(map.containsKey(s)){
            return map.get(s);
        }
        
        for(int i = 0; i < check.length; i++){
            
            if(check[i] == '0'){
                check[i] = '1';
                
                if(desiredTotal <= i + 1 || !helper(desiredTotal - (i + 1), check, map)){
                    map.put(s, true);
                    check[i] = '0';
                    return true;
                }
                
                check[i] = '0';
            }
        }
        
        map.put(s, false);
        return false;
        
    }
}
