import java.util.Random;

class MyTestingClass {
    private int id;

    public MyTestingClass(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        // Custom uniform hash
        int hash = 7;
        hash = 31 * hash + id;
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof MyTestingClass other) {
            return this.id == other.id;
        }
        return false;
    }
}

class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}

class MyHashTableTest {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>(31); // Larger prime for better distribution
        Random rand = new Random();

        for (int i = 0; i < 10000; i++) {
            int id = rand.nextInt(100000);
            MyTestingClass key = new MyTestingClass(id);
            Student student = new Student("Student" + id);
            table.put(key, student);
        }

        table.printBucketSizes();
    }
}
