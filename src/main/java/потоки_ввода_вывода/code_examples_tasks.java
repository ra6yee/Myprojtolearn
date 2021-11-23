package src.java.потоки_ввода_вывода;

import java.io.*;
import java.util.*;

public class code_examples_tasks {
}
/*
Максимальный байт
Ввести с консоли имя файла.
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода.
Требования:
•
Программа должна считывать имя файла с консоли.
•
Для чтения из файла используй поток FileInputStream.
•
В консоль должен выводиться максимальный байт, считанный из файла.
•
Поток чтения из файла должен быть закрыт.

*/

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the name of file: ");
        String nameFile=reader.readLine();
        reader.close();
        FileInputStream fis=new FileInputStream(nameFile);
        int count=0;
        int readByte;
        while(fis.available()>0){
           readByte= fis.read();
           if(readByte>count){
               count=readByte;
           }
        }
    fis.close();
        System.out.println((char)count);
    }
}

/*
Самые частые байты
*/

class Solution1 {
    public static void main(String[] args) throws Exception {
   FileInputStream fis=new FileInputStream("c:\\jetbrains-agent.jar");
        ArrayList list=new ArrayList();
   while(fis.available()>0){
       list.add(fis.read());
   }
fis.close();
   Set set1=new HashSet();
   set1.addAll(list);
        Iterator iter=set1.iterator();
        while(iter.hasNext()){
          Object ss =  iter.next();
          String nt= ss.toString();
          int out=Integer.parseInt(nt);
            char out1= (char) out;
            if(Collections.frequency(list,ss)==1){
                System.out.println(ss.toString()+"-"+Collections.frequency(list,ss));
            }
            System.out.println(ss.toString()+"-"+Collections.frequency(list,ss));
        }
    }
}
/*
Сортировка байт
Ввести с консоли имя файла.
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран.
Закрыть поток ввода-вывода.
Пример байт входного файла:
44 83 44
Пример вывода:
44 83
Требования:
•
Программа должна считывать имя файла с консоли.
•
Для чтения из файла используй поток FileInputStream.
•
В консоль через пробел должны выводиться все уникальные байты из файла в порядке возрастания.
•
Данные в консоль должны выводится в одну строку.
•
Поток чтения из файла должен быть закрыт.

*/

class Solution2 {
    public static void main(String[] args) throws Exception {
        FileInputStream fis=new FileInputStream("c:\\jetbrains-agent.jar");
        TreeSet set=new TreeSet();
        while (fis.available()>0){
            set.add(fis.read());
        }
       fis.close();
        for (Object z:set
             ) {
            System.out.print(z+" ");
        }
    }
}
/*
Исправить ошибки
Исправить функциональность в соответствии с требованиями.
Программа должна:
1. Переписать все байты одного файла в другой одним куском.
2. Закрывать потоки ввода-вывода.
Подсказка:
4 ошибки.
Требования:
•
Программа должна использовать классы FileInputStream и FileOutputStream.
•
Программа должна переписать все байты одного файла в другой одним куском.
•
Потоки FileInputStream и FileOutputStream должны быть закрыты.
•
Нужно исправить 4 ошибки.

*/

class Solution3 {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("c:/data.txt");
        // Создаем поток-записи-байт-в-файл
        FileOutputStream outputStream = new FileOutputStream("c:/result.txt");

        if (inputStream.available()>0) {
            //читаем весь файл одним куском
            byte[] buffer = new byte[inputStream.available()];
            int count = inputStream.read(buffer);
            outputStream.write(buffer, 0, count);
        }

       // inputStream.reset();
        outputStream.flush();
        inputStream.close();
        outputStream.close();
    }
}

/*
Подсчет запятых
С консоли считать имя файла.
Посчитать в файле количество символов ',', количество вывести на консоль.
Закрыть потоки.
Подсказка:
нужно сравнивать с ascii-кодом символа ','.
Требования:
•
Программа должна считывать имя файла с консоли.
•
Для чтения из файла используй поток FileInputStream.
•
В консоль должно выводится число запятых в считанном файле.

*/

class Solution4 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis=new FileInputStream("c:\\data.txt");
             int count=0;
                while (fis.available()>0){
                   if(fis.read()==44){
                       count++;
                   }
                }
        System.out.println(count);
    }
}
/*
Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать большую часть.
Закрыть потоки.
Требования:
•
Программа должна три раза считать имена файлов с консоли.
•
Для чтения из файла используй поток FileInputStream, для записи в файлы - FileOutputStream
•
Первую половину байт из первого файла нужно записать во второй файл.
•
Вторую половину байт из первого файла нужно записать в третий файл.
•
Потоки FileInputStream и FileOutputStream должны быть закрыты.

*/

 class Solution5 {
    public static void main(String[] args) throws IOException {
FileInputStream fis=new FileInputStream("c:\\data.txt");
FileOutputStream file1=new FileOutputStream("c:\\file1.txt");
FileOutputStream file2=new FileOutputStream("c:\\file2.txt");
int sizeFirstFile=fis.available();
int byteSize1;
int byteSize2;
        System.out.println(sizeFirstFile);
        if(sizeFirstFile%2==0){
            byteSize1=sizeFirstFile/2;
            byteSize2=byteSize1;
        }else{
            byteSize1=(sizeFirstFile/2)+1;
            byteSize2=sizeFirstFile-byteSize1;
        }
     if(fis.available()>=byteSize1){
         byte[] onebuff= new byte[byteSize1];
         fis.read(onebuff);
         file1.write(onebuff);
     }
     if(fis.available()>=byteSize2)
     {byte[] twobuff= new byte[byteSize2];
           fis.read(twobuff);
           file2.write(twobuff);

        }
fis.close();
     file1.close();
     file2.close();

    }
}






