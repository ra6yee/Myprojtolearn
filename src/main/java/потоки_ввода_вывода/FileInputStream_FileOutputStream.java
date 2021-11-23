package src.java.потоки_ввода_вывода;

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
//— А как будет выглядеть код копирования файла, если мы будем читать не по одному байту, а целыми блоками?
//
//— Гм. Примерно так:

class Reading{
    public static void main(String[] args) throws Exception
    {
        //Создаем поток-чтения-байт-из-файла
        FileInputStream inputStream = new FileInputStream("c:/data.txt");
        // Создаем поток-записи-байт-в-файл
        FileOutputStream outputStream = new FileOutputStream("c:/result.txt");

        byte[] buffer = new byte[1000];
        while (inputStream.available() > 0) //пока есть еще непрочитанные байты
        {
            // прочитать очередной блок байт в переменную buffer и реальное количество в count
            int count = inputStream.read(buffer);
            outputStream.write(buffer, 0, count); //записать блок(часть блока) во второй поток
        }

        inputStream.close(); //закрываем оба потока. Они больше не нужны.
        outputStream.close();
    }
}
/*
— С буфером все понятно, а что это за переменная count?

— Когда мы читаем самый последний блок данных в файле, может оказаться, что байт осталось не 1000, а, скажем, 328.
Тогда и при записи нужно указать, что записать не весь блок, а только его первые 328 байт.

Метод read при чтении последнего блока вернет значение равное количеству реально прочитанных байт.
Для всех чтений – 1000, а для последнего блока – 328.

Поэтому при записи блока мы указываем, что нужно записать не все байты из буфера, а только 328 (т.е. значение,
хранимое в переменной count).
 */






