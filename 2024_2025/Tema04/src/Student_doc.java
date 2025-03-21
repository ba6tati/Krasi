
public class Student_doc {
    private String firstName; // Поле firstName от тип String
    private String lastName; // Поле lastName от тип String
    private int courseNumber; // Поле courseNumber от тип int

    public Student_doc(String firstName, String lastName, int courseNumber) {
        /*
         * Конструктор, който приема и задава стойностите на firstName, lastName и courseNumber
         */

        this.firstName = firstName;
        this.lastName = lastName;
        this.courseNumber = courseNumber;
    }

    public String getFirstName() {
        // get-ър за firstName
        return firstName;
    }

    public void setFirstName(String firstName) {
        // set-ър за firstName
        this.firstName = firstName;
    }

    public String getLastName() {
        // get-ър за lastName
        return lastName;
    }

    public void setLastName(String lastName) {
        // set-ър за lastName
        this.lastName = lastName;
    }

    public int getCourseNumber() {
        // get-ър за courseNumber
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        // set-ър за courseNumber
        this.courseNumber = courseNumber;
    }

    @Override 
    public String toString() {
        /*
         * Представя обекта като String
         */
        return "[" + this.courseNumber + "] " + this.firstName + " " + this.lastName;
    }
}