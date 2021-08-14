package src.java.Charset_Кодировки;

import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

public class code {
}
/*
Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
Требования:
•
Программа НЕ должна считывать данные с клавиатуры.
•
Программа НЕ должна выводить данные на экран.
•
Программа должна записывать данные в файл.
•
Содержимое второго файла должно соответствовать содержимому первого файла за исключением кодировки(UTF-8).
.. через аргументы запуска делать не буду.Не хочу возиться, Укажу все в жесткой привязке.
*/class Solution {
    public static void main(String[] args) throws IOException {
        Charset windows_1251=Charset.forName("Windows-1251");
        Charset UTF_8=Charset.forName("UTF-8");
        InputStreamReader reader=new InputStreamReader( new FileInputStream("c:/test"),windows_1251);
        OutputStreamWriter writer=new OutputStreamWriter(new FileOutputStream("c:/outTest.txt"),UTF_8);
//       StringBuilder sb=new StringBuilder();
//               byte[] array=new byte[1000];
        while(reader.ready()){
            writer.write(reader.read());

        }
        reader.close();
        writer.close();
  //  String s=new String(sb,windows_1251);
    }
}
//BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]), "Windows-1251"))

 class Test2 {
    public static void main(String args[]) {

        List<File> files = Arrays.asList(File.listRoots());
        for (File f : files) {
            String s1 = FileSystemView.getFileSystemView().getSystemDisplayName(f);
            String s2 = FileSystemView.getFileSystemView().getSystemTypeDescription(f);
            System.out.println("getSystemDisplayName : " + s1);
            System.out.println("getSystemTypeDescription : " + s2);
        }


    }

}