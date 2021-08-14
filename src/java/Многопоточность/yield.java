package src.java.Многопоточность;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
public class yield {
}
//                                  Разберись, что делает программа.
// Запусти 10 раз и посмотри в какие моменты происходит "проверка".
//        Попробуй добиться выполнения "проверки" после каждого изменения баланса, для этого в moveMoney() вызови Thread.yield().
//        Требования:
//        •
//        Класс Solution должен содержать класс Account.
//        •
//        Метод moveMoney() должен перечислять сумму amount с счета from на счет to.
//        •
//        Запусти программу 10 раз и обрати внимание когда происходит проверка.
//        •
//        В методе moveMoney() добавь вызовы Thread.yield().
//        •
//        Снова запусти программу 10 раз, и убедись, что Thread.yield() никак не повлиял на результат работы.


 class Solution90 {

    private static final Random RANDOM = new Random();

    public static synchronized void moveMoney(Account from, Account to, int amount) throws InterruptedException {
        int transactionNumber = RANDOM.nextInt(5000);

        System.out.printf("Транзакция №%d: списание $%d со счета №%d. Баланс: %d.%n", transactionNumber, amount, from.getNumber(), from.getBalance());
    //   Thread.yield();
        from.setBalance(from.getBalance() - amount);
      // .yield();
        Thread.currentThread().sleep(50);

        System.out.printf("Транзакция №%d: зачисление $%d на счет №%d. Баланс: %d.%n", transactionNumber, amount, to.getNumber(), to.getBalance());
  //     Thread.yield();
        to.setBalance(to.getBalance() + amount);
        Thread.currentThread().sleep(50);
    }

    static class Account {
        private int number;
        private int balance;
        private boolean balanceChanged;

        public Account(int number, int balance) {
            this.number = number;
            this.balance = balance;
        }

        public int getNumber() {
            return number;
        }

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
            this.balanceChanged = true;
        }

        public void checkBalance() {
            System.out.println(this.number + ": проверка..."+"текущий баланс счета: "+this.balance);
            this.balanceChanged = false;
        }
    }

    public static void main(String[] args) {
        Account a1 = new Account(44444444, 3000);
        Account a2 = new Account(77777, 10);
        Account a3 = new Account(111, 0);

        Set<Account> accounts = new HashSet<>();
        Collections.addAll(accounts, a1, a2, a3);

        Thread operationThread = new Thread(() -> {
            for (int i = 1; i <= 1000; i *= 10) {
                try {
                    moveMoney(a1, a2, i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread controlThread = new Thread(() -> {
            while (operationThread.isAlive()) {
                accounts.stream().filter(a -> a.balanceChanged).forEach(Account::checkBalance);
            }
        });

        controlThread.start();
        operationThread.start();
    }
}
/*
Первый закон Финэйгла: если эксперимент удался, что-то здесь не так...
Обеспечь переуступку кванта времени (переход хода для текущей нити) для последовательных выводов текста в консоль.
Требования:
•
Класс Solution должен содержать вложенный класс YieldRunnable, который реализует интерфейс Runnable.
•
Класс YieldRunnable должен иметь поле с индексом, которое инициализируется через конструктор.
•
Метод run() должен выводить в консоль сообщения с текущим индексом о начале и конце работы метода.
•
В правильном месте должен быть вызван Thread.yield.

*/
 class Solution01 {
    public static class YieldRunnable implements Runnable {
        private int index;

        public YieldRunnable(int index) {
            this.index = index;
        }

        public void run() {
            System.out.println("begin-" + index);
          Thread.currentThread().yield();
            System.out.println("end-" + index);
           // Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        YieldRunnable yieldRunnable1=new YieldRunnable(1);
        Thread thread1=new Thread(yieldRunnable1);
    YieldRunnable yieldRunnable2=new YieldRunnable(2);
        Thread thread2=new Thread(yieldRunnable2);
        thread2.start();
        thread1.start();
  //  thread1.yield();
    }
}

