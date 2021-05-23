package JavaRush_Tasks.syntax;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.util.Arrays.sort;

public class training {
    int a = 4;
    int b = 6;
    String total = "Общий";

    public static void main(String[] args) {
        training training1 = new training();
        System.out.println(training1.total);
        String name = "Алексей";
        System.out.println(name);
        System.out.println("квадрат переменной а равен " + (training1.a * training1.a));
        String text = "JavaRush. Learn once - use anywhere";
        for (int i = 0; i < 10; i++) {
            System.out.println(i + 1 + " " + text);

        }


    }
}

class Solution {
    public static void main(String[] args) {
        String text = "Хочешь - решай задачи, не хочешь - решай нехотя";
        int i = 16;
        while (i > 0) {
            System.out.println(i + " " + text);
            i--;
        }
    }
}

class Solution2 {
    public static void main(String[] args) {
        System.out.println(sqr(34));
    }

    public static int sqr(int a) {
        return a * a;
    }
}

class Solution3 {
    public static void main(String[] args) {
        sum(2, 2);
    }

    public static void sum(int a, int b) {
        int c = a + b;
        System.out.print(c);
    }
}

class Solution4 {
    public static void main(String[] args) {
        print("Java is easy to learn!");
        print("Java opens many opportunities!");
    }

    public static void print(String s) {
        for (int i = 0; i < 4; i++) {
            System.out.println(s);
        }
    }
}

class Solution5 {
    public static void main(String[] args) {
        hackSalary(700);
    }

    public static void hackSalary(int a) {
        System.out.println("ваша зарплата " + (a + 100));// напишите тут ваш код
    }
}

class Solution6 {
    public static void main(String[] args) {
        printCircleLength(5);
    }

    public static void printCircleLength(double radius) {
        radius = (double) (2 * Math.PI * radius);
        System.out.println(radius);

    }
}

class Solution7 {
    public static void main(String[] args) {
        int a = 5;
        int b = 7;
        System.out.println(a + b);
        System.out.println(a * b);//напишите тут ваш код
    }
}

class Solution8 {
    public static void main(String[] args) {
        Person person = new Person();
    }

    public static class Person {
        String name;
        int age;
        int weight;
        int money;
    }
}
/*
Наш первый конвертер!
*/

class Solution9 {
    public static void main(String[] args) {
        System.out.println(convertCelsiusToFahrenheit(41));
    }

    public static double convertCelsiusToFahrenheit(int celsius) {
        celsius = (9 * celsius + 160) / 5;//напишите тут ваш код

        return celsius;
    }
}

/*
О семейных отношениях
*/
class Solution10 {
    public static void main(String[] args) {
        Man man = new Man();
        Woman woman = new Woman();
        man.wife = woman;
        woman.husband = man;
    }

    public static class Man {
        public int age;
        public int height;
        public Woman wife;
    }

    public static class Woman {
        public int age;
        public int height;
        public Man husband;
    }
}

/*
Одного кота нам мало
*/
class Solution11 {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Cat tomCat = new Cat();

    }

    public static class Cat {

    }
}

/*
Макс, Белла и Джек
*/
class Solution12 {
    public static void main(String[] args) {
        Dog dog1 = new Dog();
        dog1.name = "Max";

        Dog Max = new Dog();
        Max.name = "Max";
        Dog Bella = new Dog();
        Bella.name = "Bella";
        Dog Jack = new Dog();
        Jack.name = "Jack";
        //напишите тут ваш код
    }

    public static class Dog {
        public String name;
    }
}
/*
Да хоть на Луну!
*/

class Solution13 {
    public static void main(String[] args) {
        System.out.println(getWeight(888));
    }

    public static double getWeight(int earthWeight) {
        double Weight = earthWeight;
        Weight = (Weight / 100) * 17;
        return Weight;
    }
}

/*
Печатаем трижды
*/
class Solution14 {
    public static void print3(String s) {
        for (int i = 0; i < 3; i++) {
            System.out.print(s + " ");

        }
        System.out.println();
    }

    public static void main(String[] args) {
        print3("window");
        print3("file");
    }
}

/*
Минимум двух чисел
*/
class Solution15 {
    public static int min(int a, int b) {
        //напишите тут ваш код
        return Math.min(a, b);
    }

    public static void main(String[] args) {
        System.out.println(min(12, 33));
        System.out.println(min(-20, 0));
        System.out.println(min(-10, -20));
    }
}

/*
Минимум трёх чисел
*/
class Solution16 {
    public static int min(int a, int b, int c) {


        int d = Math.min(a, b);
        int e = Math.min(b, c);
        return Math.min(d, e);
    }

    public static void main(String[] args) {
        System.out.println(min(1, 2, 3));
        System.out.println(min(-1, -2, -3));
        System.out.println(min(3, 5, 3));
        System.out.println(min(5, 5, 10));
    }
}

/*
Минимум четырех чисел
*/
class Solution17 {
    public static int min(int a, int b, int c, int d) {
        if (a > b) a = b;
        if (a > c) a = c;
        if (a > d) a = d;
        return a;

    }

    public static int min(int a, int b) {
        return Math.min(a, b);

    }

    public static void main(String[] args) throws Exception {
        System.out.println(min(-20, -10));
        System.out.println(min(-40, -10, -30, 40));
        System.out.println(min(-20, -40, -30, 40));
        System.out.println(min(-20, -10, -40, 40));
        System.out.println(min(-20, -10, -30, -40));
    }
}
/*
Делиться полезно
*/

class Solution18 {
    public static void main(String[] args) {
        div(6, 3);
        div(10, 6);
        div(2, 4);
    }

    public static void div(int a, int b) {
        System.out.println(a / b);

    }
}
/*
Произведение 10 чисел
*/

class Solution19 {
    public static void main(String[] args) {
        int count = 1;
        for (int i = 1; i < 10; i++) {
            int count1 = count * (i);
            count += count1;
        }
        System.out.println(count);
    }
}

/*
Сумма 5 чисел
*/
class Solution20 {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i <= 5; i++) {
            count += i;
            System.out.println(count);
        }

    }
}

/*
Таблица умножения красивая и ровная
*/
class Solution21 {
    public static void main(String[] args) {
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                int count = i * j;
                int length = (int) Math.log10(count) + 1;

                if (length == 1)
                    System.out.print(count + "  ");
                else
                    System.out.print(count + " ");
            }
            System.out.println();
        }

    }
}
/*
Каждый охотник желает знать…
*/

class Solution22 {
    public static void main(String[] args) {
        Red red = new Red();
        Orange orange = new Orange();
        Yellow yellow = new Yellow();
        Green green = new Green();
        Blue blue = new Blue();
        Indigo indigo = new Indigo();
        Violet violet = new Violet();
        System.out.println();
        //можно и так решить
        new Red();
        new Orange();
        new Yellow();
        new Green();
        new Blue();
        new Indigo();
        new Violet();
        System.out.println("日本語");

    }

    public static class Red {
        public Red() {
            System.out.println("Red");  // Это же конструкторы!!!! они отработаются при создании объекта!!!
        }
    }

    public static class Orange {
        public Orange() {
            System.out.println("Orange");
        }
    }

    public static class Yellow {
        public Yellow() {
            System.out.println("Yellow");
        }
    }

    public static class Green {
        public Green() {
            System.out.println("Green");
        }
    }

    public static class Blue {
        public Blue() {
            System.out.println("Blue");
        }
    }

    public static class Indigo {
        public Indigo() {
            System.out.println("Indigo");
        }
    }

    public static class Violet {
        public Violet() {
            System.out.println("Violet");
        }
    }
}
/*
Сумма цифр трехзначного числа
*/

class Solution23 {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        int outNumber = 0;
        int middle = number / 100;// 5
        outNumber = middle; //занесли пять в итог
        middle *= 100;// получили 500
        number -= middle;//получили 46
        middle = number / 10;// получили 4
        outNumber += middle;//сложили с конечной суммой
        middle *= 10;//получили 40
        number -= middle;//плучили 6
        outNumber += number;

        return outNumber;
    }
}
/*
Финансовые ожидания
*/

class Solution24 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("введите число:");
        String num = reader.readLine();
        int number = Integer.parseInt(num);
        System.out.println("Я буду зарабатывать $" + number + " в час");

    }
}

class Solution25 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("введите имя: ");
        String name = reader.readLine();
        System.out.print("введите число: ");

        String num = reader.readLine();
        int number = Integer.parseInt(num);

        System.out.println(name + " захватит мир через " + number + " лет. Му-ха-ха!");
    }
}
/*
Мне не подходит этот возраст…
*/

class Solution26 {
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println("Age is: " + person.age);
        person.adjustAge(person.age);
        System.out.println("Adjusted age is: " + person.age);
    }

    public static class Person {
        public int age = 20;

        public void adjustAge(int age) {
            this.age = age + 20;//тут идет обращение к нестатической переменной класса Person, поэтому использхуется this
            System.out.println("Age in adjustAge() is: " + age);

        }
    }
}
/*
Цена яблок
*/

class Solution27 {
    public static void main(String[] args) {
        Apple apple = new Apple();
        apple.addPrice(50);
        Apple apple2 = new Apple();
        apple2.addPrice(100);
        System.out.println("Стоимость яблок " + Apple.applesPrice);
    }

    public static class Apple {
        public static int applesPrice = 0;

        public static void addPrice(int applesPrice) {
            Apple.applesPrice += applesPrice; //так как переменная статическая, то обращение к ней идет по имени класса
            // в котором она расположена.И она одна для всего класса.

        }
    }
}
/*
Как зовут кота?
*/

class Cat {
    private String name = "безымянный кот";

    public void setName(String name) {
        this.name = name;

    }

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.setName("Жужик");
        System.out.println(cat.name);
    }
}
/*
Учет котов
*/

class Cat1 {
    private static int catsCount = 0;

    public Cat1() {
        catsCount++;

    }

    public static void addNewCat() {
        catsCount++;

    }

    public static void main(String[] args) {
        Cat1 tom = new Cat1();
        Cat1 jack = new Cat1();
        Cat1 max = new Cat1();
        Cat1 brian = new Cat1();

        System.out.println(catsCount);
    }
}

/*
Задаем количество котов
*/ class Cat2 {
    private static int catsCount = 0;

    public static void setCatsCount(int catsCount) {
        Cat2.catsCount = catsCount;

    }

    public static void main(String[] args) {
        setCatsCount(502);
        System.out.println(catsCount);
    }
}
   /*
Программа учета имен
*/

class Cat3 {
    private String fullName;

    public void setName(String firstName, String lastName) {
        String fullName = firstName + " " + lastName;
        this.fullName = fullName;
        //так как переменная не статическая, то обращаться к ней через this
    }

    public static void main(String[] args) {
        Cat3 cat = new Cat3();
        cat.setName("dfgds", "jdhfjds");
        System.out.println(cat.fullName);
    }
}
    /*
Кошки во Вселенной
*/

class Solution28 {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        Cat.count++;
        //напишите тут ваш код

        Cat cat2 = new Cat();
        //напишите тут ваш код
        Cat.count++;
        System.out.println("The cat count is " + Cat.count);
    }

    public static class Cat {
        public static int count = 0;
    }
}
   /* 
  /*
Хорошо или плохо?
*/

class Solution29 {
    public static void main(String[] args) {
        compare(3);
        compare(6);
        compare(5);
    }

    public static void compare(int a) {
        if (a > 5) System.out.println("Число больше пяти");

        if (a < 5) System.out.println("Число меньше пяти");
        if (a == 5) System.out.println("Число равно пяти");
    }
}
    /*
Ближайшее к 10
*/

class Solution30 {
    public static void main(String[] args) {
        displayClosestToTen(8, 11);
        displayClosestToTen(7, 14);
        displayClosestToTen(9, 11);

    }

    public static void displayClosestToTen(int a, int b) {
        int a1 = a;
        int b1 = b;
        a = 10 - a;
        a = abs(a);
        b = 10 - b;
        b = abs(b);
        //(a < b) ? System.out.println(a1) : System.out.println(b1);
        if (a > b)
            System.out.println(b1);
        if (a < b)
            System.out.println(a1);
        if (a == b) System.out.println("числа равноудалены");

           // не работает , по моему, необходима более старшая ве
        // рсия явы.


    }

    public static int abs(int a) {
        if (a < 0) {
            return -a;
        } else {
            return a;
        }
    }
}
  /*
Попадём-не-попадём
*/

class Solution31 {
    public static void main(String[] args) {
        checkInterval(60);
        checkInterval(112);
        checkInterval(10);
    }

    public static void checkInterval(int a) {
        if (a < 100 && a > 50) System.out.println("Число в диапазоне от 50 до 100");
        else System.out.println("Число не попадает в диапазон от 50 до 100");

    }
}
/*
Времена года на Терре
*/

class Solution32 {
    public static void main(String[] args) {
        checkSeason(12);
        checkSeason(4);
        checkSeason(7);
        checkSeason(10);
    }

    public static void checkSeason(int month) {
        if ((month == 12) || (month <= 2)) System.out.println("Зимний месяц");
        if (month > 2 && month <= 5) System.out.println("Весенний месяц");
        if (month > 5 && month <= 8) System.out.println("Летний месяц");
        if (month > 8 && month <= 11) System.out.println("Осенний месяц");


    }
}
  /*
Положительное и отрицательное число
*/


class Solution33 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("введите число: ");
        String a = reader.readLine();
        int a1 = Integer.parseInt(a);
        if (a1 > 0) {
            a1 += a1;
            System.out.println(a1);
        }
        if (a1 < 0) {
            a1 += 1;
            System.out.println(a1);
        }
        if (a1 == 0) {
            a1 = 0;
            System.out.println(a1);
        }
    }

}

class Solution34 {
    public static void main(String[] args) throws Exception {
       String[] array={"понедельник", "вторник", "среда", "четверг", "пятница", "суббота", "воскресенье"
       };
BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите номер дня недели: ");
        String numOfDay=reader.readLine();
        int num= 0;
        try {
            num = Integer.parseInt(numOfDay)-1;
        } catch (NumberFormatException e) {
            System.out.println("введена некорректная информация, программа будет закрыта.");
            System.exit(11);
        }
        if(num>7 || num<1){
            System.out.println("Такого дня недели не существует");

        }
        try {
            System.out.println(array[num]);
        } catch (Exception e) {
            System.exit(12);
        }
    }
}
/*
Минимум двух чисел
*/

 class Solution35 {
    public static void main(String[] args) throws Exception {
      BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите первое число: ");
        String one=reader.readLine();
        int oneNum=Integer.parseInt(one);
        System.out.print("Введите второе число: ");
        String two=reader.readLine();
        int twoNum=Integer.parseInt(two);
        if(oneNum==twoNum){
            System.out.println("Числа равны");
        }else
        System.out.println("Минимальное введенное число: "+Math.min(oneNum,twoNum));


    }
}

class Solution36{
     public static void main(String[] args) throws Exception {
         BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
         int max = 0;
         for(int i = 0 ; i < 4 ; i++){
             int a = Integer.parseInt(reader.readLine());
             max = max < a ? a : max;// работает тернанрный оператор
         }
         log(""+max);
     }
     public static void log(String s){
         System.out.println(s);
     }
 }
class Solution37 {
    public static void main(String[] args) throws Exception {
int[]array = new int[3];
BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i <3 ; i++) {
            System.out.println("Введите число: ");
          array[i]=Integer.parseInt(reader.readLine());
        }
    sort(array);
        for (int i = 3; i >0; i--) {
            System.out.print(array[i-1]+" ");

        }
    }
}
