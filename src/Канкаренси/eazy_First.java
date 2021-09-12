package src.Канкаренси;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class eazy_First {
}

// Почитать про java.util.concurrent.locks.Lock на http://docs.oracle.com/ (там все есть в джавадоках!)
//    Написать реализацию метода someMethod():
//        1. попытаться захватить лок
//        1.1. если лок занят, то вызвать метод ifLockIsBusy()
//        1.2. если лок свободен, то:
//        1.2.1 вызвать метод ifLockIsFree()
//        1.2.2 отпустить лок при любых условиях, даже если ifLockIsFree() будет кидать исключение
//        Требования:
//        •
//        Класс Solution должен содержать приватное поле Lock lock.
//        •
//        Класс Solution должен содержать публичный метод ifLockIsFree().
//        •
//        Класс Solution должен содержать публичный метод ifLockIsBusy().
//        •
//        Метод someMethod() должен пытаться захватить лок.
//        •
//        Метод someMethod() должен вызвать метод ifLockIsBusy() если лок занят.
//        •
//        Метод someMethod() должен вызвать метод ifLockIsFree() если лок свободен.
//        •
//        Метод someMethod() должен отпускать лок при любых условиях, даже если ifLockIsFree() будет кидать исключение.

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////package com.javarush.task.task26.task2612;


/*
Весь мир играет комедию
*/
class Solution1 {
    private Lock lock = new ReentrantLock();

    public void someMethod() {
     //  Lock lock=new ReentrantLock();

      if(lock.tryLock()){
          try {
              lock.lock();
              actionIfLockIsFree();
          } finally {
              lock.unlock();
          }
      } else
          actionIfLockIsBusy();

      lock.unlock();
    }

    public void actionIfLockIsFree() {
    }

    public void actionIfLockIsBusy() {
    }
}

//    Разберись с BlockingQueue.
//        По образу и подобию класса Producer создай класс Consumer, который будет выводить данные из BlockingQueue в консоль.
//        Требования:
//        •
//        Класс Consumer должен быть создан в отдельном файле.
//        •
//        Класс Consumer должен реализовывать интерфейс Runnable.
//        •
//        Класс Consumer должен содержать приватное поле BlockingQueue queue.
//        •
//        Класс Consumer должен содержать конструктор с одним параметром, инициализирующий поле queue.
//        •
//        Метод run() класса Consumer должен постоянно выводить на экран значения из очереди.

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////package com.javarush.task.task26.task2610;



/*
Мир скучен для скучных людей
*/
 class Solution2 {

    public static void main(String[] args) throws Exception {

        BlockingQueue queue = new ArrayBlockingQueue(32);

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(producer);
        executorService.submit(consumer);

        Thread.sleep(2000);

        executorService.shutdownNow();

    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////package com.javarush.task.task26.task2610;



 class Producer implements Runnable {
    private BlockingQueue queue;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            int i = 0;
            while (true) {
                queue.put(String.valueOf(i++));
                Thread.sleep(300);
            }
        } catch (InterruptedException e) {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }
    }
}
class Consumer implements Runnable{
private BlockingQueue queue;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
      //  int i=0;
        try {
            while(true){

                    System.out.println(queue.take());
                   // Thread.sleep(300);
                   // i++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
// /Разберись с ConcurrentHashMap.
//    В отдельном файле создайте класс Producer, который будет:
//        1. каждые полсекунды добавлять в ConcurrentHashMap ключ и значение, где ключ - счетчик начиная с 1,
//        значение - фраза: "Some text for i" ,
//        пример "Some text for 1".
//        2. при возникновении исключения выводить в консоль: "[THREAD_NAME] thread was terminated", пример "[thread-1]
//         thread was terminated".
//        Требования:
//        •
//        Класс Producer должен быть создан в отдельном файле.
//        •
//        Класс Producer должен реализовывать интерфейс Runnable.
//        •
//        Класс Producer должен содержать приватное поле ConcurrentHashMap<String, String> map.
//        •
//        Класс Producer должен содержать конструктор с одним параметром, инициализирующий поле map.
//        •
//        Метод run() класса Producer должен каждые полсекунды добавлять в ConcurrentHashMap ключ и значение согласно заданию.
//        •
//        Метод run() класса Producer должен при возникновении исключения выводить в консоль "[THREAD_NAME] thread was terminated".
/*
Мир не меняется, меняемся мы
*/
 class Solution4 {
    public static void main(String[] args) throws Exception {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

        Producer1 producer = new Producer1(map);
        Consumer1 consumer = new Consumer1(map);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(producer);
        executorService.submit(consumer);

        Thread.sleep(2000);

        executorService.shutdownNow();
        //finally 5 lines have to be printed
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////package com.javarush.task.task26.task2611;


 class Consumer1 implements Runnable {
    private ConcurrentHashMap<String, String> map;

    public Consumer1(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    public void run() {
        Thread currentThread = Thread.currentThread();
        while (!currentThread.isInterrupted()) {
            if (!map.isEmpty()) {
                for (String key : map.keySet()) {
                    System.out.println(map.remove(key));
                }
            }
        }
    }
}
class Producer1 implements Runnable{
private ConcurrentHashMap<String,String> map;

    public Producer1(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
       int count=1;
        try {
        while(true) {
            String text="Some text for "+count;
            map.put(String.valueOf(count),text);
            count++;

                Thread.currentThread().sleep(500);

            }
        } catch (InterruptedException e) {
                System.out.println(String.format("Thread [%s] was terminated", Thread.currentThread().getName()) );

            }
        }
    }



