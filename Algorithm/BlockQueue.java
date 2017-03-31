


package test;

import com.company.B;
import com.company.Execution;

import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockQueue<T> {
    private Queue<T> q;

    private ReentrantLock lock = new ReentrantLock();

    private Condition empty = lock.newCondition();

    private Condition full = lock.newCondition();


    private int capacity;


    public BlockQueue(int capacity) {

        this.capacity = capacity;
        q = new LinkedList<>();

    }

    public void put(T data) {

        lock.lock();

        try {

            while (q.size() == capacity) {
                full.await();
            }

            q.offer(data);

            empty.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }


    public T getData() {

        lock.lock();

        try {

            while (q.isEmpty()) {
                empty.await();
            }

            T data = q.poll();

            full.signal();
            return data;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


        return null;

    }
}








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

Again from The Little Book of Semaphores, §2.2:

Listing 2.1: Semaphore initialization syntax
fred = Semaphore(1)
The function Semaphore is a constructor; it creates and returns a new Semaphore. 
The initial value of the semaphore is passed as a parameter to the constructor.
So in the author's pseduocode, 0 isn't the number of permits; 


it's the initial value of the semaphore. What does a value of zero mean? 
It's explained in the text immediately proceeding listing 2.1:
If the value is positive, then it represents the number of threads that can decrement without blocking. 
If it is negative, then it represents the number of threads that have blocked and are waiting.
If the value is zero, it means there are no threads waiting, but if a thread tries to decrement, it will block.

Can I add more permit to a semaphore in Java?

Semaphore s = new Semaphore(3);

semaphore.release(10);
