package src.java.File;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Tasks {
}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// ///1. На вход метода main подаются два параметра.
//Первый - path - путь к директории, второй - resultFileAbsolutePath - имя (полный путь) существующего файла, который
// будет содержать результат.
//        2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
//        Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
//        2.1. Отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке.
//        2.2. ПереименоватьresultFileAbsolutePath в 'allFilesContent.txt' (используй метод FileUtils.renameFile, и,
//        если понадобится, FileUtils.isExist).
//        2.3. В allFilesContent.txtпоследовательно записать содержимое всех файлов из п. 2.2.1. После каждого тела
//        файла записать "\n".
//        Все файлы имеют расширение txt.
//        В качестве разделителя пути используй "/".
//        Требования:
//        •
//        Файл, который приходит вторым параметром в main, должен быть переименован в allFilesContent.txt.
//        •
//        Нужно создать поток для записи в переименованный файл.
//        •
//        Содержимое всех файлов, размер которых не превышает 50 байт, должно быть записано в файл allFilesContent.txt
//        в отсортированном по имени файла порядке.
//        •
//        Поток для записи в файл нужно закрыть.
//        •
//        Не используй статические переменные.


/*
Проход по дереву файлов
*/
 class Solution {
    public static void main(String[] args) {
String path="E:/Poly";
String resultFileAbsolutePath;
Path root=Paths.get(path);
        System.out.println(root.getRoot());
//File folder=new File(path);
//        for (File z:folder.listFiles()
//             ) {
//            if(z.isDirectory()){
//                for (File x:z.listFiles()
//                     ) {
//                    System.out.println(x.getName());
//                }
//            }else
//            {
//                System.out.println(z.getName());
//            }
//        }
//
   }
}




 class FileUtils {

    public static void deleteFile(File file) {
        if (!file.delete()) System.out.println("Can not delete file with name " + file.getName());
    }

    public static void renameFile(File source, File destination) {
        if (!source.renameTo(destination)) System.out.println("Can not rename file with name " + source.getName());
    }

    public static boolean isExist(File file) {
        return file.exists();
    }
}
