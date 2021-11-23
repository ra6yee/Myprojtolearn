package src.java.Коллекции_массивы.примеры_кода;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Задания_Примеры {
}
/*
LinkedList и ArrayList
*/

class Solution {
    public static Object createArrayList() {
        ArrayList<Object>list=new ArrayList<>();
        return new ArrayList<>();


    }

    public static Object createLinkedList() {
        LinkedList<Object>linkedList=new LinkedList<>();
return new LinkedList<>();
    }

    public static void main(String[] args) {

    }
}
/*
10 тысяч удалений и вставок
*/

 class Solution2 {
    public static void main(String[] args) {
        // ArrayList
        ArrayList arrayList = new ArrayList();
        insert10000(arrayList);
        System.out.println(arrayList.size());
        get10000(arrayList);
        System.out.println(arrayList.size());
        set10000(arrayList);
        System.out.println(arrayList.size());
        remove10000(arrayList);
        System.out.println(arrayList.size());
        // LinkedList
        LinkedList linkedList = new LinkedList();
        insert10000(linkedList);
        System.out.println(linkedList.size());
        get10000(linkedList);
        System.out.println(linkedList.size());
        set10000(linkedList);
        System.out.println(linkedList.size());
        remove10000(linkedList);
        System.out.println(linkedList.size());
    }

    public static void insert10000(List list) {
        for (int i = 0; i <10000 ; i++) {
            list.add(i);

        }

    }

    public static void get10000(List list) {
        for (int i = 0; i <10000 ; i++) {
            list.get(i);

        }

    }

    public static void set10000(List list) {
        for (int i = 0; i <10000 ; i++) {
            list.set(i,i);
        }

    }

    public static void remove10000(List list) {
        for (int i = 0; i <10000 ; i++) {
            list.remove(0);               //значит ттут такое дело, как только удаляется элемент, то другой элдемено встает на его место
                                                // следовательно, в середине листа мы снесем весь список, поэтому надо указать индекс ноль
                                                 // и получается что на место удаленного индекса нуля приходит индекс один
                                                // он уже становится нулем. И так пока не кончатся эллементы

        }

    }
}
/*
Время для 10 тысяч вставок
*/

class Solution3 {
    public static void main(String[] args) {
        System.out.println(getInsertTimeInMs(new ArrayList()));
        System.out.println(getInsertTimeInMs(new LinkedList()));
    }

    public static long getInsertTimeInMs(List list) {
        Date one=new Date();

        insert10000(list);
           Date two =new Date();
           return two.getTime()-one.getTime();

        // напишите тут ваш код

    }

    public static void insert10000(List list) {
        for (int i = 0; i < 10000; i++) {
            list.add(0, new Object());
        }
    }
}
/*
Время для 10 тысяч вызовов get
*/

class Solution4 {
    public static void main(String[] args) {
        System.out.println(getGetTimeInMs(fill(new ArrayList())));
        System.out.println(getGetTimeInMs(fill(new LinkedList())));
    }

    public static List fill(List list) {
        for (int i = 0; i < 10000; i++) {
            list.add(new Object());
        }
        return list;
    }

    public static long getGetTimeInMs(List list) {
        Date one=new Date();

        get10000(list);
           Date two=new Date();
        return two.getTime()-one.getTime();

    }

    public static void get10000(List list) {
        if (list.isEmpty()) {
            return;
        }
        int x = list.size() / 2;

        for (int i = 0; i < 10000; i++) {
            list.get(x);
        }
    }
}
/*
Квартет «Методы»
*/

 class Solution5 {
    public static List getListForGet() {
        return new ArrayList();

    }

    public static List getListForSet() {
        return new ArrayList();

    }

    public static List getListForAddOrInsert() {
     return new LinkedList();

    }

    public static List getListForRemove() {
        return new LinkedList();

    }

    public static void main(String[] args) {

    }
}
/*
Cамая длинная последовательность
*/
class Solution6 {
    public static void main(String[] args) throws IOException {
        List<Integer>list=new ArrayList<>();
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i <10 ; i++) {
            System.out.print("Enter: ");
            list.add(Integer.parseInt(reader.readLine()));
        }
        int count=1;
        int count2=1;
        for (int i = 0; i <list.size() ; i++) {

            for (int j = 0; j <list.size()-1 ; j++) {
                if(list.get(j)==list.get(j+1)){
                    count++;
                }
            }
           if(count>count2) {
               count2 = count;
           }
                  count=1;
        }

        System.out.println(count2);

    }
}
/*
20 слов на букву «Л»
*/

class Solution7 {
    public static Set<String> createSet() {
      Set<String> set=new HashSet<>();
       set.add("лес");
       set.add("луч");
       set.add("лен");
       set.add("лев");
       set.add("лабаз");
       set.add("лицо");
       set.add("лира");
       set.add("лаперуз");
       set.add("лекало");
       set.add("луг");
       set.add("лопата");
       set.add("лавка");
       set.add("лево");
       set.add("лист");
       set.add("лекарство");
       set.add("лузга");
       set.add("лимон");
       set.add("лье");
       set.add("луидор");
       set.add("лом");
       set.add("лама");
       set.add("лыко");
       set.add("лик");
       set.add("лебурже");
       set.add("ларец");
       set.add("лилия");
      return  set;
    }

    public static void main(String[] args) {

    }
}
/*
Больше 10? Вы нам не подходите
*/
class Solution8 {
    public static Set<Integer> createSet() {
       Set<Integer>set=new HashSet<>();
        for (int i = 0; i <10 ; i++) {
            set.add((int)(i+Math.random()*5));

        }
        System.out.print(set);
return set;
    }

    public static Set<Integer> removeAllNumbersGreaterThan10(Set<Integer> set) {
        for (Integer z :
                set) {
            if(z>10){
                set.remove(z);
            }

        }
        System.out.println(set);
return set;
    }

    public static void main(String[] args) {

removeAllNumbersGreaterThan10(createSet());
    }
}
/*
Перепись населения
*/

class Solution9 {
    public static Map<String, String> createMap() {
      Map<String,String>map=new HashMap<>();
      map.put("Иванов","Петр");
      map.put("Петров","Петр");
      map.put("Сидоров","Сидор");
      map.put("Вознесенский","Михаил");
      map.put("Белянов","Алексей");
      map.put("Белянова","Светлана");
      map.put("Корчатова","Наталья");
      map.put("Гончаренко","Владимир");
      map.put("Фурса","Елена");
      map.put("Ульянов","Ленин");
      map.put("Королев","Сергей");
       return map;

    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
       int count=0;
        for (Map.Entry<String,String>pair :map.entrySet()
             ) {if(pair.getKey().equals(name)){count++;}

        }
return count;
    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        int count=0;
        for (Map.Entry<String,String> z:map.entrySet()
             ) {if(z.getValue().equals(lastName)){
                 count++;
        }

        }
return count;
    }

    public static void main(String[] args) {
        for (Map.Entry<String, String> pair:
       createMap().entrySet()){
            System.out.println(pair.getKey()+" "+pair.getValue());
        }
        System.out.println(getCountTheSameFirstName(createMap(),"Иванов"));
        System.out.println(getCountTheSameLastName(createMap(),"Петр"));
    }
}
/*
Добрая Зинаида и летние каникулы
*/

class Solution10 {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Сталлоне", dateFormat.parse("MAY 1 2012"));
        map.put("Петровский", dateFormat.parse("JUNE 1 2012"));
        map.put("Высотников", dateFormat.parse("JULY 1 2012"));
        map.put("Брукхаймер", dateFormat.parse("APRIL 1 2012"));
        map.put("Нагиев", dateFormat.parse("JANUARY 1 2012"));
        map.put("Сталеваров", dateFormat.parse("AUGUST 1 2012"));
        map.put("Плотников", dateFormat.parse("SEPTEMBER 1 2012"));
        map.put("Высоцкий", dateFormat.parse("MARCH 1 2012"));
        map.put("Старинов", dateFormat.parse("DECEMBER 1 2012"));
        map.put("Губошлепов", dateFormat.parse("FEBRUARY 1 2012"));

        return map;
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
//        for (Map.Entry<String,Date> z:map.entrySet()
//                        ) {int num=z.getValue().getMonth();
//            if(num>4 && num<8){
//               map.remove(z.getKey());
//            }
//
//        }

        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
        Map.Entry<String, Date> pair = iterator.next();
            int num=pair.getValue().getMonth();
            if(num>4 && num<8){iterator.remove();

            }
        }
    }

    public static void main(String[] args) throws ParseException {
        Map<String, Date> map =createMap();
        System.out.print(map);
        System.out.println();
        removeAllSummerPeople(map);
        System.out.println(map);
    }
}
/*
Нам повторы не нужны, тут нужно удалить вообще всех людей, которые повторяются, никого из них не оставлять
*/
class Solution11 {
    public static Map<String, String> createMap() {
        Map<String,String>map=new HashMap<>();
        map.put("Иванов","Петр");
        map.put("Петров","Петр");
        map.put("Сидоров","Сидор");
        map.put("Вознесенский","Михаил");
        map.put("Белянов","Алексей");
        map.put("Белянова","Светлана");
        map.put("Корчатова","Наталья");
        map.put("Гончаренко","Владимир");
        map.put("Фурса","Елена");
        map.put("Ульянов","Ленин");
        map.put("Королев","Сергей");
        return map;
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
//
        ArrayList list=new ArrayList(map.values());
        for (int i = 0; i <list.size() ; i++) {
            String name=(String) list.get(i);
            int count=0;
            for (int j = 0; j <list.size() ; j++) {
                if(name.equals(list.get(j)))
                     count++;
                if(count>1){
                    removeItemFromMapByValue(map, (String) list.get(j));
                    break;
                }
            }


        }

    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {
        Map<String,String>map=createMap();
        System.out.print(map);
        System.out.println();
       removeTheFirstNameDuplicates(map);
        System.out.println(map);

    }
}








