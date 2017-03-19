/*
Total Accepted: 27057
Total Submissions: 58471
Difficulty: Easy
Contributors: Admin
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return false.

Show Company Tags
Show Tags
Show Similar Problems



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
    public boolean canAttendMeetings(Interval[] intervals) {
        
        
        if(intervals == null || intervals.length == 0){
            return true;
        }
        
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        
        Interval prev = intervals[0];
        
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i].start - prev.end < 0){
                return false;
            }
            
            prev = intervals[i];
        }
        
        return true;
    }
}







/*

Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2.

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
    public int minMeetingRooms(Interval[] intervals) {
        
        if(intervals == null || intervals.length == 0){
            return 0;
        }
        
        Arrays.sort(intervals, new Comparator<Interval>(){
           @Override
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
            
        });
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        int count = 0;
        
        for(Interval i : intervals){
            
            if(!q.isEmpty() && q.peek() <= i.start){
                q.poll();
            }else{
                count++;
            }
            q.add(i.end);
        }
        
        return count;
        
    }
}









