package exceptions.NewExceptions;

//Напиши реализацию метода veryComplexMethod().
//        Он должен всегда кидать какое-нибудь проверяемое исключение.
//        Кинуть исключение (throw) явно нельзя.
//        Требования:
//        •
//        Метод veryComplexMethod класса veryComplexClass не должен использовать ключевое слово throw.
//        •
//        Метод veryComplexMethod класса veryComplexClass должен бросать исключение.
//        •
//        Брошенное исключение НЕ должно быть исключением времени выполнения(RuntimeException).
//        •
//        Метод veryComplexMethod не должен быть приватным.


/*
Проверяемые исключения (checked exception)
*/

import javax.swing.*;
import java.util.concurrent.Executors;

class VeryComplexClass {
    public void veryComplexMethod() throws Exception {
// можно банально поделить на ноль
int a=5/0;
// или переполнить массив
        Integer[] array=new Integer[5];
        for (int i = 0; i <6 ; i++) {
            array[i]=i;
        }
        //напишите тут ваш код
    }

    public static void main(String[] args) throws Exception {
VeryComplexClass veryComplexClass=new VeryComplexClass();
veryComplexClass.veryComplexMethod();
    }
}



//    Напиши реализацию метода methodThrowsClassCastException(). Он должен всегда кидать Runtime исключение ClassCastException.
//        Напиши реализацию метода methodThrowsNullPointerException(). Он должен всегда кидать Runtime исключение NullPointerException.
//        Кинуть исключение (throw) явно нельзя.
//        Требования:
//        •
//        Метод methodThrowsClassCastException класса veryComplexClass не должен использовать ключевое слово throw.
//        •
//        Метод methodThrowsNullPointerException класса veryComplexClass не должен использовать ключевое слово throw.
//        •
//        Метод methodThrowsClassCastException класса veryComplexClass должен бросать исключение ClassCastException.
//        •
//        Метод methodThrowsNullPointerException класса veryComplexClass должен бросать исключение NullPointerException.

/*
Runtime исключения (unchecked exception)
*/

 class VeryComplexClass1 {
    public void methodThrowsClassCastException() {
        //приведение не к тому типу
        Object x = new Integer(0);
        System.out.println((String)x);

    }

    public void methodThrowsNullPointerException() {
        String string=null;
        string.intern();

    }

    public static void main(String[] args) {
VeryComplexClass1 one=new VeryComplexClass1();
//one.methodThrowsClassCastException();
one.methodThrowsNullPointerException();
    }
}






//Исключения NameIsEmptyException и NameIsNullException должны быть checked.
//        Все типы исключений должны быть обработаны.
//        Реализацию методов main() и getNumberOfCharacters() не менять.
//        Изменен должен быть только порядок catch блоков в методе main().
//        Требования:
//        •
//        При возникновении NameIsNullException на экран должна быть выведена строка: "Ошибка: Имя не задано".
//        •
//        При возникновении NameIsEmptyException на экран должна быть выведена строка: "Ошибка: Имя пустое".
//        •
//        При возникновении любого другого исключения на экран должна быть выведена строка возвращаемая методом
//        toString этого исключения.
//        •
//        Если исключений не было, на экран должна быть выведена строка формата: "Имя содержит X символов",
//        где X - количество символов в нулевом параметре переданном в метод main.
//        •
//        Класс NameIsEmptyException должен быть потомком класса Exception.
//        •
//        Класс NameIsNullException должен быть потомком класса Exception.



/*
Исправь ошибки в коде
*/
class NameIsEmptyException extends Exception {
}
class NameIsNullException extends Exception {
}
public class Solution {
    public static void main(String[] args) {
        if (args.length > 0) {
            try {
                System.out.println("Имя содержит " + NameChecker.getNumberOfCharacters(args[0]) + " символов");
            } catch (NameIsEmptyException e) {
                System.out.println("Ошибка: Имя пустое");
            }

            catch (NameIsNullException e) {
                System.out.println("Ошибка: Имя не задано");
            }
            catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }
}



 class NameChecker {
    private static final int MAX_NUMBER_OF_CHARACTERS = 100500;
    public static int getNumberOfCharacters(String name) throws Exception {
        if (name == null)
            throw new NameIsNullException();
        else if (name.isEmpty())
            throw new NameIsEmptyException();

        int length = name.length();
        if (length > MAX_NUMBER_OF_CHARACTERS)
            throw new Exception("Слишком длинное имя");
        return length;
    }
}


