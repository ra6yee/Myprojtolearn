package src.java.String_StringBuilder;

public class пример_обработчик {
}
/*
Строки нитей или строковые нити? Вот в чем вопрос
1. Метод getPartOfString должен возвращать подстроку между первой и последней табуляцией.
2. На некорректные данные getPartOfString должен бросить исключение:
а) StringForFirstThreadTooShortException, если имя трэда FIRST_THREAD_NAME.
б) StringForSecondThreadTooShortException, если имя трэда SECOND_THREAD_NAME.
в) RuntimeException в других случаях.
3. Реализуйте логику трех protected методов в OurUncaughtExceptionHandler используя вызовы соответствующих методов
согласно следующим шаблонам:
a) 1# : StringForFirstThreadTooShortException : java.lang.StringIndexOutOfBoundsException: String index out of range: -1
б) java.lang.StringIndexOutOfBoundsException: String index out of range: -1 : StringForSecondThreadTooShortException : 2#
в) RuntimeException : java.lang.StringIndexOutOfBoundsException: String index out of range: -1 : 3#
Требования:
•
Метод getPartOfString() должен возвращать подстроку между первой и последней табуляцией строки string переданной ему в
качестве первого параметра.
•
В случае некорректных данных метод getPartOfString() должен бросить исключение StringForFirstThreadTooShortException,
 если имя трэда(threadName) Solution.FIRST_THREAD_NAME.
•
В случае некорректных данных метод getPartOfString() должен бросить исключение StringForSecondThreadTooShortException,
 если имя трэда(threadName) Solution.SECOND_THREAD_NAME.
•
В случае некорректных данных метод getPartOfString() должен бросить исключение RuntimeException, если имя
трэда(threadName) не Solution.FIRST_THREAD_NAME или Solution.SECOND_THREAD_NAME.
•
Метод getFormattedStringForFirstThread() должен возвращать строку сформированную из переданных параметров по шаблону
указанному в задании.
•
Метод getFormattedStringForSecondThread() должен возвращать строку сформированную из переданных параметров по шаблону
указанному в задании.
•
Метод getFormattedStringForOtherThread() должен возвращать строку сформированную из переданных параметров по шаблону
указанному в задании.


*/
 class Solution {
    public static void main(String[] args) {
        new Solution();
    }

    public static final String FIRST_THREAD_NAME = "1#";
    public static final String SECOND_THREAD_NAME = "2#";

    private Thread thread1;
    private Thread thread2;
    private Thread thread3;

    public Solution() {
        initThreads();
    }

    protected void initThreads() {
        this.thread1 = new Thread(new Task(this, "A\tB\tC\tD\tE\tF\tG\tH\tI"), FIRST_THREAD_NAME);
        this.thread2 = new Thread(new Task(this, "J\tK\tL\tM\tN\tO\tP\tQ\tR\tS\tT\tU\tV\tW\tX\tY\tZ"), SECOND_THREAD_NAME);
        this.thread3 = new Thread(new Task(this, "\t\t"), "3#");

     //   Thread.setDefaultUncaughtExceptionHandler(new OurUncaughtExceptionHandler());

        this.thread1.start();
        this.thread2.start();
        this.thread3.start();
    }

    public synchronized String getPartOfString(String string, String threadName) {
        int firstIndex=string.indexOf("\t");
        int lastIndex=string.lastIndexOf("\t");
      //  string.substring(string.indexOf("\t") + 1, string.lastIndexOf("\t") );
        return string.substring(firstIndex+1,lastIndex);
    }
}

 class StringForFirstThreadTooShortException extends RuntimeException {

}

class Task implements Runnable {
    private String initialString;
    private Solution solution;

    public Task(Solution solution, String initialString) {
        this.solution = solution;
        this.initialString = initialString;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        String str = this.initialString;
        do {
            System.out.println(name + str);
        } while ((str = solution.getPartOfString(str, name)) != null || !str.isEmpty());
    }
}
/*
"Есть класс Task, который работает в многопоточности. Его задача выводить строку из поля initialString в консоль, а
потом отправлять в Solution.getPartOfString(), который будет ее обрезать с начала и с конца до символов табуляции и
отправлять обратно (реализуй логику метода). Если строку больше нельзя обрезать, поток должен завершится одним из
следующих необрабатываемых видов исключений:
StringForFirstThreadTooShortException (если имя трэда FIRST_THREAD_NAME),
StringForSecondThreadTooShortException (если имя трэда SECOND_THREAD_NAME),
RuntimeException (в других случаях).
Прочитай про потоковый обработчик исключений Thread.UncaughtExceptionHandler. Допиши уже созданый обработчик так, чтобы
он обрабатывал каждое вышеперечисленное исключение и совершал вывод в консоль согласно данным шаблонам:
a) 1# : StringForFirstThreadTooShortException : java.lang.StringIndexOutOfBoundsException: String index out of range: -1
б) java.lang.StringIndexOutOfBoundsException: String index out of range: -1 : StringForSecondThreadTooShortException : 2#
в) RuntimeException : java.lang.StringIndexOutOfBoundsException: String index out of range: -1 : 3#"
 */




/*
Вот несколько моих подсказок и затыков которые пришлось преодолеть:
1) в StringForFirstThreadTooShortException нужно обязательно создать пустой конструктор:
     public StringForFirstThreadTooShortException(Exception e) {
     }
    и переопределять метод getCause с текстом вывода:
   @Override
    public synchronized Throwable getCause() {
        return new StringIndexOutOfBoundsException("string index out of range: -1");
     }
   Это нам потребуется для корректной обработки ошибок и точного вывода по шаблону.
2) Теперь про шаблоны обработки и вывода исключений на экран, у нас их три:
getFormattedStringForFirstThread, getFormattedStringForSecondThread, getFormattedStringForOtherThread

соответственно ретурны вот такие, какой куда разберитесь сами:
String.format(string, e.getClass().getSimpleName(), e.getCause(), t.getName());
String.format(string,t.getName(), e.getClass().getSimpleName(), e.getCause());
String.format(string, e.getCause(), e.getClass().getSimpleName(), t.getName());
С исключениями вроде все понятно.

3) собственно самое главное - метод getPartOfString. Тут важно все решать через try catch, именно по этому в пункте 1)
 мы делали конструктор с параметром (Exception e)!!!
Объявляем новый String (я сразу проинициализировал ее) для той подстроки, которую будем потом возвращать!
Далее саму подстроку в блоке try получаем через substring с индексами первой и последней табуляции , думаю тут и так все
 разобрались и в комментах это писали string.substring(string.indexOf("\t") + 1, string.lastIndexOf("\t")); ну с блоком
  try вроде все понятно и просто.
далее в catch (Exception e) обрабатываем все исключения которые требуются по заданию
ну например: if (threadName.equals(Solution.FIRST_THREAD_NAME)) throw new StringForFirstThreadTooShortException(e);
всего их 3 исключения.

ну как то так...


+40
Leonid
Java Developer в ProgForce
EXPERT
5 мая 2020, 17:11
Оверрайдить public synchronized Throwable getCause() не нужно! Я думаю, что гогда писалось условие, стандартный вывод
 отличался от теперешнего (можно попробовать запустить код на 8й джаве и проверить, но я не заморачивался). Короче,
  решил я ее со второй попытки: 1) вывод соответствует уловию, но есть хардкор. 2) Вывод НЕ соответствует условию,
  использую getCause() 1# : StringForFirstThreadTooShortException : java.lang.StringIndexOutOfBoundsException: begin 0,
  end -1, length 1 -> Bingo!
+2
barracuda
Уровень 41, Санкт-Петербург, Россия
EXPERT
26 мая 2020, 01:28
Спасибо большое за подробный комментарий. До прочтения сам пытался копать в эту сторону, но "не выкопал".
От себя могу лишь добавить, что я не переопределял getCause() в StringForFirstThreadTooShortException и не создавал там
 пустой конструктор.
Просто в классе Solution в методе getPartOfString в блоке catch(Exception e){...} я это исключение e передал в
RuntimeException(e).
А Вы , видимо, передали его сюда:
throw new StringForFirstThreadTooShortException(e);
Я же оставил его пустым:
throw new StringForFirstThreadTooShortException();
 */