import java.util.concurrent.locks.ReentrantLock;

public class Singleton {


    private static Singleton instance;

    private static ReentrantLock lock = new ReentrantLock();

    public static Singleton getInstance() {
        if (instance == null) {
            lock.lock();

            if (instance == null) {
                instance = new Singleton();
            }

            lock.unlock();
        }

        return instance;
    }
}


第一种形式是
public class Singleton { 
　　private Singleton(){} 
　　
　　private static final Singleton instance = new Singleton(); 
　　
　　public static Singleton getInstance() { 
　　　　return instance;
　　} 
} 
第二种形式是: 
public class Singleton { 
　　private Singleton(){} 

　　private static Singleton instance = null;

　　public static synchronized Singleton getInstance() { 
　　　　if (instance==null){ 
　　　　　　instance＝new Singleton(); 
　　　　}
　　　　return instance;
　　} 
} 
