public class CatManipulating {

    public static void main(String[] args) {

        Cat someCat = new Cat( );
        someCat.sayMiau( );
        System.out.printf("The color of cat %s is %s.%n",
                someCat.getName(), someCat.getColor());

        Cat myBrownCat = new Cat("Johnny", "brown");
        myBrownCat.sayMiau( );
        System.out.printf("The color of the cat %s is %s.%n",
                myBrownCat.getName(), myBrownCat.getColor());
    }
}