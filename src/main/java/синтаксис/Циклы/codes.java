package src.java.синтаксис.Циклы;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class codes {
}
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////Избавьтесь от меток в методе isSubstringPresent сохранив логику.
//    Метод возвращает true, в случае если строка substring является подстрокой строки string, иначе false.
//        В коде должны отсутствовать операторы break и continue.
//        Требования:
//        •
//        Метод isSubstringPresent должен возвращать true, если строка substring является подстрокой строки string.
//        •
//        Метод isSubstringPresent должен возвращать false, если строка substring НЕ является подстрокой строки string.
//        •
//        В методе isSubstringPresent должны отсутствовать операторы break.
//        •
//        В методе isSubstringPresent должны отсутствовать операторы continue.

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////package com.javarush.task.task27.task2701;


/*
Избавляемся от меток
*/
 class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        String substring = reader.readLine();

        if (isSubstringPresent(substring, string)) {
            System.out.println("String: \n" + substring + "\nis present in the string: \n" + string);
        } else {
            System.out.println("String: \n" + substring + "\nis not present in the string: \n" + string);
        }
    }

    static boolean isSubstringPresent(String substring, String string) {
        if(string.contains(substring)){
            return true;
        }else
        return false;
    }
}
//    Вставьте в код единственную строчку - оператор (не break), чтобы на экран выводился треугольник из букв S.
//        Требования:
//        •
//        Программа должна выводить на экран треугольник из букв S.
//        •
//        В программе должен быть использован оператор continue.
//        •
//        В программе не должен быть использован оператор break.
//        •
//        Программа не должна считывать данные с клавиатуры.

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////package com.javarush.task.task27.task2702;

/*
Нужный оператор
*/
class Solution2 {
    public static void main(String args[]) {
        label:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (j > i)  {
                    System.out.println();
                    continue label;
                }
                System.out.print("S");
            }
        }
    }
}

