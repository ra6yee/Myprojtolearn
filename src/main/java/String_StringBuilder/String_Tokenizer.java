package src.java.String_StringBuilder;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class String_Tokenizer {
}
/*
StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример
getTokens("level22.lesson13.task01", ".")
возвращает массив строк
{"level22", "lesson13", "task01"}
Требования:
•
Метод getTokens должен использовать StringTokenizer.
•
Метод getTokens должен быть публичным.
•
Метод getTokens должен принимать два параметра типа String.
•
Массив типа String возвращенный методом getTokens должен быть заполнен правильно(согласно условию задачи).

*/
class Solution123 {
    public static void main(String[] args) {
getTokens("level22.lesson13.task01", ".");
    }
    public static String [] getTokens(String query, String delimiter) {
     //   ArrayList<String> array=new ArrayList<>();

        StringTokenizer token=new StringTokenizer(query,delimiter);
        String[] array= new String[token.countTokens()];
        int count=0;
        while (token.hasMoreElements()){
            array[count]=(token.nextToken());
            count++;
        }
        for (String z:array
             ) {
            System.out.println(z);

        }
        return array;
    }
}
//отлично, все делится и работает.Хотя, как по мне, проще проитись сплит стринг.
