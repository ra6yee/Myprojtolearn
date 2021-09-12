package src.java.Многопоточность.Thread_Group;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class first {
}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// ///В классе Solution создай публичный статический класс AmigoThreadFactory, реализующий интерфейс ThreadFactory.
//1. Реализация интерфейсного метода - создайте и верните трэд, который должен:
//        1.1. не быть демоном,
//        1.2. иметь нормальный приоритет,
//        1.3. имя трэда должно иметь шаблон "GN-pool-A-thread-B",
//        где GN - это имя группы,
//        A - это номер фабрики инкрементируется в пределах класса начиная с 1, используйте AtomicInteger,
//        B - номер треда инкрементируется в пределах конкретной фабрики начиная с 1, используйте AtomicInteger.
//        2. Каждая фабрика должна иметь ту группу тредов (ThreadGroup), в которой она была создана.
//        3. Методы main и emulateThreadFactory не участвуют в тестировании.
//        Пример вывода:
//        secondGroup-pool-2-thread-1
//        firstGroup-pool-1-thread-1
//        firstGroup-pool-1-thread-3
//        secondGroup-pool-2-thread-3
//        firstGroup-pool-1-thread-2
//        secondGroup-pool-2-thread-2
//        Требования:
//        •
//        В классе Solution нужно создать класс public static AmigoThreadFactory, который реализует интерфейс ThreadFactory.
//        •
//        Фабрика AmigoThreadFactory должна создавать трэды, которые не являются демоном.
//        •
//        Фабрика AmigoThreadFactory должна создавать трэды, которые имеют нормальный приоритет.
//        •
//        Фабрика AmigoThreadFactory должна создавать имена для трэдов по шаблону "GN-pool-A-thread-B".
//        •
//        Каждая фабрика должна производить трэды с группой (ThreadGroup), в которой она была создана.

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// ////package com.javarush.task.task28.task2802;




/*
Пишем свою ThreadFactory
*/
 class Solution {

    public static void main(String[] args) {
        class EmulatorThreadFactoryTask implements Runnable {
            @Override
            public void run() {
                emulateThreadFactory();
            }
        }

        ThreadGroup group = new ThreadGroup("firstGroup");
        Thread thread = new Thread(group, new EmulatorThreadFactoryTask());

        ThreadGroup group2 = new ThreadGroup("secondGroup");
        Thread thread2 = new Thread(group2, new EmulatorThreadFactoryTask());

        thread.start();
        thread2.start();
    }

   static class AmigoThreadFactory implements ThreadFactory {
   //   final   AtomicInteger numFabric=new AtomicInteger(1);
      private ThreadGroup group;
       final AtomicInteger threadNumber = new AtomicInteger(0);

        @Override
        public Thread newThread(Runnable r) {
          Thread thread= new Thread(r);
          group=thread.getThreadGroup();
          int groupId=group.getName().equals("firstGroup")?1:2;
          thread.setName(group.getName()+"-pool-"+groupId+"-thread-"+threadNumber.incrementAndGet());
           thread.setDaemon(false);
           thread.setPriority(Thread.NORM_PRIORITY);
            return thread;
        }
    }

    private static void emulateThreadFactory() {
        AmigoThreadFactory factory = new AmigoThreadFactory();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        factory.newThread(r).start();
        factory.newThread(r).start();
        factory.newThread(r).start();
    }
}
/////Класс Solution будет использоваться трэдами.
//    Реализуй логику всех методов, используйте класс ThreadLocalRandom.
//        getRandomIntegerBetweenNumbers должен возвращать случайный int между from и to.
//        getRandomDouble должен возвращать случайный double.
//        getRandomLongBetween0AndN должен возвращать случайный long между 0 и n.
//        Требования:
//        •
//        В классе Solution должны быть только статические методы.
//        •
//        Метод getRandomIntegerBetweenNumbers с помощью ThreadLocalRandom должен возвращать случайный int [from..to].
//        •
//        Метод getRandomDouble с помощью ThreadLocalRandom должен возвращать случайный double [0..1).
//        •
//        Метод getRandomLongBetween0AndN с помощью ThreadLocalRandom должен возвращать случайный long [0..n].

/*
ThreadLocalRandom
*/
 class Solution11 {
    public static int getRandomIntegerBetweenNumbers(int from, int to) {
       return ThreadLocalRandom.current().nextInt(from, to);

    }

    public static double getRandomDouble() {
        return ThreadLocalRandom.current().nextDouble();
    }

    public static long getRandomLongBetween0AndN(long n) {
        return ThreadLocalRandom.current().nextLong();
    }

    public static void main(String[] args) {
        System.out.println(getRandomIntegerBetweenNumbers(1,100));
    }
}





