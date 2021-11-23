package src.java.Regular_Ex;
//примеры использования регулярных выражений.С описанияем и комментариями

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.sql.SQLOutput;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class code_Examples {
    public static void main(String[] args) {
//первое.создаем паттерн, который и задает шаблон поиска
        Pattern pattern = Pattern.compile("s");//поиск буквы s в тексте
        Matcher matcher = pattern.matcher("sdfsdfsflllieoiweriwer");
        System.out.println(matcher.find());
        // далее выводим самое первое совпадение
        matcher.find();// находит первое совпадение и хранит его
        String s = matcher.group(); //сохраняем в переменную первое совпадение.Но при этом оно остается в матчере
        System.out.println(s);
        // посмотрим на второе совпадение
        //matcher.reset();//это сброс матчера и он начнет читать  по новой
        matcher.find();
        String a = matcher.group();
        System.out.println(a);

    }
}

// как сверить в булл, наличие в строке нужной информации:
class codeString {
    public static void main(String[] args) {
        String s = "sdfsdfsdfsdfsdfsdf";
        s.matches("");// это основной шаблон, выдает либо true либо false;
        if (s.matches("\\w+") == true) {// тут если вся строка совпадет, то выдаст тру, а не подстрока
            System.out.println("Ok! This String contains necessary information");
        }
    }
}

//Должен возвращать подстроку между первой и второй табуляцией.
class tabToTab {
    public static void main(String[] args) {
        String s = "\tJavaRush - лучший сервис \tобучения Java\t.";
        Pattern pattern = Pattern.compile("\\t.*?\\t");
        Matcher matcher = pattern.matcher(s);
        matcher.find();
        System.out.println(s.substring(matcher.start(), matcher.end()));
        System.out.println(matcher.group());


    }
}