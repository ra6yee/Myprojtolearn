package Многопоточность;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class примеры_кода {
}
/*
My first thread

Создать public static class TestThread - нить с интерфейсом Runnable.
TestThread должен выводить в консоль "My first thread".
Требования:
•
Добавь в класс Solution публичный статический класс TestThread.
•
Класс TestThread должен реализовывать интерфейс Runnable.
•
Метод run класса TestThread должен выводить "My first thread".
•
Программа должна вывести "My first thread".
•
Метод main не изменять.


*/

 class Solution {
    public static class TestThread implements Runnable{

        @Override
        public void run() {
            System.out.println("My first thread");
        }
    }
    public static void main(String[] args) {
        TestThread task = new TestThread();
        Thread child=new Thread(task);
        child.start();
        new Thread(task).start();
    }
}
/*
My second thread
1. Создать public static класс TestThread, унаследованный от класса Thread.
2. Создать статик блок внутри TestThread, который выводит в консоль "it's a static block inside TestThread".
3. Метод run должен выводить в консоль "it's a run method".



*/

class Solution1 {
    public static class TestThread extends Thread{
       static {
           System.out.println("it's a static block inside TestThread");
       }

        @Override
        public void run() {
            System.out.println("it's a run method");
        }
    }
    public static void main(String[] args) {
        TestThread thread = new TestThread();
        thread.start();
    }
}
/*
Список и нити
В методе main добавить в статический объект list 5 нитей.
Каждая нить должна быть новым объектом класса Thread, работающим со своим объектом класса SpecialThread.
Требования:
•
В методе main создай 5 объектов типа SpecialThread.
•
В методе main создай 5 объектов типа Thread.
•
Добавь 5 разных нитей в список list.
•
Каждая нить из списка list должна работать со своим объектом класса SpecialThread.
•
Метод run класса SpecialThread должен выводить "it's a run method inside SpecialThread".


*/

class Solution2 {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        //Add your code here - добавьте свой код тут
        list.add(new Thread(new SpecialThread()));
        list.add(new Thread(new SpecialThread()));
        list.add(new Thread(new SpecialThread()));
        list.add(new Thread(new SpecialThread()));
        list.add(new Thread(new SpecialThread()));
        for (Thread z :list
                ) {
            z.start();
        }
    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's a run method inside SpecialThread");
        }
    }
}
/*
Вывод стек-трейса
1. Создать таск (public static класс SpecialThread, который реализует интерфейс Runnable).
2. SpecialThread должен выводить в консоль свой стек-трейс.
Подсказка: main thread уже выводит в консоль свой стек-трейс.
Требования:
•
Добавь в класс Solution публичный статический класс SpecialThread.
•
Класс SpecialThread не должен быть унаследован от какого-либо дополнительного класса.
•
Класс SpecialThread должен реализовывать интерфейс Runnable.
•
Метод run класса SpecialThread должен выводить свой стек-трейс.


*/

class Solution3 {
    public static class SpecialThread implements Runnable{

        @Override
        public void run() {
            for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
                System.out.println(element);
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new SpecialThread());
        thread.start();

        System.out.println("*****************");

        for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
            System.out.println(element);
        }
    }
}
/*
Поговорим о музыке

1. Измени класс Violin так, чтоб он стал таском для нити. Используй интерфейс MusicalInstrument
2. Реализуй необходимый метод в нити Violin. Реализация должна быть следующей:
2.1. Считай время начала игры - метод startPlaying().
2.2. Подожди 1 секунду - метод sleepNSeconds(int n), где n - количество секунд.
2.3. Считай время окончания игры - метод stopPlaying().
2.4. Выведи на консоль продолжительность игры в миллисекундах. Используй методы из пунктов 2.1 и 2.3.
Пример "Playing 1002 ms".
Требования:
•
Класс Violin не должен быть унаследован от какого-либо дополнительного класса.
•
Класс Violin должен реализовывать интерфейс MusicalInstrument.
•
Метод run класса Violin должен вызывать метод startPlaying.
•
Метод run класса Violin должен вызывать метод sleepNSeconds с параметром 1 секунда.
•
Метод run класса Violin должен вызывать метод stopPlaying.
•
Метод run класса Violin должен выводить на консоль продолжительность игры в миллисекундах. Используй формат из примера.

*/
class Solution4 {
    public static int delay = 1000;

    public static void main(String[] args) {
        Thread violin = new Thread(new Violin("Player"));
        violin.start();
    }

    public static void sleepNSeconds(int n) {
        try {
            Thread.sleep(n * delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public interface MusicalInstrument extends Runnable {
        Date startPlaying();

        Date stopPlaying();
    }

    public static class Violin implements MusicalInstrument{
        private String owner;

        public Violin(String owner) {
            this.owner = owner;
        }

        public Date startPlaying() {
            System.out.println(this.owner + " is starting to play");
            return new Date();
        }

        public Date stopPlaying() {
            System.out.println(this.owner + " is stopping playing");
            return new Date();
        }

        @Override
        public void run() {
           Date start=startPlaying();
           sleepNSeconds(1);
           Date stop=stopPlaying();

            System.out.println("Playing "+(stop.getTime()-start.getTime())+ "ms.");
        }
    }
}
/*
join: в нужное время в нужном месте
*/

class Solution6 {
    public static void main(String[] args) throws InterruptedException {
        PrintListThread firstThread = new PrintListThread("firstThread");
        PrintListThread secondThread = new PrintListThread("secondThread");
        firstThread.start();
//firstThread.join();
        secondThread.start();
    secondThread.join();
    }

    public static void printList(List<String> list, String threadName) {
        for (String item : list) {
            System.out.println(String.format("%s : %s", threadName, item));
        }
    }

    public static List<String> getList(int n) {
        List<String> result = new ArrayList<String>();
        if (n < 1) return result;

        for (int i = 0; i < n; i++) {
            result.add(String.format("String %d", (i + 1)));
        }
        return result;
    }

    public static class PrintListThread extends Thread {
        public PrintListThread(String name) {
            super(name);
        }

        public void run() {
            printList(getList(20), getName());
        }
    }
}
/*
Horse Racing
*/

class Solution7 {

    public static void main(String[] args) throws InterruptedException {
        List<Horse> horses = prepareHorsesAndStart(10);
        while (calculateHorsesFinished(horses) != horses.size()) {
        }
    }

    public static int calculateHorsesFinished(List<Horse> horses) throws InterruptedException {
        int finishedCount = 0;
        for (Horse z:
                horses
             ) { if(z.isFinished()){
                 finishedCount++;
        }else{
            System.out.println("Waiting for " +z.getName());
           // Thread.currentThread().join();
            z.join();
        }

        }
        return finishedCount;
    }

    public static List<Horse> prepareHorsesAndStart(int horseCount) {
        List<Horse> horses = new ArrayList<>(horseCount);
        String number;
        for (int i = 1; i < horseCount + 1; i++) {
            number = i < 10 ? ("0" + i) : "" + i;
            horses.add(new Horse("Horse_" + number));
        }

        for (int i = 0; i < horseCount; i++) {
            horses.get(i).start();
        }
        return horses;
    }

    public static class Horse extends Thread {

        private boolean isFinished;

        public Horse(String name) {
            super(name);
        }

        public boolean isFinished() {
            return isFinished;
        }

        public void run() {
            String s = "";
            for (int i = 0; i < 1001; i++) {   // Delay
                s += "" + i;
                if (i == 1000) {
                    s = " has finished the race!";
                    System.out.println(getName() + s);
                    isFinished = true;
                }
            }
        }
    }
}
/*
Продвижение на политических дебатах
*/

class Solution8 {
    public static int totalSpeechCount = 200;
    public static int utterancesPerSpeech = 1000000;

    public static void main(String[] args) throws InterruptedException {
        Politician ivanov = new Politician("Иванов");

        Politician petrov = new Politician("Петров");
        Politician sidorov = new Politician("Сидоров");

        while (ivanov.getSpeechCount() + petrov.getSpeechCount() + sidorov.getSpeechCount() < totalSpeechCount) {
            ivanov.join();
        }

        System.out.println(ivanov);
        System.out.println(petrov);
        System.out.println(sidorov);
    }

    public static class Politician extends Thread {
        private volatile int utteranceCount;

        public Politician(String name) {
            super(name);
            start();
        }

        public void run() {
            while (utteranceCount < totalSpeechCount * utterancesPerSpeech) {
                utteranceCount++;
            }
        }

        public int getSpeechCount() {
            return utteranceCount / utterancesPerSpeech;
        }

        @Override
        public String toString() {
            return String.format("%s сказал речь %d раз", getName(), getSpeechCount());
        }
    }
}




