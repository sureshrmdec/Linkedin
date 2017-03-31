import java.util.concurrent.locks.*;

public class H2O {
    private int HCount = 0;
    private int OCount = 0;
    private Lock lock = new ReentrantLock();
    private Condition condH = lock.newCondition();
    private Condition condO = lock.newCondition();


    public void H() throws InterruptedException {
        lock.lock();
        try {
            HCount++;
            if (HCount >= 2 && OCount >= 1) {
                System.out.println("2 H and 1 O consumed in H()");
                HCount -= 2;
                OCount -= 1;
                condH.signal();
                condO.signal();
            } else {
                condH.await();
            }
        } finally {
            lock.unlock();
        }
    }

    public void O() throws InterruptedException {
        lock.lock();
        try {
            OCount++;
            if (HCount >= 2 && OCount >= 1) {
                System.out.println("2 H and 1 O consumed in O()");
                HCount -= 2;
                OCount -= 1;
                condH.signal();
                condH.signal();
            } else {
                condO.await();
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        int n = 3;
        final H2O h2o = new H2O();
        Thread[] threads = new Thread[n];
        for (int i = 0; i < n; i++) {
            final int id = i;
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 3; j++) {
                        if (id % 3 == 0) {
                            try {
                                System.out.println(String.format("Producing an O in thread %d", id));
                                h2o.O();
                            } catch (InterruptedException e) {
                                System.out.println(String.format("Thread %d is interrupted for O().", id));
                            }
                        } else {
                            try {
                                System.out.println(String.format("Producing an H in thread %d", id));
                                h2o.H();

                            } catch (InterruptedException e) {
                                System.out.println(String.format("Thread %d is interrupted for H().", id));
                            }
                        }
                    }
                }
            });
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }
}




package multiThreads;
 
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
 
class H2O {
    int Hcount;
    int Ocount;
    Lock lock = new ReentrantLock();
    Condition cH = lock.newCondition();
    Condition cO = lock.newCondition();
  
    public void H() {
        lock.lock();
        Hcount++;
        if (Hcount >= 2 && Ocount >= 1) {
            Hcount -= 2;
            Ocount -= 1;
            cH.signal();
            cO.signal();
            System.out.println("H2O");
        } else {
            try {
                cH.await();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        lock.unlock();
    }
  
    public void O() {
        lock.lock();
        Ocount++;
        if (Hcount >= 2 && Ocount >= 1) {
            Hcount -= 2;
            Ocount -= 1;
            cH.signal();
            cH.signal();
            System.out.println("H2O");
        } else {
            try {
                cO.await();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        lock.unlock();
    }
}
 
class Hclass implements Runnable {
    private H2O obj;
  
    public Hclass(H2O obj) {
        this.obj = obj;
    }
    @Override
    public void run() {
        // TODO Auto-generated method stub
        obj.H();
    }
  
}
 
class Oclass implements Runnable {
    private H2O obj;
  
    public Oclass(H2O obj) {
        this.obj = obj;
    }
    @Override
    public void run() {
        // TODO Auto-generated method stub
        obj.O();
    }
  
}
 
public class H2Oexample {
    final private static H2O obj = new H2O();
  
    public static void main(String[] args) {
        for (int i = 0; i< 10; i++) {
            new Thread(new Hclass(obj)).start();
        }
        for (int i = 0; i< 5; i++) {
            new Thread(new Oclass(obj)).start();
        }
    }
}
