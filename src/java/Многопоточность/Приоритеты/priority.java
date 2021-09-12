package src.java.Многопоточность.Приоритеты;

import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class priority {
}
//    В отдельном файле создай класс MyThreadунаследовавшись от Thread.
//        MyThread должен:
//        1. Иметь возможность быть созданным используя любой конструктор супер-класса (Alt+Insert).
//        2. Приоритет у трэдов должен проставляться циклично от минимального значения до максимального значения.
//        3. если у трэда установлена трэд-группа(ThreadGroup), то приоритет трэда не может быть больше максимального
//        приоритета его трэд-группы.
//        Требования:
//        •
//        Создай класс MyThread в отдельном файле. Унаследуй его от Thread.
//        •
//        В классе MyThread должны присутствовать конструкторы, аналогичные конструкторам супер-класса.
//        •
//        Приоритет у объектов MyThread должен проставляться циклично, от MIN_PRIORITY до MAX_PRIORITY.
//        •
//        Если у объекта MyThread установлена ThreadGroup, приоритет MyThread не должен быть выше максимального приоритета ThreadGroup.


/*
Приоритеты в Threads
*/
class Solution {
static class MyThread extends Thread{
    AtomicInteger atomicInteger=new AtomicInteger(0);
    static int count=0;
    {
//      AtomicInteger count = null;
//      count.set();
////        int priority=getThreadGroup().getMaxPriority();
////         setPriority(priority--);
//        setPriority(count.getAndIncrement());
//        if(count.get()>10){
//            count.set(1);
//        }

//        setPriority((atomicInteger.get()<10)?atomicInteger.addAndGet(1):atomicInteger.addAndGet(-9));
//             atomicInteger.getAndIncrement();
   setPriority(count++ % 10 + 1);
    }

    public MyThread() {
    }

    public MyThread(Runnable target) {
        super(target);
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
    }

    public MyThread(String name) {
        super(name);
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
    }
}
    public static void main(String[] args) {
        for (int i = 0; i < 12; i++) {
            System.out.print(new MyThread().getPriority() + " ");
        }
        //output
        //1 2 3 4 5 6 7 8 9 10 1 2

        System.out.println();
        ThreadGroup group = new ThreadGroup("someName");
        group.setMaxPriority(7);
        for (int i = 0; i < 12; i++) {
            System.out.print(new MyThread(group, "name" + i).getPriority() + " ");
           // new MyThread().start();
        }
        //output
        //3 4 5 6 7 7 7 7 1 2 3 4
    }
}
