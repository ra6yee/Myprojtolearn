package src.java.Многопоточность.Callable_Future;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class code {
}
//    Реализуй логику метода getTask, который должен возвращать объект Callable.
//        Объект Callable должен вычислять сумму всех чисел от 1 до переданного числа i включая его, и возвращать его в виде строки.
//        Метод main не участвует в тестировании.
//        Требования:
//        •
//        Класс Solution должен содержать статический метод getTask(int).
//        •
//        Метод getTask должен возвращать объект Callable<String>.
//        •
//        Объект Callable должен возвращать в виде строки сумму всех чисел от 1 до переданного числа i, включая его
//        •
//        Сумма должна правильно считаться для чисел произвольной длины.




/*
Осваиваем Callable
*/
 class Solution22 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Future<String>> futures = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 1000; i <= 1010; i++) {
            futures.add(executor.submit(getTask(i)));
        }

        futures.add(executor.submit(getTask(10000000)));

        for (Future<String> future : futures) {
            System.out.println(future.get());
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);

/* output
500500
501501
502503
503506
504510
505515
506521
507528
508536
509545
510555
50000005000000
*/
    }

    public static Callable<String> getTask(final int i) {
        Callable<String> cs = new Callable<String>() {
            long count = 0;
            @Override
            public String call() throws Exception {

                for (int j = 1; j < i + 1; j++) {
                    count = count + j;
                }
                String rezult = Long.toString(count);

                return rezult;
            }
        };

        return cs;

    }
 }
//хз что это было и как я это сделал
//Callable<String> интерфейс поэтому нужно делать через анонимный класс и внутри реализовать метод call()
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// /Класс FactorialCalculator предназначен для вычисления факториала числа переданного в
// его конструктор в качестве параметра. К сожалению, он реализован некорректно и тебе необходимо это исправить.
//Внимательно разбери метод main класса Solution.
//        Требования:
//        •
//        Класс FactorialCalculator должен поддерживать интерфейс Callable.
//        •
//        Метод call класса FactorialCalculator должен возвращать результат выполнения метода factorial.
//        •
//        Метод call класса FactorialCalculator должен быть публичным.
//        •
//        Поле number класса FactorialCalculator должно быть приватным.


/*
FutureTask
*/

 class Solution1 {
    private static final ExecutorService threadpool = Executors.newFixedThreadPool(4);
    private static final int n = 16;

    public static void main(String args[]) throws InterruptedException, ExecutionException {
        FactorialCalculator task = new FactorialCalculator(n);

        System.out.println("Submitting Task ...");
        Future future = threadpool.submit(task);
        System.out.println("The task was submitted successfully");

        while (!future.isDone()) {
            System.out.println("The task is not done yet....");
            Thread.sleep(1);
        }

        System.out.println("The task is done. Let's check the result");
        long factorial = (long) future.get();

        System.out.println("Factorial of " + n + " is " + factorial);
        threadpool.shutdown();
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////package com.javarush.task.task28.task2813;



 class FactorialCalculator implements Callable {
    private final int number;

    public FactorialCalculator(int number) {
        this.number = number;
    }

    @Override
    public Long call() throws InterruptedException {
        return factorial(number);
    }

    public long factorial(int number) throws InterruptedException {
        if (number < 0) {
            throw new IllegalArgumentException("Number must be greater than zero");
        }
        long result = 1;
        while (number > 1) {
            Thread.sleep(1);
            result = result * number;
            number--;
        }
        return result;
    }
}


// //Класс ReadWriteMap должен предоставлять корректный доступ к объекту Map из многих потоков, но в его
// реализации были допущены ошибки. Найди их и исправь.
//P.S. Для корректной работы Map в многопоточной среде, желательно пользоваться стандартной реализацией,
//        например ConcurrentHashMap из пакета java.util.concurrent. Но иногда требуется работа с другим типом мапы,
//        например LinkedHashMap и тогда предложенное решение будет как никогда кстати.
//        Требования:
//        •
//        Поле readLock должно быть инициализировано с помощью метода readLock вызванного на объекте lock.
//        •
//        Поле writeLock должно быть инициализировано с помощью метода writeLock вызванного на объекте lock.
//        •
//        В методе put должен быть вызван метод lock на объекте writeLock.
//        •
//        В методе get должен быть вызван метод lock на объекте readLock.
//        •
//        В методе put в блоке finally должен быть вызван метод unlock на объекте writeLock.
//        •
//        В методе get в блоке finally должен быть вызван метод unlock на объекте readLock.


/*
ReentrantReadWriteLock
*/

class Solution21 {
    public static void main(String[] args) {
        ReadWriteMap<Integer, String> linkedSafeMap = new ReadWriteMap<>(new LinkedHashMap<>());
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////package com.javarush.task.task28.task2811;



 class ReadWriteMap<K, V> {
    private final Map<K, V> map;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock=lock.readLock();
    private final Lock writeLock=lock.writeLock();



     public ReadWriteMap(Map<K, V> map) {
        this.map = map;
    }

    public V put(K key, V value) {
        try {writeLock.lock();
            return map.put(key, value);
        } finally {writeLock.unlock();

        }
    }

    public V get(K key) {
        try {readLock.lock();
            return map.get(key);
        } finally {readLock.unlock();

        }
    }
}
