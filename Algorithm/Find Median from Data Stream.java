public class MedianFinder {

    // Adds a number into the data structure.
    
    private Queue<Integer> maxQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
    
    private Queue<Integer> minQueue = new PriorityQueue<Integer>();
    
    public void addNum(int num) {
        
        maxQueue.add(num);
        minQueue.add(maxQueue.poll());
        
        if(maxQueue.size() < minQueue.size()){
            maxQueue.add(minQueue.poll());
        }
        
    }

    // Returns the median of current data stream
    public double findMedian() {
        
        if(maxQueue.size() == minQueue.size()){
            return (double)(maxQueue.peek() + minQueue.peek()) / 2;
        }else{
                    
            return maxQueue.peek();
        }

    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
