package синтаксис;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/*
java.util.Comparator и java.lang.Comparable

Как видно, существует такой такой интерфейс.
Класс, который его реализует говорит этим, что "Я реализую функцию сравнения объектов".

Это оператор сравнения, возвращает 1 -1 0 в зависимости от результата сравнения.
Comparator возвращает int по следующей схеме:
отрицательный int (первый объект отрицательный, то есть меньше)
положительный int (первый объект положительный, хороший, то есть больший)
ноль = объекты равны
Теперь напишем компаратор. Нам потребуется импорт java.util.Comparator. После импорта добавим в main метод:

Comparator<Message> comparator = new Comparator<Message>(){
public int compare(Message o1, Message o2) {
    return o1.getId().compareTo(o2.getId());
}
};


Как мы видим из примера, помимо Comparator'а есть ещё один интерфейс — java.lang.Comparable,
 реализуя который мы должны определить метод compareTo. А метод compareTo описывает то,
  каким образом экземпляр класса нужно сравнивать с другими экземплярами.
   Например, строки сравниваются лексиграфически, а числа сравниваются по значению.
  Данный интерфейс говорит, что "Класс, который реализует интерфейс, позволяет сравнивать экземпляры класса".
  Например, у Integer реализация compareTo выглядит следующим образом:

(x < y) ? -1 : ((x == y) ? 0 : 1)



 */
class Message {
    private String message;
    private int id;

    public Message(String message) {
        this.message = message;
        this.id = new Random().nextInt(1000);
    }
    public String getMessage() {
        return message;
    }
    public Integer getId() {
        return id;
    }
    public String toString() {
        return "[" + id + "] " + message;
    }
}

public class compare_Компаратор {
    public static void main(String[] args) {
        Comparator<Message> comparator = new Comparator<Message>(){
            public int compare(Message o1, Message o2) {
                return o1.getId().compareTo(o2.getId());
            }
        };
        List<Message> messages = new ArrayList();
        messages.add(new Message("Hello World"));
        messages.add(new Message("Hello Sun"));
int one=comparator.compare(messages.get(0), messages.get(0));
        System.out.println(one);
    }
}
////////////////////////////////////////////////////////////////////////////
