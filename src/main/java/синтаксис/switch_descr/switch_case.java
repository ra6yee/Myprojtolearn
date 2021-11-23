package src.java.синтаксис.switch_descr;

import java.util.ArrayList;
import java.util.List;

public class switch_case {
  /*
    String objectClassName = o.getClass().getSimpleName();
switch (objectClassName) {
        case ("Dog"): System.out.println("Собака"); break;
        case ("Cat"): System.out.println("Кошка"); break;
        case ("Bird"): System.out.println("Птица"); break;
        case ("Lamp"): System.out.println("Лампа"); break;
        default: System.out.println("Такого класса нет");
    }

*/

  /*
switch (ВыражениеДляВыбора) {
           case  (Значение1):
               Код1;
               break;
           case (Значение2):
               Код2;
               break;
...
           case (ЗначениеN):
               КодN;
               break;
           default:
               КодВыбораПоУмолчанию;
               break;
       }

Порядок выполнения в операторе следующий:
Вычисляется ВыражениеДляВыбора.
Далее оператор switch сравнивает полученное выражение с очередным Значением (в порядке перечисления).
Если ВыражениеДляВыбора совпало со Значением, то выполняется код, идущий после двоеточия.
Если встречается конструкция break — то управление передается за пределы команды switch.
Если совпадений ВыражениеДляВыбора и Значений не выявлено, то управление передаётся КодуВыбораПоУмолчанию.

   */
  public static List<String> getPlanetAtmosphere(int seqNumberFromSun) {
      List<String> result = new ArrayList<>();
      switch (seqNumberFromSun) {
          case 1: result.add("Нет атмосферы");
              break;
          case 2:
          case 4: result.add("Углекислый газ");
              break;
          case 3: result.add("Углекислый газ");
              result.add("Азот");
              result.add("Кислород");
              break;
          case 5:
          case 6: result.add("Водород");
              result.add("Гелий");
              break;
          case 7:
          case 8: result.add("Метан");
              result.add("Водород");
              result.add("Гелий");
              break;
          default:
              break;
      }
      return result;
  }
}
//    Реализуй логику метода switchTest:
//        1. Не используй условные операторы.
//        2. Используй 1 switch, у которого 2 case и 1 default.
//        3. Ожидаемый вывод:
//        Вывод для E1.A - "it's E1.A"
//        Вывод для E1.B - "it's E1.B"
//        Вывод для E1.C - "it's E1.C"
//        Вывод для E1.Y - "it's E1.Y"
//        Вывод для E2.D - "it's E2.D"
//        Вывод для E2.E - "it's E2.E"
//        Вывод для E2.F - "it's E2.F"
//        Вывод для всех других значений - "undefined"
//        Требования:
//        •
//        Класс Solution должен содержать метод switchTest и enums E1, E2, E3.
//        •
//        Реализуйте метод switchTest, используя 1 switch, у которого 2 case и 1 default.
//        •
//        Вывод в консоль должен соответствовать условию задачи.
//        •
//        Использовать условные операторы нельзя.

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////package com.javarush.task.task28.task2801;

/*
Осваиваем switch
*/
 class Solution {
    public static enum E1 {A, B, C, Y}

    public static enum E2 {D, E, F}

    public static enum E3 {D, E, F}

    public static void main(String[] args) {
        Solution.switchTest(E1.C);
        Solution.switchTest(E3.D);
        Solution.switchTest(E2.D);
       // System.out.println(E1.A.ordinal());
        /* output
        it's E1.C
        undefined
        it's E2.D
         */
    }

    public static void switchTest(Enum obj) {
      Enum one=obj;
      String name=obj.getDeclaringClass().getSimpleName();
       switch (obj.getDeclaringClass().getSimpleName()){
           case "E1":
               System.out.println("it`s E1."+obj.name());
               break;
               case "E2":
               System.out.println("it`s E2."+obj.name());
               break;
               case "E3":
               System.out.println("it`s E3."+obj.name());
               break;
           default:
               System.out.println("undefined");
       }
    }
}




























