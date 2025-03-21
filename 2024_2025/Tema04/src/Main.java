import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // Инициализиране на буфериран четец
    public static List<Course> courses = new ArrayList<>(); // Инициализиране на ArrayList courses

    public static void main(String[] args) throws IOException {
        loop: while (true) { // while цикъл с име, за да може да се спре от switch-case-а
            System.out.println("Select an option:"); // Принтира в конзолата "Select an option:"
            System.out.println("1. Create Course"); // Принтира в конзолата "1. Create Course"
            System.out.println("2. Add Student to Course"); // Принтира в конзолата "2. Add Student to Course"
            System.out.println("3. Print Course Info"); // Принтира в конзолата "3. Print Course Info"
            System.out.println("4. Exit"); // Принтира в конзолата "4. Exit"
            System.out.println(); // Принтира празен ред, за да се придаде естетически вид

            int userInput = Integer.parseInt(reader.readLine()); // Чете ред от конзолата, превръща го в int и го запазва в променливата userInput

            switch (userInput) {
                /*
                 * Намира избора на потребителя и извиква съответния метод
                 */

                case 1 -> createCourse(); // При userInput = 1 се извиква метода createCourse()
                case 2 -> createStudent(); // При userInput = 2 се извиква метода createStudent()
                case 3 -> printCoursesInfo(); // При userInput = 3 се извиква метода printCoursesInfo()
                case 4 -> { 
                    /*
                     * При userInput = 3 се прекъсва while цикъла и програмата спира
                     */
                    break loop; 
                }
                default -> logError("Invalid option!"); // Ако userInput не е равен на нито една от възможните опции, възниква грешка "Invalid option!"
            }

            System.out.println(); // Принтира празен ред
        }
    }

    static void createCourse() throws IOException {
        /*
         * Създава курс по данните въведните от потребителя
         */
        System.out.print("Course Id: "); // Принтира "Course Id: "
        int courseId = Integer.parseInt(reader.readLine()); // Чете ред от конзолата, превръща го в int и го запазва в променливата courseId

        System.out.println(); // Принтира празен ред

        Course course = new Course(courseId); // Създава нов обект от тип Course 
        courses.add(course); // Добавя курса към ArrayList-а courses
    }

    static void createStudent() throws IOException {
        /*
         * Приема данни от конзолата и създава обект от тип Student
         */

        System.out.print("Course Id: ");
        int courseId = Integer.parseInt(reader.readLine()); // Чете ред от конзолата, превръща го в int и го запазва в променливата courseId

        Course course = getCourseById(courseId); // Намира курса със зададеното id и го запазва в променливата course

        if (course == null) { 
            /*
             * Ако курсът не съществува, принтира в конзолата дадената грешка
             */
            logError("This course doesn't exist!"); 
            return; // Прекъсва метода дотук
        }

        // System.out.println();

        System.out.print("First Name: "); // Принтира "First Name: "
        String firstName = reader.readLine(); // Чете ред от конзолата и го запазва в променливата firstName

        System.out.print("Last Name: "); // Принтира "Last Name: "

        String lastName = reader.readLine(); // Чете ред от конзолата и го запазва в променливата lastName

        System.out.print("Course Number: "); // Принтира "Course Number: "
        int courseNumber = Integer.parseInt(reader.readLine()); // Чете ред от конзолата, превръща го в int и го запазва в променливата courseNumber

        Student_doc student = new Student_doc(firstName, lastName, courseNumber); // Създава нов обект от тип Student със съответните въведени данни

        course.addStudent(student); // Добавя обекта в избрания от потребителя курс
    }

    static void printCoursesInfo() {
        /*
         * Принтира информация за всички създадени курсове
         */

        for(Course course: courses) { // for-each цикъл
            course.printInfo(); // Вика метода printInfo от класа Course
            System.out.println(); // Принтира празен ред
        }
    }

    static Course getCourseById(int courseId) {
        /*
         * Приема аргумент couseId от тип int
         * Връща курса с даденото id или null, ако не е намерен такъв
         */

        for(Course course: courses) { // for-each цикъл
            if (course.getCourseId() == courseId) { 
                /* 
                 * Ако дадения курс е равен на подаденото id, връща променливата course
                 */
                return course;
            }
        }

        return null;
    }

    static void logError(String message) {
        /*
         * Приема аргумент message от тип String
         * Принтира в конзолата съответното съобщение с префикс "[ERROR] "
         */

        System.out.println();
        System.out.println("[ERROR] " + message);
    }
}