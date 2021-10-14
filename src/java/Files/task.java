package src.java.Files;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class task {
}


/*
Находим все файлы
Реализовать логику метода getFileTree, который должен в директории root найти список всех файлов включая вложенные.
Используй очередь, рекурсию не используй.
Верни список всех путей к найденным файлам, путь к директориям возвращать не надо.
Путь должен быть абсолютный.
Требования:
•
Метод getFileTree должен принимать аргументом String root, по которому нужно найти все вложенные файлы.
•
Метод getFileTree должен возвращать список строк.
•
Нужно реализовать метод getFileTree: найти все файлы по указанному пути и добавить их в список.
•
Метод getFileTree должен быть вызван только 1 раз (рекурсию не использовать).

*/
class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> pathesFiles = new ArrayList<>();
        Queue<File> listFiles = new ArrayDeque<>();
        listFiles.add(new File(root));
        while (!listFiles.isEmpty()) {
            File current = listFiles.poll();
            File[] fileDirList = current.listFiles();
            if (fileDirList != null) {
                for (File z : fileDirList
                ) {
                    if (z.isDirectory()) {
                        listFiles.offer(z);
                    } else pathesFiles.add(z.getAbsolutePath());
                }
            }
        }
        return pathesFiles;

    }

    public static void main(String[] args) throws IOException {
        List<String> files = getFileTree("c:/инфинити");
        for (String z : files
        ) {
            System.out.println(z);

        }
    }
}


// /Давай реализуем настраиваемый поиск файлов в директории.
//    Просмотри интерфейс java.nio.file.FileVisitor и его базовую реализацию java.nio.file.SimpleFileVisitor.
// Во время поиска по дереву файлов с помощью метода Files.walkFileTree(Path start, FileVisitor<? super Path> visitor)
//        мы используем объект FileVisitor для выполнения необходимых операций над найденными объектами Path.
//        Наш класс для поиска будет называться SearchFileVisitor и расширять SimpleFileVisitor.
//        Поиск можно будет выполнять по таким критериям:
//        - выражение, встречающееся в названии файла (String);
//        - выражение, встречающееся в содержимом файла (String);
//        - максимальный и минимальный размер файла (int).
//        Можно задавать либо один, либо сразу несколько критериев для поиска.
//        Я в main написал код, который использует готовый SearchFileVisitor для поиска файлов, тебе осталась совсем
//        легкая задача - выполнить его реализацию.
//        Подсказка 1: методы get... , set... - это геттеры и сеттеры полей. Основная логика класса по поиску
//        выполняется в методе visitFile(Path file, BasicFileAttributes attrs).
//        Подсказка 2: для работы с файлами используй только классы из пакета java.nio.
//        Требования:
//        •
//        В классе SearchFileVisitor нужно создать поля partOfName, partOfContent, minSize, maxSize и сеттеры для них.
//        •
//        В классе SearchFileVisitor нужно создать поле foundFiles и геттер для него. Поле должно быть сразу инициализировано.
//        •
//        Если в SearchFileVisitor задан критерий поиска partOfName, метод visitFile должен добавить файл в foundFiles,
//        если в названии содержится строка partOfName.
//        •
//        Если в SearchFileVisitor задан критерий поиска partOfContent, метод visitFile должен добавить файл в
//        foundFiles, если в содержимом встречается строка partOfContent.
//        •
//        Если в SearchFileVisitor задан критерий поиска maxSize, метод visitFile должен добавить файл в foundFiles,
//        если размер файла меньше maxSize.
//        •
//        Если в SearchFileVisitor задан критерий поиска minSize, метод visitFile должен добавить файл в foundFiles,
//        если размер файла больше minSize.
//        •
//        Метод visitFile должен быть реализован так, чтобы учитывать сразу несколько критериев поиска.


/*
Продвинутый поиск файлов
*/
class Solution1 {

    public static void main(String[] args) throws IOException {
        SearchFileVisitor searchFileVisitor = new SearchFileVisitor();

        //searchFileVisitor.setPartOfName("amigo");
        searchFileVisitor.setPartOfContent("programmer");
        //  searchFileVisitor.setMinSize(500);
        // searchFileVisitor.setMaxSize(10000);

        Files.walkFileTree(Paths.get("c:/SecretFolder"), searchFileVisitor);

        List<Path> foundFiles = searchFileVisitor.getFoundFiles();

        if (foundFiles.size() != 0) {
            for (Path file : foundFiles) {
                System.out.println(file);
            }
        }
    }

}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// //////////////////////////package com.javarush.task.task31.task3111;


class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String PartOfName = null;
    private String PartOfContent = null;
    private int MinSize = 0;
    private int MaxSize = 0;
    private List<Path> foundFiles = new ArrayList<>();

    public String getPartOfName() {
        return PartOfName;
    }

    public void setPartOfName(String partOfName) {
        PartOfName = partOfName;
    }

    public String getPartOfContent() {
        return PartOfContent;
    }

    public void setPartOfContent(String partOfContent) {
        PartOfContent = partOfContent;
    }

    public int getMinSize() {
        return MinSize;
    }

    public void setMinSize(int minSize) {
        MinSize = minSize;
    }

    public int getMaxSize() {
        return MaxSize;
    }

    public void setMaxSize(int maxSize) {
        MaxSize = maxSize;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    public void setFoundfiles(List<Path> foundfiles) {
        this.foundFiles = foundfiles;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        String nameOffile = String.valueOf(file.getFileName());

        if (PartOfName != null) {
            if (nameOffile.contains(PartOfName)) {
                System.out.println(true);
                foundFiles.add(file);
            }
        }
        // List<String> text= Files.readAllLines(file);
        if (PartOfContent != null) {
            if (new String(content).contains(PartOfContent))

                foundFiles.add(file);
        }

        if (MinSize != 0 && MaxSize == 0) {
            if (content.length >= MinSize) {
                foundFiles.add(file);
            }
        }

        if (MinSize == 0 && MaxSize != 0) {
            if (content.length <= MaxSize) {
                foundFiles.add(file);
            }
        }

        if (MinSize != 0 && MaxSize != 0) {
            if (content.length <= MaxSize && content.length >= MinSize) {
                foundFiles.add(file);
            }
        }


        return FileVisitResult.CONTINUE;
    }
}

