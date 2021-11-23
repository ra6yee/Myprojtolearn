package src.java.паттерны_проектирования.dfs.обертка_System;

import java.io.*;

public class примеры_кода {
}

/*
Wrapper (Decorator)
разберись что делает программа

Аналогично классу DecoratorRunnableImpl создай класс DecoratorMyRunnableImpl.
Требования:
• Создай класс DecoratorMyRunnableImpl, аналогичный DecoratorRunnableImpl.
• После запуска, каждый класс должен вывести в консоль "'Имя класса' body".
• Классы RunnableImpl и DecoratorRunnableImpl изменять нельзя.
• Метод main изменять нельзя.

*/
 class Solution {
    public static void main(String[] args) {
        new Thread(new DecoratorRunnableImpl(new DecoratorMyRunnableImpl(new RunnableImpl()))).start();
    }
    public static class RunnableImpl implements Runnable {
        @Override
        public void run() {
            System.out.println("RunnableImpl body");
        }
    }
    public static class DecoratorRunnableImpl implements Runnable {
        private Runnable component;
        public DecoratorRunnableImpl(Runnable component) {
            this.component = component;
        }
        @Override
        public void run() {
            System.out.print("DecoratorRunnableImpl body ");
            component.run();
        }
    }
public static class DecoratorMyRunnableImpl implements Runnable{
private Runnable component;
 public DecoratorMyRunnableImpl(Runnable component){
     this.component=component;
 }
    @Override
    public void run() {
        component.run();
        System.out.println("DecoratorMyRunnableImpl body");
        System.out.printf(">> %s << ",Thread.currentThread().getName());

    }
   }
 }


 interface AmigoOutputStream {
    void flush() throws IOException;
    void write(int b) throws IOException;
    void write(byte[] b) throws IOException;
    void write(byte[] b, int off, int len) throws IOException;
    void close() throws IOException;
}
/*
Расширяем AmigoOutputStream
Используя шаблон проектирования Wrapper (Decorator) расширь функциональность AmigoOutputStream.
В классе QuestionFileOutputStream при вызове метода close() должна быть реализована следующая функциональность:
1. Вывести в консоль фразу "Вы действительно хотите закрыть поток? Д/Н".
2. Считайте строку.
3. Если считанная строка равна "Д", то закрыть поток.
4. Если считанная строка не равна "Д", то не закрывать поток.
Требования:
• Интерфейс AmigoOutputStream изменять нельзя.
• Класс QuestionFileOutputStream должен реализовывать интерфейс AmigoOutputStream.
• Класс QuestionFileOutputStream должен инициализировать в конструкторе поле типа AmigoOutputStream.
• Все методы QuestionFileOutputStream должны делегировать свое выполнение объекту AmigoOutputStream.
• Метод close() должен спрашивать у пользователя "Вы действительно хотите закрыть поток? Д/Н".
• Метод close() должен закрывать поток только в случае, если считает с консоли ответ "Д".


*/
class QuestionFileOutputStream implements AmigoOutputStream {
private AmigoOutputStream Amigo;
BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
    public QuestionFileOutputStream(AmigoOutputStream amigo) {
        Amigo = amigo;
    }

    @Override
    public void flush() throws IOException {
             Amigo.flush();
    }

    @Override
    public void write(int b) throws IOException {
Amigo.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
Amigo.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
Amigo.write(b,off,len);
    }

    @Override
    public void close() throws IOException {
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        String answer=reader.readLine();
        if(answer.equals("Д")){
            Amigo.close();
        }
    reader.close();
    }
}

/*
AmigoOutputStream

1 Измени класс AmigoOutputStream так, чтобы он стал Wrapper-ом для класса FileOutputStream. Используй наследование.
2 При вызове метода close() должны выполняться следующая последовательность действий:
2.1 Вызвать метод flush().
2.2 Дописать следующий текст "JavaRush © All rights reserved.", используй метод getBytes().
2.3 Закрыть поток методом close().
Требования:
• Метод main изменять нельзя.
• Класс AmigoOutputStream должен наследоваться от класса FileOutputStream.
• Класс AmigoOutputStream должен принимать в конструкторе объект типа FileOutputStream.
• Все методы write(), flush(), close() в классе AmigoOutputStream должны делегировать свое выполнение объекту FileOutputStream.
• Метод close() должен сначала вызвать метод flush(), затем дописать текст, затем закрыть пот

 */

class AmigoOutputStream1 extends FileOutputStream {
    private FileOutputStream fileOutputStream;
String signature= System.lineSeparator()+" JavaRush © All rights reserved.";

    public static String fileName = "C:\\result1.txt";

    public AmigoOutputStream1(FileOutputStream fileOutputStream) throws FileNotFoundException {
        super(fileName,true);

        this.fileOutputStream=fileOutputStream;
    }

public void write(byte[]b) throws IOException {

        fileOutputStream.write(b);
}

public void close() throws IOException {
      fileOutputStream.flush();
     // write("\n\r".getBytes());
      write(signature.getBytes());
      fileOutputStream.close();
}
public static void main(String[] args) throws IOException {
      AmigoOutputStream1 one=  new AmigoOutputStream1(new FileOutputStream(fileName,true));
     String hello="dfsdfsdfsdfsdfsdfsdfsdfsdf";
      one.write(hello.getBytes());
    one.close();
    }


}

