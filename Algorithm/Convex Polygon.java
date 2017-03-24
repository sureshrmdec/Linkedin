/*

Given a list of points that form a polygon when joined sequentially, find if this polygon is convex (Convex polygon definition).

Note:

There are at least 3 and at most 10,000 points.
Coordinates are in the range -10,000 to 10,000.
You may assume the polygon formed by given points is always a simple polygon (Simple polygon definition). In other words, we ensure that exactly two edges intersect at each vertex, and that edges otherwise don't intersect each other.
Example 1:

[[0,0],[0,1],[1,1],[1,0]]

Answer: True

Explanation:
Example 2:

[[0,0],[0,10],[10,10],[10,0],[5,5]]

Answer: False

Explanation:
Show Company Tags
Show Tags


*/

    public boolean isConvex(int[][] points) {

        if (points == null || points.length == 0 || points[0].length == 0) {

            return false;
        }


        int curr = 0;
        int prev = 0;

        int n = points.length;

        for (int i = 0; i < n; i++) {

            int dx1 = (points[(i + 1) % n][0]) - (points[(i) % n][0]);
            int dy1 = (points[(i + 1) % n][1]) - (points[(i) % n][1]);
            int dx2 = (points[(i + 2) % n][0]) - (points[(i) % n][0]);
            int dy2 = (points[(i + 2) % n][1]) - (points[(i) % n][1]);


           curr = dx1 * dy2 - dx2 * dy1;

           if(curr != 0){

               if(curr * prev < 0){
                   return false;
               }


               prev = curr;

           }
        }

        return true;

    }



public class Solution {
    public boolean isConvex(List<List<Integer>> points) {
        
        
        if(points == null){
            return false;
        }
        
        int n = points.size();
        
        long prev = 0;
        long curr = 0;
        
        for(int i = 0; i < n; i++){
            
            long dx1 = points.get((i + 1) % n).get(0) - points.get(i).get(0);
            long dy1 = points.get((i + 1) % n).get(1) - points.get(i).get(1);
            long dx2 = points.get((i + 2) % n).get(0) - points.get(i).get(0);
            long dy2 = points.get((i + 2) % n).get(1) - points.get(i).get(1);
            
            
            
            curr = dx1 * dy2 - dx2 *dy1;
            
            if(curr != 0){
                if(curr * prev < 0){
                    return false;
                }
                
                else prev = curr;
            }
            
            
            
        }
        return true;
        
    }
}
