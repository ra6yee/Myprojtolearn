package src.java.Многопоточность;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class wait_notify_notifyAll {
}
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Дана стандартная реализация методологии wait-notify.
//    Почитай про CountDownLatch и перепиши тело метода someMethod используя поле latch.
//        Весь лишний код удали из класса.
//        Требования:
//        •
//        Из класса Solution должно быть удалено поле lock.
//        •
//        Из метода someMethod должен быть удален synchronized блок.
//        •
//        В методе someMethod должен быть вызван метод await без параметров у объекта сохраненного в поле latch.
//        •
//        В методе someMethod должен быть вызван метод retrieveValue.
//        •
//        В методе someMethod должен быть вызван метод countDown у объекта сохраненного в поле latch.

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////package com.javarush.task.task27.task2711;


/*
CountDownLatch
*/

//class Solution89 {
//    private final Object lock = new Object();
//    private volatile boolean isWaitingForValue = true;
//
//    CountDownLatch latch = new CountDownLatch(1);
//
//    public void someMethod() throws InterruptedException {
//        synchronized (lock) {
//            while (isWaitingForValue) {
//                lock.wait();
//            }
//
//            retrieveValue();
//
//            isWaitingForValue = false;
//            lock.notify();
//        }
//    }
//
//    void retrieveValue() {
//        System.out.println("Value retrieved.");
//    }
//
//    public static void main(String[] args) {
//
//    }
//}

class Solution89 {
   // private final Object lock = new Object();
  //  private volatile boolean isWaitingForValue = true;

    static CountDownLatch latch = new CountDownLatch(4);

    public void someMethod() throws InterruptedException {

            latch.await();


            retrieveValue();

            // isWaitingForValue = false;

          //  latch.countDown();
        }

    void retrieveValue() {
        System.out.println("Value retrieved.");
    }

    public static void main(String[] args) throws InterruptedException {
Solution89 sol=new Solution89();
sol.someMethod();
latch.countDown();
latch.countDown();
latch.countDown();
latch.countDown();
latch.countDown();
    }       // да тут надо отдельные потоки содавать, а не мутить это все в одном потоке
}

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    // В классе TransferObject расставь вызовы методов wait/notify/notifyAll, чтобы обеспечить последовательное создание и получение объекта.
//    В методах run классов ConsumerTask и ProducerTask создай необходимые synchronized блоки.
//        Ожидаемый вывод:
//        ...
//        Put: M
//        Got: M
//        Put: N
//        Got: N
//        Put: K
//        Got: K
//        ...
//        где M, N, K - числа
//        Метод main не участвует в тестировании
//        P.S. Всегда старайся использовать concurrent коллекции вместо ручной реализации wait/notify/notifyAll.
//        Задачи подобные этой позволяют лучше понять основы работы многопоточных приложений.
//        Требования:
//        •
//        В методе run класса ConsumerTask должен содержаться synchronized блок, монитор - transferObject.
//        •
//        В методе run класса ProducerTask должен содержаться synchronized блок, монитор - transferObject.
//        •
//        Метод get класса TransferObject должен ждать появления value, и возвращать его после того, как оно появится.
//        •
//        Метод put класса TransferObject должен ждать пока value заберут и обновлять его значение после того, как оно пропадет.
//        •
//        Метод get класса TransferObject должен устанавливать флаг isValuePresent в false и уведомлять другие нити
//        ожидающие освобождения монитора перед возвратом значение поля value.
//        •
//        Метод put класса TransferObject должен устанавливать флаг isValuePresent в true и уведомлять другие нити
//        ожидающие освобождения монитора после обновления значение поля value.


/*
Producer–consumer
*/
 class Solution44 {
    public static void main(String args[]) throws InterruptedException {
        TransferObject transferObject = new TransferObject();
        ProducerTask producerTask = new ProducerTask(transferObject);
        ConsumerTask consumerTask = new ConsumerTask(transferObject);

        Thread.sleep(50);
        producerTask.stop();
        consumerTask.stop();
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////package com.javarush.task.task27.task2709;

class TransferObject {
    private int value;
    protected volatile boolean isValuePresent = false; //use this variable

    public synchronized int get() {
        while (!isValuePresent){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Got: " + value);
        isValuePresent=false;
        notify();
        return value;
    }

    public synchronized void put(int value) {
       while(isValuePresent){
           try {
               wait();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
        this.value = value;
       isValuePresent=true;
        System.out.println("Put: " + value);
             notify();
    }
}


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////package com.javarush.task.task27.task2709;


      class ProducerTask implements Runnable {
         private TransferObject transferObject;
         protected volatile boolean stopped;
         static volatile AtomicInteger i = new AtomicInteger(0);

         public ProducerTask(TransferObject transferObject) {
             this.transferObject = transferObject;
             new Thread(this, "ProducerTask").start();
         }

         public void run() {
             synchronized (transferObject) {
                 while (!stopped) {
                     transferObject.put(i.incrementAndGet());

                 }
             }
         }

         public void stop() {
             stopped = true;
         }
     }


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////package com.javarush.task.task27.task2709;

     class ConsumerTask implements Runnable {
         private TransferObject transferObject;
         protected volatile boolean stopped;

         public ConsumerTask(TransferObject transferObject) {
             this.transferObject = transferObject;
             new Thread(this, "ConsumerTask").start();
         }

         public void run() {
             synchronized (transferObject) {
                 while (!stopped) {
                     transferObject.get();
                 }
             }
         }

         public void stop() {
             stopped = true;
         }
     }


         // Расставь wait-notify.
//         Пример вывода:
//        Thread-0 MailServer received: [Person [Thread-1] wrote an email 'AAA'] in 1001 ms after start
//        Требования:
//        •
//        Объекты класса MailServer должны работать корректно в многопоточном окружении.
//        •
//        Объекты класса Person должны работать корректно в многопоточном окружении.
//        •
//        В методе run класса MailServer должен присутствовать synchronized блок, монитор - mail.
//        •
//        В методе run класса Person должен присутствовать synchronized блок, монитор - mail.


/*
Расставьте wait-notify
*/
 class Solution9 {
    public static void main(String[] args) {
        Mail mail = new Mail();
        Thread server = new Thread(new MailServer(mail));
        Thread amigo = new Thread(new Person(mail));

        server.start();
        amigo.start();
    }
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

 class Person implements Runnable {
    private final Mail mail;

    public Person(Mail mail) {
        this.mail = mail;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        try {
            Thread.sleep(1000);
            //сделайте что-то тут - do something here
            synchronized (mail) {
                mail.setText("Person [" + name + "] wrote an email 'AAA'");
               mail.notify();
            }
            //сделайте что-то тут - do something here
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////package com.javarush.task.task27.task2710;

 class MailServer implements Runnable {
    private Mail mail;

    public MailServer(Mail mail) {
        this.mail = mail;
    }

    @Override
    public void run() {
        synchronized (mail) {
            long startTime = System.currentTimeMillis();
            while(mail.getText()==null){
                try {
                   mail.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


            String name = Thread.currentThread().getName();
            long endTime = System.currentTimeMillis();
            System.out.format("%s MailServer received: [%s] in %d ms after start", name, mail.getText(), (endTime - startTime));
        }
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////package com.javarush.task.task27.task2710;

 class Mail {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
/*
Не делал никакого цикла ан проверку while(mail.getText==null), как многие пишут внизу, для чего я не понял это делать??
 Как я понял принцип работы в кратце такой:
1. Стартует нить server.start();
2. Она занимает монитор mail  вот так - synchronized(mail) и встаёт в ожидание mail.wait();
3. В то время нить  amigo.start() - которая тоже  synchronized (mail) - определяет текст вот так mail.setText(......)
и будит  mail.notify() - освобождает монитор;
4. После чего server продолжает работу и  выводит текст в консоль...

В этой задаче: В случае если код Person отработает полностью, до конца, и потом управление перейдет в MailServer,
то MailServer должен повиснуть когда у него сработает mail.wait() по причине того что будить его будет некому, так как
код Person завершил свою работу.
А если вводишь проверку  while(mail.getText==null) то MailServer в цикл с mail.wait() не заходит, и код отрабатывает
нормально


Долго тупил не понимая почему у меня на wait(); ошибки сыпятся. Оказывается подразумевается this.wait().
И правильно было вызывать mail.wait();
Что в общем то и логично, ибо если у нас есть 2 или более вложенных блока synchronize, то компилятору не понятно,
какой из мютексов отпускать.

как я понял это.
Мы вызываем блок синхронизации на объекте mail, этим мы захватили мютекс, потом вызываем mail.wait() этим мы усыпляем
нить и освобождаем мютекс объекта mail, эта нить будет спать пока ее не разбудят.
Потом в другой нити происходит нужное нам событие, мы синхронизируемся на объекте mail, у объекта mail вызываем
mail.notify(); или mail.notifyAll(); тут мы говорим спящей нити, захвати мютекс объекта mail и продолжи выполнение
задачи.


*/



