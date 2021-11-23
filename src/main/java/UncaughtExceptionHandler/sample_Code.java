package src.java.UncaughtExceptionHandler;

import java.util.*;

public class sample_Code {
}
/*
Поживем - увидим
Все исключения, которые возникают в процессе работы нити Solution, должны быть обработаны одним из вариантов:
1. Если это Error, то вывести в консоль "Нельзя дальше работать".
2. Если это Exception, то вывести в консоль "Надо обработать".
3. Если это Throwable, то вывести в консоль "Поживем - увидим".
Реализуй эту логику.
Требования:
•
В конструкторе Solution должен устанавливаться свой UncaughtExceptionHandler, который будет перехватывать возникшие
ошибки и выводить текст в консоль.
•
Если выполнение нити Solution закончилось исключением Error, нужно вывести в консоль "Нельзя дальше работать".
•
Если выполнение нити Solution закончилось исключением Exception, нужно вывести в консоль "Надо обработать".
•
Если выполнение нити Solution закончилось исключением Throwable, нужно вывести в консоль "Поживем - увидим".

Думаю уже не актуально, но может для других))
Нам не надо создавать экземпляр Thread т.к. мы наследуемся от Thread. В этом разница реализации наследования самой нити
и имплементации Runnable, где, как раз, и нужен объект new Thread(Runnable target), где target и является нашим классом,
 имплементирующим Runnable.

getUncaughtExceptionHandler().uncaughtException(this, e); прописать в кетче исключения
*/
 class Solution extends Thread {
    @Override
    public void run() {
        System.out.println("sdfdsfdsfdsf");

        int a=4/0;
    }
    public Solution() {
           // Thread solution=new Thread(this);
           this.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
               @Override
               public void uncaughtException(Thread t, Throwable e) {
                   if(e instanceof Exception){                        // вот это правильно
                       System.out.println("Поживем - увидим");
                   }else
               if(e.getCause().equals(Error.class)){
                   System.out.println("Нельзя дальше работать");
               }else
              if(e instanceof Exception){
                  System.out.println("Надо обработать");
              }
              else
                  System.out.println("by-by");
               }
           });
    }

    public static void main(String[] args) throws Exception {
        Thread solution=new Solution();
        solution.start();
      //  Thread.currentThread().sleep(2000);
         // solution.setUncaughtExceptionHandler();
    }
}



/*
Вооружаемся до зубов!
Создай свой UncaughtExceptionHandler в виде локального класса внутри конструктора.
UncaughtExceptionHandler должен маскировать звездочками имя трэда и выводить в консоль описание возникшей ошибки.
"Thread-0" должно быть заменено на "********".
"Thread-4321" должно быть заменено на "***********".
Требования:
•
Определение класса Solution и его поля менять нельзя.
•
Конструктор Solution должен создавать свой UncaughtExceptionHandler, и сохранять его в поле handler.
•
Созданный UncaughtExceptionHandler должен выводить описание возникшей ошибки в консоль.
•
В описании ошибки имя трэда должно быть замаскировано символами "*".
*/
 class Solution22 extends TimerTask {
    protected TimerTask original;
    protected final Thread.UncaughtExceptionHandler handler;

    public Solution22(TimerTask original) {

        if (original == null) {
            throw new NullPointerException();
        }
        this.original = original;
        this.handler = new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getName());
                System.out.println(t.getName(). replaceAll(".", "*"));
                String name=t.getName(). replaceAll(".", "*");
                  Thread.currentThread().setName(name);
                  t.setName(name);
                System.out.println(e.getMessage());
              //  System.out.println(e.getMessage().replaceAll());
            }
        };

        class UncaughtExceptionHandler implements Thread.UncaughtExceptionHandler  {

            @Override
            public void uncaughtException(Thread t, Throwable e) {

            }
        }


    }

    public void run() {
        try {
            original.run();
        } catch (Throwable cause) {
            Thread currentThread = Thread.currentThread();
            handler.uncaughtException(currentThread, new Exception("Blah " + currentThread.getName().replaceAll(".", "*") + " blah-blah-blah", cause));
        }
    }

    public long scheduledExecutionTime() {
        return original.scheduledExecutionTime();
    }

    public boolean cancel() {
        return original.cancel();
    }

    public static void main(String[] args) {
        new Thread(new Solution22(new TimerTask()
        {
            @Override
            public void run()
            {
                throw new Error();
            }
        })).start();

    }
}
/*
Живем своим умом
В классе Solution реализуй интерфейс UncaughtExceptionHandler, который должен:
1. прервать нить, которая бросила исключение.
2. вывести в консоль стек исключений, начиная с самого вложенного.
Пример исключения:
new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")))
Пример вывода:
java.lang.IllegalAccessException: GHI
java.lang.RuntimeException: DEF
java.lang.Exception: ABC
Требования:
•
Класс Solution должен реализовывать интерфейс Thread.UncaughtExceptionHandler.
•
После вызова uncaughtException нужно прервать нить, которая бросила исключение.
•
Затем, вывести в консоль стек исключений, начиная с самого вложенного исключения.
•
Сообщения должны выводиться в формате "exception class: exception message".

*/
 class Solution32 implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
      //  e.printStackTrace();
        System.out.println(e.getCause());
        soute(e);

  // e.printStackTrace();
  // StackTraceElement[] stackTraceElements=e.getStackTrace();
    }
    public void soute (Throwable e) {
        if (e.getCause() != null)
            soute(e.getCause());
        System.out.println(e);
    }

    public static void main(String[] args) {
      Solution32  sdf=new Solution32();
        new Solution32().uncaughtException(Thread.currentThread(), new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));
       // new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));
     //   Thread.setDefaultUncaughtExceptionHandler(new Solution32());

       // throw  new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));

    }
}

