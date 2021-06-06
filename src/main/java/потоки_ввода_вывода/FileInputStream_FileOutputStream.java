package потоки_ввода_вывода;

import java.io.*;
import java.util.ArrayList;

/*
Для того, чтобы прочитать данные из файла на диске, есть специальный класс FileInputStream, который реализует интерфейс InputStream.
Хочешь записать прочитанные данные в другой файл? Для этого есть класс FileOutputStream, который реализует интерфейс OutputStream.
 */
public class FileInputStream_FileOutputStream {
    public static void main(String[] args) throws IOException
    {      // так выглядит копирование одного файла в другой!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        InputStream inStream = new FileInputStream("c:/source.txt");
        OutputStream outStream = new FileOutputStream("c:/result.txt");

        while (inStream.available() > 0)
        {
            int data = inStream.read(); //читаем один байт из потока для чтения
            outStream.write(data); //записываем прочитанный байт в другой поток.
        }

        inStream.close(); //закрываем потоки
        outStream.close();
    }
}
class MyClass/////представим, что наш класс содержит в себе один объект – ArrayList типа Integer.
{
    private ArrayList<Integer> list;

    //Теперь у нас в классе реализован метод read, который позволяет последовательно вычитать все содержимое нашего списка list.
    //И метод write, который позволяет записывать в наш list значения.
    public void write(int data)
    {
        list.add(data);
    }
    public int read()
    {
        int first = list.get(0);
        list.remove(0);
        return first;
    }

    public int available()
    {
        return list.size();
    }
}      //Это, конечно, не реализация интерфейсов InputStream и OutputStream, но очень похоже.

//— Да, это понятно. А как все-таки сохранить содержимое такого объекта в файл?
class writeFile {//Запись объекта MyClass в файл
    public static void main(String[] args) throws IOException {
        MyClass myObject = new MyClass();
        OutputStream outStream = new FileOutputStream("c:/my-object-data.txt");

        while (myObject.available() > 0) {
            int data = myObject.read(); //читаем один int из потока для чтения
            outStream.write(data); //записываем прочитанный int в другой поток.
        }
        outStream.close();
    }
}
class readFile{//Чтение объекта MyClass из файла
    public static void main(String[] args) throws IOException {
        InputStream inStream = new FileInputStream("c:/my-object-data.txt");
        MyClass myObject = new MyClass();

        while (inStream.available() > 0)
        {
            int data = inStream.read(); //читаем один int из потока для чтения
            myObject.write(data); //записываем прочитанный int в другой поток.
        }

        inStream.close(); //закрываем потоки
    }
}