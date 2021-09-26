package src.java.Files;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/*
мощный метод для обхода дерева файлов — Files.walkFileTree()

Вот что нам нужно сделать.

Во-первых, нам понадобится FileVisitor. FileVisitor — это специальный интерфейс, в котором описаны все методы для обхода
 дерева файлов.

В частности, мы поместим туда логику считывания содержимого файла и проверки, содержит ли он нужный нам текст.
 */
public class обход_дерева_каталогов extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
           // File file1=file.toFile();
           long file_Size= Files.size(file);
             if(file_Size>)
return FileVisitResult.CONTINUE;
    }

    public static void main(String[] args) {
        
    }
}
