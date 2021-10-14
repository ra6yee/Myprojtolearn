package src.java.Files;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class сведения_директория {
}
// Напиши программу, которая будет считать подробную информацию о папке и выводить ее на консоль.
//    Первым делом считай путь к папке с консоли.
//        Если введенный путь не является директорией - выведи "[полный путь] - не папка" и заверши работу.
//        Затем посчитай и выведи следующую информацию:
//        Всего папок - [количество папок в директории и поддиректориях]
//        Всего файлов - [количество файлов в директории и поддиректориях]
//        Общий размер - [общее количество байт, которое хранится в директории]
//        Используй только классы и методы из пакета java.nio.
//        Квадратные скобки [ ] выводить на экран не нужно.
//        Требования:
//        •
//        Метод main должен считывать путь к папке с консоли.
//        •
//        Если введенный путь не является директорией - нужно вывести "[полный путь] - не папка" и завершить работу.
//        •
//        Используй только классы и методы из пакета java.nio.
//        •
//        На консоль должна быть выведена следующая информация: "Всего папок - [количество папок в директории и поддиректориях]".
//        •
//        На консоль должна быть выведена следующая информация: "Всего файлов - [количество файлов в директории и поддиректориях]".
//        •
//        На консоль должна быть выведена следующая информация: "Общий размер - [общее количество байт, которое хранится в директории]".





/*
Что внутри папки?
*/
class Solution3 {

    public static void main(String[] args) throws IOException {
    countFiles cf=new countFiles();

        Path dir= Paths.get("C:/Users1");

        if(!Files.isDirectory(dir)){
            System.out.println(dir.toFile().getCanonicalPath()+" не папка");
            System.exit(22);
        }else{
            System.out.println(dir.toFile().getCanonicalPath()+" это папка");
        }
   Files.walkFileTree(dir,cf);
        System.out.println("Всего папок-"+cf.getCountDir());
        System.out.println("Всего файлов-"+cf.getCountFiles());
        System.out.println("Всего байт-"+cf.getTotalSizeFiles());
    }
}
class  countFiles implements FileVisitor<Path> {
    private long countDir=-1;
    private long totalSizeFiles=0;
    private long countFiles=0;

    public long getCountDir() {
        return countDir;
    }

    public long getTotalSizeFiles() {
        return totalSizeFiles;
    }

    public long getCountFiles() {
        return countFiles;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        countDir++;
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        totalSizeFiles+=attrs.size();
        countFiles++;
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }
}