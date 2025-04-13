public class Main2{
    public static void main(String[] args){
        MyArrayList<Integer> list=new MyArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        System.out.println("Size:"+list.size());
        System.out.println("First item:"+list.get(0));
        System.out.println("Second item:"+list.get(1));
        list.add(25,2);
        System.out.println("After adding 25 at index 2, second item:"+list.get(2));
        System.out.println("Index of 30:"+list.find(30));
        System.out.println("Removed item:"+list.remove(1));
        System.out.println("Size after removal:"+list.size());
        list.reverse();
        System.out.println("List after reversing:");
        for(int i=0;i<list.size();i++)
            System.out.print(list.get(i)+" ");
    }
}