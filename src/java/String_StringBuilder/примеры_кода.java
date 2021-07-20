package src.java.String_StringBuilder;

public class примеры_кода {
}
/*
Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример:
"JavaRush - лучший сервис обучения Java."
Результат:
"- лучший сервис обучения"
Пример:
"Амиго и Диего лучшие друзья!"
Результат:
"и Диего лучшие друзья!"
На некорректные данные бросить исключение TooShortStringException(сделать исключением).
Требования:
•
Класс TooShortStringException должен быть потомком класса RuntimeException.
•
Метод getPartOfString должен принимать строку в качестве параметра.
•
В случае, если в метод getPartOfString были переданы некорректные данные, должно возникнуть исключение TooShortStringException.
•
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова, которое следует после 4-го пробела.

*/
 class Найти_подстроку {
    public static void main(String[] args) {
        System.out.println(getPartOfString( " JavaRush - Java. "));
    }

    public static String getPartOfString(String string) {
        String finish="";
        String []begin =string.split(" ");
        if(begin.length<5||string.equals(null)){

            try {
                throw new TooShortStringException();
            } catch (TooShortStringException e) {
               // e.printStackTrace();
                System.out.println(e.toString());
            }
            finally {
                System.exit(0);
            }
        }
     //   StringBuilder finish=begin[1]+" "+
        for (int i = 1; i <5 ; i++) {
             finish=finish+begin[i]+" ";
        }
        finish.trim();


//        for (String z:begin
//             ) {
//            System.out.println(z);      это проверка того что пришло в массив
//
//        }
        return finish;
    }

    public static class TooShortStringException extends Exception {
        public  String toString(){

            return"Данный ввода неверны.Недостаточная длина строки";

        }

    }
}

/*
Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
Требования:
•
Класс TooShortStringException должен быть потомком класса Exception.
•
Метод getPartOfString должен принимать строку в качестве параметра.
•
В случае, если строка, переданная в метод getPartOfString содержит менее 2 табуляций должно возникнуть исключение TooShortStringException.
•
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
использую методы класса String

*/
class Solution2 {
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

    public static void main(String[] args)  {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
       // System.out.println(getPartOfString("\tJavaRush - лучший сервис обучения Java."));
        // System.out.println(getPartOfString(""));
    }
}
