package src.java.Внутренние_классы.Вложенные_классы;
import java.util.LinkedList;
import java.util.List;
public class Local_classes {
}
/*
Реализация интерфейса используя локальный класс
В классе Cat реализуй логику метода toSayable, которая описана в джавадоке.
Требования:
•
В классе Cat должен быть реализован публичный метод toSayable с одним параметром типа int.
•
Метод toSayable должен возвращать объект типа Sayable.
•
Если полученный параметр меньше 1, метод say() должен вернуть строку формата: "name спит.", где name - имя текущего кота.
•
Если полученный параметр больше либо равен 1, метод say() должен вернуть строку формата: "name говорит мяяяу!", где
name - имя текущего кота, а количество букв "я" в слове "мяяяу" равно полученному параметру.
•
Программа должна выводить данные на экран.

*/
 class Solution11 {
    public static void main(String[] args) {
        List<Pet> pet = Util.getPets();
        List<Sayable> pets = Util.convertPetToSayable(pet);
        Util.printDialog(pets);
    }
}
 interface Sayable {
    String say();
}

//////////////////////////////////////////////////////////////
interface Pet {
    public Sayable toSayable(int i);
}

////////////////////////////////////////////////////////////////////

 class Util {
    //Util отлично работает со всеми классами Cat, Mouse. А ведь Mouse отличается от Cat.
    public static void printDialog(List<Sayable> pets) {
        for (int i = 0; i < pets.size(); i++) {
            System.out.println(pets.get(i).say());
        }
    }

    public static List<Pet> getPets() {
        List<Pet> pets = new LinkedList<>();
        pets.add(new Cat("Мурзик"));
        pets.add(new Cat("Васька"));
        pets.add(new Cat("Кошка"));
        pets.add(new Mouse());
        pets.add(new Cat("Томас"));
        return pets;
    }

    public static List<Sayable> convertPetToSayable(List<Pet> pets) {
        List<Sayable> result = new LinkedList<>();
        for (Pet pet : pets) {
            int i = (int) (Math.random() * 7) - 2;
            result.add(pet.toSayable(i));
        }
        return result;
    }
}

///////////////////////////////////////////////////////////
/*
В работе вам иногда будет нужно закастить класс к какому-нибудь интерфейсу (тут Sayable),
который не реализован в текущем классе
 */
 class Cat implements Pet {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    /**
     * Это - механизм адаптирования к другому интерфейсу - Sayable
     * Внутри метода toSayable создайте class CatPet, реализующий интерфейс Sayable
     * Логика метода say:
     * Если i < 1, то вывести на экран, что кот спит. Пример, "Васька спит."
     * Иначе вывести фразу: "имя_кота говорит мяу!". Пример для i=3, "Васька говорит мяяяу!"
     * <p/>
     * <b>Пример вывода:</b>
     * Мурзик спит.
     * Васька говорит мяяу!
     * Кошка говорит мяяяяяу!
     * Мышь пищит.
     * Томас говорит мяу!
     * <p/>
     * @param i количество букв 'я' в слове мяу
     * @return экземпляр класса CatPet
     */
    public Sayable toSayable(final int i) {
        class CatPet implements Sayable{
                   StringBuilder sb=new StringBuilder("М");
                   @Override
            public String say() {
                       for (int j = 0; j <i ; j++) {
                           sb.append("я");
                       }
                       sb.append("у");
                if(i<1){return Cat.this.name+" спит"; }
                else
                return Cat.this.name+" говорит "+sb.toString();
            }
        }
        return new CatPet();
    }
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////package com.javarush.task.task24.task2407;

/*
обратите внимание, как именно Mouse отличается от Cat
Этот класс - привычный для вас.
*/
 class Mouse implements Pet, Sayable {
    @Override
    public Sayable toSayable(int i) {
        return this;
    }

    @Override
    public String say() {
        return "Мышь пищит.";
    }
}

