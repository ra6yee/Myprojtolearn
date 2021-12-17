package Аннотации.Tasks;

//import org.powermock.core.classloader.annotations.PrepareForTest;

import javax.swing.text.StyledEditorKit;
import java.lang.annotation.*;
import java.lang.reflect.Field;

//             Разберись в коде и исправьте ошибку.
//        Ориентируйся на ожидаемый вывод.
//        Сделай минимально возможные изменения.
//        Требования:
//        •
//        Программа должна выводить данные на экран.
//        •
//        Вывод на экран должен соответствовать ожидаемому.
//        •
//        Аннотация(@interface) LongPositive должна быть отмечена двумя другими аннотациями.
//        •
//        Аннотация(@interface) LongPositive должна применяться только к полям.
//        •
//        Аннотация(@interface) LongPositive должна быть доступна во время выполнения программы.

 final class ReflectionAnnotationUtil {
    public static void check(Object someObject) throws IllegalAccessException {
        Class<?> testedClass = someObject.getClass();
        for (Field field : testedClass.getDeclaredFields()) {
            if (field.isAnnotationPresent(LongPositive.class)) {
                processLongPositiveAnnotationField(someObject, testedClass, field);
            }
        }
    }

    private static void processLongPositiveAnnotationField(Object someObject, Class<?> testedClass, Field field) throws
            IllegalAccessException
    {
        field.setAccessible(true);
        Class<?> fieldType = field.getType();

        //assert type is long
        if (!fieldType.equals(long.class)) {
            String msg = String.format("Поле %s в классе %s имеет аннотацию LongPositive, но его тип %s.",
                    field.getName(), testedClass.getSimpleName(), fieldType.getSimpleName());
            System.out.println(msg);
            return;
        }

        //assert value is positive
        long value = (long) field.get(someObject);
        if (value <= 0) {
            String msg = String.format("Поле %s в классе %s имеет аннотацию LongPositive, но его значение не положительное.",
                    field.getName(), testedClass.getSimpleName());
            System.out.println(msg);
        }
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////package com.javarush.task.task38.task3809;

 class IncorrectAccount {
    @LongPositive
    private String amountString;
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////package com.javarush.task.task38.task3809;



@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
 @interface LongPositive {
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////package com.javarush.task.task38.task3809;

/*
Annotation + Reflection
*/

public class Solution {
    public static void main(String[] args) throws IllegalAccessException {
        JavaRushBankAccount account = new JavaRushBankAccount("Mr.Smith");
        System.out.println("Проверка №1:");
        ReflectionAnnotationUtil.check(account);

        System.out.println("Проверка №2:");
        account.setAmount(100);
        ReflectionAnnotationUtil.check(account);

        System.out.println("Проверка №3:");
        ReflectionAnnotationUtil.check(new IncorrectAccount());
/* Ожидаемый вывод:

Проверка №1:
Поле amount в классе JavaRushBankAccount имеет аннотацию LongPositive, но его значение не положительное.
Проверка №2:
Проверка №3:
Поле amountString в классе IncorrectAccount имеет аннотацию LongPositive, но его тип String.

*/
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////package com.javarush.task.task38.task3809;

 class JavaRushBankAccount {
    private String ownerName;

    @LongPositive
    private long amount;

    public JavaRushBankAccount(String ownerName) {
        this.ownerName = ownerName;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}


//     Проект должен компилироваться и выводить аннотацию класса Solution.
//        Класс Solution и его аннотацию не менять.
//        Аннотация Changelog должна быть видна во время выполнения.
//        Требования:
//        •
//        Вывод на экран должен соответствовать ожидаемому.
//        •
//        На экран должна быть выведена аннотация @Changelog класса Solution.
//        •
//        Аннотация @Changelog должна быть видна во время выполнения программы.
//        •
//        В классе Solution должен быть реализован метод main с одним параметром типа String[].



 enum Position {
    JUNIOR,
    MIDDLE,
    SENIOR,
    OTHER
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////package com.javarush.task.task38.task3810;

 @interface Revision {
     int revision();
    Date date();
     Author[] authors() default {} ;
    String comment() default "" ;
     //напиши свой код
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////package com.javarush.task.task38.task3810;

 @interface Date {
      int year();
      int month();
      int day();
      int hour();
      int minute();
      int second();

    //напиши свой код
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////package com.javarush.task.task38.task3810;

/*
Реализуй аннотации
*/

@Changelog({
        @Revision(
                revision = 4089,
                date = @Date(year = 2011, month = 5, day = 30, hour = 18, minute = 35, second = 18),
                comment = "Новый файл добавлен"),
        @Revision(
                revision = 6018,
                date = @Date(year = 2013, month = 1, day = 1, hour = 0, minute = 0, second = 1),
                authors = {@Author(value = "Серега", position = Position.MIDDLE)},
                comment = "Фикс багов"),
        @Revision(
                revision = 10135,
                date = @Date(year = 2014, month = 12, day = 31, hour = 23, minute = 59, second = 59),
                authors = {@Author(value = "Диана", position = Position.OTHER),
                        @Author("Игорь"),
                        @Author(value = "Витек", position = Position.SENIOR)})
})
class Solution3 {
    public static void main(String[] args) {
        System.out.println(Solution3.class.getAnnotation(Changelog.class).toString());
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////package com.javarush.task.task38.task3810;

 @interface Author {

    String value() ;
    Position position() default Position.OTHER ;
    //напиши свой код
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////package com.javarush.task.task38.task3810;
@Retention(RetentionPolicy.RUNTIME)
 @interface Changelog {
    Revision[] value() default {} ;
    //напиши свой код
}

@Retention(value= RetentionPolicy.RUNTIME) //1) Должна быть доступна во время выполнения программы.
@Target(ElementType.TYPE)
 @interface Ticket {
    //3) Должна содержать enum Priority c элементами LOW, MEDIUM, HIGH.
    public enum Priority {LOW, MEDIUM, HIGH}

    //4) Приоритет будет задавать свойство priority — по умолчанию Priority.MEDIUM.
    Priority priority() default Priority.MEDIUM;

    //5) Свойство tags будет массивом строк и будет хранить теги связанные с тикетом.
    String[] tags() default {};

    //6) Свойство createdBy будет строкой — по умолчанию Amigo.
    String createdBy() default "Amigo";}




//    В классе Solution необходимо реализовать простейшую обработку аннотаций.
//        В методы printFullyQualifiedNames() и printValues() приходит класс. Если этот класс отмечен аннотацией 
//        PrepareMyTest, необходимо вывести на экран fullyQualifiedNames и values в соответствующих методах и вернуть 
//        true. Если же аннотация PrepareMyTest отсутствует - вернуть false.
//        Для вывода на экран классов из массива value используй сокращенное имя (getSimpleName).
//        Требования:
//        •
//        Метод printFullyQualifiedNames() должен возвращать false в случае, если переданный в качестве параметра класс
//        не отмечен аннотацией @PrepareMyTest.
//•
//        Метод printValues() должен возвращать false в случае, если переданный в качестве параметра класс не отмечен
//        аннотацией @PrepareMyTest.
//•
//        Метод printFullyQualifiedNames() должен выводить на экран все элементы массива fullyQualifiedNames, и
//        возвращать true, если полученный класс отмечен аннотацией @PrepareMyTest.
//•
//        Метод printValues() должен выводить на экран все элементы массива value используя их сокращенное имя, и
//        возвращать true, если полученный класс отмечен аннотацией @PrepareMyTest.

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////package com.javarush.task.task38.task3812;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
//@PrepareForTest
 @interface PrepareMyTest {
    Class<?>[] value() default Solution5.class;

    String[] fullyQualifiedNames() default "";
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////package com.javarush.task.task38.task3812;

@PrepareMyTest(value = {Solution5.class, SomeTest.class}, fullyQualifiedNames = {"com.javarush.task.task38.task3812.Fox"})
 class SomeTest {
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////package com.javarush.task.task38.task3812;

 class Fox {
    String name = "fox";
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////package com.javarush.task.task38.task3812;

/*
Обработка аннотаций
*/

 class Solution5 {
    public static void main(String[] args) {
      printFullyQualifiedNames(Solution5.class);
        printFullyQualifiedNames(SomeTest.class);

        printValues(Solution5.class);
       printValues(SomeTest.class);
    }

    public static boolean printFullyQualifiedNames(Class c) {

if(c.isAnnotationPresent(PrepareMyTest.class)) {
    PrepareMyTest prepareMyTest = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);
    for (String z :
            prepareMyTest.fullyQualifiedNames()) {
        System.out.println(z);
        return true;
    }
}

        return false;
    }

    public static boolean printValues(Class c) {
        if(c.isAnnotationPresent(PrepareMyTest.class)){
            PrepareMyTest prepareMyTest=(PrepareMyTest)c.getAnnotation(PrepareMyTest.class);
            Class<?>[] value=prepareMyTest.value();
            for (Class z:value
                 ) {
                System.out.println(z.getSimpleName());

            }
            return true;
        }        return false;
    }
}
















