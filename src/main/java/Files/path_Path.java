package src.java.Files;

import java.nio.file.Path;
import java.nio.file.Paths;

/*
Path, по большому счету, — это переработанный аналог класса File. Работать с ним значительно проще, чем с File.

Во-первых, из него убрали многие утилитные (статические) методы, и перенесли их в класс Files.

Во-вторых, в Path были упорядочены возвращаемые значения методов. В классе File методы возвращали то String, то boolean,
 то File — разобраться было непросто.

Например, был метод getParent(), который возвращал родительский путь для текущего файла в виде строки. Но при этом был
метод getParentFile(), который возвращал то же самое, но в виде объекта File!

 Вот некоторые из них и примеры их работы:
!!!!getFileName() — возвращает имя файла из пути;

!!!!getParent() — возвращает «родительскую» директорию по отношению к текущему пути (то есть ту директорию, которая
находится выше по дереву каталогов);

!!!!getRoot() — возвращает «корневую» директорию; то есть ту, которая находится на вершине дерева каталогов;

!!!!startsWith(), endsWith() — проверяют, начинается/заканчивается ли путь с переданного пути:


 */
public class path_Path {
    public static void main(String[] args) {
        Path one_main= Paths.get("E:\\мультипоток");
        Path parent=one_main.getParent();
        System.out.println(parent);
        Path fileName=one_main.getFileName();
        System.out.println(fileName);//возвращает имя файла из пути
        Path root = one_main.getRoot();
        System.out.println(root);

        boolean endWithTxt = one_main.endsWith("Desktop\\testFile.txt");
        System.out.println(endWithTxt);

        boolean startsWithLalala = one_main.startsWith("lalalala");
        System.out.println(startsWithLalala);
        //Обрати внимание на то, как работает метод endsWith(). Он проверяет, заканчивается ли текущий путь на
        // переданный путь. Именно на путь, а не на набор символов.

    }
}
/*
в Path есть группа методов, которая упрощает работу с абсолютными (полными) и относительными путями.

Давай рассмотрим эти методы:
boolean isAbsolute() — возвращает true, если текущий путь является абсолютным:

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

   public static void main(String[] args) {

       Path testFilePath = Paths.get("C:\\Users\\Username\\Desktop\\testFile.txt");

       System.out.println(testFilePath.isAbsolute());
   }
}
Вывод в консоль:

true

Path normalize() — «нормализует» текущий путь, удаляя из него ненужные элементы. Ты, возможно, знаешь, что в популярных
операционных системах при обозначении путей часто используются символы “.” (“текущая директория”) и “..”
(родительская директория). Например: “./Pictures/dog.jpg” обозначает, что в той директории, в которой мы сейчас
находимся, есть папка Pictures, а в ней — файл “dog.jpg”

Так вот. Если в твоей программе появился путь, использующий “.” или “..”, метод normalize() позволит удалить их и
получить путь, в котором они не будут содержаться:

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

   public static void main(String[] args) {


       Path path5 = Paths.get("C:\\Users\\Java\\.\\examples");

       System.out.println(path5.normalize());

       Path path6 = Paths.get("C:\\Users\\Java\\..\\examples");
       System.out.println(path6.normalize());
   }
}
Вывод в консоль:

C:\Users\Java\examples
C:\Users\examples
Path relativize() — вычисляет относительный путь между текущим и переданным путем.

Например:

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

   public static void main(String[] args) {

       Path testFilePath1 = Paths.get("C:\\Users\\Users\\Users\\Users");
       Path testFilePath2 = Paths.get("C:\\Users\\Users\\Users\\Users\\Username\\Desktop\\testFile.txt");

       System.out.println(testFilePath1.relativize(testFilePath2));
   }
}
Вывод в консоль:

Username\Desktop\testFile.txt

Полный список методов Path довольно велик. Найти их все ты сможешь в документации Oracle.
 */
































