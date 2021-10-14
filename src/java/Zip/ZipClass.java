package src.java.Zip;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipClass {
    public static void main(String[] args) throws IOException {
        String fileName = "c:/test";
        String zipFile = "c:/archive.zip";
        Path folder = Paths.get(fileName);
        Path Zip = Paths.get(zipFile);
        //    unZip(Zip,folder);
        String ZipName = "c:/ZipArchive.zip";
        String FileToZip = "c:/test.pdf";
   //     ZipFile(Paths.get(ZipName), Paths.get(FileToZip));
        String zipFileEx="c:/archiveMain.zip";
        String fileAdd="c:/testOne.txt";
        addFileToZip(Paths.get(fileAdd),Paths.get(zipFileEx));
        System.out.println("verify");
    }

    public static void unZip(Path zip, Path folderUnZip) throws IOException {
        if (!Files.exists(folderUnZip)) {
            Files.createDirectories(folderUnZip);
        }
        String NameZip = zip.toAbsolutePath().toString();
        FileInputStream fis = new FileInputStream(NameZip);
        ZipInputStream zis = new ZipInputStream(fis);
        ZipEntry ze = null;
        while ((ze = zis.getNextEntry()) != null) {
            if (!Files.exists((Paths.get(folderUnZip.toString() + "/" + ze.getName().toString())))) {
                Files.createFile(Paths.get(folderUnZip.toString() + "/" + ze.getName().toString()));
                // а теперь магия
                FileOutputStream fos = new FileOutputStream(folderUnZip.toString() + "/" + ze.getName().toString());
                byte[] buffer = new byte[1024];
                int length;
                while ((length = zis.read(buffer)) != -1) {
                    fos.write(buffer, 0, length); // не понимаю, как поток  узнает что надо перестать выдавать байты,
                    // где указывавется на то что это и именно это окончание зипЭнтри???
                }
                fos.close();
            }
        }
        fis.close();
        zis.close();
    }

    public static void ZipFile(Path zip, Path fileToZip) throws IOException {
        String NameFile = zip.toAbsolutePath().toString();
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(NameFile));//открыли поток
        // создаем поток,который будет читать файл для архивации
        FileInputStream fis = new FileInputStream(fileToZip.toAbsolutePath().toString());
        // создаем ентри
        ZipEntry entry = new ZipEntry(fileToZip.getFileName().toString());
        //создаем файл с таким же названием в архиве, но пока что он будет пустой. Его размер будет нулевой.
        zos.putNextEntry(entry);
// заполняем поулченный файл байтами нашего файла
        // для этого считываем наш файл в созданный поток fis

        byte[] buffer1 = new byte[fis.available()];
        fis.read(buffer1);
        // теперь записываем этот массив в файл, вернее его содержимое в файл в архиве.
        zos.write(buffer1);
        //странно что не получается в этот поток записать напрямую файл из потока. Видимо, необходим паттерн адаптер.
        // теперь закрываем текущую энтри
        zos.closeEntry();
        fis.close();
        zos.close();
    }

//добавление файла в существующий архив
    public static void addFileToZip(Path fileName,Path Zip) throws IOException {
       String nameZip=Zip.toAbsolutePath().toString();
       String namefile=fileName.toAbsolutePath().toString();
        if(!Files.exists(Zip)){
            System.out.println("Zip is not exist");

        }else{
            // сначала нужно распаковать архив во временную папку
            // создаем временную папку:
            Path temp=Files.createTempDirectory("zip");
            // создаем поток из которого убедм считывать архив
            ZipInputStream zis=new ZipInputStream(new FileInputStream(nameZip));
            //создаем  зипэнтри
            ZipEntry ze;
            // считываем зипэнтри в цикле.Циклом проходим по всему архиву
           while( (ze = zis.getNextEntry()) !=null){
               String nameFileInZip=ze.getName();
               //создаем поток для чтения байтов из этой зип, который будет записывать байты файла
               // сразу во временную папку
               FileOutputStream fos=new FileOutputStream(temp.toString()+"/"+ze.getName());
               //файл почти создали, теперь в него нужно записать содержимое по байтам
               byte[] buffer=new byte[1024];
               int lenght;
               while((lenght=zis.read(buffer))!=-1){
                   fos.write(buffer,0,lenght);
                   fos.close();
               }
              zis.closeEntry();
           }
            zis.close();
            //            FileInputStream fis=new FileInputStream(nameZip);
//            ZipInputStream zis=new ZipInputStream(fis);
//             ZipEntry ze=null;
//             while((ze=zis.getNextEntry())!=null) {
//                 FileOutputStream fos=new FileOutputStream(ze.getName().toString());
//                 byte[] arrayFile=new byte[1024];
//
//             }

        }
    }
}
