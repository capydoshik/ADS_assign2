public class MyArrayList<T> {
    private Object[] array;
    private int size=0;
    private int capacity=5;
    public MyArrayList() {
        array=new Object[capacity];
    }
    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T)array[index];
    }
    public void add(T item) {
        if(size==capacity)expand();
        array[size++]=item;
    }
    public void add(T item,int index) {
        if(index<=size) {
            if(size==capacity)expand();
            for(int i=size;i>index;i--)array[i]=array[i-1];
            array[index]=item;
            size++;
        }
    }
    public int find(T item) {
        for(int i=0;i<size;i++)if(array[i].equals(item))return i;
        return -1;
    }
    @SuppressWarnings("unchecked")
    public T remove(int index) {
        T removedItem=(T)array[index];
        for(int i=index;i<size-1;i++)array[i]=array[i+1];
        size--;
        return removedItem;
    }
    public void reverse() {
        for(int i=0;i<size/2;i++) {
            Object z=array[i];
            array[i]=array[size-1-i];
            array[size-1-i]=z;
        }
    }
    private void expand() {
        capacity=(int)(capacity*1.5);
        Object[] array1=new Object[capacity];
        System.arraycopy(array,0,array1,0,size);
        array=array1;
    }
    public int size() {
        return size;
    }
}
