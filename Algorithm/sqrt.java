/*

Implement int sqrt(int x).

Compute and return the square root of x.

*/

public class Solution {
    public int mySqrt(int x) {
        
        
        long st = 1;
        long ed = x;
        
        while(st + 1 < ed){
            
            long mid = st + (ed - st) / 2;
            
            if(mid * mid > x){
                ed = mid;
            }else{
                st = mid;
            }
            
        }
        
        if(ed * ed <= x){
            return (int)ed;
        }
        
        return (int)st;
    }
}


int sqrt(int x) {
    if (x == 0) return 0;
    double last = 0;
    double res = 1;
    while (res != last)
    {
        last = res;
        res = (res + x / res) / 2;
    }
    return int(res);
}


double sqrt(double x) {
    if (x == 0) return 0;
    double last = 0.0;
    double res = 1.0;
    while (res != last)
    {
        last = res;
        res = (res + x / res) / 2;
    }
    return res;
}
