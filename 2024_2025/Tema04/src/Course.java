import java.util.ArrayList;
import java.util.List;

public class Course {
    int courseId; // Поле courseId от тип int
    List<Student_doc> students = new ArrayList<>(); // ArrayList students, който съдържа всички ученици на дадения клас

    public Course(int courseId) {
        /*
         * Конструктор, който приема и задава стойностите на courseId
         */

        this.courseId = courseId;
    }

    public int getCourseId() {
        // get-ър за courseId
        return courseId;
    }

    public void setCourseId(int courseId) {
        // set-ър за courseId
        this.courseId = courseId;
    }

    public List<Student_doc> getStudents() {
        // get-ър за students
        return students;
    }

    @Override
    public String toString() {
        /*
         * Представя обекта като String
         */
        return "[" + this.courseId + "]";
    }

    public void addStudent(Student_doc student) {
        /*
         * Добавя обект от тип Student в ArrayList-а students
         */

        this.students.add(student);
    }

    public void printInfo() {
        /*
         * Принтира в конзолата курса и всички ученици в него
         */
        
        System.out.println(this + ": ");
        
        for (Student_doc student: this.students) {
            System.out.println(student);
        }
    }
}
