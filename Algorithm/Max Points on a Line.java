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
