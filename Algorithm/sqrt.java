/*

Implement int sqrt(int x).

Compute and return the square root of x.

*/


	public static double mySqrt(double x, int digit) {
		double start = 0;
		double end = x < 1 ? 1.0 : x;
		double diff = 1 / Math.pow(10, digit);
		while (start < end - diff) {
			double mid = start + (end - start) / 2;
			if (mid == x / mid) {
				return mid;
			} else if (mid > x / mid) {
				end = mid;
			} else {
				start = mid;
			}
		}
		return (start + end) / 2;
	}

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

public class SquareRootFinder {
 
    public static void main(String args[]) {
 
        System.out.println("Square Root of 25 is: " + squareRoot(25));
        System.out.println("Square Root of 81 is: " + squareRoot(81));
        System.out.println("Square Root of -100 is: " + squareRoot(-100));
        System.out.println("Square Root of 1 is: " + squareRoot(1));
        System.out.println("Square Root of 0 is: " + squareRoot(0));
 
    }
 
    /**
     * This method use binary search to find the square root.
     *
     * @param number
     * @return square root of the number
     */
    private static double squareRoot(double number) {
        double squareRoot = 0;
        double startValue = 0;
        double endValue = number;
        double precision = 0.00001;
 
        if (number < 0) {
            squareRoot = -1;
        } else if (number == 0 || number == 1) {
            squareRoot = number;
        } else {
 
            // we will use binary search to narrow down.
            while (endValue - startValue > precision) {
                double midValue = (startValue + endValue) / 2;
                squareRoot = midValue * midValue;
 
                if (squareRoot == number) {
                    return squareRoot;
                } else if (squareRoot > number) {
                    endValue = midValue;
                } else {
                    startValue = midValue;
                }
            }
 
            // if a match is not found
            squareRoot = (startValue + endValue) / 2;
 
        }
        return squareRoot;
    }
 
}
