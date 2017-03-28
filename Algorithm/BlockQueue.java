import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class BlockQueue<T> {
	public int capacity;
	public Queue<T> queue;
	final Lock lock = new ReentrantLock();
	final Condition notFull = lock.newCondition();
	final Condition notEmpty = lock.newCondition();
	
	public BlockQueue(int limit) {
		this.capacity = limit;
		this.queue = new LinkedList<>();
	}
	
	public void put(T data) throws InterruptedException {
		lock.lock();
		try {
			while (queue.size() == capacity) {
				notFull.await();
			}
			queue.offer(data);
			notEmpty.signal();
		} finally {
			lock.unlock();
		}
	}
	
	public T get() throws InterruptedException {
		lock.lock();
		try {
			while (queue.size() == 0) {
				notEmpty.await();
			}
			T data = queue.poll();
			notFull.signal();
			return data;
		} finally {
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {

		
	}
	
	
}

Superficially the behavior of these method might look similar - acquire()/await() 
can make threads block in some cirsumstances and release()/signal() can unblock threads in some circumstances. 
However Semaphore and Condition serve different purposes:

java.util.concurrent.Semaphore is relatively higher-level synchronization mechanism, 
intended for use by general developers. You would use it typically to restrict concurrent access to some 
resource by making each requester thread call acquire() before accessing the resource 
(that way making the thread block if no semaphore permit was available). Description from the javadoc:
    
    
public class Example {
    private int value = 0;

    private final Semaphore mutex = new Semaphore(1)

    public int getNextValue() throws InterruptedException {
        try {
            mutex.acquire();
            return value++;
        } finally {
            mutex.release();
        }
    }
}

