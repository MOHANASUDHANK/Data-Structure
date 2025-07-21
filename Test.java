public class Test {
        public static void main(String[] args) {
        // MyArrayList<Integer> li = new MyArrayList<>();
        // li.add(1);
        // li.add(2);
        // li.add(3);
        // li.print();

        // MyDeque<Integer> dq = new MyDeque<>();
        // dq.addFirst(1);
        // dq.addFirst(0);;
        // dq.addFirst(-1);
        // dq.addLast(2);
        // dq.print();
         

        // MyHashMap<Integer,String> mp = new MyHashMap<>();
        // mp.put(1, "apple");
        // mp.put(2,"mango");
        // mp.put(2, "banana");
        // System.out.println(mp.get(2));
        // mp.print();
        // System.out.println("hello");
        
        MyPriorityQueue<Integer> pq = new MyPriorityQueue<>();
        pq.add(7);
        pq.add(2);
        pq.add(4);
        pq.add(1);
        pq.print();
        pq.poll();
        pq.poll();
        pq.print();

        }
}
