package src.java.потоки_ввода_вывода.RandomAccessFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.EnumSet;

/*
 метод main приходят три параметра:
1) fileName - путь к файлу;
2) number - число, позиция в файле;
3) text - текст.
Записать text в файл fileName начиная с позиции number.
Запись должна производиться поверх старых данных, содержащихся в файле.
Если файл слишком короткий, то записать в конец файла.
Используй RandomAccessFile и его методы seek и write.
Требования:
•
В методе main класса Solution необходимо использовать RandomAccessFile.
•
В методе main класса Solution программа должна записывать данные в файл при помощи метода write класса RandomAccessFile.
•
Запись в файл должна происходить с указанной позиции с заменой содержимого.
•
Если файл слишком короткий, то запись text должна происходить в конец файла.

 */
public class solution {
    public static void main(String[] args) throws IOException {
        Path file = Paths.get("c:/text.txt");
        long num = 100;
        String text = "Hello World!!!";
        writeToFile(file, num, text);
    }

    public static void writeToFile(Path file, long number, String text) throws IOException {
        String filePath = file.toAbsolutePath().toString();
        RandomAccessFile raf = new RandomAccessFile(filePath, "rw");
        long lenFile = raf.length();
        if (lenFile < number) {

        }

        raf.seek(number);
        raf.writeBytes(text);
    }
}


//    В метод main приходят три параметра:
//        1) fileName - путь к файлу;
//        2) number - число, позиция в файле;
//        3) text - текст.
//        Считать текст с файла начиная с позиции number, длинной такой же как и длинна переданного текста в третьем параметре.
//        Если считанный текст такой же как и text, то записать в конец файла строку 'true', иначе записать 'false'.
//        Используй RandomAccessFile и его методы seek(long pos), read(byte[] b, int off, int len), write(byte[] b).
//        Используй один из конструкторов класса String для конвертации считанной строчки в текст.
//        Требования:
//        •
//        В методе main класса Solution необходимо использовать RandomAccessFile, который должен использовать файл,
//        который приходит первым параметром.
//        •
//        В методе main класса Solution программа должна устанавливать позицию в файле, которая передана во втором параметре.
//        •
//        В методе main класса Solution программа должна считывать данные с файла при помощи метода read(byte[] b, int off, int len).
//        •
//        Запись должна происходить в конец файла.
//        •
//        Если считанный текст такой же как и text, то программа должна записать в конец переданного файла строку 'true'.
//        •
//        Если считанный текст НЕ такой же как и text, то программа должна записать в конец переданного файла строку 'false'.

/*
Используем RandomAccessFile
*/

class Solution1 {
    public static void main(String... args) throws IOException {
        Path file = Paths.get("c:/text.txt");
        long number = 5;
        String text = "Hello World";
        fileOperation(file, number, text);
    }

    public static void fileOperation(Path file, long number, String text) throws IOException {
        String filePath = file.toAbsolutePath().toString();
        RandomAccessFile raf1 = new RandomAccessFile(filePath, "rw");
        long sizefile=raf1.length();
        int sizeText=text.length();

          byte[] textfile=new byte[5];
        raf1.seek(number);
        raf1.read(textfile,0,5);
String finish=new String(textfile);
        byte[]textToFind=text.getBytes();
        if(text.equals(finish)){
            raf1.seek(sizefile);
            raf1.writeBytes("true");
        }else{
            raf1.seek(sizefile);
            raf1.writeBytes("false");
        }
    }
}
