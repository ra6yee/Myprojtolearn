package синтаксис;

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




