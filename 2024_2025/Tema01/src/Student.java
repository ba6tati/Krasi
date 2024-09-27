public class Student {
    int courseNumber;
    String firstName;
    String lastName;
    
    public Student() {
        this.courseNumber = 21114;
        this.firstName = "Krasimir";
        this.lastName = "Zhelezov";
    }

    public Student(int courseNumber, String firstName, String lastName) {
        this.courseNumber = courseNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
