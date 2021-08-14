package src.java.String_StringBuilder.String_format;

import java.util.Date;

public class code {
}
/*
Форматирование строки
Исправить метод getFormattedString так, чтобы он возвращал строку с параметрами для форматирования.
Для перевода каретки не используйте \n.
Должен быть вывод:
20 / 7 = 2,86
Exp = 3,33e+00
Требования:
•
Для перевода строки не должно быть использовано выражение \n.
•
Метод getFormattedString должен быть статическим.
•
Вывод на экран должен соответствовать условию задачи.
•
Метод getFormattedString должен возвращать строку с параметрами для форматирования согласно условию задачи.



*/
class Solution {
    public static void main(String[] args) {
        System.out.println(String.format(getFormattedString(), 20.0 / 7.0, 10.0 / 3.0));
        //должен быть вывод
        //20 / 7 = 2,86
        //Exp = 3,33e+00
    }

    public static String getFormattedString() {
        return "20 / 7 = %.2f %n Exp = %.2e";
    }
}

/*
МНЕ нравится курс JavaRush
Исправить метод getFormattedString так, чтобы он возвращал строку с параметрами для форматирования.
Параметры должны меняться местами.
Должен быть вывод:
МНЕ нравится курс JavaRush
Требования:
•
Метод getFormattedString должен быть публичным.
•
Метод getFormattedString должен быть статическим.
•
Вывод на экран должен соответствовать условию задачи.
•
Метод getFormattedString должен возвращать строку с параметрами для форматирования согласно условию задачи.

*/
 class Solution1 {
    public static void main(String[] args) {
        System.out.println(String.format(getFormattedString(), "JavaRush", "курс", "мне", "нравится"));
        //должен быть вывод
        //"МНЕ нравится курс JavaRush"
    }
    public static String getFormattedString() {

        return "%3$S %4$s %2$s %1$s";
    }
}
/*
Форматирование даты
Исправить метод getFormattedString так, чтобы он возвращал строку с параметрами для форматирования.
Должен быть вывод аналогичный следующему:
05:04:18 09:09:09 (число:месяц:год часы:минуты:секунды)
Требования:
•
Метод getFormattedString должен быть публичным.
•
Метод getFormattedString должен быть статическим.
•
Вывод на экран должен соответствовать условию задачи.
•
Метод getFormattedString должен возвращать строку с параметрами для форматирования согласно условию задачи.

*/
 class Solution2 {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(String.format(getFormattedString(), date));
        //должен быть вывод аналогичный следующему
        //31:10:13 15:59:59
    }

    public static String getFormattedString() {
        return "%1$td:%1$tm:%1$ty %1$tH:%1$tM:%1$tS";
    }
}
