/*

Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        
        boolean insert = false;
        
        List<Interval> res = new ArrayList<>();
        
        for(int i = 0; i < intervals.size(); i++){
            
            if(insert){
                
                res.add(intervals.get(i));
                
                continue;
            }
            
            
            if(newInterval.start > intervals.get(i).end){
                
                res.add(intervals.get(i));
                
                continue;
            }
            
            if(newInterval.start <= intervals.get(i).end && intervals.get(i).start <= newInterval.end){
                
                newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
                newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
                continue;
            }
            
            if(newInterval.end < intervals.get(i).end){
                res.add(newInterval);
                insert = true;
                res.add(intervals.get(i));
            }
        }
        
        if(!insert){
            res.add(newInterval);
        }
        
        return res;
        
    }
}
