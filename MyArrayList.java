public class MyArrayList<T>{

        private Object[] data;
        private int size;
        private int capacity;

        MyArrayList(){
                capacity =  10;
                data     =  new Object[capacity];
                size     =  0;
        }

        public void add(T element){
                ensureCapacity();
                data[size++] = element;
        }

        public T get(int index){
                checkIndex(index);
                return (T) data[index];
        }

        public void set(int  index,T element){
                checkIndex(index);
                data[index] = element;
        }

        public T remove(int index){
                checkIndex(index);
                T removed = (T) data[index];
                for(int i=index ; i<size-1; i++){
                        data[i] = data[i+1];
                }
                data[--size] = null;
                return removed;
        }

        public int size(){
                return size;
        }

        private void checkIndex(int index){
                if(index < 0 || index >= size){
                        throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
                }
        }

        private void ensureCapacity(){
                if(size == capacity){
                        capacity *= 2;
                        Object[] newData = new Object[capacity];
                        for(int i=0; i<capacity/2;i++){
                                newData[i] = data[i];
                        }
                        data = newData;
                }
        }

        public void print(){
                for(int i=0; i<size; i++){
                        System.out.print(data[i]+" ");
                }
                System.out.println();
        }

}