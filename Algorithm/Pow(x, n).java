/*
Total Accepted: 138649
Total Submissions: 517276
Difficulty: Medium
Contributors: Admin
Implement pow(x, n).

Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  

*/

public class Solution {
    public double myPow(double x, int n) {
        
        
        if(n == 0){
            return 1;
        }
        
        if(n == 1){
            return x;
        }
        
        if(n > 0){
            
            double temp = myPow(x, Math.abs(n / 2));
            
            if(n % 2 == 0){
                
                return temp * temp;
            }else{
                return temp * temp * x;
            }
        }else{
            
            double temp = myPow(x, Math.abs(n / 2));
            
            if(n % 2 == 0){
                
                return 1 / (temp * temp);
            }else{
                return 1 / (temp * temp * x);
            }
            
        } 
    }
}
