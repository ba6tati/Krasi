public class Main {

    public static int x = 10;
    public int y = 7;

    public Main() {
    }

    public Main(int x, int y) {
        this.x = x;
        this.y = y;

        //System.out.println("this.x = " + this.x);
        //System.out.println("this.y = " + this.y);
    }

    public static void printInfo(Main obj){
        System.out.println("obj.x = " + obj.x);
        System.out.println("obj.y = " + obj.y);
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("\nObject 1 : ");
        Main obj1 = new Main();
        printInfo(obj1);

        obj1.x = obj1.x + 20;
        printInfo(obj1);

        System.out.println("\nObject 2 : ");
        Main obj2 = new Main();
        printInfo(obj2);

        // System.out.println("myObj2 info:");
        // myObj2.printInfo();
        // System.out.println("myObj1.x * myObj1.y = " + myObj1.x * myObj1.y);
    }
}

