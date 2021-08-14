package src.java.Интерфейсы_Маркеры;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.rmi.Remote;
import java.util.ArrayDeque;
import java.util.EventListener;

public class code {
}
/*
Создание своего интерфейса-маркера
1. Создай интерфейс-маркер SelfInterfaceMarker.
2. Создай класс SelfInterfaceMarkerImpl, который реализует SelfInterfaceMarker.
3. Добавь в SelfInterfaceMarkerImpl минимум 2 любых public метода.
4. Создай исключение UnsupportedInterfaceMarkerException, унаследуй его от класса Exception.
5. В методе testClass класса Util: если параметр == null, то выбросьте UnsupportedInterfaceMarkerException.
Требования:
•
Интерфейс-маркер SelfInterfaceMarker должен быть создан в отдельном файле.
•
Класс SelfInterfaceMarkerImpl должен быть создан в отдельном файле и реализовывать интерфейс SelfInterfaceMarker.
•
В классе SelfInterfaceMarkerImpl должны существовать минимум два public метода.
•
Исключение UnsupportedInterfaceMarkerException должно быть создано в отдельном файле.
•
Метод testClass класса Util должен бросать исключение UnsupportedInterfaceMarkerException в случае, если полученный параметр равен null.
•
В интерфейсе SelfInterfaceMarker не должны быть объявлены методы или декларированы константы.

*/
 class Solution {
    public static void main(String[] args) throws UnsupportedInterfaceMarkerException {
        SelfInterfaceMarkerImpl obj = new SelfInterfaceMarkerImpl();
        Util.testClass(obj);
        Util.testClass(null);
    }

}
class Util {
    // Пример того, как можно использовать интерфейс-маркер
    // Этот метод подходит только для классов, реализующих SelfInterfaceMarker
    public static void testClass(SelfInterfaceMarker interfaceMarker)  {
        if(interfaceMarker==null){
            try {
                throw new UnsupportedInterfaceMarkerException();
            } catch (UnsupportedInterfaceMarkerException e) {
                e.printStackTrace();
                System.exit(4);
            }
        }
        for (Method method : interfaceMarker.getClass().getDeclaredMethods()) {

            System.out.println(method);
        }
    }
}

interface  SelfInterfaceMarker{
 }

 class SelfInterfaceMarkerImpl implements SelfInterfaceMarker{
     public void One(){
     System.out.println("One");
 }
     public void Two(){
         System.out.println("Two");
     }
 }
class UnsupportedInterfaceMarkerException extends Exception{

}
/*
Cloneable
Добавьте java-код, чтобы метод mainотработал без исключений.
Требования:
•
Класс Test4 должен поддерживать интерфейс Cloneable.
•
В классе Test4 должен быть реализован метод clone() без параметров.
•
В методе main должен быть вызван метод clone на объекте типа Test1.
•
В методе main должен быть вызван метод clone на объекте типа Test2.
•
В методе main должен быть вызван метод clone на объекте типа Test4.
•
В методе main должен быть вызван метод c1one на объекте типа Test3.
•
Класс Test1 должен поддерживать интерфейс Cloneable.

*/
class Solution1 {

    public static void main(String[] args) throws CloneNotSupportedException {
        Test1 test1 = new Test1();
        test1.clone();

        Test2 test2 = new Test2();
        test2.clone(new Test2());

        Test3 test3 = new Test3();
        test3.c1one();

        Test4 test4 = new Test4();
        //test4.clone();
        test4.c1one(); // тут вместо буквы цифра, туфта, а не задание
    }


    public static class Test1  {
        protected Test1 clone() throws CloneNotSupportedException {
            return (Test1)super.clone();
        }
    }

    public static class Test2 extends Test1 {
        public Test2 clone(Test2 test2) throws CloneNotSupportedException {
            return (Test2)test2.clone();
        }
    }

    public static class Test3 {
        protected Object c1one() throws CloneNotSupportedException {
            return new Test3();
        }
    }

    public static class Test4 extends Test3  {
        protected Object c1one() throws CloneNotSupportedException {
            return super.c1one();
        }
    }
}
/*
Так-с... сопоставим
Исправь ошибки: перемести методы clone в те классы, в которых они должны быть реализованы.
Лишние методы удали.
Не удаляй метод main.
Требования:
•
В классе C должен быть реализован метод clone без параметров.
•
В классе Solution должен существовать метод main.
•
В классе Solution должны существовать 4 вложенных класса.
•
В классе Solution должен существовать 1 метод.
•
Метод clone в классе C должен возвращать объект типа C.

*/
class Solution2 {
    public static class A implements Serializable {
    }

    public static class B implements Remote {
    }

    public static class C extends ArrayDeque {
        public C clone() {
            return (C) super.clone();
        }
    }

    public static class D implements EventListener {
    }

//    protected A clone() throws CloneNotSupportedException {
//        return (A) super.clone();
//    }
//
//    protected Thread clone() throws CloneNotSupportedException {
//        return (Thread) super.clone();
//    }
//
//    protected final B clone() throws CloneNotSupportedException {
//        return (B) super.clone();
//    }
//
//    protected ArrayDeque clone() throws CloneNotSupportedException {
//        return super.clone();
//    }
//
//
//
//    protected D clone() throws CloneNotSupportedException {
//        return (D) super.clone();
//    }

    public static void main(String[] args) {

    }
}

