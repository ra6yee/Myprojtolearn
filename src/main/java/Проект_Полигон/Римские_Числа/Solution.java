package Проект_Полигон.Римские_Числа;

//Амиго, привет! Я недавно увлекся историей вашей планеты и меня заинтересовал период Древнего Рима.
//        Интересно тогда было жить, сплошные развлечения и вино! Или рабство, если не повезло со стартовой локацией...
//        В общем, мне нужен метод romanToInteger, который будет конвертировать число в римской системе счисления 
//        {I, V, X, L, C, D, M} в десятичную. Иначе никак не разобрать что и когда у них происходило.
//        Требования:
//        •
//        Метод romanToInteger должен конвертировать число в римской системе счисления в десятичную.
//        •
//        Метод romanToInteger должен возвращать значение типа int и принимать один параметр типа String.
//        •
//        Метод romanToInteger должен быть публичным.
//        •
//        Метод romanToInteger должен быть статическим.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

/*
Древний Рим
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите римское число: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Результат преобразования полученного числа в арабское число:  " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {
        int rezult = 0;
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        char[] array = new char[s.length()];
        array = s.toCharArray();

        int tmpRezult = map.get(String.valueOf(array[array.length - 1]));
        int tmpRezultLast = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            tmpRezultLast = map.get(String.valueOf(array[i]));

            if (tmpRezultLast >= tmpRezult) {
                rezult += tmpRezultLast;
            } else {
                if (tmpRezultLast < tmpRezult) {
                    rezult -= map.get(String.valueOf(array[i]));
                }
            }
            tmpRezult = tmpRezultLast;
        }
        return rezult;
    }
}





































