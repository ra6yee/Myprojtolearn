package StackTrace;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Arrays;

public class Примеры_кода {
}
/*
Возвращаем StackTrace
*/
class Solution {
    public static void main(String[] args) {
        method1();
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        for (StackTraceElement element : stackTraceElements)
        {
            System.out.println(element.getMethodName());
        }
    }

    public static StackTraceElement[] method1() {
        method2();
        return Thread.currentThread().getStackTrace();
    }

    public static StackTraceElement[] method2() {
        method3();
        return Thread.currentThread().getStackTrace();
    }

    public static StackTraceElement[] method3() {
        method4();
        return Thread.currentThread().getStackTrace();
    }

    public static StackTraceElement[] method4() {
        method5();
        return Thread.currentThread().getStackTrace();
    }

    public static StackTraceElement[] method5() {
        return Thread.currentThread().getStackTrace();
    }
}
/*
И снова StackTrace
*/

class Solution2 {
    public static void main(String[] args) {
        method1();
        StackTraceElement[] stackTraceElements=Thread.currentThread().getStackTrace();
        for (StackTraceElement z :
                stackTraceElements)
        {
            System.out.println(z.getMethodName());

        }
       // System.out.println(stackTraceElements[stackTraceElements.length-1].getMethodName());
    }

    public static String method1() {
        method2();
        StackTraceElement[] stackTraceElements=Thread.currentThread().getStackTrace();
        System.out.println(stackTraceElements[2].getMethodName());
       return Thread.currentThread().getName();
    }

    public static String method2() {
        method3();
        StackTraceElement[] stackTraceElements=Thread.currentThread().getStackTrace();
       System.out.println(stackTraceElements[2].getMethodName());
       return null;
    }

    public static String method3() {
        method4();
        StackTraceElement[] stackTraceElements=Thread.currentThread().getStackTrace();
     System.out.println(stackTraceElements[2].getMethodName());
        return null;
    }

    public static String method4() {
        method5();
        StackTraceElement[] stackTraceElements=Thread.currentThread().getStackTrace();
        System.out.println(stackTraceElements[2].getMethodName());
        return null;
    }

    public static String method5() {
        StackTraceElement[] stackTraceElements=Thread.currentThread().getStackTrace();
       System.out.println(stackTraceElements[2].getMethodName());
        System.out.println("я метод: "+stackTraceElements[1].getMethodName());
        return null;
    }
}

/*
Кто меня вызывал?
*/

class Solution3 {
    public static void main(String[] args) {
        method1();
     //   StackTraceElement[] stackTraceElements=Thread.currentThread().getStackTrace();
      //  Arrays.stream(stackTraceElements).forEach(System.out::println);
    }

    public static int method1() {
        method2();
        StackTraceElement[] stackTraceElements=Thread.currentThread().getStackTrace();
        int num=stackTraceElements[2].getLineNumber();
        System.out.println("Я вызыван из строки номер "+num);
        return  /*напишите тут ваш код*/ num;
    }

    public static int method2() {
        method3();
        StackTraceElement[] stackTraceElements=Thread.currentThread().getStackTrace();
        int num=stackTraceElements[2].getLineNumber();
        System.out.println("Я вызыван из строки номер "+num);
        return  /*напишите тут ваш код*/ 0;
    }

    public static int method3() {
          method4();
        StackTraceElement[] stackTraceElements=Thread.currentThread().getStackTrace();
        int num=stackTraceElements[2].getLineNumber();
        System.out.println("Я вызыван из строки номер "+num);
        return  /*напишите тут ваш код*/ 0;
    }

    public static int method4() {
        method5();
        StackTraceElement[] stackTraceElements=Thread.currentThread().getStackTrace();
        int num=stackTraceElements[2].getLineNumber();
        System.out.println("Я вызыван из строки номер "+num);
        return  /*напишите тут ваш код*/ 0;
    }

    public static int method5() {
        StackTraceElement[] stackTraceElements=Thread.currentThread().getStackTrace();
        int num=stackTraceElements[2].getLineNumber();
        System.out.println("Я вызыван из строки номер "+num);
        System.out.println();
         Arrays.stream(stackTraceElements)

                 .map(StackTraceElement::getLineNumber)
                 .forEach(System.out::println);
        return  /*напишите тут ваш код*/ 0;
    }
}

/*
Там, в синих глубинах стек-трейса…
*/

class Solution4 {
    public static void main(String[] args) {
        int deep = getStackTraceDeep();
    }

    public static int getStackTraceDeep() {
      StackTraceElement[] stackTraceElements=Thread.currentThread().getStackTrace();
       int deep=stackTraceElements.length;
        System.out.println(deep);
      return deep;
    }
}
/*
Логирование стек-трейса
*/

class Solution5 {
    public static void main(String[] args) {
        log("In main method");
    }

    public static void log(String s) {
     StackTraceElement[]stackTraceElements=Thread.currentThread().getStackTrace();
     String class_name=stackTraceElements[2].getClassName();
     String method_name=stackTraceElements[2].getMethodName();
        System.out.println(class_name+"."+method_name+":"+s);
    }
}


