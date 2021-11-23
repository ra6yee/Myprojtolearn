package src.java.Многопоточность.DeadLock;

public class deadLock_code {
}
//    Расставь модификаторы так, чтобы при работе с этим кодом появился deadlock.
//        Метод main порождает deadlock, поэтому не участвует в тестировании.
//        Требования:
//        •
//        Класс Solution.Friend НЕ должен быть приватным.
//        •
//        Класс Solution.Friend должен быть статическим.
//        •
//        Метод bow должен быть объявлен с модификатором synchronized.
//        •
//        Метод bowBack должен быть объявлен с модификатором synchronized.

/*
Создаем deadlock
*/
 class Solution3 {
    static class Friend {
        private final String name;

        public Friend(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public synchronized void bow(Friend bower) {
            System.out.format("%s: %s"
                            + " bowed to me!%n",
                    this.name, bower.getName());
            bower.bowBack(this);
        }

        public synchronized void bowBack(Friend bower) {
            System.out.format("%s: %s"
                            + " bowed back to me!%n",
                    this.name, bower.getName());
        }
    }

    public static void main(String[] args) {
        final Friend alphonse =
                new Friend("Alphonse");
        final Friend gaston =
                new Friend("Gaston");
        new Thread(new Runnable() {
            public void run() {
                alphonse.bow(gaston);
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                gaston.bow(alphonse);
            }
        }).start();
    }
}
//    В методе secondMethod расставь synchronized блоки так, чтобы при использовании класса Solution нитями образовывался deadlock.
//        Требования:
//        •
//        В методе secondMethod должен присутствовать синхронизированный блок по объекту lock.
//        •
//        В методе secondMethod должен присутствовать вложенный синхронизированный блок по объекту this.
//        •
//        Поле lock должно быть приватным.
//        •
//        Метод secondMethod не должен быть объявлен с модификатором synchronized.

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////package com.javarush.task.task27.task2705;

/*
Второй вариант deadlock
*/
class Solution2 implements Runnable {
    private final Object lock = new Object();

    public Solution2() {

    }

    public synchronized void firstMethod() throws InterruptedException {
        synchronized (lock) {
            doSomething();
      // Thread.sleep(500);
        }
    }

    public synchronized void secondMethod() throws InterruptedException {
        synchronized (lock) {
            synchronized (this) {
                doSomething();
               // Thread.sleep(500);
            }
        }
    }

    private  void doSomething() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
//Solution2 sol1=new Solution2();

//Solution2 sol2=new Solution2();
Thread thread1=new Thread(new Solution2());
thread1.setName("one");

Thread thread2=new Thread(new Solution2());
thread2.setName("two");
thread1.start();
thread2.start();
    }

    @Override
    public void run() {
      //  lock=new Solution2();

        try {
            firstMethod();
            secondMethod();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Расставь модификаторы так, чтобы при работе с этим кодом появился deadlock.
//Метод main порождает deadlock, поэтому не участвует в тестировании.
//        Требования:
//        •
//        Поле field должно быть приватным.
//        •
//        Метод getField НЕ должен быть приватным.
//        •
//        Метод sout должен быть объявлен с модификатором synchronized.
//        •
//        Метод sout2 должен быть объявлен с модификатором synchronized.

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*
Модификаторы и deadlock
*/
 class Solution1 {
    private final String field;

    public Solution1(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }

    public synchronized void sout(Solution1 solution) {
        System.out.format("111:  %s: %s %n", this.field, solution.getField());
        solution.sout2(this);
    }

    public synchronized void sout2(Solution1 solution) {
        System.out.format("222:  %s: %s %n", this.field, solution.getField());
        solution.sout(this);
    }

    public static void main(String[] args) {
        final Solution1 solution = new Solution1("first");
        final Solution1 solution2 = new Solution1("second");
        new Thread(new Runnable() {
            public void run() {
                solution.sout(solution2);
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                solution2.sout(solution);
            }
        }).start();

    }
}
/*
Убираем deadlock
*/
 class Solution5 {

    public void safeMethod(Object obj1, Object obj2) {

      obj1=obj1.hashCode()>obj2.hashCode()?obj1:obj2;
      obj2=obj1.hashCode()>obj2.hashCode()?obj2:obj1;
        synchronized (obj1) {
            longTimeMethod();
            synchronized (obj2) {
                unsafeMethod(obj1, obj2);
            }
        }
    }

    public void longTimeMethod() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {
        }
    }

    protected void unsafeMethod(Object obj1, Object obj2) {
        System.out.println(obj1 + " " + obj2);
    }

    public static void main(String[] args) {
        final Object o1 = new Object();

        final Object o2 = new Object();
        final Solution5 solution = new Solution5();

        new Thread() {
            @Override
            public void run() {
                solution.safeMethod(o1, o2);
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                solution.safeMethod(o2, o1);
            }
        }.start();
    }
}
/*
        Определяем порядок захвата монитора
        Реализуй логику метода isLockOrderNormal, который должен определять:
соответствует ли порядок synchronized блоков в методе someMethodWithSynchronizedBlocks -
порядку передаваемых в него аргументов.
В случае, если сначала происходит синхронизация по o1, а потом по o2, метод должен вернуть true.
Если наоборот - false.


Требования:
1.	Метод isLockOrderNormal должен возвращать true в случае, если синхронизация в методе someMethodWithSynchronizedBlocks
 происходит сначала по объекту o1, а потом по o2.
2.	Метод isLockOrderNormal должен возвращать false в случае, если синхронизация в методе someMethodWithSynchronizedBlocks
 происходит сначала по объекту o2, а потом по o1.
3.	Метод isLockOrderNormal НЕ должен быть приватным.
4.	Класс Solution НЕ должен быть объявлен с модификатором final.
        */
 class Solution6 {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj1) {
            synchronized (obj2) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isLockOrderNormal(final Solution6 solution, final Object o1, final Object o2) throws Exception {
Thread one= new Thread(new Runnable() {
    @Override
    public void run() {
        synchronized (o1){
                synchronized (o2){

                }
        }
        try {
            Thread.currentThread().sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
});
Thread two= new Thread(new Runnable() {
    @Override
    public void run() {
solution.someMethodWithSynchronizedBlocks(o1,o2);
    }
});
one.start();
two.start();
Thread.sleep(2000);
if(!two.getState().equals(Thread.State.BLOCKED)){
return true;
}else
        return false;
    }

    public static void main(String[] args) throws Exception {
        final Solution6 solution = new Solution6();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isLockOrderNormal(solution, o1, o2));
    }
}
