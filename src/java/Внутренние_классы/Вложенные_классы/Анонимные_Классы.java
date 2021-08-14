package src.java.Внутренние_классы.Вложенные_классы;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class Анонимные_Классы {
}
/*
Напряги извилины!
Метод printName должен выводить имя собственного объекта, т.е. "The Darkside Hacker"
Сделайте минимум изменений.
Требования:
•
Вывод на экран должен соответствовать условию.
•
В классе Solution должен присутствовать метод sout без параметров.
•
В классе Solution должно присутствовать поле name.
•
Модификатор доступа метода getName должен быть расширен.

*/
 class Solution34 {
    private String name;

    Solution34(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void sout() {
        new Solution34("The Darkside Hacker") {
            void printName() {
                System.out.println(getName());
            }
        }.printName();
    }

    public static void main(String[] args) {
        new Solution34("Риша").sout();
    }
}
// низрена не понял, но код работает
// может надо пройтись дебаггером


/*
Повторяем threads
Сделать так, чтобы в методе someActions вызывались только методы класса Solution.
Ожидаемый вывод в методе main:
Amigo: Mmmmm, beef
Amigo: knock knock
Amigo: Zzzzzzz...1 s
Требования:
•
Вывод на экран должен соответствовать условию задачи.
•
В методе someActions должен быть вызван метод sleep класса Solution.
•
В классе Solution должно присутствовать поле name.
•
В классе Solution должно присутствовать поле food.
•
В классе Solution должно присутствовать поле sound.

*/
class Solution111 {
    public  final String name;
    public final String food;
    public final String sound;

    public Solution111(String name, String food, String sound) {
        this.name = name;
        this.food = food;
        this.sound = sound;
    }

    public void eat() {
        System.out.println(name + ": Mmmmm, " + food);
    }

    public void play() {
        System.out.println(name + ": " + sound + " " + sound);
    }

    public  void sleep(long milliseconds) {
        System.out.println(name + ": Zzzzzzz..." + (milliseconds / 1000) + " s");
    }

    public void live() throws InterruptedException {
        Thread thread = new Thread() {
            public void run() {
                try {
                    someActions();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            private void someActions() throws InterruptedException {
                eat();
                play();
                Solution111.this.sleep(1000);
            }
        };
        thread.start();
        thread.join();
    }

    public static void main(String[] args) throws InterruptedException {
        new Solution111("Amigo", "beef", "knock").live();
    }
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class Animal{
    public void eat(){
        System.out.println(" Animal is eating...");
    }
}
class mainOne{
    public static void main(String[] args) {
        Animal animal=new Animal();
        animal.eat();
        //А теперь переопределим метод eat в другом объекте класса Animal
        Animal animal1= new Animal(){
          public void eat(){
              System.out.println("Animal1 is eating...");
          }                                               // используется один раз
        };
          animal1.eat();

    }
}
// более полезный вариант использования аноноимного класса
// создаем интерфейс, в нем указываем сигнатуру методов
interface  animal{
    public void eat(); //поместили сигнатуру метода, который должен будет использоваться
}
class Test{
    public static void main(String[] args) {
        // как бы это не смотрелось, но мы создаем объект интерфейса
        animal animal=new animal() { // и получаем анонимный класс, который можно использовать один раз.
            @Override
            public void eat() {
                System.out.println("animalOne is eating...");
            }
        };
        animal.eat();
    // можем создать сколько угодно таких анонимных разовых классов
        animal animal1= new animal() {
            @Override
            public void eat() {
                System.out.println(" Hello animal1.");
            }
        };
    animal1.eat();
    }
}


