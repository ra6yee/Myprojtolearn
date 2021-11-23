package src.java.синтаксис;

/*
Конструкторы позволяют при создании объекта, сразу заполнить его поля.По умолчанию существует конструктор, который
исолняется первым.Если задан любой конструктор, то дефолтный конструктор отключается.
 Конструкторы могут иметь одинаковое имя, но должны отличаться набором аргументов.Порядок следования аргументов важен.

вызывается меню alt+ins

обязательно запомни: если тебе в твоем классе нужно несколько конструкторов, включая пустой, его нужно создать отдельно.
 если этого не сделать, то не получится создать объект с иными аргументами, нежели в созданном конструкторе. Пустой
 объект точно не создать.

 */
public class конструкторы_геттер_сеттер {
}
 class Cat {

    String name;
    int age;

    //конструктор для класса Cat
    public Cat(String name, int age) {
        this.name = name;
        this.age = age;   // слово this указыват на то что поля заполняются именно у создаваемого объекта.
                           // Указывается в конструкторе!!!

    }

    public static void main(String[] args) {

        Cat barsik = new Cat("Barsik", 5);
    }
}


// тут интересно работают переменные счетчика

class Artifact {
     static int count = 0;
     String name;
     int age;
     int num;

     public Artifact() {
         count++;
         this.num = count;
     }

     public Artifact(int num, String name) {
         count++;
         this.num = count;
         this.name = name;
     }

     public Artifact(int num, String name, int age) {
         count++;
         this.num = count;
         this.name = name;
         this.age = age;
     }

     public static void main(String[] args) {

         Artifact first = new Artifact();
         Artifact first1=new Artifact();
         Artifact second = new Artifact(0, "Acteki");
         Artifact third = new Artifact(0, "Acteki", 12);
         System.out.println(first1.num);
         System.out.println(second.num + ", " + second.name);
         System.out.println(third.num + ", " + third.name + ", " + third.age);
         System.out.println(count);
     }
 }