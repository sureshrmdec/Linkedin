/*

Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.

Update (2015-02-10):
The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.

Show Company Tags
Show Tags
Show Similar Problems


*/

public class Solution {
    public boolean isNumber(String s) {
        
        if(s == null || s.length() == 0){
            return false;
        }
        
        s = s.trim();
        
        
        boolean numberFound = false;
        boolean pointFound = false;
        boolean eFound = false;
        
        boolean numberAfterEFound = true;
        
        
        for(int i = 0; i < s.length(); i++){
            
            char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                
                numberFound = true;
                numberAfterEFound = true;
                
            }else if(c == 'e'){
                
                if(!numberFound || eFound){
                    return false;
                }
                numberAfterEFound = false;
                eFound = true;
            }else if(c == '.'){
                
                if(pointFound || eFound){
                    return false;
                }
                
                pointFound = true;
            }else if(s.charAt(i) == '+' || s.charAt(i) =='-'){
                if(i != 0 && s.charAt(i - 1) != 'e'){
                    return false;
                }
            }else{
                return false;
            }
            
        }
        
        
        return numberFound && numberAfterEFound;
        
    }
}
