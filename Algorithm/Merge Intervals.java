/*

Total Accepted: 111413
Total Submissions: 385083
Difficulty: Medium
Contributors: Admin
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        
        
        
        if(intervals == null || intervals.size() == 0){
            return intervals; 
        }
        
        Collections.sort(intervals, new Comparator<Interval>(){
           
            public int compare(Interval i1, Interval i2){
                
                return i1.start - i2.start;
            }
            
        });
        
        
        
        List<Interval> res = new ArrayList<>();
        Interval prev = intervals.get(0);
        
        for(int i = 1; i < intervals.size(); i++){
            
            Interval curr = intervals.get(i);
        
            if(prev.end >= curr.start){
                
                prev.end = Math.max(prev.end, curr.end);
            }else{
                res.add(prev);
                prev = curr;
            }
        
        }
        
        res.add(prev);
        
        return res;
    }
}
