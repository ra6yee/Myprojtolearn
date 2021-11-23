package src.java.Files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

/*
Для записи данных в файл у него есть метод write(), а для чтения — целых 3: read(), readAllBytes() и readAllLines()
Мы подробно остановимся на последнем. Почему именно на нем?

Потому что у него есть очень интересный тип возвращаемого значения — List<String>! То есть он возвращает нам список
строк файла.
 Конечно, это делает работу с содержимым очень удобной, ведь весь файл, строку за строкой, можно, например, вывести в
 консоль в обычном цикле for:
 */
public class менять_содержимое_ФАЙЛОВ {
    public static void main(String[] args) throws IOException {


    List<String> lines = Files.readAllLines(Paths.get("e:/новый текстовый документ.txt"));

       for (String s: lines) {
        System.out.println(s);
    }
}
}
