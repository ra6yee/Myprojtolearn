package src.java.Files;

import java.nio.file.Path;
import java.nio.file.Paths;

/*
Paths
Paths — это совсем простой класс с единственным статическим методом get(). Его создали исключительно для того, чтобы
 из переданной строки или URI получить объект типа Path.

Другой функциональности у него нет.
 */
public class Pathses {
    public static void main(String[] args) {

        Path testFilePath = Paths.get("C:\\Users\\Username\\Desktop\\testFile.txt");// надо вручную импортировать
                                                                                  // нужный класс
    // это все что делает данный класс.Но мы получили path. Что с ним делать укажу в соответствующем файле.
    }
}
