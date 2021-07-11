package src.java.Serialization;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class code {
}
/*
    Externalizable для апартаментов
    Реализуй интерфейс Externalizable в классе Apartment.
Требования:
•
Класс Solution.Apartment должен поддерживать интерфейс Externalizable.
•
В классе Solution.Apartment должен быть реализован метод writeExternal с одним параметром типа ObjectOutput.
•
В классе Solution.Apartment должен быть реализован метод readExternal с одним параметром типа ObjectInput.
•
В методе writeExternal, на полученном в качестве параметра объекте типа ObjectOutput должен быть вызван метод writeObject с параметром address.
•
В методе writeExternal, на полученном в качестве параметра объекте типа ObjectOutput должен быть вызван метод writeInt с параметром year.
•
Метод readExternal должен корректно восстанавливать из ObjectInput значение поля address.
•
Метод readExternal должен корректно восстанавливать из ObjectInput значение поля year.

        */
 class Solution1222 {

    public static class Apartment implements Externalizable {

        private String address;
        private int year;

        /**
         * Mandatory public no-arg constructor.
         */
        public Apartment() { super(); }

        public Apartment(String addr, int y) {
            address = addr;
            year = y;
        }

        /**
         * Prints out the fields used for testing!
         */
        public String toString() {
            return("Address: " + address + "\n" + "Year: " + year);
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(this.address);
            out.writeInt(123);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
address=(String)in.readObject();
year=(int)in.readInt();

        }
    }
//проверим что получилось у меня.Интересно
    public static void main(String[] args) throws IOException, ClassNotFoundException {
Apartment ap=new Apartment("Maykop str.Pionerskaya 385a",2021);
        FileOutputStream fos=new FileOutputStream("apart");

        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(ap);

        //проведем десериализацию объекта и проверим его поля
        FileInputStream fis=new FileInputStream("apart");
        ObjectInputStream ois=new ObjectInputStream(fis);
      Apartment  ap1=(Apartment)ois.readObject();
   fos.close();
   fis.close();
        System.out.println(ap1.toString());
        System.out.println(ap);
    }
}
//Задача решена и усвоена заодно и усложнена.Но стало интересней.
/*
OutputToConsole
*/
class Solution50 {
    public static String greeting = "Hello world";

    /**
     * OutputToConsole is an inner base class for improving your attentiveness.
     * An OutputToConsole object encapsulates the information needed
     * for displaying the [greeting] variable to the console.
     * @author JavaRush
     */
    public static class OutputToConsole implements Externalizable {
        private int counter;

        /**
         * @param out A stream for externalization
         * @throws java.io.IOException
         */
        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeInt(counter);
        }

        /**
         * @param in A stream for de-externalization
         * @throws java.io.IOException
         * @throws ClassNotFoundException
         */
        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            counter = in.readInt();
        }

        /**
         * Class constructor that sets the private counter field.
         */
        public OutputToConsole(int counter) {
            this.counter = counter;
        }

        /**
         * Prints greeting message to console counter times.
         */
        public void printMessage() {
            for (int i = 0; i < counter; i++) {
                System.out.println(greeting);
            }
        }
    }

    public static void main(String[] args) {

    }
}
/*
Externalizable Person
Класс Person должен сериализовываться с помощью интерфейса Externalizable.
Исправь ошибку сериализации.
Сигнатуры методов менять нельзя.
Требования:
•
В классе Solution.Person должен быть создан публичный конструктор без параметров.
•
В классе Solution.Person должен быть создан конструктор с тремя параметрами (String firstName, String lastName, int age).
•
Класс Solution.Person должен поддерживать интерфейс Externalizable.
•
Методы readExternal и writeExternal должны позволять корректно сериализовывать и десериализовывать объекты типа Person.


            firstName = (String) in.readObject();
            mother = (Person) in.readObject();
            lastName = (String) in.readObject();
            father = (Person) in.readObject();
            age = (int) in.readObject();
            children = (List<Person>) in.readObject();
по этой фишке есть 2 способа и вот мой прошёл, а это который верху это вариант в разделе Получить правильное решение в
 IDE, и вот вопрос и как же лучше, тупо последовательно или так ☝, и в чем разница?

*/
 class Solution51 {
    public static class Person implements Externalizable {
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person() {
        }

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(mother);
            out.writeObject(father);
            out.writeObject(firstName);
            out.writeObject(lastName);
            out.writeInt(age);
            out.writeObject(children);
        }
//нужно убедиться в том что порядок полей будет одинаков при десериализации.!!!!!!!!!!!!!!!!!!!!!!!!!
        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            mother = (Person)in.readObject();
            father = (Person)in.readObject();
            firstName = (String) in.readObject();
            lastName =(String) in.readObject();
            age =(int) in.readInt();
            children = (List)in.readObject();
        }
    }

    public static void main(String[] args) {

    }
}

/*
Serializable Solution
Сериализуй класс Solution.
Подумай, какие поля не нужно сериализовать, пометь ненужные поля модификатором transient.
Объект всегда должен содержать актуальные итоговые данные.
Метод src.main не участвует в тестировании.
Написать код проверки самостоятельно в методе src.main:
1) создать файл, открыть поток на чтение (input stream) и на запись(output stream);
2) создать экземпляр класса Solution - savedObject;
3) записать в поток на запись savedObject(убедитесь, что они там действительно есть);
4) создать другой экземпляр класса Solutionс другим параметром;
5) загрузить из потока на чтение объект - loadedObject;
6) проверить, что savedObject.string равна loadedObject.string;
7) обработать исключения.
Требования:
•
Поле pattern должно быть отмечено модификатором transient.
•
Поле currentDate должно быть отмечено модификатором transient.
•
Поле temperature должно быть отмечено модификатором transient.
•
Поле string НЕ должно быть отмечено модификатором transient.
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Я думаю это не необходимость, а логичность.
Зачем сохранять pattern на каждом объекте, если он точно у всех одинаковый?
С  currentDate и temperature, другая история - они у объектов могут быть разные, НО! они нас не интересуют при загрузке
из файла. Вся нужная информация (дата и температура) уже сохранена в строке strng. Поэтому и с
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
*/
class Solution52 implements Externalizable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution52 saveObject=new Solution52(6);

        File serData=new File("serr_data");
        FileOutputStream fos=new FileOutputStream("serr_data");
        FileInputStream fis=new FileInputStream("serr_data");
        ObjectOutputStream save=new ObjectOutputStream(fos);
        save.writeObject(saveObject);
        System.out.println(saveObject.string);
     ObjectInputStream ois= new ObjectInputStream(fis);
     Solution52 loadedObject=(Solution52)ois.readObject();
        System.out.println(loadedObject.string);

      //  System.out.println(new Solution52(4));

    }

  transient   private final String pattern = "dd MMMM yyyy, EEEE";
  transient   private Date currentDate;
    transient private int temperature;
    String string;

    public Solution52() {
    }

    public Solution52(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(string);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
string=(String) in.readObject();
    }
}
/*
Переопределение сериализации
Сделайте так, чтобы после десериализации нить runner продолжила работать.
Ключевые слова объекта runner менять нельзя.
Hint/Подсказка:
Конструктор не вызывается при десериализации, только инициализируются все поля.
Требования:
•
Класс Solution должен поддерживать интерфейс Serializable.
•
Класс Solution должен поддерживать интерфейс Runnable.
•
Поле runner в классе Solution должно быть объявлено с модификатором transient.
•
В методе readObject должен быть создан новый объект типа Thread с текущим объектом в качестве параметра.
•
В методе readObject должен быть вызван метод start у нового объекта типа Thread.


*/
class Solution53 implements Serializable,Runnable{
   transient private Thread runner;
    private int speed;

    public Solution53(int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    public void run() {
        // do something here, doesn't matter what
    }

    /**
     Переопределяем сериализацию.
     Для этого необходимо объявить методы:
     private void writeObject(ObjectOutputStream out) throws IOException
     private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
     Solution53 solution53=(Solution53)in.readObject();
      Thread thread=new Thread(solution53);
        thread.start();

      //in.defaultReadObject();
    }

    public static void main(String[] args) {

    }
}
/*
Минимум изменений
1) Если родительский класс реализует интерфейс Serializable, то все его подклассы автоматически наследуют это интерфейс.

2) Если же наш класс впервые реализует Serializable в своей ветке наследования, то его суперкласс должен отвечать
специальному требованию – у него должен быть доступный конструктор без параметров.
*/
class Solution54 {
    public class A implements Serializable{
        String name = "A";

        public A() {
        }

        public A(String name) {
            this.name += name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public class B extends A {
        String name = "B";

        public B(String name) {
            super(name);
            this.name += name;
        }
    }

    public class C extends B {
        String name = "C";

        public C(String name) {
            super(name);
            this.name = name;
        }
    }

    public static void main(String[] args) {
        C c = new Solution54().new C("ну Цэ типа");
    }
}

/*
Десериализация
На вход подается поток, в который записан сериализованный объект класса A либо класса B.
Десериализуй объект в методе getOriginalObject так, чтобы в случае возникновения исключения было выведено сообщение на
экран и возвращен null.
Реализуй интерфейс Serializable где необходимо.
Требования:
•
Класс B должен быть потомком класса A.
•
Класс A должен поддерживать интерфейс Serializable.
•
Класс B не должен явно поддерживать интерфейс Serializable.
•
Метод getOriginalObject должен возвращать объект типа A полученный из потока ObjectInputStream.
•
Метод getOriginalObject должен возвращать null, если при попытке десериализации не был получен объект типа A.
•
Метод getOriginalObject должен возвращать null, если при попытке десериализации возникло исключение.

*/
class Solution55 implements Serializable{
    public static A getOriginalObject(ObjectInputStream objectStream) {
        A a= null;
        try {
            a = (A)objectStream.readObject();
        } catch (IOException e) {
            return null;

        } catch (ClassNotFoundException e) {
            return null;

        }
        if(a instanceof A){
           return a;
       }
       else{if(a instanceof B){
            System.out.println("not success");}
        }
           return null;
    }

    public class A implements Serializable{
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args) throws IOException {
        B b=new Solution55().new B();
        FileOutputStream fos=new FileOutputStream("seerB");
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(b);
            FileInputStream fis=new FileInputStream("seerB");
            ObjectInputStream ois=new ObjectInputStream(fis);
       B b2=(B)Solution55.getOriginalObject(ois);
    }
}
/*
Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найди проблему и исправь ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
В сигнатуре класса В ошибки нет :).
В методе src.main ошибок нет.
Требования:
•
Класс B должен быть потомком класса A.
•
Класс B должен поддерживать интерфейс Serializable.
•
Класс A не должен поддерживать интерфейс Serializable.
•
Класс A не должен поддерживать интерфейс Externalizable.
•
Программа должна выполняться без ошибок.
•
При десериализации должны корректно восстанавливаться значение полей nameA и nameB.

*/
class Solution56 implements Serializable {
    public static class A {

        public A() {
        }

        protected String nameA = "A";

        public A(String nameA) {
            this.nameA += nameA;
        }
    }

    public class B extends A implements Serializable {
        private void readObject(ObjectInputStream in ) throws IOException, ClassNotFoundException {
            in.defaultReadObject();
            nameA= (String) in.readObject();
        }
      private   void writeObject(ObjectOutputStream out) throws IOException {
            out.defaultWriteObject();
            out.writeObject(this.nameA);
        }

        private String nameB;

        public B(String nameA, String nameB) {
            super(nameA);
            this.nameA += nameA;
            this.nameB = nameB;
        }

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(arrayOutputStream);

        Solution56 solution = new Solution56();
        B b = solution.new B("B2", "C33");
        System.out.println("nameA: " + b.nameA + ", nameB: " + b.nameB);

        oos.writeObject(b);

        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(arrayOutputStream.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(arrayInputStream);

        B b1 = (B)ois.readObject();
        System.out.println("nameA: " + b1.nameA + ", nameB: " + b1.nameB);
    }
}
/*
Исправить ошибку. Сериализация
После десериализации объекта класса Solution обнаружили, что данных в словаре [m] нет :(
Исправить 1 ошибку.
Требования:
•
В классе Solution не должно быть метода void Solution без параметров.
•
В классе Solution должен существовать конструктор без параметров.
•
В классе Solution должен существовать метод size без параметров.
•
В классе Solution метод size должен возвращать значение типа int.

*/
 class Solution213 implements Serializable {
    public Solution213() {
    }

    public static void main(String args[]) throws Exception {
        FileOutputStream fileOutput = new FileOutputStream("your.file.name");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);

        Solution213 solution = new Solution213();
        solution.Solution();
        outputStream.writeObject(solution);

        fileOutput.close();
        outputStream.close();

        //load
        FileInputStream fiStream = new FileInputStream("your.file.name");
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);

        Solution213 loadedObject = (Solution213) objectStream.readObject();

        fiStream.close();
        objectStream.close();

        //Attention!!
        System.out.println(loadedObject.size());
    }

    private Map<String, String> m = new HashMap<>();

    public Map<String, String> getMap() {
        return m;
    }

    public void Solution() {
        m.put("Mickey", "Mouse");
        m.put("Mickey1", "Mantle");
        m.put("Mickey2", "Mantle");
        m.put("Mickey13", "Mantle");
        m.put("Mickey14", "Mantle");
        m.put("Mickey15", "Mantle");
        m.put("Mickey16", "Mantle");
    }

    public int size() {
        return getMap().size();
    }
}

/*
Сериализация человека
Сериализуй класс Person стандартным способом. При необходимости добавь некоторым полям модификатор transient.
Требования:
•
Класс Person должен поддерживать интерфейс Serializable.
•
Поле fullName должно быть отмечено модификатором transient.
•
Поле greeting должно быть отмечено модификатором transient.
•
Поле outputStream должно быть отмечено модификатором transient.
•
Поле logger должно быть отмечено модификатором transient.
•
Поле firstName НЕ должно быть отмечено модификатором transient.
•
Поле lastName НЕ должно быть отмечено модификатором transient.
•
Поле country НЕ должно быть отмечено модификатором transient.
•
Поле sex НЕ должно быть отмечено модификатором transient.

*/
 class Solution59 {

    public static class Person implements Serializable {
        String firstName;
        String lastName;
       transient String fullName;
      transient   final String greeting;
        String country;
         Sex sex;
       transient PrintStream outputStream;
       transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greeting = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
             private void writeObject(ObjectOutputStream out) throws IOException {
                       out.defaultWriteObject();
                // out.writeObject();
                  //     this.fullName=String.format("%s, %s", this.lastName, this.firstName);
             }

             private  void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {

            in.defaultReadObject();
           // this=new Person(this.firstName,this.lastName,this.country,this.sex);
                // this.fullName=String.format("%s, %s", this.lastName, this.firstName);
                  // this.outputStream=System.out;
                //   this.logger=Logger.getLogger(String.valueOf(Person.class));
                  // this.greeting="sdfsdf";
             }
    private  Object readResolve(){
           return new Person(this.firstName,this.lastName,this.country,this.sex);
    }
    }

    enum Sex {
        MALE,
        FEMALE
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person=new Person("Nick","Jonson","Japan",Sex.MALE);
        System.out.println(person.logger);
        FileOutputStream fos=new FileOutputStream("serial_Person");
ObjectOutputStream oos=new ObjectOutputStream(fos);
oos.writeObject(person);
FileInputStream fis=new FileInputStream("serial_Person");
ObjectInputStream ois=new ObjectInputStream(fis);
Person person2=(Person)ois.readObject();
        System.out.println(person2.greeting+person2.logger+person2.fullName+person2.country+person2.sex+person2.logger+person2.outputStream);
        oos.close();
        fis.close();
        fos.close();
        ois.close();

    }
}

/*
Сериализация под запретом
Запрети сериализацию класса SubSolution используя NotSerializableException.
Сигнатуры классов менять нельзя.
Требования:
•
Класс Solution должен поддерживать интерфейс Serializable.
•
Класс SubSolution должен быть создан внутри класса Solution.
•
Класс SubSolution должен быть потомком класса Solution.
•
При попытке сериализовать объект типа SubSolution должно возникать исключение NotSerializableException.
•
При попытке десериализовать объект типа SubSolution должно возникать исключение NotSerializableException.

*/
class Solution60 implements Serializable {
    public static class SubSolution extends Solution60 {
        private void writeObject(ObjectOutputStream out) throws NotSerializableException {
            throw new NotSerializableException("dsfsdfdsf");
        }
        private void readObject(ObjectInputStream in) throws NotSerializableException {
            throw new NotSerializableException();
        }

    }

    public static void main(String[] args) {

    }
}
/*
Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправь ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать экземпляр класса Solution
2) записать в него данные - writeObject
3) сериализовать класс Solution - writeObject(ObjectOutputStream out)
4) десериализовать, получаем новый объект
5) записать в новый объект данные - writeObject
6) проверить, что в файле есть данные из п.2 и п.5
Требования:
•
Поле stream должно быть объявлено с модификатором transient.
•
В методе writeObject(ObjectOutputStream out) не должен быть вызван метод close у потока полученного в качестве параметра.
•
В методе readObject(ObjectInputStream in) не должен быть вызван метод close у потока полученного в качестве параметра.
•
В методе readObject(ObjectInputStream in) поле stream должно быть инициализировано новым объектом типа FileOutputStream
с параметрами(fileName, true).
•
В конструкторе класса Solution поле stream должно быть инициализировано новым объектом типа FileOutputStream с
параметром(fileName).

*/
class Solution61 implements Serializable, AutoCloseable {
    private FileOutputStream stream;
       public String fileName;
    public Solution61(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName=fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
       // out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
       // in.close();
        this.stream=new FileOutputStream(this.fileName,true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) {

    }
}
/*
Расставить обращение к методам суперкласса и модификаторы доступа так, чтобы вывод на экран был следующим:
C class, method2
A class, method2
A class, method1
B class, method1
1. Из одного метода можно вызвать только один метод суперкласса.
2. Из одного метода можно вызвать только один метод класса.
3. Можно менять модификаторы доступа к методам.
Требования:
•
Вывод на экран должен соответствовать условию задачи.
•
Метод method1 должен быть объявлен с модификатором доступа private в классе A.
•
Метод method1 в классе B должен содержать вызов super.method2().
•
Метод method2 в классе С должен содержать вызов super.method1().
•
Метод method2 в классе A должен содержать вызов method1().
 */
class Solution62 {
    public static void main(String[] s) {
        A a = new C();
        a.method2();
    }

    public static class A {
//        public A() {
//        method2();
//        }

      private void method1() {
            System.out.println("A class, method1");
        }

        public void method2() {
            method1();
            System.out.println("A class, method2");
        }
    }

    public static class B extends A {


        public void method1() {
            super.method2();
            System.out.println("B class, method1");
        }

        public void method2() {

            System.out.println("B class, method2");
        }
    }

    public static class C extends B {


        public void method1() {
            System.out.println("C class, method1");
        }

        public void method2() {
          //  super.method1(); это не ошибка, все работает.
            System.out.println("C class, method2");
        }
    }
}






















