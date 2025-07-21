import java.nio.channels.Pipe.SourceChannel;

public class MyPriorityQueue<T extends Comparable<T>> {
        private int capacity;
        private Object[] heap;
        private int size;

        MyPriorityQueue(){
                capacity = 16;
                heap = new Object[capacity];
                size = 0;
        }

        public void add(T element){
                ensureCapacity();
                heap[size]  = element;
                shiftup(size);
                size++;
        }

        public T peek(){
                if(isEmpty()) throw new RuntimeException("PriorityQueue is Empty");

                return (T) heap[0];
        }

        public T poll(){
                if(isEmpty()) throw new RuntimeException("PriorityQueue is Empty");

                T value = (T) heap[0];
                heap[0] = heap[size-1];
                heap[size-1] = null;
                size--;
                shiftdown(0);
                return value;
        }

        public int size(){
                return size;
        }

        public boolean isEmpty(){
                return size == 0;
        }

        private void ensureCapacity(){
                if(size >= capacity){
                        capacity *= 2;
                        Object[] newHeap = new Object[capacity];
                        for(int i=0; i<size;i++){
                                newHeap[i] = heap[i];
                        }
                        heap = newHeap;
                }
        }

        private void shiftup(int index){
                T value = (T) heap[index];
                while(index>0){
                        int parentIndex = (index - 1) / 2;
                        T parent = (T) heap[parentIndex];
                        if(value.compareTo(parent)>=0) break;
                        heap[index] = parent;
                        index = parentIndex;
                }
                heap[index] = value;
        }

        private void shiftdown(int index){
                T value = (T) heap[index];
                int half = size / 2 ;
                while(index<half){
                        int left = (index * 2) + 1;
                        int right = (index * 2) + 2;
                        int smallest = left;

                        if((right < size) && (((T) heap[right]).compareTo((T) heap[left])<0)) {
                                smallest = right;
                        }
                        if(value.compareTo((T)heap[smallest])<=0) break;

                        heap[index] = heap[smallest];
                        index = smallest;
                }
                heap[index] = value;
        }

        public void print(){
                System.out.print("[ ");
                for(int i=0; i<size; i++){
                        System.out.print(heap[i]+" ");
                }
                System.out.println("]");
        }
}