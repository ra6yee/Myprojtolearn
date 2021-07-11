package src.java.ООП;


class Cow {
    public void printAll() {
        printColor();
        printName();
    }
    public void printColor() {
        System.out.println("Я - белая");
    }

    public void printName() {
        System.out.println("Я - корова");
    }
}

class Whale extends Cow {
    public void printName() {
        System.out.println("Я - кит");
    }
}

public class Polymorfition {
    public static void main(String[] args) {
          Whale whale=new Whale();
          whale.printColor();
          whale.printName();
          Cow cow=new Cow();
          cow.printName();
          cow.printColor();
          whale.printAll();
    }
}
