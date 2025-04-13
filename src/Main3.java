import java.util.Random;

public class Main3 {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            list.add(rand.nextInt(100));
        }
        System.out.println("Size:" + list.size());
        System.out.println("Item at index 0:" + list.get(0));
        System.out.println("Item at index 1:" + list.get(1));
        System.out.println("Item at index 2:" + list.get(2));
        System.out.println("Removed item at index 1:" + list.remove(1));
        System.out.println("Size after removal:" + list.size());
        list.reverse();
        System.out.println("List after reversal:");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
