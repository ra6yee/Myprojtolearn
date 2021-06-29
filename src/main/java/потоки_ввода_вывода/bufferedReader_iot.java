package потоки_ввода_вывода;

import java.io.*;

public class bufferedReader_iot {


    InputStream inputStream = System.in;
    Reader inputStreamReader = new InputStreamReader(inputStream);
    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

    String name = bufferedReader.readLine(); //читаем строку с клавиатуры
    String sAge = bufferedReader.readLine(); //читаем строку с клавиатуры
    int nAge = Integer.parseInt(sAge); //преобразовываем строку в число.


    // более компактная запись
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String name = reader.readLine();
        String sAge = reader.readLine();
        int nAge = Integer.parseInt(sAge);
    }



    public bufferedReader_iot() throws IOException {
    }
}
// считывает посимвольно из  файла
// Для чтения данных (неважно откуда, из консоли, файла или откуда-то еще)
// в классе InputStreamReader тоже используется метод read().
class Main {

    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("C:\\Users\\username\\Desktop\\testFile.txt"));
    }
}
//методы считывания разных данных из консоли.
class ConsoleReader12 {
    public static String readString() throws Exception {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        String string=reader.readLine();
        return string;

    }

    public static int readInt() throws Exception {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        int number=Integer.parseInt(reader.readLine());
        return number;
    }

    public static double readDouble() throws Exception {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        double munber=Double.parseDouble(reader.readLine());
        return munber;
    }

    public static boolean readBoolean() throws Exception {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        boolean bool=Boolean.parseBoolean(reader.readLine());
        return bool;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
    }
}
/*
Считать с консоли 2 имени файла.
Вывести во второй файл все символы с четным порядковым номером (нумерация начинается с 1).
Пример первого файла:
text in file
Вывод во втором файле:
eti ie
Закрыть потоки ввода-вывод
Требования:
•
Программа должна считывать имена файлов с консоли (используй BufferedReader).
•
BufferedReader для считывания данных с консоли должен быть закрыт.
•
Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
•
Поток чтения из файла (FileReader) должен быть закрыт.
•
Программа должна записывать во второй файл все байты из первого файла с четным порядковым номером (используй FileWriter).
•
Поток записи в файл (FileWriter) должен быть закрыт.


 */

class Code {
    public static void main(String[] args) throws IOException {
//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
//        System.out.print("enter first file path: ");
//        String file1=reader.readLine();
//        System.out.print("enter second file path: ");
//     String file2=reader.readLine();
//     reader.close();
     FileReader fileReader=new FileReader("c:\\text1.txt");
     FileWriter fileWriter=new FileWriter("c:\\textOut.txt");
    int count=0;
     while(fileReader.ready()){
         count++;
         int text=fileReader.read();
         if(count%2==0){
             fileWriter.write(text);
         }else text=0;

     }
fileReader.close();
     fileWriter.close();
    // System.out.println();
    }
}
/*
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки.
Требования:
•
Программа должна считывать имя файла с консоли (используй BufferedReader).
•
BufferedReader для считывания данных с консоли должен быть закрыт.
•
Программа должна считывать содержимое файла (используй FileReader c конструктором принимающим String).
•
Поток чтения из файла (FileReader) должен быть закрыт.
•
Программа должна выводить в консоль количество слов "world", которые встречаются в файле.

 */

class Code2{
    public static void main(String[] args) throws IOException {
BufferedReader reader=new BufferedReader(new FileReader("c:\\text1.txt"));
       // FileReader fl=new FileReader("c:\\text1.txt");
        int count=0;
while ((reader.ready())){
    String[] world=reader.readLine().split("\\W");
    for (String z:world
         ) {
      if(z.toString().equals("world")){
          count++;
      }

    }
}reader.close();
        System.out.println("количество повторений: "+count);
    }
}

