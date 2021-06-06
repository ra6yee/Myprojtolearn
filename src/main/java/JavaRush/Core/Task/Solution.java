package JavaRush.Core.Task;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import sun.corba.Bridge;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static jdk.nashorn.internal.objects.Global.println;

public class Solution {
    public static void main(String[] args) {

    }
}
/*
Киты и коровы
*/

class Solution1 {
    public static void main(String[] args) {
        Cow cow = new Whale();

        System.out.println(cow.getName());
    }

    public static class Cow {
        public String getName() {
            return "Я - корова";
        }
    }

    public static class Whale extends Cow {
        public String getName() {
            return "Я не корова, я кит!!!";
        }
    }
}

/*
Кит, коровий потомок
*/
class Solution2 {
    public static void main(String[] args) {
        Cow cow = new Whale();

        System.out.println(cow.getName());
    }

    public static class Cow {
        public String getName() {
            return "Я - корова";
        }
    }

    public static class Whale extends Cow {
        public String getName() {
            String Whale = "";
            return Whale;
        }
    }
}
/*
Кесарю — кесарево
*/

class Solution3 {
    public static void main(String[] args) {
        Pet pet1 = new Cat();
        Pet cat = pet1.getChild();


        Pet pet2 = new Dog();
        Pet dog = pet2.getChild();

    }

    public static class Pet {

        public Pet getChild() {
            return new Pet();
        }
    }

    public static class Cat extends Pet {
        public String nameCat;

        public Pet getChild() {
            return new Cat();
        }

        public String getNameCat() {
            return nameCat;
        }

        public void setNameCat(String nameCat) {
            this.nameCat = nameCat;
        }
    }

    public static class Dog extends Pet {
        private String nameDog;

        public String getNameDog() {
            return nameDog;
        }

        public void setNameDog(String nameDog) {
            this.nameDog = nameDog;
        }

        public Pet getChild() {

            return new Dog();
        }
    }
}
/*
То ли птица, то ли лампа
*/

class Solution4 {
    public static void main(String[] args) {
        printObjectType(new Cat());
        printObjectType(new Bird());
        printObjectType(new Lamp());
        printObjectType(new Cat());
        printObjectType(new Dog());
    }

    public static void printObjectType(Object o) {
        switch (o.getClass().getSimpleName()) {
            case "Cat":
                System.out.println("кошка для Кота");
                break;

            case "Bird":
                System.out.println("птица для Птицы");
                break;
            case "Lamp":
                System.out.println("лампа для Лампы");
                break;
            case "Dog":
                System.out.println("собака для Собаки");
                break;
        }


        // System.out.println(o.getClass().getSimpleName());
    }

    public static class Cat {
    }

    public static class Dog {
    }

    public static class Bird {
    }

    public static class Lamp {
    }
}
/*
Определимся с животным
*/

class Solution5 {
    public static void main(String[] args) {
        System.out.print(getObjectType(new Cow()));
        System.out.print(getObjectType(new Dog()));
        System.out.print(getObjectType(new Whale()));
        System.out.print(getObjectType(new Pig()));
    }

    public static String getObjectType(Object o) {
        switch (o.getClass().getSimpleName()) {
            case "Cow":
                System.out.println("Корова");
                break;
            case "Dog":
                System.out.println("Собака");
                break;
            case "Whale":
                System.out.println("Кит");
                break;
            default:
                System.out.println("Неизвестное животное");
        }

        return "";
    }

    public static class Cow {
    }

    public static class Dog {
    }

    public static class Whale {
    }

    public static class Pig {
    }
}
/*
Абстрактный класс Pet
*/

class Solution6 {
    public static void main(String[] args) {

    }

    abstract public static class Pet {
        public String getName() {
            return "Я - котенок";
        }
    }

}
/*
«Исправь код», часть 1
*/

class Solution7 {
    public static void main(String[] args) {

    }

    abstract public static class Pet {
        public String getName() {
            return "Я - котенок";
        }

        public abstract Pet getChild();
    }
}


class Solution8 {
    public static void main(String[] args) {

    }

    public static abstract class Animal {
        public abstract String getName();
    }

    public static class Cow extends Animal {
        @Override
        public String getName() {
            return "Машка";
        }
    }

}
/*
Кошки не должны быть абстрактными!
*/

class Solution9 {
    public static void main(String[] args) {

    }

    public static abstract class Pet {
        public abstract String getName();

        public abstract Pet getChild();
    }

    public static class Cat extends Pet {

        @Override
        public String getName() {
            return null;
        }

        @Override
        public Pet getChild() {
            return null;
        }
    }

    public static class Dog extends Pet {

        @Override
        public String getName() {
            return null;
        }

        @Override
        public Pet getChild() {
            return null;
        }
    }

}

// интерфейсы

/*
Летать охота
*/

class Solution10 {
    public static void main(String[] args) {

    }

    public interface CanFly {
        void Fly();

        String NameOfMachine();
    }
    //add an interface here - добавь интерфейс тут

}
/*
Лететь, бежать и плыть
*/

class Solution11 {
    public static void main(String[] args) {

    }

    interface CanFly {
        void Fly();
    }

    interface CanRun {
        void Run();
    }

    interface CanSwim {
        void Swim();
    }
//add interfaces here - добавь интерфейсы тут

}
/*
Есть, летать и двигаться
*/

class Solution12 {
    public static void main(String[] args) {

    }

    public interface CanFly {
        public void fly();
    }

    public interface CanMove {
        public void move();
    }

    public interface CanEat {
        public void eat();
    }

    public class Dog implements CanMove, CanEat {
        @Override
        public void move() {

        }

        @Override
        public void eat() {

        }
    }

    public class Duck implements CanFly, CanMove, CanEat {
        @Override
        public void fly() {

        }

        @Override
        public void move() {

        }

        @Override
        public void eat() {

        }
    }

    public class Car implements CanMove {
        @Override
        public void move() {

        }
    }

    public class Airplane implements CanFly, CanMove {
        @Override
        public void fly() {

        }

        @Override
        public void move() {

        }
    }
}
/*
Класс Human и интерфейсы CanRun, CanSwim
*/

class Solution13 {
    public static void main(String[] args) {

    }

    interface CanRun {
        void Run();
    }

    interface CanSwim {
        void Swim();
    }

    abstract class Human implements CanRun, CanSwim {
    }
    //add public interfaces and a public class here - добавь public интерфейсы и public класс тут
}
/*
Все мы немного кошки…
*/

class Solution14 {
    public static void main(String[] args) {
        Pet pet = new Cat();
        Pet pet2 = new Pet();
        System.out.println(pet.getName());
        System.out.println(pet2.getName());
        System.out.println(pet.hanter());
        System.out.println(pet2.hanter());
    }

    public static class Pet {
        public String hanter() {
            return "И пуха и пера и мяса!!";
        }

        public String getName() {
            return "Я - пушистик";
        }
    }

    public static class Cat extends Pet {
        public String getName() {
            return "Я-КОТ!!";
        }
    }
}
/*
Больше не Пушистик
*/

class Solution15 {
    public static void main(String[] args) {
        Pet pet = new Cat();
        pet.setName("Я - пушистик");

        System.out.println(pet.getName());
    }

    public static class Pet {
        protected String name;

        public Pet() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

    public static class Cat extends Pet {
        @Override
        public void setName(String name) {
            this.name = "Я-КОТ";// это более правильно в данном случае
            //super.setName("Я-КОТ"); но и это сработает
        }
    }
}
/*
И снова Пушистик…
*/

class Solution16 {
    public static void main(String[] args) {
        Pet pet = new Cat();
        pet.setName("Я - пушистик");

        System.out.println(pet.getName());
    }

    public static class Pet {
        protected String name;

        public Pet() {
        }

        public final String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

    public static class Cat extends Pet {
        @Override
        public void setName(String name) {
            super.setName("");
        }
    }
}
/*
Посетители
*/

class Solution17 {
    public static void main(String[] args) {
        System.out.println(getObjectType(new Cat()));
        System.out.println(getObjectType(new Tiger()));
        System.out.println(getObjectType(new Lion()));
        System.out.println(getObjectType(new Bull()));
        System.out.println(getObjectType(new Cow()));
        System.out.println(getObjectType(new Animal()));
    }

    public static String getObjectType(Object o) {
        System.out.println(o.getClass().getSimpleName());

        return "Животное";
    }

    public static class Cat extends Animal   //<--Классы наследуются!!
    {
    }

    public static class Tiger extends Cat {
    }

    public static class Lion extends Cat {
    }

    public static class Bull extends Animal {
    }

    public static class Cow extends Animal {
    }

    public static class Animal {
    }
}
/*
Интерфейсы к классу Human
*/

class Solution18 {
    public static void main(String[] args) {
        Human human = new Human();
        System.out.println(human);
    }

    public static interface Worker {
        public void workLazy();
    }

    public static interface Businessman {
        public void workHard();
    }

    public static interface Secretary {
        public void workLazy();
    }

    public static interface Miner {
        public void workVeryHard();
    }

    public static class Human implements Businessman, Secretary, Worker {

        public void workHard() {
        }

        public void workLazy() {
        }
    }
}

/*
Родитель класса CTO
*/

class Solution19 {

    public static void main(String[] args) {
        CTO cto = new CTO();
        System.out.println(cto);
    }

    public static interface Businessman {
        public void workHard();
    }

    public static class Human {
        public void workHard() {
        }
    }

    public static class CTO extends Human implements Businessman {

    }
}
/*
Попадание в десятку
*/

class Solution20 {
    public static void main(String[] args) {
        Integer i = 5;
        int x = transformValue(i);

        System.out.println(x);
    }

    public static Integer transformValue(Integer a) {
        return a + a;
    }

    public static int transformValue(int i) {
        return i * i;
    }
}

/*
Некорректные строки
*/

class Solution21 {
    public static void main(String[] args) throws Exception {
        System.out.println(SimpleObject.NAME);
        System.out.println(Button.NAME);
    }

    interface SimpleObject {
        String NAME = "SimpleObject";

        void onPress();
    }

    interface Button extends SimpleObject {

        final String NAME = "Submit";// final  можно стереть, потому что в интерфейсе все поля и так константы, поэтому их название пишутся в верхнем регистре.

        // public void onPress();

        // protected void onPress();

        // void onPress();

        //  private void onPress();
        //   protected String onPress(Object o);

        String onPress(Object o);

        //private String onPress(Object o);

    }
}

/*
The weather is fine
*/
class Solution22 {
    public static void main(String[] args) {
        System.out.println(new Today(WeatherType.CLOUDY));
        System.out.println(new Today(WeatherType.FOGGY));
        System.out.println(new Today(WeatherType.FREEZING));
    }

    static class Today implements Weather {
        private String type;

        Today(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return String.format("Today it will be %s", this.getWeatherType());
        }

        @Override
        public String getWeatherType() {
            return this.type;
        }
    }

    public interface Weather {
        String getWeatherType();
    }

    public interface WeatherType {
        String CLOUDY = "Cloudy";
        String FOGGY = "Foggy";
        String FREEZING = "Freezing";
    }

}
/*
Чтение файла
*/

class Solution23 {
    public static void main(String[] args) throws IOException {
        // BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        // System.out.println("Введите  имя и путь к файлу");
        //String path=reader.readLine();
        FileReader fr = new FileReader("c:\\тест.txt");
        int count = 0;
        while (fr.ready()) {
            System.out.print(((char) fr.read()));
        }
        fr.close();

        BufferedInputStream is = new BufferedInputStream(new FileInputStream("c:\\тест.txt"));
        while (is.available() > 0) {
            System.out.print((char) (is.read()));
        }
        is.close();
    }
}

/*
Писатель в файл с консоли
*/
class Solution24 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("name file: ");
        String nameFile = reader.readLine();
        FileWriter fw = new FileWriter(nameFile);
        String text;
        text = reader.readLine();
        if (text.equals("exit")) {
            System.exit(12);
        } else {
            fw.write(text + "\r\n");

        }

        do {
            text = reader.readLine();
            if (text.equals("exit")) {
                break;
            } else {
                fw.write(text + "\r\n");
            }
            ;
            fw.write(reader.readLine() + "\r\n");
        } while (!(text.equals("exit")));
        reader.close();
        fw.close();
    }
}

/*
Neo
*/

class Solution25 {
    public static void main(String[] args) throws Exception {
        System.out.println(Matrix.NEO);
    }

    static class Matrix {
        public static DBObject NEO = new User().initializeIdAndName(1, "Neo");


    }

    interface DBObject {
        DBObject initializeIdAndName(long id, String name);
    }

    static class User implements DBObject {
        long id;
        String name;

        @Override
        public String toString() {
            return String.format("The user's name is %s, id = %d", name, id);
        }

        @Override
        public DBObject initializeIdAndName(long id, String name) {
            this.name = name;
            this.id = id;
            return User.this;
        }
    }
}
/*
Bingo!
*/

class Solution26 {
    public static void main(String[] args) {
        Object animal = new Tiger();
        boolean isCat = animal instanceof Cat;
        boolean isTiger = animal instanceof Tiger;
        boolean isPet = animal instanceof Pet;

        printResults(isCat, isTiger, isPet);
    }

    private static void printResults(boolean cat, boolean tiger, boolean pet) {
        if (cat && tiger && pet) System.out.println("Bingo!");
    }

    static class Pet {
    }

    static class Cat extends Pet {
    }

    static class Tiger extends Cat {
    }
}
/*
Bingo-2!
*/

class Solution27 {
    public static void main(String[] args) {
        Cat cat = new TomCat();

        boolean isCat = cat instanceof Cat;
        boolean isMovable = cat instanceof CanMove;
        boolean isTom = cat instanceof TomCat;

        if (isCat && isMovable && isTom) System.out.println("Bingo!");
    }

    interface CanMove {
    }

    static class Cat implements CanMove {
    }

    static class TomCat extends Cat {

    }
}
/*
Building и School
*/

class Solution28 {
    public static void main(String[] args) {
        Building school = getSchool();
        Building shop = getBuilding();

        System.out.println(school);
        System.out.println(shop);
    }

    public static Building getSchool() {
        //измените null на объект класса Building или School
        return new School();
    }

    public static Building getBuilding() {
        //измените null на объект класса Building или School
        return new Building();
    }

    static class School extends Building/*Добавьте сюда ваш код*/ {
        @Override
        public String toString() {
            return "School";
        }
    }

    static class Building /*Добавьте сюда ваш код*/ {
        @Override
        public String toString() {
            return "Building";
        }
    }
}

/*
Коты
*/
class Solution29 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name;
        while (!(name = reader.readLine()).isEmpty()) {
            Cat cat = CatFactory.getCatByKey(name);
            System.out.println(cat.toString());

        }//напишите тут ваш код
        reader.close();
    }

    static class CatFactory {
        static Cat getCatByKey(String key) {
            Cat cat = null;
            if ("vaska".equals(key)) {
                cat = new MaleCat("Василий");
            } else if ("murka".equals(key)) {
                cat = new FemaleCat("Мурочка");
            } else if ("kiska".equals(key)) {
                cat = new FemaleCat("Кисюлька");
            } else {
                cat = new Cat(key);
            }
            return cat;
        }
    }

    static class Cat {
        private String name;

        protected Cat(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public String toString() {
            return "Я уличный кот " + getName();
        }
    }

    static class MaleCat extends Cat {
        MaleCat(String name) {
            super(name);
        }

        public String toString() {
            return "Я - солидный кошак по имени " + getName();
        }
    }

    static class FemaleCat extends Cat {
        FemaleCat(String name) {
            super(name);
        }

        public String toString() {
            return "Я - милая кошечка по имени " + getName();
        }
    }
}
/*
Food
*/

class Solution30 {
    public static void main(String[] args) {
        Food food = new Food();
        Selectable selectable = new Food();
        Food newFood = (Food) selectable;

        foodMethods(food);
        selectableMethods(selectable);
    }

    public static void foodMethods(Food food) {
        food.onSelect();
        food.onEat();//тут добавьте вызов методов для переменной food
    }

    public static void selectableMethods(Selectable selectable) {
        if (selectable instanceof Selectable) {
            selectable.onSelect();

        }
    }

    interface Selectable {
        void onSelect();
    }

    static class Food implements Selectable {
        public void onEat() {
            System.out.println("The food was eaten");
        }

        @Override
        public void onSelect() {
            System.out.println("The food was selected");
        }
    }
}
/*
Без ошибок
1. new Object() нельзя, потому что переменную типа Object невозможно закастить на его потомка.
2. Внимательно следим за иерархией: Джерри наследуется от серого мышонка,
в свою очередь серый мышонок происходит от мышонка и наконец мышонок от объекта.
3. По такой цепочке получается, что Джерри является потомком серого мышонка, простого мышонка и объекта.
4. В итоге можно расширить тип Джерри.

Джерри является серой мышью? Да! Он от нее унаследован.
Джерри является просто мышью? Да! Он по цепочке от нее унаследован.
Т.е. Джерри является и серой мышью и просто мышью одновременно. Думаю понятно, какой объект нужно создавать.
Джерри является объектом? Да! Значит можем сохранить объект Джерри в переменную класса Object. Это расширение типа.

И для понимания того, что дальше написано.
Объект является мышью? Не факт! Объектом может быть что угодно. Поэтому требуется оператор преобразования типа.
 Это сужение. Присваиваем переменной мышь ссылку на объект Джерри, которая хранится в obj.
  Объект тот же остался, он не изменился.
Далее. Мышь является серой мышью? Тоже не факт! Мышь и белая может быть. Тоже требуется оператор преобразования типа.
 Присваиваем переменной серая мышь ссылку мышь, которая в свою очередь на Джерри ссылается. Объект тот же.
Серая мышь является Джерри? Не факт! Серую мышь могут и Рататуй звать. Тоже оператор используем.
Присваиваем переменной джерри ссылку на серую мышь, которая по цепочке ссылается на объект Джерри.
В итоге у нас все переменные ссылаются на объект Джерри. Собственно поэтому на консоль выводится 4 раза Джерри.

*/

class Solution31 {
    public static void main(String[] args) {
        Object obj = new Jerry();//Add your code here

        Mouse mouse = (Mouse) obj;
        GrayMouse grayMouse = (GrayMouse) mouse;
        Jerry jerry = (Jerry) grayMouse;

        printClasses(obj, mouse, grayMouse, jerry);

    }

    public static void printClasses(Object obj, Mouse mouse, GrayMouse grayMouse, Jerry jerry) {
        System.out.println(jerry.getClass().getSimpleName());
        System.out.println(grayMouse.getClass().getSimpleName());
        System.out.println(mouse.getClass().getSimpleName());
        System.out.println(obj.getClass().getSimpleName());
    }

    static class Mouse {
    }

    static class GrayMouse extends Mouse {
    }

    static class Jerry extends GrayMouse {
    }
}
/*
Player and Dancer
*/

class Solution32 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Person person = null;
        String key;
        while (!(key = reader.readLine()).equals("exit")) {
            if ("player".equals(key)) {
                person = new Player();
            } else if ("dancer".equals(key)) {
                person = new Dancer();
            }
            haveFun(person);
        }
    }

    public static void haveFun(Person person) {
        if (person instanceof Player) {
            ((Player) person).play();
        }
        if (person instanceof Dancer) {
            ((Dancer) person).dance();
        }
    }

    interface Person {
    }

    static class Player implements Person {
        void play() {
            System.out.println("playing");
        }
    }

    static class Dancer implements Person {
        void dance() {
            System.out.println("dancing");
        }
    }
}
/*
Мосты
*/

class Solution33 {
    public static void main(String[] args) {
        println(new WaterBridge());
        println(new SuspensionBridge());


    }

    interface Bridge {
        int getCarsCount();
    }

    static class WaterBridge implements Bridge {

        @Override
        public int getCarsCount() {
            return 100;
        }
    }

    static class SuspensionBridge implements Bridge {

        @Override
        public int getCarsCount() {
            return 0;
        }
    }

    public static void println(Bridge bridge) {
        System.out.println(bridge.getCarsCount());
    }
}
/*
Дегустация вин
1. Создаём классы в отдельных файлах с методами, которые возвращают строки согласно ТЗ
(обращайте внимание на заглавные буквы, а ещё лучше всегда копируйте текст).
2. Из методов класса решения нужно возвращать новые объекты соответствующего типа
 чтобы добиться следующего вывода в консоль:
Вкусно
День Рождения
Новый Год
День Рождения

3. В методе получения вкусной выпивки мы НЕ можем создать объект класса выпивка
 потому что класс абстрактный, поэтому мы возвращаем объект типа вино,
  который дотягивается до метода вкуса за счёт наследования.

*/

class Solution34 {
    abstract static class Drink {
        public void taste() {
            System.out.println("Вкусно");
        }

    }

    static class Wine extends Drink {
        public String getHolidayName() {
            String HoliDay1 = "День рождения";
            return HoliDay1;
        }
    }

    static class BubblyWine extends Wine {
        public String getHolidayName() {
            String Holiday = "Новый год";
            return Holiday;
        }
    }

    public static void main(String[] args) {
        getDeliciousDrink().taste();
        System.out.println(getWine().getHolidayName());
        System.out.println(getBubblyWine().getHolidayName());
        System.out.println(getWine().getHolidayName());
    }

    public static Drink getDeliciousDrink() {
        return new Wine();
    }

    public static Wine getWine() {
        return new Wine();
    }

    public static Wine getBubblyWine() {
        return new BubblyWine();
    }
}

/*
User, Loser, Coder and Proger
*/

class Solution35 {
    public interface Person {
        class User implements Person {
            void live() {
                System.out.println("I usually just live.");
            }
        }

        class Loser implements Person {
            void doNothing() {
                System.out.println("I usually do nothing.");
            }
        }

        class Coder implements Person {
            void writeCode() {
                System.out.println("I usually write code.");
            }
        }

        class Proger implements Person {
            void enjoy() {
                System.out.println("It's a wonderful life!");
            }
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;
        while (true) {
            System.out.print("enter the key: ");
            key = reader.readLine();
            if ((key).equals("user")) {
                doWork(new Person.User());
            } else if ((key).equals("loser")) {
                doWork(new Person.Loser());
            } else if ((key).equals("coder")) {
                doWork(new Person.Coder());
            } else if ((key).equals("proger")) {
                doWork(new Person.Proger());
            } else break;
        }
        //тут цикл по чтению ключей, пункт 1
        {
            //создаем объект, пункт 2

            doWork(person); //вызываем doWork

        }
    }

    public static void doWork(Person person) {
        if (person instanceof Person.User) {
            ((Person.User) person).live();
        }
        if (person instanceof Person.Loser) {
            ((Person.Loser) person).doNothing();
        }
        if (person instanceof Person.Coder) {
            ((Person.Coder) person).writeCode();
        }
        if (person instanceof Person.Proger) {
            ((Person.Proger) person).enjoy();
        }
    }
}
/*
Реализовать метод printMainInfo
*/

class Solution36 {
    public static void main(String[] args) {
        Object obj = new Circle();
        Movable movable = (Movable) obj;
        Drawable drawable = new Rectangle();

        printMainInfo(drawable);
        printMainInfo(movable);
    }

    public static void printMainInfo(Object object) {
        if (object instanceof Movable) {
            ((Movable) object).move();
        }
        if (object instanceof Drawable) {
            ((Drawable) object).draw();
        }
    }

    static interface Movable {

        void move();
    }

    static class Circle implements Movable {

        public void draw() {
            System.out.println("Can be drawn");
        }

        public void move() {
            System.out.println("Can be moved");
        }

    }

    static interface Drawable {
        void draw();
    }

    static class Rectangle implements Drawable {
        public void draw() {
            System.out.println("Can be drawn");
        }

        public void move() {
            System.out.println("Can be moved");
        }
    }
}
/*
ООП - Расставить интерфейсы
*/

class Solution37 {
    public static void main(String[] args) {

    }

    public interface Movable {
        boolean isMovable();
    }

    public interface Sellable {
        Object getAllowedAction(String name);
    }

    public interface Discountable {
        Object getAllowedAction();
    }

    public static class Clothes implements Movable, Sellable, Discountable {
        @Override
        public boolean isMovable() {
            return false;
        }

        @Override
        public Object getAllowedAction(String name) {
            return null;
        }

        @Override
        public Object getAllowedAction() {
            return null;
        }
    }
}
/*
ООП - Наследование животных
*/

class Solution38 {
    //добавьте классы Goose и Dragon тут

    public static void main(String[] args) {
        System.out.println(new Goose().getSize());
        System.out.println(new Dragon().getSize());
    }

    public static class BigAnimal {
        protected String getSize() {
            return "как динозавр";
        }
    }

    public static class SmallAnimal {
        String getSize() {
            return "как кошка";
        }
    }

    public static class Goose extends SmallAnimal {
        public String getSize() {
            String parentSize = super.getSize();
            return ("гусь маленький " + parentSize);
        }
    }

    public static class Dragon extends BigAnimal {
        public String getSize() {
            String parentSize = super.getSize();
            return ("дракон большой " + parentSize);

        }
    }

}
/*
ООП - машинки
*/

class Solution39 {
    public static void main(String[] args) {
        new Solution39.LuxuriousCar().printlnDesire();
        new Solution39.CheapCar().printlnDesire();
        new Solution39.Ferrari().printlnDesire();
        new Solution39.Lanos().printlnDesire();
    }

    public static class LuxuriousCar {
       protected void printlnDesire() {
            System.out.println(Constants.WANT_STRING + Constants.LUXURIOUS_CAR);
        }
    }

    public static class CheapCar {
       protected void printlnDesire() {
            System.out.println(Constants.WANT_STRING + Constants.CHEAP_CAR);
        }
    }


    public static class Ferrari extends LuxuriousCar {
        public void printlnDesire() {
            System.out.println(Constants.WANT_STRING + Constants.FERRARI_NAME);
        }
    }

    public static class Lanos extends CheapCar {
        public void printlnDesire() {
            System.out.println(Constants.WANT_STRING + Constants.LANOS_NAME);
        }
    }


    public static class Constants {
        public static String WANT_STRING = "Я хочу ездить на ";
        public static String LUXURIOUS_CAR = "роскошной машине";
        public static String CHEAP_CAR = "дешевой машине";
        public static String FERRARI_NAME = "Феррари";
        public static String LANOS_NAME = "Ланосе";
    }
}
/*
ООП - книги
*/

class Solution40 {
    public static void main(String[] args) {
        List<Book> books = new LinkedList<Book>();
        books.add(new MarkTwainBook("Tom Sawyer"));
        books.add(new AgathaChristieBook("Hercule Poirot"));
      //  System.out.println(books);
        for (Book z:books
             ) {
            System.out.println(z);

        }
    }

    abstract static class Book {
        private String author;

        public Book(String author) {
            this.author = author;
        }

        public abstract Book getBook();

        public abstract String getTitle();

        private String getOutputByBookType() {
            String agathaChristieOutput = author + ": " + getBook().getTitle() + " is a detective";
            String markTwainOutput = getBook().getTitle() + " was written by " + author;

            String output = "output";
           if(this instanceof MarkTwainBook){
               return markTwainOutput;
           }if(this instanceof AgathaChristieBook ){
               return agathaChristieOutput;
            }

            return output;
        }

        public String toString() {
            return getOutputByBookType();
        }
    }

public static class MarkTwainBook extends Book{
       String title;
    public MarkTwainBook(String title) {
        super("MarkTwain");
        this.title=title;
    }

    @Override
    public MarkTwainBook getBook() {
        return this;
    }

    @Override
    public String getTitle() {
        return this.title;
    }
}
public static class AgathaChristieBook extends Book{
String title;
    public AgathaChristieBook(String title) {
        super("AgathaChristie");
     this.title=title;
    }

    @Override
    public Book getBook() {
        return this;
    }

    @Override
    public String getTitle() {
        return this.title;
    }
}
}
/*
ООП - исправь ошибки в наследовании
*/

 class Solution41 {
    public static interface LivingPart {
        Object containsBones();
    }

    public static class BodyPart implements LivingPart {
        private String name;

        public BodyPart(String name) {
            this.name = name;
        }

        public Object  containsBones() {
            String yes="yes";
            return yes;
        }

        public String toString() {
            return containsBones().equals("yes") ? name + " содержит кости" : name + " не содержит кости";
        }
    }

    public static class Finger extends BodyPart {
        private boolean isArtificial;

        public Finger(String name, boolean isArtificial) {
            super(name);
            this.isArtificial = isArtificial;
        }

        public Object containsBones() {
            if(super.containsBones().equals("yes") && !isArtificial)
            {return "yes";}
            else return "no";

           // return super.containsBones().equals("yes") && !isArtificial;
        }
    }

    public static void main(String[] args) {
        printlnFingers();
        printlnBodyParts();
        printlnLivingParts();
    }

    private static void printlnLivingParts() {
        System.out.println(new BodyPart("Рука").containsBones());
    }

    private static void printlnBodyParts() {
        List<BodyPart> bodyParts = new ArrayList<BodyPart>(5);
        bodyParts.add(new BodyPart("Рука"));
        bodyParts.add(new BodyPart("Нога"));
        bodyParts.add(new BodyPart("Голова"));
        bodyParts.add(new BodyPart("Тело"));
        System.out.println(bodyParts.toString());
    }

    private static void printlnFingers() {
        List<Finger> fingers = new ArrayList<Finger>(5);
        fingers.add(new Finger("Большой", true));
        fingers.add(new Finger("Указательный", true));
        fingers.add(new Finger("Средний", true));
        fingers.add(new Finger("Безымянный", false));
        fingers.add(new Finger("Мизинец", true));
        System.out.println(fingers.toString());
    }
}
/*
Что-то лишнее
*/

class Solution42 {
    public static void main(String[] args) {
        print((short) 1);
        print((Number) 1);
        print(1);
        print((Integer) 1);
        print((int) 1);
    }

    public static void print(Integer i) {
        System.out.println("Это Integer");
    }

//    public static void print(int i) {
//        System.out.println("Это Integer");
//    }

    public static void print(Short i) {
        System.out.println("Это Object");
    }

    public static void print(Object i) {
        System.out.println("Это Object");
    }

    public static void print(double i) {
        System.out.println("Это double");
    }

    public static void print(Double i) {
        System.out.println("Это double");
    }

//    public static void print(float i) {
//        System.out.println("Это Double");
//    }
}
/*
ООП - Перегрузка
*/

class Solution43 {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }public static void printMatrix(double m, int n, String value) {
        System.out.println("Заполняем объектами String");
       // printMatrix(m, n, (Object) value);
    }public static void printMatrix(int m, double n, String value) {
        System.out.println("Заполняем объектами String");
       // printMatrix(m, n, (Object) value);
    }public static void printMatrix(byte m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }public static void printMatrix(int m, byte n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }public static void printMatrix(short m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }public static void printMatrix(int m, short n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }public static void printMatrix(short m, byte n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }public static void printMatrix(int m, int n, StringReader value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }
}
/*
ООП - Перегрузка - убираем лишнее
*/

class Solution44 {
    public static void main(String[] args) {
        print(1);
    }

    public static void print(byte b) {
        System.out.println("Я буду Java прогером!");
    }

    public static void print(double d) {
        System.out.println("Я буду Java прогером!");
    }

//    public static void print(long l) {
//        System.out.println("Я буду Java прогером!");
 //   }

//    public static void print(float f) {
//        System.out.println("Я буду Java прогером!");
//    }

    public static void print(char c) {
        System.out.println("Я буду Java прогером!");
    }
}
/*
Мужчина или женщина?
*/

class Solution45 {
    public static void main(String[] args) {
        Man man = new Man();
        Woman woman = new Woman();

        printName(man);
        printName(woman);
    }

    public static void printName(Human man) {

    }

    public static class Human {

    }

    public static class Man extends Human{

    }

    public static class Woman extends Human{

    }
}
/*
Все лишнее - прочь!
*/

class Solution46 {
    public static void main(String[] args) {
        add((short) 1, 2f);
        add(1, 2);
        add(2d, 2);
        add("1", 2d);
        add((byte) 1, 2d);
    }

    public static void add(int i, int j) {
        System.out.println("Integer addition");
    }

    public static void add(int i, double j) {
        System.out.println("Integer and double addition");
    }

    public static void add(Object i, double j) {
        System.out.println("Double addition");
    }
}
/*
Максимально простой код-1
*/

class Solution47 {
    public static void main(String[] args) {
        JuniorJavaDev me = new JuniorJavaDev();
        System.out.println(me.askHubert("What do you think about com.javarush.task.task15.task1511?"));
        System.out.println(me.askZapp("When will the next update happen?"));
    }

    public interface SpecificSerializable extends Serializable {
    }

    public static class JavaDev  implements SpecificSerializable {
        String answerQuestion(String question) {
            return String.format("I'll be thinking of [%s]", question);
        }
    }

    public static class JuniorJavaDev extends JavaDev{
        JavaDev zapp = new JavaDev();
        JavaDev hubert = new JavaDev();

        String askZapp(String question) {
            return zapp.answerQuestion(question);
        }

        String askHubert(String question) {
            return hubert.answerQuestion(question);
        }
    }
}
/*
Максимально простой код-2
*/

class Solution48 {
    public static void main(String[] args) {
        SiamCat simka = new SiamCat("Simka");
        NakedCat nakedSimka = simka.shave();
    }

    public static class NakedCat {
//        public NakedCat() {
//          //  super();
//        }
    }

    public static class NormalCat extends NakedCat {
        public NormalCat() {
          //  super();
        }

        public NormalCat(String name) {
            System.out.println("My name is " + name);
        }

        public NakedCat shave() {
            return this;
        }
    }

    public static class SiamCat extends NormalCat {
        public SiamCat(String name) {
            super(name);
        }
    }
}
/*
Максимально простой код-3
*/

class Solution49 {
    public static void main(String[] args) {
    }

    public interface Runnable {

    }

    public class Machine  implements Runnable {
//        public Machine() {
//            super();
//        }
    }

    public class Car extends Machine {
//        public Car() {
//            super();
//        }
    }
}







