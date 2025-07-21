public class MyHashMap<K,V>{

        private static class Node<K,V> {
                K key;
                V value;
                Node<K,V> next;

                Node(K key,V value){
                        this.key = key;
                        this.value = value;
                }
        }

        private int capacity;
        private float loadFactor;
        private int size;
        private Node<K,V>[] buckets;

        MyHashMap(){
                capacity = 16;
                loadFactor = 0.75f;
                buckets =(Node<K, V>[]) new Node[capacity];
        }

        private int hash(K key){
                if(key == null) return 0;
                int h = key.hashCode();
                return ( h^(h>>>16)) & (capacity - 1);
        }

        public void put(K key , V value){
                int index = hash(key);
                Node<K,V> head = buckets[index];
                Node<K,V> curr = head;

                while(curr != null){
                        if((curr.key == null && key == null ) || (curr.key != null && curr.key.equals(key))){
                                curr.value = value;
                                return;
                        }
                        curr = curr.next;
                }
                Node<K,V> newNode = new Node<K,V>(key, value);
                newNode.next = head;
                buckets[index] = newNode;
                size++;

                if((float)size/capacity >= loadFactor){
                        resize();
                }
        }

        public V get(K key){
                int index = hash(key);
                Node<K,V> head = buckets[index];
                while (head != null) {
                        if((head.key == null && key == null ) || (head.key != null && head.key.equals(key))){
                                return head.value;
                        }
                        head = head.next;
                }
                return null;
        }

        public V remove(K key){
                int index = hash(key);
                Node<K,V> curr = buckets[index];
                Node<K,V> prev = null;
                while(curr != null){
                        if((key == null && curr.key == null) || (curr.key != null && curr.key.equals(key))){
                                if(prev == null) buckets[index] = curr.next;
                                else prev.next = curr.next;
                                size-- ;
                                return curr.value;
                        }
                        prev = curr;
                        curr = curr.next;
                }
                return null;
        }

        public int size(){
                return size;
        }

        public boolean containsKey(K key){
                int index = hash(key);
                Node<K,V> head = buckets[index];
                while (head != null) {
                        if((head.key == null && key == null ) || (head.key != null && head.key.equals(key))){
                                return true;
                        }
                        head = head.next;
                }
                return false;
        }

        public MyArrayList<K>  getKeys(){
               MyArrayList<K> keys  = new MyArrayList<>();
               for(int i=0; i<capacity; i++){
                Node<K,V> curr = buckets[i];
                while (curr != null) {
                        keys.add(curr.key);
                        curr = curr.next;
                }
               }
               return keys;
        }

        public MyArrayList<V>  getValues(){
               MyArrayList<V> values  = new MyArrayList<>();
               for(int i=0; i<capacity; i++){
                Node<K,V> curr = buckets[i];
                while (curr != null) {
                        values.add(curr.value);
                        curr = curr.next;
                }
               }
               return values;
        }

        private void reInsert(Node<K,V> node){
                int index = hash(node.key);
                node.next = buckets[index];
                buckets[index] = node;
        }

        private void resize(){
                int oldCapacity = capacity;
                capacity = oldCapacity*2;
                Node<K,V>[] oldBuckets = buckets;
                buckets = (Node<K,V>[]) new Node[capacity];
                
                for(int i=0; i<oldCapacity; i++){
                        Node<K,V> head = oldBuckets[i];
                        while(head!=null){
                                Node<K,V> next =head.next;
                                reInsert(head);
                                head.next = null;
                                head = next;
                        }
                }
        }

        public void print(){
               for(int i=0; i<capacity; i++){
                Node<K,V> curr = buckets[i];
                while (curr != null) {
                        System.out.print("[ "+ curr.key+", "+curr.value+" ] ");
                        curr = curr.next;
                }
               }
        }
}