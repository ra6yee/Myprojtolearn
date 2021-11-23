package src.java.Files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.ATOMIC_MOVE;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/*
сразу в коде покажу.Это новый метод библиотеки Files.Удобно
 */
public class copyFile {
    public static void main(String[] args) throws IOException {



        // create file
      String file_First="c:/one.txt";
        Path fileN=Paths.get(file_First);
        if(!Files.exists(Paths.get(file_First))) {
            Path file = Files.createFile(Paths.get(file_First));
            fileN=file;
            System.out.println("Файл создан? ");
            System.out.println(Files.exists(file));
        }else{
            System.out.println("Файл уже существует");
        }
        // create directory
        String Directory="c:/destiny";
        Path direct=Paths.get(Directory);
          if(!Files.exists(Paths.get(Directory))){
              Path dir=Files.createDirectory(Paths.get(Directory));
              direct=dir;
              System.out.println("Директория создана?");
              System.out.println(Files.exists(dir));

          }    else {
              System.out.println("Директория уже создана");
          }
   Files.copy(fileN.normalize(),Paths.get("c:/destiny/one.txt"));
    }
}
