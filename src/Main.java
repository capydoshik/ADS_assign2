public class Main{
    public static void main(String[] args){
        SinglyLinkedList<Integer> list=new SinglyLinkedList<>();
        list.addFirst(10);
        list.addLast(20);
        list.addLast(30);
        list.addFirst(5);
        System.out.println("List after adding elements:");
        list.printAll();

        System.out.println("Size: " + list.size());

        list.removeLast();
        System.out.println("List after removing last element:");
        list.printAll();

        System.out.println("Size after removal: " + list.size());

        System.out.println("Search for 20: " + list.search(20));

        list.insertAt(25, 1);
        System.out.println("List after inserting 25 at index 1:");
        list.printAll();

        list.removeByValue(10);
        System.out.println("List after removing value 10:");
        list.printAll();

        SinglyLinkedList<Integer> otherList=new SinglyLinkedList<>();
        otherList.addFirst(50);
        otherList.addLast(60);
        list.combine(otherList);
        System.out.println("List after combining with another list:");
        list.printAll();

        list.reverse();
        System.out.println("List after reversal:");
        list.printAll();

        list.sort();
        System.out.println("List after sorting:");
        list.printAll();
    }
}
