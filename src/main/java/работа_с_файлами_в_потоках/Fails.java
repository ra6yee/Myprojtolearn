package работа_с_файлами_в_потоках;

import javax.swing.*;
import java.io.*;

public class Fails {
}
class ЧтениеФайла{// это только для текстовых файлов!!!!
    public static void main(String[] args) throws IOException {


    FileReader fr=new FileReader("C:\\Users\\программист\\IdeaProjects\\Myprojtolearn\\src\\main\\java\\работа_с_файлами_в_потоках\\test");
    int count=0;
    while(fr.ready()){
        System.out.print(((char)fr.read()));
    }
   fr.close();
}
}
/*
Писатель в файл с консоли только для символьных данныъх
*/

class Solution24 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("name file: ");
        String nameFile = reader.readLine();
        FileWriter fw = new FileWriter(nameFile);
        String text;
        text=reader.readLine();
        if (text.equals("exit")) {
            System.exit(12);
        } else {
            fw.write(text+"\r\n");

        }

        do {
            text = reader.readLine();
            if (text.equals("exit")) {
                break;
            }else{fw.write(text+"\r\n");};
            fw.write(reader.readLine()+"\r\n");
        } while (!(text.equals("exit")));
        reader.close();
        fw.close();
    }
}
/*
чтение побайтово из файла
 */
class byteRead{
    public static void main(String[] args) throws IOException {
        FileInputStream fis=new FileInputStream("c:\\test");
        FileOutputStream fos=new FileOutputStream("c:\\test_out.txt");
        while(fis.available()>0){
            int one=fis.read();// получаем числовое представление символа из аски таблицы
            fos.write(one);
        }
    fis.close();
        fos.close();
    }
}
/*
чтение байтов в буфер
 */
class byte_Buffer_Read{
    public static void main(String[] args) throws IOException {
        BufferedInputStream bis=new BufferedInputStream(new FileInputStream("c:\\test"),1024);
        while(bis.available()>0){

            System.out.print((char)bis.read());
        }
        bis.close();
    }
}
/*
запись в файл
 */
class byte_write_file{
    public static void main(String[] args) throws IOException {
        FileOutputStream fos=new FileOutputStream("c:\\probe.txt",true);
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
       String text="";
        do {
            text=reader.readLine();

            if(text.equals("q")){
                break;
            }
          //  text+="\\n";

            fos.write(text.getBytes());
            //fos.;
      //      fos.write(Integer.parseInt(System.getProperty("line.separator")));
        }while (!(text.equals("q")));

        reader.close();
        fos.close();
    }
}