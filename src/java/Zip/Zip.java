package src.java.Zip;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Map;
import java.util.TreeMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Zip {
//    // создаем архив
//    FileOutputStream zipFile = new FileOutputStream("c:/archive.zip");
//    ZipOutputStream zip = new ZipOutputStream(zipFile);
//
////кладем в него ZipEntry – «архивный объект»
//zip.putNextEntry(new ZipEntry("document.txt"));
//
//    //копируем файл «document-for-archive.txt» в архив под именем «document.txt»
//    File file = new File("c:/document-for-archive.txt");
//
//    public Zip() throws FileNotFoundException {
//    }
//Files.copy(file.toPath(), zip);
//
//// закрываем архив
//zip.close();
}
//    В метод main приходит список аргументов.
//        Первый аргумент - имя результирующего файла resultFileName, остальные аргументы - имена файлов fileNamePart.
//        Каждый файл (fileNamePart) - это кусочек zip архива. Нужно разархивировать целый файл, собрав его из кусочков.
//        Записать разархивированный файл в resultFileName.
//        Архив внутри может содержать файл большой длины, например, 50Mb.
//        Внутри архива может содержаться файл с любым именем.
//        Пример входных данных. Внутри архива находится один файл с именем abc.mp3:
//        C:/result.mp3
//        C:/pathToTest/test.zip.003
//        C:/pathToTest/test.zip.001
//        C:/pathToTest/test.zip.004
//        C:/pathToTest/test.zip.002
//        Требования:
//        •
//        В методе main нужно создать ZipInputStream для архива, собранного из кусочков файлов. Файлы приходят
//        аргументами в main, начиная со второго.
//        •
//        Создай поток для записи в файл, который приходит первым аргументом в main. Запиши туда содержимое файла из архива.
//        •
//        Поток для чтения из архива должен быть закрыт.
//        •
//        Поток для записи в файл должен быть закрыт.

/*
Разархивируем файл
*/
 class Solution {
    public static void main(String[] args) {
    }
}
//В метод main приходит список аргументов.
//    Первый аргумент - полный путь к файлу fileName.
//        Второй аргумент - путь к zip-архиву.
//        Добавить файл (fileName) внутрь архива в директорию 'new'.
//        Если в архиве есть файл с таким именем, то заменить его.
//        Пример входных данных:
//        C:/result.mp3
//        C:/pathToTest/test.zip
//        Файлы внутри test.zip:
//        a.txt
//        b.txt
//        После запуска Solution.main архив test.zip должен иметь такое содержимое:
//        new/result.mp3
//        a.txt
//        b.txt
//        Подсказка: нужно сначала куда-то сохранить содержимое всех энтри, а потом записать в архив все энтри вместе с добавленным файлом.
//        Пользоваться файловой системой нельзя.
//        Требования:
//        •
//        В методе main создай ZipInputStream для архивного файла (второй аргумент main). Нужно вычитать из него все содержимое.
//        •
//        В методе main создай ZipOutputStream для архивного файла (второй аргумент main).
//        •
//        В ZipOutputStream нужно записать содержимое файла, который приходит первым аргументом в main.
//        •
//        В ZipOutputStream нужно записать все остальное содержимое, которое было вычитано из ZipInputStream.
//        •
//        Потоки для работы с архивом должны быть закрыты.





/*
Добавление файла в архив\
// упрощу задачу, выполнить задание любыми средствами.Оно и лучше будет для меня.
Ставлю задачу, необходимо просто добавить в архив файл.Это будет более чем достаточно
Еще задача вспомогательная, записать в мапу все файлы архива.При этом в ключ пишем имя файла,а в значение содержимое.
Судя по всему, необходим поток bytearrayoutputstream
*/
class Solution2 {
    public static void main(String[] args) throws IOException {
        String fileName="c:/test.txt";
        String zipFile="c:/archive.zip";
//        FileOutputStream fos=new FileOutputStream(zipFile);// закинули в поток для чтения нужный файл
//        ZipOutputStream zipFileStream=new ZipOutputStream(fos);// далее это поток закинули в зип поток
//File file=new File(fileName);              // создали файл по имени
//        String nameFile="new/"+file.getName().toString();
//        zipFileStream.putNextEntry(new ZipEntry(nameFile)); //создали пустой зип энтри с названием файла для арживации
//        Files.copy(file.toPath(),zipFileStream); //копируем файл в архив
//   zipFileStream.close();
//   fos.close();
        Map<String, ByteArrayOutputStream>mapZip=new TreeMap<>();
        try(ZipInputStream zis=new ZipInputStream(new FileInputStream(zipFile))
            )
        {
         ZipEntry entry;
         String name;
         while((entry=zis.getNextEntry())!=null){
            //mapZip.put(entry.getName(),byteArrayOutputStream.writeTo(new FileOutputStream(zis.read()));)
             //FileOutputStream fos=new FileOutputStream();
            // ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream((int) entry.getSize());
           //  byte[]buffer=
             System.out.println(entry.getName());

         }
        }

    }
}
