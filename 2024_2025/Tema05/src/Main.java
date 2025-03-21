import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Score> scores = new ArrayList<>();

        Score score1 = new Score(6, 5, 6);
        Score score2 = new Score(4, 4, 4);
        Score score3 = new Score(6, 6, 5);
        Score score4 = new Score(6, 5, 6);
        Score score5 = new Score( 5, 5, 4);

        Student student1 = new Student("Krasimir", "Zhelezov", 21114, score1);
        Student student2 = new Student("Kristian", "Djenev", 21115, score2);
        Student student3 = new Student("Svetoslav", "Trifonov", 21124, score3);
        Student student4 = new Student("Martin", "Panteleev", 21119, score4);
        Student student5 = new Student("Martin", "Qnkov", 21118, score5);

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

        scores.add(score1);
        scores.add(score2);
        scores.add(score3);
        scores.add(score4);
        scores.add(score5);

        Utility.printAllStudents(students);
    }
}