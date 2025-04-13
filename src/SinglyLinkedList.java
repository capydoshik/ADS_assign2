public class SinglyLinkedList<T> {
    private Node<T> head;
    private int size;

    public SinglyLinkedList() {
        head=null;
        size=0;
    }

    public void addFirst(T newItem) {
        Node<T> newNode=new Node<>(newItem);
        newNode.next=head;
        head=newNode;
        size++;
    }

    public void addLast(T newItem) {
        Node<T> newNode=new Node<>(newItem);
        if(head==null)
            head=newNode;
        else {
            Node<T> current=head;
            while(current.next!=null)
                current=current.next;
            current.next=newNode;
        }
        size++;
    }

    public void removeLast() {
        if(head==null)
            return;
        if(head.next==null)
            head=null;
        else {
            Node<T> current=head;
            while(current.next!=null&&current.next.next!=null)
                current=current.next;
            current.next=null;
        }
        size--;
    }

    public void printAll() {
        Node<T> current=head;
        while(current!=null) {
            System.out.print(current.data+" ");
            current=current.next;
        }
        System.out.println();
    }

    public boolean search(T keyItem) {
        Node<T> current=head;
        while(current!=null) {
            if(current.data.equals(keyItem))
                return true;
            current=current.next;
        }
        return false;
    }

    public void insertAt(T newItem,int index) {
        if(index<0||index>size) return;
        if(index==0) addFirst(newItem);
        else {
            Node<T> newNode=new Node<>(newItem);
            Node<T> current=head;
            for(int i=0;i<index-1;i++)
                current=current.next;
            newNode.next=current.next;
            current.next=newNode;
            size++;
        }
    }

    public void removeByValue(T value) {
        if(head==null) return;
        if(head.data.equals(value)) {
            head=head.next;
            size--;
            return;
        }
        Node<T> current=head;
        while(current.next!=null&&!current.next.data.equals(value)) current=current.next;
        if(current.next!=null) {
            current.next=current.next.next;
            size--;
        }
    }

    public void combine(SinglyLinkedList<T> otherList) {
        if(otherList.head==null) return;
        if(head==null) head=otherList.head;
        else {
            Node<T> current=head;
            while(current.next!=null) current=current.next;
            current.next=otherList.head;
        }
        size+=otherList.size;
    }

    public void reverse() {
        Node<T> prev=null,current=head,next=null;
        while(current!=null) {
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        head=prev;
    }

    public void sort() {
        if(head==null||head.next==null) return;
        Node<T> sorted=null,current=head;
        while(current!=null) {
            Node<T> next=current.next;
            sorted=insertSorted(sorted,current);
            current=next;
        }
        head=sorted;
    }

    private Node<T> insertSorted(Node<T> sorted,Node<T> newNode) {
        if(sorted==null||((Comparable<T>)newNode.data).compareTo(sorted.data)<0) {
            newNode.next=sorted;
            sorted=newNode;
        } else {
            Node<T> current=sorted;
            while(current.next!=null&&((Comparable<T>)newNode.data).compareTo(current.next.data)>0)
                current=current.next;
            newNode.next=current.next;
            current.next=newNode;
        }
        return sorted;
    }

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data=data;
            this.next=null;
        }
    }
    public int size() {
        return size;
    }
}

