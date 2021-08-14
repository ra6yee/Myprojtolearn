package src.java.Многопоточность.Продолжение;

import static java.lang.Thread.State.TERMINATED;

public class code {
}

/*
Switch для нитей
Обработай список нитей в зависимости от состояния:
1. Если нить еще не запущена, то запусти ее.
2. Если нить в ожидании, то прерви ее.
3. Если нить работает, то проверь маркер isInterrupted.
4. Если нить прекратила работу, то выведи в консоль ее приоритет.
Используй switch.
Требования:
•
Метод processThreads принимает аргументом массив нитей.
•
Если переданная нить не запущена, нужно ее запустить.
•
Если переданная нить находится в ожидании, нужно ее прервать.
•
Если переданная нить работает, то нужно проверить маркер isInterrupted.
•
Если переданная нить завершила работу, нужно вывести в консоль ее приоритет.
•
Метод processThreads должен использовать оператор switch.


*/
class Solution {
    public static void processThreads(Thread... threads) {
        for (Thread z : threads
        ) {
            switch (z.getState()) {
                case NEW:
                    z.start();
                    break;
                case WAITING:
                    z.interrupt();
                    break;
                case RUNNABLE:
                    z.isInterrupted();
                    break;
                case TERMINATED:
                    System.out.println(z.getPriority());
                break;
            }

        }//implement this method - реализуйте этот метод
    }

    public static void main(String[] args) {

    }
}

/*
Без дураков
1. Создай private classMyUncaughtExceptionHandler, который на перехват исключения должен подождать половину секунды, а
затем вывести на экран secretKey, имя трэда и сообщение возникшего исключения.
Используй String.format(...).
Пример:
super secret key, Thread-0, it's an example
2. Разберись в последовательности выполняемого кода и обеспечь логирование возникновения исключения в п.1.
3. Метод main в тестировании не участвует.
Требования:
•
Создай private class MyUncaughtExceptionHandler с конструктором по-умолчанию в классе MyThread.
•
Во время перехвата исключения, MyUncaughtExceptionHandler должен вызвать Thread.sleep(500).
•
Затем, MyUncaughtExceptionHandler должен выводить в консоль secretKey, имя трэда и сообщение возникшего исключения.
•
Для вывода сообщения используй String.format(...).
•
Нужно обеспечить логирование возникновения исключения.

*/
 class Solution1 {

    public static void main(String[] args) {
        MyThread myThread = new Solution1().new MyThread("super secret key");
        myThread.start();
    }

    public class MyThread extends Thread {
        private String secretKey;

        public MyThread(String secretKey) {
            this.secretKey = secretKey;
            setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
            setDaemon(true);
        }

        @Override
        public void run() {
            throw new NullPointerException("it's an example");
        }
       private class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {


            public MyUncaughtExceptionHandler() {
                super();
            }


            @Override
            public void uncaughtException(Thread t, Throwable e) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                System.out.println(secretKey.toString());
                System.out.println(t.getName());
                System.out.println(e.getCause());
            }
        }

    }

}

/*
Почитал комментарии.
1. Спасибо за демона, но его не комментил, а - setDaemon(false)
2. В public class MyThread создаем приватный клас по п.1 задания, который имплементит UncaughtExceptionHandler.
 Конструктор не нужен.
3. Там же реализуем-оверрайдим метод public void uncaughtException(Thread t, Throwable e), в котором и содержится вся логика из п.2-5 требований:
      3.1 Спим 500 милисекунд
      3.2 Выводим в консоль так называемый "лог": секреткей + у переданого треда берем нейм + у ексепшена - месседж. Обязательно при помощи String.format!
4. Все!
....Ну еще п.3 обернул в try-catch по требованию IDEA
 */
/*
Мониторинг состояния нити
Cоздай класс нити LoggingStateThread, которая будет выводить в консоль все состояния (State) переданной в конструктор нити.
Нить LoggingStateThread должна сама завершаться после остановки переданной в конструктор нити.
Метод main не участвует в тестировании.
Требования:
•
Создай класс LoggingStateThread в отдельном файле. Он должен наследовать класс Thread.
•
Класс LoggingStateThread должен содержать поле нити, за которой он будет следить. Это поле должно инициализироваться
через конструктор.
•
Переопредели метод run в классе LoggingStateThread.
•
После запуска класс LoggingStateThread должен выводить в консоль изменения состояния переданной нити.
•
После завершения работы наблюдаемой нити, LoggingStateThread так же должен завершить работу.


*/
 class Solution3 {
    public static void main(String[] args) throws InterruptedException {
        Thread target = new Thread();
        LoggingStateThread loggingStateThread = new LoggingStateThread(target);

        loggingStateThread.start(); //NEW
        Thread.sleep(1000);
        target.start();  //RUNNABLE
        Thread.sleep(1000);
        //TERMINATED
    }
}
class LoggingStateThread extends Thread {
    private Thread thread;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
//        String stateThread=thread.getState().toString();
//        System.out.println(stateThread);
//        State state=thread.getState();
//        System.out.println(state);
//       while(!(thread.getState()==TERMINATED)){
//           String eventStateThread=thread.getState().toString();
//           if(!thread.getState().toString().equals(stateThread)) {
//               System.out.println(eventStateThread);
//           stateThread=eventStateThread;
//           }
//        }
//    }
 State firstState=thread.getState();
        System.out.println(firstState);
        State secondState;
 do{
      secondState=thread.getState();
 if (!(secondState==firstState))
     System.out.println(secondState);
           firstState=secondState;

 }while (thread.getState()!=(TERMINATED));
        if(secondState!=TERMINATED){
            System.out.println(thread.getState().toString());
        }
    }
 }

