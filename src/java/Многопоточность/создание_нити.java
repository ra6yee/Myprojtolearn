package src.java.Многопоточность;
/*
1) Создать объект класса Thread (нить)

2) Передать в него метод, который нужно выполнить

3) Вызвать у созданного объекта Thread метод start.

или класс должен реализовать интерфейс runnable
или наследовать класс Thread.

 */
public class  создание_нити {

    static class Printer implements Runnable { //Класс, который реализует интерфейс Runnable.
        public void run() {
            System.out.println("I’m printer");
        }
    }

    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread childThread = new Thread(printer);
        childThread.start();
    }
}
//1 Создали объект класса Printer, который содержит метод run.
//2 Создали новый объект класса Thread, передали ему в конструкторе объект printer, чей метод run()нужно будет исполнить.
//3 Запустили новую нить в работу, вызовом метода start().

//создадим нить на основе интерфейса runnable
class Printer implements Runnable
{                                      // класс на основе интерфейса
    private String name;
    public Printer(String name)
    {
        this.name = name;
    }
    public void run()                 // переопределили метод run, в нем можно написать все что угодно.
    {
        System.out.println("I’m " + this.name);
    }

    public static void main(String[] args)
    {
        Printer printer1 = new Printer("Коля"); // создали одну нить
        Thread thread1 = new Thread(printer1);
        thread1.start();

        Printer printer2 = new Printer("Вася"); // создали вторую нить
        Thread thread2 = new Thread(printer2);
        thread2.start();
   // создадим три одинаковые нити, которые делают одно и то же
        Printer printer = new Printer("Наташа");

        Thread thread3 = new Thread(printer);
        thread3.start();

        Thread thread4 = new Thread(printer);
        thread4.start();

        Thread thread5 = new Thread(printer);
        thread5.start();
    }
}

// реализуем класс наследник от Thread

class PrinterP extends Thread {
    private String name;

    public PrinterP(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println("I’m " + this.name);
    }

    public static void main(String[] args) {
        PrinterP printer = new PrinterP("Вася");
        printer.start();

        PrinterP printer2 = new PrinterP("Коля");
        printer2.start();

    }
}
/*
— Это решение красивее.

— Да, но у него есть минусы:

1) Вам может понадобиться запустить несколько нитей на основе одного единственного объекта, как это сделано в «примере с Наташей».

2) Если вы унаследовались от класса Thread, вы не можете добавить еще один класс-родитель к своему классу.

3) Если у вашего класса есть класс-родитель, вы не можете добавить второго – Thread.

— Т.е. каждая из нитей после вызова метода start начнет выполнять метод run того объекта, который ему передали в конструкторе?

— Да. А если в конструкторе ничего не передали, то Thread просто исполняет свой внутренний метод run.

— А почему нельзя просто вызвать этот метод, например, так:

Код
public static void main(String[] args)
{
 Printer printer1 = new Printer("Коля");
 printer1.run();
}
— Когда главная нить дойдет до метода run, наш «маленький роботик»,
 просто зайдет внутрь и начнет исполнять все команды которые там есть внутри и только после их выполнения
  вернется в метод main и продолжит работу дальше. Создания второго «маленького робота» не произойдет
   и вся работа будет делаться последовательно, а не параллельно (одновременно).

— Ясно. А можно вызвать какой-нибудь другой метод, а не run?

— Нет. Все привязано к интерфейсу Runnable, а он «знает» только об одном своем методе – run.
*/
//Еще вариант создания потока через new Thread - через анонимный класс:
//
//        Thread thread = new Thread(new Runnable() {
//@Override
//public void run() {
//        System.out.println("Реализация run");
//        }
//        });



