package src.java.StringReader_Writer;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import java.io.*;

public class sol {
}
//    Реализуй логику метода getStackTrace, который в виде одной строки (одного объекта типа String)
//        должен возвращать весь стек-трейс переданного исключения.
//        Используй подходящий метод класса Throwable, который поможет записать стек-трейс в StringWriter.
//        Метод main не участвует в тестировании.
//        Требования:
//        •
//        Публичный статический метод String getStackTrace (Throwable) должен существовать.
//        •
//        В методе getStackTrace необходимо создать объект типа StringWriter.
//        •
//        В методе getStackTrace (Throwable) необходимо использовать метод класса Throwable, который принимает объект типа PrintWriter.
//        •
//        Метод getStackTrace (Throwable) должен возвращать весь стек-трейс переданного исключения.


/*
Пишем стек-трейс
*/
 class Solution {
    public static void main(String[] args) {
        String text = getStackTrace(new IndexOutOfBoundsException("fff"));
        System.out.println(text);
    }

    public static String getStackTrace(Throwable throwable) {
        StringWriter sw=new StringWriter();
        PrintWriter pw=new PrintWriter(sw);
      //  sw.write(printStackTrace(throwable));
        throwable.printStackTrace(pw);//пиздец... И зачем я это делал????? Идиотская залача
        return sw.toString();
    }
}

//    Реализуй логику метода getAllDataFromInputStream. Он должен вернуть StringWriter, содержащий все данные из
//    переданного потока.
//        Возвращаемый объект ни при каких условиях не должен быть null.
//        Метод main не участвует в тестировании.
//        Требования:
//        •
//        Публичный статический метод getAllDataFromInputStream (InputStream) должен существовать.
//        •
//        Метод getAllDataFromInputStream (InputStream) должен возвращать StringWriter.
//        •
//        Метод getAllDataFromInputStream (InputStream) должен вернуть StringWriter, который содержит все данные из
//        переданного потока.
//        •
//        Возвращаемый объект ни при каких условиях не должен быть null.


/*
Читаем из потока
*/
class Solution1 {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("c:/testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter sw=new StringWriter();
        char z;
        while(is.available()>0){
            z= (char) is.read();// а вот этот код уже интересен, может где-нибудь и пригодиться.
            sw.write(z);
        }
        return sw;
    }
}


//        Для тебя не составит труда реализовать шифр Цезаря, напомню что это просто сдвиг вправо по алфавиту на key букв.
//        В методе main есть хороший пример.
//        Реализуй логику метода String decode(StringReader reader, int key).
//        Метод получает данные в закодированном виде.
//        Он должен вернуть дешифрованную строку, что хранится в StringReader - е.
//        Возвращаемый объект ни при каких условиях не должен быть null.
//        Метод main не участвует в тестировании.
//        Требования:
//        •
//        Класс Solution должен содержать метод String decode(StringReader reader, int key).
//        •
//        Метод decode(StringReader reader, int key) должен вернуть дешифрованную строку что хранится в StringReader - е.
//        •
//        Возвращаемый объект ни при каких условиях не должен быть null.
//

/*
Шифр Цезаря
*/

 class Solution2 {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0
    }

    public static String decode(StringReader reader, int key) throws IOException {
StringWriter sw=new StringWriter();
BufferedReader bf=new BufferedReader(reader);
int i;
while( (i=bf.read())!=-1){
            int z=i+key;

            sw.write((char)z);
        }
        bf.close();
        return sw.toString();
    }
}
