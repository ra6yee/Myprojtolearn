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
