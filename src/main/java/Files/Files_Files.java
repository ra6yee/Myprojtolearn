package src.java.Files;
/*
Files — это утилитный класс, куда были вынесены статические методы из класса File. Files — это примерно то же, что и
Arrays или Collections, только работает он с файлами, а не с массивами и коллекциями :)

Он сосредоточен на управлении файлами и директориями. Используя статические методы Files, мы можем создавать, удалять и
перемещать файлы и директории.

Для этих операций используются методы createFile() (для директорий — createDirectory()), move() и delete().
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Files_Files {
    public static void main(String[] args) throws IOException {
        Path file=null;
        Path directory=null;
        //создание директории обязательно проверять наличие и файлов и папок, если они уже существуют
        // то выбросится исключение.
      if(!Files.exists(Paths.get("C:\\Users1\\2folder"))) {
          Path testDirectory = Files.createDirectories(Paths.get("C:\\Users1\\2folder"));
          directory=testDirectory;
          System.out.println("Была ли директория успешно создана?");
          System.out.println(Files.exists(Paths.get("C:\\Users1\\2folder")));
      }
        //создание файла
       if (!Files.exists(Paths.get("C:\\Users1\\testFile111.txt"))) {
           Path testFile1 = Files.createFile(Paths.get("C:\\Users1\\testFile111.txt"));
           file=testFile1;
           System.out.println("Был ли файл успешно создан?");
           System.out.println(Files.exists(Paths.get("C:\\Users1\\testFile111.txt")));
       }


        //перемещаем файл с рабочего стола в директорию testDirectory. Перемещать надо с указанием имени файла в папке!
   Path  file1= Files.move(Paths.get("C:/Users1/testFile111.txt"), Paths.get("C:/Users1/2folder/testFile111.txt")); // только так и переместило!!!

        System.out.println("Остался ли наш файл в корне папки?");
        System.out.println(Files.exists(Paths.get("C:\\Users1\\testFile111.txt")));

        System.out.println("Был ли наш файл перемещен в testDirectory?");
        System.out.println(Files.exists(Paths.get("C:\\Users1\\2folder\\testFile111.txt")));

        //удаление файла
    //    Files.delete(testFile1);
        System.out.println("Файл все еще существует?");
        System.out.println(Files.exists(Paths.get("C:\\Users\\Username\\Desktop\\testDirectory\\testFile111.txt")));
    }
}
/*



 */