/*
implement stack with pop(), push() and findmiddle() with O(1) time

*/

/*


Find Median from Data Stream   Add to List QuestionEditorial Solution  My Submissions
Examples: 
[2,3,4] , the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
For example:

add(1)
add(2)
findMedian() -> 1.5
add(3) 
findMedian() -> 2



*/

public class MedianFinder {

    // Adds a number into the data structure.Collections.reverseOrder()
    
    private PriorityQueue<Integer> minQueue = new PriorityQueue<Integer>();
    private PriorityQueue<Integer> maxQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
    
    
    public void addNum(int num) {
        
        maxQueue.add(num);
        
        minQueue.add(maxQueue.poll());
        
        
        if(maxQueue.size() < minQueue.size()){
            maxQueue.add(minQueue.poll());
        }
        
        
    }

    // Returns the median of current data stream
    public double findMedian() {
        
        if(minQueue.size() == maxQueue.size()){
            return (double)((maxQueue.peek() + minQueue.peek())) / 2;
        }else{
            return maxQueue.peek();
        }
    }
};
