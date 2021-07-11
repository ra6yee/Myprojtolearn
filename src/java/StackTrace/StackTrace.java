package src.java.StackTrace;
/*
— Java-машина ведет запись всех вызовов функций. У нее есть для этого специальная коллекция – стек (Stack).
Когда одна функция вызывает другую, Java-машина помещает в этот стек новый элемент StackTraceElement.
 Когда функция завершается этот элемент удаляется из стека.
  Таким образом, в этом стеке всегда хранится актуальная информация о текущем состоянии «стека вызовов функций».

— Каждый StackTraceElement содержит информацию о методе, который был вызван.
В частности можно получить имя этого метода с помощью функции getMethodName.

класс содержит несколько полей, которые можно получить
    private String declaringClass;
    private String methodName;
    private String fileName;
    private int    lineNumber;
    больше там ничего нет
     getFileName();
     getLineNumber();
     getClassName()
     getMethodName()
все возвращения в string формате
 */
public class StackTrace {
}
 class ExceptionExample
{
    public static void main(String[] args)
    {
        method1();
    }

    public static void method1()
    {
        method2();
    }

    public static void method2()
    {
        method3();
    }

    public static void method3()
    {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        for (StackTraceElement element : stackTraceElements)
        {
            System.out.println(element.getMethodName());
        }
    }
}
