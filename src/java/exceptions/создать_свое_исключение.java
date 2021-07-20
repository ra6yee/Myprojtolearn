package src.java.exceptions;
//чтобы создать свое исключение, необходимо создать класс этого исключения и унаследовать его от класса Exception
// а в конструкторе этого класса необходимо передать сообщение в родительский класс.Сообщение об ошибке.
// Для генерации исключения в методе  выбрасывается исключение с помощью оператора
//на примере исключения FactorialException
// throw: throw new FactorialException("Число не может быть меньше 1", num).
// Кроме того, так как это исключение не обрабатывается с помощью try..catch, то мы передаем обработку вызывающему методу,
// используя оператор throws: public static int getFactorial(int num) throws FactorialException
public class создать_свое_исключение {
    public static void main(String[] args)  {
        //int a=1;
String a="dfd3sf";
reviewData(a);
    }
static void reviewData(String a) {
boolean digit=a.matches(".*\\d+.*");
        if ( digit==true){
            try {
                throw new Exec_text();
            } catch (Exec_text exec_text) {
               // exec_text.printStackTrace();
                System.out.println( exec_text.toString());
                System.exit(0);
            }

        }
    }

    static class Exec_text extends Exception {
        // переопределим метод toString;
        public String toString() {
            return "Ошибка данных, это не стринг";
        }
    }
}
class Solution21 {
    public static String getPartOfString(String string) {
        if (string.equals("")){
            try {
                throw new TooShortStringException();
            } catch (TooShortStringException e) {
                System.out.println("Нулевая длина строки");
                System.exit(02);

            }
        }


        int startfirstEnter=string.indexOf("\t");
        // System.out.println(startfirstEnter);
        int finishSecondEnter=string.indexOf("\t",startfirstEnter+1);

        if(startfirstEnter==-1||finishSecondEnter==-1){
            try {
                throw new TooShortStringException();
            } catch (TooShortStringException e) {
                System.out.println(e.toString());
                System.exit(11);
            }
        }
        // System.out.println(finishSecondEnter);
        String outString=string.substring(startfirstEnter+1,finishSecondEnter);
        return outString;
    }

    public static class TooShortStringException extends Exception {
        @Override
        public String toString() {
            return "полученая строка, не соответствует заданной";
        }
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
        // System.out.println(getPartOfString("\tJavaRush - лучший сервис обучения Java."));
        // System.out.println(getPartOfString(""));
    }
}
