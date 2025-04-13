public class MyLinkedList<T> {
    private MyNode<T> head;
    private MyNode<T> tail;
    private int size;

    public MyLinkedList() {
        head=null;
        tail=null;
        size=0;
    }

    public void add(T newItem) {
        MyNode<T> newNode=new MyNode<>(newItem);
        if(head==null) {
            head=tail=newNode;
        } else {
            tail.next=newNode;
            tail=newNode;
        }
        size++;
    }

    public void add(T newItem,int index) {
        if(index<=size) {
            MyNode<T> newNode=new MyNode<>(newItem);
            if(index==0) {
                newNode.next=head;
                head=newNode;
            } else {
                MyNode<T> current=head;
                for(int i=0;i<index-1;i++) {
                    current=current.next;
                }
                newNode.next=current.next;
                current.next=newNode;
            }
            if(index==size) {
                tail=newNode;
            }
            size++;
        }
    }

    public T get(int index) {
        MyNode<T> current=head;
        for(int i=0;i<index;i++) {
            current=current.next;
        }
        return current.data;
    }

    public int find(T keyItem) {
        MyNode<T> current=head;
        for(int i=0;i<size;i++) {
            if(current.data.equals(keyItem)) {
                return i;
            }
            current=current.next;
        }
        return -1;
    }

    public T remove(int index) {
        MyNode<T> current=head;
        T removedItem=null;
        if(index==0) {
            removedItem=head.data;
            head=head.next;
            if(head==null) {
                tail=null;
            }
        } else {
            for(int i=0;i<index-1;i++) {
                current=current.next;
            }
            MyNode<T> removedNode=current.next;
            removedItem=removedNode.data;
            current.next=removedNode.next;
            if(current.next==null) {
                tail=current;
            }
        }
        size--;
        return removedItem;
    }

    public void reverse() {
        MyNode<T> prev=null;
        MyNode<T> current=head;
        MyNode<T> next=null;
        tail=head;
        while(current!=null) {
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        head=prev;
    }

    private static class MyNode<T> {
        T data;
        MyNode<T> next;

        MyNode(T data) {
            this.data=data;
            this.next=null;
        }
    }

    public int size() {
        return size;
    }
}
