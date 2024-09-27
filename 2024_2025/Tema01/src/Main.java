//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("BMW", "e36", (short) 1994);
        System.out.println(car1.year);
    }
}

class Car {
    String brand;
    String model;
    short year;

    public Car(String brand, String model, short year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }
}