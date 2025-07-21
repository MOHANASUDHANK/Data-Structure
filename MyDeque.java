public class MyDeque<T> {
        class Node{
                T data;
                Node left;
                Node right;

                Node(T data){
                        this.data = data;
                }
        }

        private Node head;
        private Node tail;
        private int size;

        public void addFirst(T data){
                Node newNode = new Node(data);
                if(isEmpty()){
                        head = tail = newNode;
                }
                else{
                        newNode.right = head;
                        head.left = newNode;
                        head = newNode;
                }
                size++;
        }

        public void addLast(T data){
                Node newNode = new Node(data);
                if(isEmpty()){
                        head = tail = newNode;
                }
                else{
                        newNode.left = tail;
                        tail.right = newNode;
                        tail = newNode;
                }
                size++;
        }

        public T removeFirst(){
                if(isEmpty()) throw new RuntimeException("Deque is empty");
                T data = head.data;
                head = head.right;
                if(head != null) head.left = null;
                else tail = null;
                size--;
                return  data;
        }

        public T removeLast(){
                if(isEmpty()) throw new RuntimeException("Deque is empty");
                T data = tail.data;
                tail = tail.left;
                if(tail != null)tail.right = null;
                else head = null;
                size--; 
                return data;
        }

        public T peekFirst(){
                if(isEmpty()) throw new RuntimeException("Deque is empty");
                return (T) head.data;
        }

        public T peekLast(){
                if(isEmpty()) throw new RuntimeException("Deque is empty");
                return (T) tail.data;
        }

        public int size(){
                return size;
        }

        public boolean isEmpty(){
                return size == 0;
        }

        public void print(){
                Node node = head;
                while(node != null){
                        System.out.print(node.data+" ");
                        node = node.right; 
                }
        }
}
