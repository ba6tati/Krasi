public class Main {
    public static void main(String[] args) throws Exception {
        Student student1 = new Student();
        Student student2 = new Student(21115, "Kristian", "Djenev");
        Student student3 = new Student(21124, "Svetoslav", "Trifonov");

        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);
    }
}