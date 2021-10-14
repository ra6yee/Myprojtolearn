package src.java.Files;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.io.*;

import java.util.Arrays;

import static java.nio.file.FileVisitResult.SKIP_SUBTREE;


/*
мощный метод для обхода дерева файлов — Files.walkFileTree()

Вот что нам нужно сделать.

Во-первых, нам понадобится FileVisitor. FileVisitor — это специальный интерфейс, в котором описаны все методы для обхода
 дерева файлов.

В частности, мы поместим туда логику считывания содержимого файла и проверки, содержит ли он нужный нам текст.
 */
public class обход_дерева_каталогов extends SimpleFileVisitor<Path> {
ArrayList<Path>list=new ArrayList<>();
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            File file1=file.toFile();
            long size=file1.length();
           long file_Size= Files.size(file);
             if(size<50){
                 list.add(file);

             }
return FileVisitResult.CONTINUE;
    }

    public static void main(String[] args) throws IOException {
        обход_дерева_каталогов ttt= new обход_дерева_каталогов();
        Files.walkFileTree(Paths.get("e:/"),ttt);
        Arrays.sort(new ArrayList[]{ttt.list});
        File reziutFile=new File("e:/one.txt");
        File rezFile=new File("e:/two.txt");
      if ( reziutFile.renameTo(rezFile)){
          System.out.println("переименование прошло успешно");
      } else
          System.out.println("файл не удалось переименовать");
BufferedOutputStream ous=new BufferedOutputStream(new FileOutputStream(rezFile));
        for (Path z:ttt.list
             ) {
            BufferedInputStream bufferedInputStream=new BufferedInputStream(new FileInputStream(z.toFile()));
            while (bufferedInputStream.available()>0){
               // char c= (char) bufferedInputStream.read();
ous.write(bufferedInputStream.read());
            }
           String finish="\r\n";
            byte[] at=finish.getBytes();
            ous.write(at);
bufferedInputStream.close();
            System.out.println(z.getFileName());

        }
    ous.close();
    }
}

//    В классе Solution переопредели логику двух методов:
//        - visitFile кроме своей логики должен добавлять в archived все пути к zip и rar файлам
//        - visitFileFailed должен добавлять в failed все пути к недоступным файлам и возвращать SKIP_SUBTREE
//        Пример вывода:
//        D:/mydir/BCD.zip
//        Метод main не участвует в тестировании
//        Требования:
//        •
//        В классе Solution нужно переопределить метод visitFile.
//        •
//        Метод visitFile, кроме своей логики, должен добавлять в поле archived все пути к zip и rar файлам.
//        •
//        В классе Solution нужно переопределить метод visitFileFailed.
//        •
//        Метод visitFileFailed должен добавлять в поле failed все пути к недоступным файлам и возвращать SKIP_SUBTREE.

/*
Поиск скрытых файлов
*/
class Solution6 extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        String name=file.getFileName().toString();

        if(name.contains("zip")||name.contains("rar")){
            archived.add(file.toString());
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        failed.add(file.toString());
        return SKIP_SUBTREE;
    }

    public static void main(String[] args) throws IOException {
        EnumSet<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
        final Solution6 solution = new Solution6();
        Files.walkFileTree(Paths.get("c:/инфинити"), options, 20, solution);

        List<String> result = solution.getArchived();
        System.out.println("All archived files:");
        for (String path : result) {
            System.out.println("\t" + path);
        }

        List<String> failed = solution.getFailed();
        System.out.println("All failed files:");
        for (String path : failed) {
            System.out.println("\t" + path);
        }
    }

    private List<String> archived = new ArrayList<>();
    private List<String> failed = new ArrayList<>();

    public List<String> getArchived() {
        return archived;
    }

    public List<String> getFailed() {
        return failed;
    }


}
















