package Многопоточность;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class interrupt_code {
}
/*
Считаем секунды
1. Напиши реализацию метода run в нити Stopwatch (секундомер).
2. Stopwatch должен посчитать количество секунд, которое прошло от создания нити до ввода строки.
3. Выведи количество секунд в консоль.
Требования:
•
Метод run класса Stopwatch (секундомер) должен содержать цикл.
•
Метод run должен вызывать Thread.sleep(1000).
•
Метод run должен увеличивать значение поля seconds на 1 каждую секунду.
•
После прерывания работы нити Stopwatch (вызова метода interrupt), метод run должен вывести количество секунд (seconds) в консоль.
•
В классе Stopwatch должен быть только один метод run.

*/

class Solution21 {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        //create and run thread
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        //read a string
        reader.readLine();
        stopwatch.interrupt();
        //close streams
        reader.close();
        in.close();
    }

    public static class Stopwatch extends Thread {
        private int seconds;

        public void run() {
         while(!(Thread.currentThread().isInterrupted())) {
             try {
                 Thread.sleep(1000);

             } catch (InterruptedException e) {
                 Thread.currentThread().interrupt();
             }
             seconds++;


         }

            System.out.println(seconds);
        }
    }
}

/*
Отсчет на гонках
1. Разберись, что делает программа.
2. Реализуй логику метода run так, чтобы каждую секунду через пробел
выдавался отсчет начиная с numSeconds до 1, а потом слово [Марш!] (см примеры).
3. Если нить работает 3.5 секунды или более, прерви ее методом interrupt и внутри нити выведи в консоль слово [Прервано!].
Пример для numSeconds=4 :
"4 3 2 1 Прервано!"
4. Если нить работает менее 3.5 секунд, она должна завершиться сама.
Пример для numSeconds=3 :
"3 2 1 Марш!"
PS: метод sleep выбрасывает InterruptedException.
Требования:
•
Метод run класса RacingClock должен содержать цикл.
•
Объект класса RacingClock должен каждую секунду уменьшать значение переменной numSeconds на единицу.
•
Метод main должен вызывать Thread.sleep(3500).
•
Метод main должен вызывать метод interrupt у объекта clock.
•
Если numSeconds равно 3, то программа должна вывести "3 2 1 Марш!".
•
Если numSeconds равно 4, то программа должна вывести "4 3 2 1 Прервано!".

*/
 class Solution22 {
    public static volatile int numSeconds = 3;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        Thread.currentThread().sleep(3500);
        clock.interrupt();
      //  clock.
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }
               int numSec2=numSeconds;
        public void run() {

            for (int i = 0; i <numSeconds+1 ; i++) {
                System.out.print(numSec2+" ");
                numSec2--;
                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {
                    //  Thread.currentThread().interrupt();
                    if (!(Thread.currentThread().isInterrupted())) {
                        System.out.print("Прервано!");
                        break;
                    }
                }
               if(numSec2==0){
                   System.out.println("Марш!");
                   break;
               }


            }
        }
    }
}

/*
Снова interrupt
Создай нить TestThread.
В методе main создай экземпляр нити, запусти, а потом прерви ее используя метод interrupt().
Требования:
•
Класс TestThread должен быть унаследован от Thread.
•
Класс TestThread должен иметь public void метод run.
•
Метод main должен создавать объект типа TestThread.
•
Метод main должен вызывать метод start у объекта типа TestThread.
•
Метод main должен вызывать метод interrupt у объекта типа TestThread.


*/

class Solution23 {
    public static void main(String[] args) throws InterruptedException {
        TestThread tt=new TestThread();
        Thread second= new Thread(tt);
        second.start();
        Thread.currentThread().sleep(5000);
        second.interrupt();
    }

    //Add your code below - добавь код ниже
    public static class TestThread extends Thread {
        int i=10;
        @Override

        public void run() {
            System.out.println(i--);
        }
    }
}
/*
Один для всех, все - для одного
1. Разберись, как работает программа.
1.1. Обрати внимание, что объект Water - один для всех нитей.
2. Реализуй метод ourInterruptMethod, чтобы он прерывал все нити из threads.
3. В методе run исправь значения переменных:
3.1. isCurrentThreadInterrupted - должна равняться значению метода isInterrupted у текущей нити.
3.2. threadName - должна равняться значению метода getName (реализовано в классе Thread) у текущей нити.
Требования:
•
Метод ourInterruptMethod должен прервать все нити из списка threads.
•
Метод run должен получать текущую нить с помощью Thread.currentThread.
•
Метод run должен использовать метод isInterrupted текущей нити.
•
Метод run должен использовать метод getName текущей нити.
•
Метод main должен работать примерно 3 сек.

*/

class Solution24 {
    public static byte threadCount = 3;
    static List<Thread> threads = new ArrayList<Thread>(threadCount);

    public static void main(String[] args) throws InterruptedException {
        initThreadsAndStart();
        Thread.sleep(3000);
        ourInterruptMethod();
    }

    public static void ourInterruptMethod() {
        for (Thread z:threads
             ) {z.interrupt();

        }
    }

    private static void initThreadsAndStart() {
        Water water = new Water("water");
        for (int i = 0; i < threadCount; i++) {
            threads.add(new Thread(water, "#" + i));
        }

        for (int i = 0; i < threadCount; i++) {
            threads.get(i).start();
        }
    }

    public static class Water implements Runnable {
        private String sharedResource;

        public Water(String sharedResource) {
            this.sharedResource = sharedResource;
        }

        public void run() {
            //fix 2 variables - исправь 2 переменных
            boolean isCurrentThreadInterrupted = Thread.currentThread().isInterrupted();
            String threadName = Thread.currentThread().getName();

            try {
                while (!isCurrentThreadInterrupted) {

                    System.out.println("Объект " + sharedResource + ", нить " + threadName);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
            }
        }
    }
}







