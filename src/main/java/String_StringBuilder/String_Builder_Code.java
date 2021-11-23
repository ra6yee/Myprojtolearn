package src.java.String_StringBuilder;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;

public class String_Builder_Code {
}
/*
Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Использовать StringBuilder.
Кодировка файла - UTF-8.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
Требования:
•
Метод main должен считывать имя файла с клавиатуры.
•
В методе main должен быть использован StringBuilder.
•
В классе Solution должен содержаться вложенный класс Pair с методами equals, hashCode и toString. Удалять или изменять
эти методы нельзя.
•
В классе Pair должен быть объявлен конструктор без параметров (или конструктор по умолчанию).
•
Список result должен быть заполнен корректными парами согласно условию задачи.

*/
 class Solution3 {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
//        FileReader reader=new FileReader("c:/test");
//        StringBuilder sb=new StringBuilder();
//        String text;
//        ArrayList<StringBuilder>arrayListOfFile=new ArrayList<>();
//        while(reader.ready()){
//            text= (Character.toString((char) reader.read()));
//            if((text == " ") || (text == "\n")){
//                  arrayListOfFile.add(sb);
//            sb.setLength(0);
//            }
//            sb.append(text);
//           // if(reader.read()==" "||)
//        }
//        for (StringBuilder a:arrayListOfFile
//             ) {
//            System.out.println(a.toString());
//
//        }
     //   BufferedReader br = new BufferedReader(new InputStreamReader(
               // new FileInputStream("DirectionResponse.xml"), "windows-1251"));
      InputStreamReader reader= new InputStreamReader (new FileInputStream("c:/test"),"windows-1251");
             int text;
             String fileText="";
        while(reader.ready()){
       text=reader.read();
       fileText+=(char)text;
    }
    fileText.trim();
        System.out.println(fileText);
        String[] arrayFileText=fileText.split("\\s");
//        for (String z:arrayFileText
//             ) {
//            System.out.print(z+" ");
//
//        }
  //String s=arrayFileText[0];
  StringBuilder sb;
        StringBuilder sbInner;
  StringBuilder[] sbArray;
 ArrayList result=new ArrayList();
  //sb.append(s);
        for (int i = 0; i <arrayFileText.length ; i++) {
            sb=new StringBuilder(arrayFileText[i]);
            for (int j = i; j <arrayFileText.length ; j++) {
                sbInner=new StringBuilder(arrayFileText[j]);
                sbInner.reverse();
                if(sb.toString().equals(sbInner.toString())){
                    result.add((sb.append(" ").append(sbInner.reverse())).toString());
                }

            }
        }
        for (int i = 0; i <result.size() ; i++) {
           String s= (String) result.get(i);
            System.out.println(s);
        }
    reader.close();
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
/*
Формируем WHERE
Сформируй часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{name=Ivanov, country=Ukraine, city=Kiev, age=null}
Результат:
name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'
Требования:
•
Метод getQuery должен принимать один параметр типа Map.
•
Метод getQuery должен иметь тип возвращаемого значения String.
•
Метод getQuery должен быть статическим.
•
Метод getQuery должен возвращать строку сформированную по правилам описанным в условии задачи.

*/
 class Solution4 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Ivanov");
        map.put("Country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", null);
        System.out.println(getQuery(map));
    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder sb= new StringBuilder();
        sb.append("{name = ").append( params.get("name")).append(" and ");
        sb.append("country = ").append( params.get("Country")).append(" and ");
        sb.append("city = ").append( params.get("city")).append(" and ");
        sb.append("age = ").append( params.get("age")).append(" }");
       ;
        return sb.toString();
    }
}

