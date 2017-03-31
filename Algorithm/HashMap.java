public class MyMap<K, V> {


    static class Node<K, V> {

        K key;

        V val;

        Node<K, V> next;

        public Node(K key, V val) {

            this.key = key;
            this.val = val;
        }


    }


    private List<Node<K, V>> buffer;

    private int maxSize;

    private int curSize;


    private ReentrantLock lock = new ReentrantLock();

    public MyMap() {

        this.buffer = new ArrayList<>(100);

        for (int i = 0; i < 100; i++) {

            buffer.add(null);
        }

        maxSize = 100;
        curSize = 0;
    }


    private void put(K key, V val) {

        int code = key.hashCode();

        int index = code % maxSize;


        Node<K, V> node = new Node<>(key, val);


        lock.lock();

        try {


            if (buffer.get(index) == null) {

                buffer.set(index, node);
            } else {

                Node<K, V> curr = buffer.get(index);
                Node<K, V> prev = null;

                while (curr != null && !curr.key.equals(key)) {

                    prev = curr;
                    curr = curr.next;

                }

                if (prev != null) {

                    if (curr == null) {
                        prev.next = node;
                    } else {
                        prev.next = node;
                        node.next = curr.next;

                    }
                }
            }


            curSize++;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }


    public V get(K key) {

        lock.lock();

        try {

            int index = key.hashCode() % maxSize;

            if (buffer.get(index) == null) {
                return null;
            } else {


                Node<K, V> curr = buffer.get(index);

                while (curr != null && !curr.key.equals(key)) {

                    curr = curr.next;
                }

                return curr == null ? null : curr.val;
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

        return null;
    }

    public static void main(String[] args) {
        MyMap<Integer, String> map = new MyMap<>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        System.out.println(map.get(1));
        System.out.println(map.get(2));
        System.out.println(map.get(3));
    }
}
