/*
implement stack with pop(), push() and findmiddle() with O(1) time

*/








package com.company;

/**
 * Created by Jason on 4/1/2017.
 */
public class MidStack<T> {


	static class Node<T> {

		T val;
		Node<T> prev;
		Node<T> next;

		Node(T val) {
			this.val = val;
		}


	}

	private int size = 0;
	private Node<T> head = null;
	private Node<T> tail = null;
	private Node<T> mid = null;


	public void push(T val) {

		Node<T> node = new Node<T>(val);

		if (head == null) {

			head = node;
			tail = node;
			mid = node;
		} else {
			tail.next = node;
			node.prev = tail;
			tail = node;

			if (size % 2 == 0) {
				mid = mid.next;
			}


		}

		size++;

	}


	public T pop() {
		if(tail == null){
			return null;
		}

		Node<T> temp = tail;

		if(size == 1){

			head = null;
			tail = null;
			mid = null;
		}else{
			tail.prev.next = null;
			if(size % 2 != 0){
				mid = mid.prev;
			}

			tail = tail.prev;
		}

		size--;

		return temp.val;



	}
	public T mid() {
		if (mid == null) {
			return null;
		}
		return mid.val;
	}


	public static void main(String[] args) {
		MidStack<Integer> ms = new MidStack<>();
		ms.push(1);
		ms.push(2);
		ms.push(3);
		System.out.println("mid: " + ms.mid());
		ms.pop();
		System.out.println("mid: " + ms.mid());
		ms.pop();
		System.out.println("mid: " + ms.mid());
	}
}








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
