package src.java.лямбды_стримы;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Collections;

/*
вывод коллекции через форич лямбдой
 */
public class лямбды {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>();
        Collections.addAll(list,"Hello","By-By","One","Two","three","four");
        list.forEach((x)-> System.out.println(x)); // если разобраться. то  это тот же самый "for each" только сложнее

        // если имеется тольку один параметр, то можно опустить скобки:
         list.forEach(x-> System.out.println(x));
            // или сделать вообще кратко
        list.forEach(System.out::println);//  это уже удобно. ненамного, но все же
        //Подумайте сами: мы хотели для каждого элемента коллекции list выполнять какое-то действие.
        // Если это действие — вызов одной функции (такой как println()),
        // было бы разумно просто передать функцию в метод в качестве параметра.
        //
        //А как объяснить компилятору, что функцию нужно именно передать, а не вызват
        // Для этого перед именем метода ставим не точку, а два двоеточия: одно двоеточие уже занято в тернарном операторе.
        //
        //Это и есть самая простая и компактная запись.
    }
}
/*
вывод коллекции через форич лямбдой
 */
class лямбды2 {
    public static void main(String[] args) {


    }
}/*
вывод коллекции через форич лямбдой
 */
class лямбды3 {
    public static void main(String[] args) {


    }
}/*
вывод коллекции через форич лямбдой
 */
class лямбды4 {
    public static void main(String[] args) {


    }
}/*
вывод коллекции через форич лямбдой
 */
class лямбды5 {
    public static void main(String[] args) {


    }
}/*
вывод коллекции через форич лямбдой
 */
class лямбды6 {
    public static void main(String[] args) {


    }
}