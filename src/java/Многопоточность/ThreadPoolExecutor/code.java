package src.java.Многопоточность.ThreadPoolExecutor;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class code {
}

// 1. В методе main создай фиксированный пул из 5 трэдов используя класс Executors.
//2. В цикле отправь на исполнение в пул 10задач Runnable.
//        3. У каждой задачи в методе run вызови метод doExpensiveOperation с порядковым номером задачи начиная с 1, см. пример вывода.
//        4. Запрети добавление новых задач на исполнение в пул (метод shutdown).
//        5. Дай пулу 5 секунд на завершение всех задач (метод awaitTermination и параметр TimeUnit.SECONDS).
//        Требования:
//        •
//        Используя класс Executors, создай в методе main фиксированный пул из 5 трэдов.
//        •
//        Пул должен принимать на исполнение 10 задач Runnable.
//        •
//        Каждая задача должна вызывать метод doExpensiveOperation с порядковым номером задачи, начиная с 1.
//        •
//        Запрети добавление новых задач на исполнение в пул.
//        •
//        На завершение всех задач в пуле нужно установить 5 секунд.

/*
.shutdown();

Инициирует упорядоченное завершение работы, при котором ранее отправленные задачи выполняются, но новые задачи не
 принимаются


.awaitTermination(long timeout, TimeUnit unit)

Блокирует поток, в котором был вызван (в данном случае main), до тех пор, пока все задачи не завершат выполнение после
 запроса на выключение, или пока не истечет время ожидания, или пока текущий поток не будет прерван
 (в зависимости от того, что произойдет раньше)
 */


/*
Знакомство с Executors
*/
 class Solution {
    public static void main(String[] args) throws InterruptedException {
        //Add your code here
ExecutorService executorService=Executors.newFixedThreadPool(5);
        for (int i = 0; i <10 ; i++) {
            int finalI = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                  doExpensiveOperation(finalI);
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(5, TimeUnit.SECONDS);

        /* output example
pool-1-thread-2, localId=2
pool-1-thread-1, localId=1
pool-1-thread-3, localId=3
pool-1-thread-1, localId=7
pool-1-thread-1, localId=9
pool-1-thread-4, localId=4
pool-1-thread-5, localId=5
pool-1-thread-2, localId=6
pool-1-thread-1, localId=10
pool-1-thread-3, localId=8
         */
    }

    private static void doExpensiveOperation(int localId) {
        System.out.println(Thread.currentThread().getName() + ", localId="+localId);
    }
}

// 1. В методе main создай очередь LinkedBlockingQueue<Runnable>.
//2. В цикле добавь в очередь 10 задач Runnable.
//        3. У каждой задачи в методе run вызови метод doExpensiveOperation с порядковым номером задачи начиная с 1, см. пример вывода.
//        4. Создай объект ThreadPoolExecutor со следующими параметрами:
//        - основное количество трэдов (ядро) = 3,
//        - максимальное количество трэдов = 5,
//        - время удержания трэда живым после завершения работы = 1000,
//        - тайм-юнит - миллисекунды,
//        - созданная в п.1. очередь с задачами.
//        5. Запусти все трэды, которые входят в основное кол-во трэдов - ядро, используй метод prestartAllCoreThreads.
//        6. Запрети добавление новых задач на исполнение в пул (метод shutdown).
//        7. Дай объекту ThreadPoolExecutor 5секунд на завершение всех тасок (методawaitTermination и параметрTimeUnit.SECONDS).
//        Требования:
//        •
//        В методе main нужно создать очередь LinkedBlockingQueue<Runnable>.
//        •
//        В цикле добавь в очередь 10 задач Runnable.
//        •
//        Нужно создать объект ThreadPoolExecutor с параметрами, указанными в задании.
//        •
//        С помощью метода prestartAllCoreThreads нужно запустить основные трэды.
//        •
//        Каждая задача должна вызывать метод doExpensiveOperation с порядковым номером задачи, начиная с 1.
//        •
//        Запрети добавление новых задач на исполнение в пул.
//        •
//        На завершение всех задач в пуле нужно установить 5 секунд.

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*
Знакомство с ThreadPoolExecutor
*/
 class Solution1 {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<Runnable>linkedBlockingQueue=new LinkedBlockingQueue<>();
ThreadPoolExecutor executorService= new ThreadPoolExecutor(3,5,1000,TimeUnit.MILLISECONDS,linkedBlockingQueue);
        for (int i = 0; i <10 ; i++) {
            int finalI = i;
            linkedBlockingQueue.add(new Runnable() {
                @Override
                public void run() {
                   doExpensiveOperation(finalI);
                }
            });

        }
        //prestartAllCoreThreads.
        executorService.prestartAllCoreThreads();
        executorService.shutdown();
        executorService.awaitTermination(5,TimeUnit.SECONDS);
        /* Example output
pool-1-thread-2, localId=2
pool-1-thread-3, localId=3
pool-1-thread-1, localId=1
pool-1-thread-3, localId=5
pool-1-thread-2, localId=4
pool-1-thread-3, localId=7
pool-1-thread-1, localId=6
pool-1-thread-3, localId=9
pool-1-thread-2, localId=8
pool-1-thread-1, localId=10
         */
    }

    private static void doExpensiveOperation(int localId) {
        System.out.println(Thread.currentThread().getName() + ", localId=" + localId);
    }
}
//    Разберись в чем отличие методов shutdown и shutdownNow. Выведи список всех незавершенных задач на экран.
//        Должно получиться что-то вроде:
//        pool-1-thread-1, localId=1
//        pool-1-thread-2, localId=2
//        pool-1-thread-3, localId=3
//        pool-1-thread-4, localId=4
//        pool-1-thread-5, localId=5
//        java.util.concurrent.FutureTask@7e6cbb7a was not completed
//        java.util.concurrent.FutureTask@7c3df479 was not completed
//        java.util.concurrent.FutureTask@7106e68e was not completed
//        java.util.concurrent.FutureTask@7eda2dbb was not completed
//        java.util.concurrent.FutureTask@6576fe71 was not completed
//        Требования:
//        •
//        В методе main класса Solution должен быть вызван метод shutdownNow на объекте executor.
//        •
//        В методе main класса Solution на экран должны быть выведены все задачи которые не успел выполнить executor.
//        •
//        Метод main должен быть публичным.
//        •
//        Метод main должен быть статическим.


/*
ShutdownNow!
*/

 class Solution4 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 10; i++) {
            final int localId = i;
            executor.submit(new Runnable() {
                public void run() {
                    doExpensiveOperation(localId);
                }
            });
        }


        List<Runnable> list=executor.shutdownNow();
        executor.shutdownNow();
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i)+" was not completed");
        }
    }

    private static void doExpensiveOperation(int localId) {
        System.out.println(Thread.currentThread().getName() + ", localId="+localId);
    }
}



