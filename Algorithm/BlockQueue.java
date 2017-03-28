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


Superficially the behavior of these method might look similar - acquire()/await() can make threads block in some cirsumstances and release()/signal() can unblock threads in some circumstances. However Semaphore and Condition serve different purposes:

java.util.concurrent.Semaphore is relatively higher-level synchronization mechanism, intended for use by general developers. 
	You would use it typically to restrict concurrent access to some resource by making each requester thread call acquire() 
	before accessing the resource (that way making the thread block if no semaphore permit was available).
	Description from the javadoc:
Conceptually, a semaphore maintains a set of permits. Each acquire() blocks if necessary until a permit is available, 
and then takes it. Each release() adds a permit, potentially releasing a blocking acquirer.
java.util.concurrent.locks.Condition is relatively low-level synchronization mechanism which basically enhances functionality 
provided java.lang.Object methods wait(), notify() and notifyAll(). It enables the thread to suspend its activities 
when it needs to wait for some condition to become true (generally through activity of other threads) and then 
it enables those other threads to "wake up" the waiting thread(s) when the state variables taking part in 
the condition might have changed. It is generally harder to use correctly and general developers are advised 
to use higher-level mechanisms from package java.util.concurrent (like Semaphore).
You can find more detailed information about this in the excellent book "Java Concurrency in Practice" from Brian Goetz.



 表面上这两个方法的行为是相似的: acquire()/await()在某些情况下可以令线程阻塞, release()/signal()则可以解除阻塞. 
	 然而Semaphore和Condition有着不同的目的：

    1.java.util.concurrent.Semaphore是相对更高级别的同步机制, 旨在供程序员使用. 你可以在访问资源之前, 
使请求者线程调用acquire()来限制对资源的并发访问(如果没有semaphore 的许可, 此方法令线程阻塞). javadoc中的描述为:

    Conceptually, a semaphore maintains a set of permits. Each acquire() blocks if necessary until a permit is available, 
and then takes it. Each release() adds a permit, potentially releasing a blocking acquirer.
    2.java.util.concurrent.locks.Condition则是一个相对低级别的同步机制, 它主要提升了java.lang.Object methods wait(), 
notify() and notifyAll()的功能. 当需要等待某些条件为真时(通常通过其它线程的活动), 它使线程暂停活动; 当条件中状态变量变化的时候, 
使其他线程"唤醒"正在等待的线程. 通常来说, 正确使用它是比较困难的并且建议开发者使用java.util.concurrent包中更高级的机制（比如： Semaphore）.
    
    
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

