class Programix { // дефиниране на клас

  String languages; // дефиниране на променлива от тип String, наречен languages

  Programix(String lang) { // дефиниране на конструктор
    languages = lang; // променливата languages приема стойността подадена от lang
    System.out.println(languages + " Programming Language"); // извежда променливата languages
  }

  public static void main(String[] args) { // дефиниране на главният метод

    Programix obj1 = new Programix("Java"); // инициализиране на обект от тип Programix, наречен obj1; подава се "Java" като аргумент на конструктора
    Programix obj2 = new Programix("Python"); // инициализиране на обект от тип Programix, наречен obj2; подава се "Python" като аргумент на конструктора
    Programix obj3 = new Programix("C"); // инициализиране на обект от тип Programix, наречен obj3; подава се "C" като аргумент на конструктора
  }
}