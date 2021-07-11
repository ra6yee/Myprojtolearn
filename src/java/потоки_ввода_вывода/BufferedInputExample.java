package src.java.потоки_ввода_вывода;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

/*
Помнишь, мы проходили BufferedReader и говорили, что его можно не использовать?

Когда мы пишем:

BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))

…использовать BufferedReader не обязательно: InputStreamReader справится с задачей.
Но BufferedReader делает это эффективнее и, к тому же, умеет читать данные целыми строками, а не отдельными символами.

С BufferedInputStream все так же! Класс накапливает вводимые данные в специальном буфере без постоянного обращения к устройству ввода.
inputStream->BufferedInputStream
Рассмотрим пример:
 */
public class BufferedInputExample {

    public static void main(String[] args) throws Exception {
        InputStream inputStream = null;
        BufferedInputStream buffer = null;

        try {

            inputStream = new FileInputStream("C:/токен.txt");

            buffer = new BufferedInputStream(inputStream);

            while(buffer.available()>0) {

                char c = (char)buffer.read();

                System.out.println("Был прочитан символ " + c);
            }
        } catch(Exception e) {

            e.printStackTrace();

        } finally {

            inputStream.close();
            buffer.close();
        }
    }
}
