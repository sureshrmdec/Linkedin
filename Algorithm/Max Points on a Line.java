/*

Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  
*/

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
	public int maxPoints(Point[] points) {
		if(points.length == 0||points == null)
			return 0;

		if(points.length == 1)
			return 1;

		int max = 0;  //the final max value, at least one
		for(int i = 0; i < points.length; i++) {
			HashMap<Float, Integer> hashMap = new HashMap<Float, Integer>();
			int duplicate = 0;
			int localMax = 1; //the max value of current slope, at least one
			for(int j = 0; j < points.length; j++) {
				if(i == j)
					continue;

				if(points[i].x == points[j].x && points[i].y == points[j].y){
					duplicate++;
					continue;
				}


				float k = (float) (points[j].y - points[i].y) / (points[j].x - points[i].x);

				int value = 2;

				if (hashMap.containsKey(k)) {
					value = hashMap.get(k) + 1;
				}

				hashMap.put(k, value);
			}

            for (Integer value : hashMap.values())   {
                localMax = Math.max(localMax, value);  
            }
          
            localMax += duplicate;  
            max = Math.max(max, localMax);  
		}
		return max;
	}
}



/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

public class Solution {
    public int maxPoints(Point[] points) {
        if (points.length <= 1)
            return points.length;
        int maxUniv = Integer.MIN_VALUE;
        for (int i = 0; i < points.length; i++) {
            Point cur = points[i];
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            int howManyCur = 1, maxLocal = 0;
            for (int j = i + 1; j < points.length; j++) {   //这里可以从i+1开始，之前的都算过了
                    Point iter = points[j];
                    if (iter.x == cur.x && iter.y == cur.y) {//同一顶点
                        howManyCur += 1;
                    } 
                    else {          //不同顶点
                        String key = getSlopeInString(cur, iter);
                        //map里存(过cur点,斜率key)代表的直线有多少除了cur的点
                        map.put(key, map.containsKey(key) ? map.get(key) + 1 : 1);
                        maxLocal = Math.max(maxLocal, map.get(key));
                    }
            }
            maxLocal = howManyCur + maxLocal;
            maxUniv = Math.max(maxLocal, maxUniv);
        }
        return maxUniv;
    }
    public String getSlopeInString(Point cur, Point iter) {
        int numerator = iter.y - cur.y;
        int denominator = iter.x - cur.x;
        String sign = getSign(numerator, denominator);
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));//0和任意一个非零数'a'的gcd为'a',0和0的gcd为0,所以斜率为无穷的情况分母为0
        return sign + Math.abs(numerator)/gcd + "/" + Math.abs(denominator)/gcd;
    }
    //a和b为非负整数 且 a和b不同时为0
    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }
    public String getSign(int a, int b) {
        if (a <= 0 && b <= 0 || a >= 0 && b >= 0)
            return "+";
        else 
            return "-";
    }
}
