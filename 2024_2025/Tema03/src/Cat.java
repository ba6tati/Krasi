public class Cat {

    // Field name
    private String name;
    // Field color
    private String color;

    // GET / SET . . .


    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    // // Constructor with-out parameters
    public Cat( ) {
        this.name = "Unnamed";
        this.color = "gray";
    }

    // Constructor with parameters
    public Cat(String name1, String color1) {
        this.name = name1;
        this.color = color1;
    }

    // Other methods
    public void sayMiau() {
        System.out.println("Cat " + this.name + " said: Miauuuuuu!");
    }
}