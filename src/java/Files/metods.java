package src.java.Files;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.List;
public class metods {
}
//    Реализуй логику методов:
//        1. readBytes - должен возвращать все байты файла fileName.
//        2. readLines - должен возвращать все строки файла fileName. Используй кодировку по умолчанию.
//        3. writeBytes - должен записывать массив bytes в файл fileName.
//        4. copy - должен копировать файл resourceFileName на место destinationFileName.
//        ГЛАВНОЕ УСЛОВИЕ:
//        Никаких других импортов!
//        Требования:
//        •
//        Импорты в классе Solution менять нельзя.
//        •
//        Метод readBytes должен возвращать все байты файла fileName.
//        •
//        Метод readLines должен возвращать все строки файла fileName с кодировкой по умолчанию.
//        •
//        Метод writeBytes должен записывать массив bytes в файл fileName.
//        •
//        Метод copy должен копировать файл resourceFileName на место destinationFileName.

/*
Своя реализация
*/
 class Solution5 {
    public static byte[] readBytes(String fileName) throws IOException {
        byte[]BytesFile=Files.readAllBytes(Paths.get(fileName));
        return BytesFile;
    }

    public static List<String> readLines(String fileName) throws IOException {
        List<String>list=Files.readAllLines(Paths.get(fileName),Charset.defaultCharset());
        return list;
    }

    public static void writeBytes(String fileName, byte[] bytes) throws IOException {
        Files.write(Paths.get(fileName),bytes);
    }

    public static void copy(String resourceFileName, String destinationFileName) throws IOException {
        Files.copy(Paths.get(resourceFileName),Paths.get(destinationFileName), StandardCopyOption.REPLACE_EXISTING);
    }
}
