package синтаксис;
// объект может быть только экземпляром класса
//т е сначала создаетсякласс, потом его объект
public class создание_объекта {

}
class Solution{
    String sex;
    int age;

    public Solution() {
    }

    public Solution(String sex, int age) {
        this.sex = sex;
        this.age = age;
    }
}
// объект создается в классе с точкой входа в программу.
// объект можно инициализировать полями через создание конструкторов
// в классе, объект которого созадется.
// Конструкторы и геттеры с сеттерками можно создать через сочетание
// альт + инсерт
class main{
    public static void main(String[] args) {
        Solution solution = new Solution();
    solution.age=23;
    solution.sex="Male";
// создаем через конструктор
        Solution sol2=new Solution("Female",40);

    }
}

class Solution1 {
    public static void main(String[] args) {
        Cat cat8 = new Cat();// это новый объект типа Cat
        Cat cat9;            // а это переменная под ссылку для нового объекта типа Cat. Сейчас она пустая null
    }

    public static class Cat {

    }
}
/*
Питомцам нужны люди
*/
class Solution2 {
    public static void main(String[] args) {
       Cat Tom=new Cat();        // тут хитрый ход с владельцем животных, женщиной, будь внимателен.
       Dog Max=new Dog();
       Fish Ariel=new Fish();
       Woman Lena=new Woman();
       Tom.owner=Lena;
       Max.owner=Lena;
       Ariel.owner=Lena;

    }

    public static class Cat {
        public Woman owner;
    }

    public static class Dog {
        public Woman owner;
    }

    public static class Fish {
        public Woman owner;
    }

    public static class Woman {
    }
}
/**
 Мы создали класс Cat, и указали для него две переменные — строку name, и число age.
 Такие переменные классов называются полями.
 По сути — это шаблон для всех кошек, которых мы создадим в будущем. У каждой кошки (объекта класса Cat)
 будет две переменные — имя и возраст.

 public class Cat {

 String name;
 int age;

 public static void main(String[] args) {
 Cat barsik = new Cat();
 barsik.age = 3;
 barsik.name = "Барсик";

 System.out.println("Мы создали кота по имени " + barsik.name + ", его возраст - " + barsik.age);
 }

 }
 Стоит отметить что переменная static будет принадлежать всему классу,а не какому либо объекту.
 если, например добавить:
 static count;
  то доступ к ней будет из любого объекта класса по умолчанию.
 Изменять ее сможет любой объект.

 Например:

 public class Cat {

 String name;
 int age;

 static int count = 0; общая переменная для всего класса

 public static void main(String[] args) {
 Cat barsik = new Cat();
 barsik.age = 3;
 barsik.name = "Барсик";
 count++; здесь увеличивается переменная

 Cat vasia = new Cat();
 vasia.age = 5;
 vasia.name = "Вася";
 count++; в этом объекте увеличивается та же переменная

 System.out.println("Мы создали кота по имени " + barsik.name + ", его возраст - " + barsik.age);
 System.out.println("Мы создали кота по имени " + vasia.name + ", его возраст - " + vasia.age);

 System.out.println("Общее количество котов = " + count);
 }
 }
 Теперь у нас в классе появилась новая переменная — count (количество). Она отвечает за подсчет созданных котов.
 Каждый раз, когда в методе main мы создаем кота, мы увеличиваем эту переменную на 1.
 Эта переменная обозначена ключевым словом static. Это значит, что она принадлежит классу,
 а не конкретному объекту класса. Что, конечно, логично: если имя у каждого кота должно быть свое,
 то счетчик котов нам нужен один на всех.
 Именно этого позволяет добиться слово static — переменная count одна для всех котов.
 Обрати внимание: когда мы выводим ее в консоль, мы не пишем barsik.count или vasia.count.
 Она не принадлежит ни Барсику, ни Васе — она принадлежит всему классу Cat. Поэтому — просто count.
 Можно также написать Cat.count — это тоже будет правильно.



 */