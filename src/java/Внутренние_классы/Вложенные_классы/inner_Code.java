package src.java.Внутренние_классы.Вложенные_классы;
import java.text.ChoiceFormat;
import java.text.Format;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Comparator;
import java.lang.*;
public class inner_Code {
}
/*
Как выбрать нужное?
В методе main присвой объекту Object obj экземпляр класса TEST.
Не изменяй ничего кроме метода main.
Требования:
• В классе Solution должно существовать поле TEST.
• В классе Solution должен существовать класс TEST.
• В классе Solution должно существовать поле obj.
• В методе main в поле obj должен быть сохранен объект типа TEST(экземпляр класса TEST).

*/
 class Solution4 {
    public static final String TEST = "test";

    public static class TEST {
        @Override
        public String toString() {
            return "test class";
        }
    }

    static Object obj;

    public static void main(String[] args) {
        obj =new TEST();
        System.out.println(obj.toString());
        System.out.println(new Solution4().toString());
    }
}

/*
Рефакторинг, вложенные классы
Отрефакторите класс Solution: вынесите все константы в public вложенный(nested) класс Constants.
Запретите наследоваться от Constants.
Требования:
• В классе Solution должен быть создан класс Constants содержащий строковые константы.
• Класс Constants должен быть публичным.
• Класс Constants должен быть объявлен с модификатором, запрещающим наследование от этого класса.
• В классе Constants должна существовать константа SERVER_IS_CURRENTLY_NOT_ACCESSIBLE со значением "The server is not currently accessible.".
• В классе Constants должна существовать константа USER_IS_NOT_AUTHORIZED со значением "The user is not authorized.".
• В классе Constants должна существовать константа USER_IS_BANNED со значением "The user is banned.".

*/
class Solution5 {
   final static class Constants{
     static final  String  SERVER_IS_CURRENTLY_NOT_ACCESSIBLE= "The server is not currently accessible.";
    static final String  USER_IS_NOT_AUTHORIZED="The user is not authorized.";
    static final String  USER_IS_BANNED="The user is banned.";
    static final String  ACCESS_IS_DENIED="Access is denied.";

    }
    public class ServerNotAccessibleException extends Exception {
        public ServerNotAccessibleException() {
            super(Constants.SERVER_IS_CURRENTLY_NOT_ACCESSIBLE);
        }
        public ServerNotAccessibleException(Throwable cause) {
            super(Constants.SERVER_IS_CURRENTLY_NOT_ACCESSIBLE, cause);
        }
    }
    public class UnauthorizedUserException extends Exception {
        public UnauthorizedUserException() {
            super(Constants.USER_IS_NOT_AUTHORIZED);
        }
        public UnauthorizedUserException(Throwable cause) {
            super(Constants.USER_IS_NOT_AUTHORIZED, cause);
        }
    }
    public class BannedUserException extends Exception {
        public BannedUserException() {
            super(Constants.USER_IS_BANNED);
        }
        public BannedUserException(Throwable cause) {
            super(Constants.USER_IS_BANNED, cause);
        }
    }
    public class RestrictionException extends Exception {
        public RestrictionException() {
            super(Constants.ACCESS_IS_DENIED);

        }

        public RestrictionException(Throwable cause) {
            super(Constants.ACCESS_IS_DENIED, cause);
        }
    }
    public static void main(String[] args) {
    }
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// анонимные иннерклассы
/*
Вспомним наследование
Исправить наследование во всех классах, чтобы вывод метода main был CCBAYS.
Требования:
•
Вывод на экран должен соответствовать условию задачи.
•
Класс C должен поддерживать интерфейс JustAnInterface.
•
Класс B должен быть потомком класса C.
•
Класс Solution должен быть потомком класса C.

*/
 class Solution311 extends C {
    private class A {
        protected String value = "A";//6

        public A() {//5
            System.out.print(value);//7
        }
    }

    private A a = new A() {//4
        { //у анонимных классов нет своих конструкторов, но что-то можно сделать в блоке инициализации класса
            value = "Y";//8
            if (super.getClass().getName().contains(".Solution311$")) {
                System.out.print(value);
            }
        }
    };

    public Solution311() {//2
        System.out.print("S");
    }

    public static void main(String[] args) {
        new Solution311();//1
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


 class C implements JustAnInterface {
    public C() {//3
        System.out.print("C");
        B localB = B;
    }
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////package com.javarush.task.task24.task2411;

 interface JustAnInterface {
    public static final B B = new B();

    class B extends C{
        public B() {
            System.out.print("B");
        }
    }
}
/*
Читаю комментарии и вижу, что ни у кого не возникло такого же вопроса, как у меня. Либо для остальных это элементарно,
 либо они просто не обратили внимание. Но для тех, кто не понял не всю эту тему с порядком создания классов и
 суперклассов (как по мне, это было не трудно), а вот это:

1. ЗАЧЕМ ТУТ ВООБЩЕ НУЖНО ПИСАТЬ В КОНСТРУКТОРЕ КЛАССА С "B localB = B;"
2. Почему это не вечный цикл?

Ответ:
1. Поле интерфейса инициализируется при первом обращении к нему (вернее, это один из тригеров, который может привести к
его инициализации). То есть, без этой строчки поле B b останется пустым, а значит, не будет создан объект класса B и не
 будет нужного вывода в консоль

2. Все поля интерфейсов являются по умолчанию public static final (это даже подписали зачем-то, хотя не нужно. Но
видимо, чтобы не забыли). Почему мы не получаем вечный цикл с родителем С: "создать объект класса С, создать объект
класса B, но сначала создать объект класса С, создать объект класса B, но сначала С, В, С, В.."? Все элементарно, это
поле - static final, оно может быть инициализировано только один раз и является общим для всего интерфейса,
а значит, второй раз при создании объекта класса С, объект класса В создан не будет, а просто возьмется из поля B b
 */



/*
Знания - сила!
1. В методе sort написать компаратор для Stock:
1.1. Первичная сортировка по name в алфавитном порядке
1.2. Вторичная сортировка по дате без учета часов, минут, секунд (сверху самые новые), потом по прибыли от положительных к отрицательным
... open 125,64 and last 126,74 - тут прибыль= 126,74-125,64
... open 125,64 and last 123,43 - тут прибыль= 123,43-125,64
2. Разобраться с *Format-ами и исправить IllegalArgumentException.
Подсказка - это одна строчка.
Пример вывода:
Fake Apple Inc. AAPL | 17-11-2025 open 125,64 and last 123,43
Fake Applied Materials, Inc. AMAT | 15-01-1983 change 0,26
Требования:
•
Во время работы программы не должны возникать исключения.
•
Программа должна выводить данные на экран.
•
Метод sort должен корректно сортировать полученный список в соответствии с условием задачи.
•
Класс Solution.Stock должен быть публичным.

небольшая добавка про сортировку в блоке
public int compare(Stock stock1, Stock stock2)

String str1 = (String) stock1.get("name"); // обязательно указываем (String) так как без этого передается Object
String str2 = (String) stock2.get("name");
 int i = str1.compareTo(str2);  // сортируем по алфавиту в порядке от A до Z, для обратного порядка нужно менять местами str2 и str1
//соответственно метод .compareTo присваивает переменной i значение (-1) если меньше, (0) если равно, (1) если больше, тут думаю понятно.
 if (i != 0) return i; // если значения по полю name при сравнении оказались не равными то сортировка закончилась и можно return i
                            // соответсвенно если i == 0 то тогда надо сортировать по следующему параметру date, логика аналогичная
                           // если и при сравнении по date , i==0 то следующий параметр но там есть вариация...
*/
class Solution33 {
    public static void main(String[] args) {
        List<Stock> stocks = getStocks();
        sort(stocks);
        Date actualDate = new Date();
        printStocks(stocks, actualDate);
    }

    public static void printStocks(List<Stock> stocks, Date actualDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        double[] filelimits = {0d, actualDate.getTime()};
        String[] filepart = {"change {4}", "open {2} and last {3}"};

        ChoiceFormat fileform = new ChoiceFormat(filelimits, filepart);
        Format[] testFormats = {null,null, dateFormat, fileform};
        MessageFormat pattform = new MessageFormat("{0}   {1} | {5} {6}");
        pattform.setFormats(testFormats);

        for (Stock stock : stocks) {
            String name = ((String) stock.get("name"));
            String symbol = (String) stock.get("symbol");
            double open = !stock.containsKey("open") ? 0 : ((double) stock.get("open"));
            double last = !stock.containsKey("last") ? 0 : ((double) stock.get("last"));
            double change = !stock.containsKey("change") ? 0 : ((double) stock.get("change"));
            Date date = (Date) stock.get("date");
            Object[] testArgs = {name, symbol, open, last, change, date, date.getTime()};
            System.out.println(pattform.format(testArgs));
        }
    }
//в общем, как оказалось, необходимо проводить три сортировки, но мы переходим к каждой из них,Ю итолько тогда, когда
    // более ранняя сортировка дает совпадение, тоесть, например, мы сортируем по имени  и полявились  два одинаковых
// имени, вот только тогда мы переходим ко второй сортировке.Все просто и элементарно тогда получается.Глупое описание
// тех задания.
    public static void sort(List<Stock> list) {
        list.sort(new Comparator<Stock>() {
            public int compare(Stock stock1, Stock stock2) {
               int i=((String)stock1.get("name")).compareTo((String)stock2.get("name"));
               if(i==0){
               int ii=((Date)stock1.get("date")).compareTo((Date)stock2.get("date"));
               if(ii==0){

               }
               }
             //  ((Double)stock1.get("last")-(Double)stock1.get("open")).compareTo((Double)stock2.get("last")-(Double)stock2.get("open"));

                return ((String)stock1.get("name")).compareTo((String)stock2.get("name"));
            }
        });
    }

    public static class Stock extends HashMap<String, Object>  {
        public Stock(String name, String symbol, double open, double last) {
            put("name", name);
            put("symbol", symbol);
            put("open", open);
            put("last", last);
            put("date", getRandomDate(2020));
        }

        public Stock(String name, String symbol, double change, Date date) {
            put("name", name);
            put("symbol", symbol);
            put("date", date);
            put("change", change);
        }
    }

    public static List<Stock> getStocks() {
        List<Stock> stocks = new ArrayList<>();

        stocks.add(new Stock("Fake Apple Inc.", "AAPL", 125.64, 123.43));
        stocks.add(new Stock("Fake Cisco Systems, Inc.", "CSCO", 25.84, 26.3));
        stocks.add(new Stock("Fake Google Inc.", "GOOG", 516.2, 512.6));
        stocks.add(new Stock("Fake Intel Corporation", "INTC", 21.36, 21.53));
        stocks.add(new Stock("Fake Level 3 Communications, Inc.", "LVLT", 5.55, 5.54));
        stocks.add(new Stock("Fake Microsoft Corporation", "MSFT", 29.56, 29.72));

        stocks.add(new Stock("Fake Nokia Corporation (ADR)", "NOK", .1, getRandomDate()));
        stocks.add(new Stock("Fake Oracle Corporation", "ORCL", .15, getRandomDate()));
        stocks.add(new Stock("Fake Starbucks Corporation", "SBUX", .03, getRandomDate()));
        stocks.add(new Stock("Fake Yahoo! Inc.", "YHOO", .32, getRandomDate()));
        stocks.add(new Stock("Fake Applied Materials, Inc.", "AMAT", .26, getRandomDate()));
        stocks.add(new Stock("Fake Comcast Corporation", "CMCSA", .5, getRandomDate()));
        stocks.add(new Stock("Fake Sirius Satellite", "SIRI", -.03, getRandomDate()));

        return stocks;
    }

    public static Date getRandomDate() {
        return getRandomDate(1970);
    }

    public static Date getRandomDate(int startYear) {
        int year = startYear + (int) (Math.random() * 30);
        int month = (int) (Math.random() * 12);
        int day = (int) (Math.random() * 28);
        GregorianCalendar calendar = new GregorianCalendar(year, month, day);
        return calendar.getTime();
    }
}




























