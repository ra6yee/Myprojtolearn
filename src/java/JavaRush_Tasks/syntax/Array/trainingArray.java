package src.java.JavaRush_Tasks.syntax.Array;

import com.sun.org.apache.xml.internal.utils.res.XResources_zh_CN;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import sun.awt.windows.WBufferStrategy;

import javax.jws.Oneway;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.nio.Buffer;
import java.nio.BufferUnderflowException;
import java.util.*;

public class trainingArray {
}
/*
Массивный максимум
*/

class Solution {
    public static void main(String[] args) throws Exception {
        int[] array = initializeArray();
        int max = max(array);
        System.out.println(max);
    }

    public static int[] initializeArray() throws IOException {
       int[]arrayInt=new int[10];
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i <10 ; i++) {
            System.out.println("Enter the number: ");
            arrayInt[i]=Integer.parseInt(reader.readLine());

        }
        return arrayInt;
    }

    public static int max(int[] array) {
        int k=0;
        for (int j = 0; j <array.length ; j++) {
            if(array[j]>k){ k=array[j];

            }

        }
        return k;
    }
}
/*
Массив из строчек в обратном порядке
*/

class Solution2 {
    public static void main(String[] args) throws Exception {
        String[] array=new String[10];
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i <8 ; i++) {
               array[i]=reader.readLine();
        }
        for (int i = array.length; i >0 ; i--) {
            System.out.println(array[i-1]);

        }
    }
}
/*
Общение одиноких массивов
*/

class Solution3 {
    public static void main(String[] args) throws Exception {
        int[] numbers=new int[10];
        String[] strings=new String[10];
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i <10 ; i++) {
            strings[i]=reader.readLine();
            int x=strings[i].length();
            numbers[i]=x;
        }
        for (int a:numbers
             ) {
            System.out.println(a);

        }
    }
}
/*
Переверни массив
*/

class Solution4 {
    public static void main(String[] args) throws Exception {
       int[] array=new int[10];
       BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i <10 ; i++) {
            System.out.print("введите число: ");
            array[i]=Integer.parseInt(reader.readLine());
        }

        for (int i = array.length; i >0 ; i--) {
            System.out.println(array[i-1]);

        }
    }
}
/*
Что за список такой?
*/

class Solution5 {
    public static void main(String[] args) throws IOException {
        ArrayList<String>list=new ArrayList();
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i <5 ; i++) {
            System.out.print("Введите строку: ");
              list.add(reader.readLine());
        }
        System.out.println("Размер списка : "+list.size());
        for (String x:list
             ) {
            System.out.println(x);

        }
    }
}
/*
Самая длинная строка
*/

class Solution6 {
    private static ArrayList<String> strings;

    public static void main(String[] args) throws Exception {
        strings=new ArrayList();
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i <5 ; i++) {
            strings.add(reader.readLine());
        }
           int sizeOfString=0;
        for (int i = 0; i <strings.size() ; i++) {
            if(strings.get(i).length()>sizeOfString){
                sizeOfString=strings.get(i).length();
            }
        }
        for (String z:strings
             ) {if(z.length()==sizeOfString){
            System.out.println(z);
        }

        }
    }
}
/*
Выражаемся покороче
*/

class Solution7 {
    public static void main(String[] args) throws Exception {
        ArrayList<String>list=new ArrayList();
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i <5 ; i++) {
            System.out.println("Enter: ");
            list.add(reader.readLine());
        }
    int min=list.get(0).length();
        for (int i = 1; i <list.size() ; i++) {
            if(min>list.get(i).length()){
                min=list.get(i).length();
            }
        }
        for (String x:list
        ) {if((x.length()==min)) System.out.println(x);
        }
    }
}
/*
В начало списка
*/

class Solution8 {
    public static void main(String[] args) throws Exception {
        ArrayList<String>list=new ArrayList();
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i <10 ; i++) {
            System.out.print("enter: ");
              list.add(0,reader.readLine());
        }
        for (String x:list
             ) {
            System.out.println(x);

        }
    }
}
/*
Удалить и вставить
*/

class Solution9 {
    public static void main(String[] args) throws Exception {
        ArrayList<String>list=new ArrayList();
                BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i <5 ; i++) {
            System.out.println("enter: ");
            list.add(reader.readLine());
        }
        for (int i = 0; i <13 ; i++) {
                String z=list.get(list.size()-1);
                list.remove(list.size()-1);
                list.add(0,z);
        }
        for (String a:list
             ) {
            System.out.println(a);

        }
    }
}
/*
Играем в Jолушку
*/

 class Solution10 {
    public static void main(String[] args) throws Exception {
       ArrayList<Integer>totalList=new ArrayList();
       ArrayList<Integer>oddList=new ArrayList();
       ArrayList<Integer>eddList=new ArrayList();
       BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i <20 ; i++) {
            System.out.println("enter: ");
            totalList.add(Integer.parseInt(reader.readLine()));
        }
        for (int i = 0; i <totalList.size() ; i++) {
            if(totalList.get(i)%3==0){
                oddList.add(totalList.get(i));
            }
            if(totalList.get(i)%2==0){
                eddList.add(totalList.get(i));
            }

        }
   printList(totalList);
   printList(oddList);
   printList(eddList);
    }

    public static void printList(ArrayList<Integer> list) {
        for (int z:list
             ) {
            System.out.println(z);

        }
    }
}

/*
Слова в обратном порядке
*/

class Solution11 {
    public static void main(String[] args) throws Exception {
        ArrayList<String>list=new ArrayList<String>();
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i <5 ; i++) {
            System.out.println("enter: ");
            list.add(reader.readLine());
        }
    list.remove(2);
        Collections.reverse(list);
        for (String a :
                list) {
            System.out.println(a);
        }
    }
}
/*
Продолжаем мыть раму
*/

class Solution12 {
    public static void main(String[] args) {
        ArrayList<String>list=new ArrayList<String>();
        Collections.addAll(list,"мама","мыла","раму");

        for (int i = 1; i <6 ; i+=2) {
            list.add(i,"именно");
        }
        for (String z :
                list) {
            System.out.println(z);

        }
    }
}
/*
Р или Л
*/

class Solution13 {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("роза");
        strings.add("лоза");
        strings.add("лира");
        strings = fix(strings);

        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> strings) {
        //напишите тут ваш код
        return null;
    }
}

/*
Set из растений
*/



class Solution14 {
    public static void main(String[] args) {
        Set<String>set=new HashSet();
        Collections.addAll(set,"арбуз","банан","груша","дыня","яблоко","вишня","ежевика","женьшень","ирис","картофель");
        //это сокращенный итератор
        for (String a :
                set) {
            System.out.println(a);
        }
        // полный код с итератором
        Iterator<String>iterator=set.iterator();
        while(iterator.hasNext()){
            String a=iterator.next();
            System.out.println(a);
        }
    }
}
/*
Map из 10 пар
*/



class Solution15 {
    public static void main(String[] args) {
        Map<String,String>map=new HashMap<String, String>();
map.put("арбуз","ягода");
map.put("банан","трава");
map.put("вишня","ягода");
map.put("груша","фрукт");
map.put("дыня","овощ");
map.put("ежевика","куст");
map.put("женьшень","корень");
map.put("земляника","ягода");
map.put("ирис","цветок");
map.put("картофель","клубень");
Iterator<Map.Entry<String,String>>iterator_map=map.entrySet().iterator();
while(iterator_map.hasNext()){
    Map.Entry<String,String> pair=iterator_map.next();
            String key=pair.getKey();
    String volume=pair.getValue();
    System.out.println(key+"-"+volume);
}

    }
}
/*
Коллекция Map из котов
*/

class Solution16 {
    public static void main(String[] args) throws Exception {
        String[] cats = new String[]{"васька", "мурка", "дымка", "рыжик", "серый", "снежок", "босс", "борис", "визя", "гарфи"};

        Map<String, Cat> map = addCatsToMap(cats);

        for (Map.Entry<String, Cat> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }
    }


    public static Map<String, Cat> addCatsToMap(String[] cats) {

Map<String,Cat>map=new HashMap();
        for (int i = 0; i <cats.length ; i++) {
           map.put(cats[i],new Cat(cats[i]) );

        }

return map;
    }


    public static class Cat {
        String name;

        public Cat(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name != null ? name.toUpperCase() : null;
        }
    }
}
/*
Вывести на экран список ключей
*/

class Solution17 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap();
        map.put("Sim", "Sim");
        map.put("Tom", "Tom");
        map.put("Arbus", "Arbus");
        map.put("Baby", "Baby");
        map.put("Cat", "Cat");
        map.put("Dog", "Dog");
        map.put("Eat", "Eat");
        map.put("Food", "Food");
        map.put("Gevey", "Gevey");
        map.put("Hugs", "Hugs");

        printKeys(map);
    }

    public static void printKeys(Map<String, String> map) {

       Iterator<Map.Entry<String,String>>iterator=map.entrySet().iterator();
       while(iterator.hasNext()){
        Map.Entry<String,String >pair=iterator.next();
           System.out.println(pair.getKey());
       }
    }
}
/* 
На экране — значения!
*/

class Solution18 {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap();
        map.put("Sim", "Sim");
        map.put("Tom", "Tom");
        map.put("Arbus", "Arbus");
        map.put("Baby", "Baby");
        map.put("Cat", "Cat");
        map.put("Dog", "Dog");
        map.put("Eat", "Eat");
        map.put("Food", "Food");
        map.put("Gevey", "Gevey");
        map.put("Hugs", "Hugs");

        printValues(map);
    }

    public static void printValues(Map<String, String> map) {
      Iterator<Map.Entry<String,String>>iterator=map.entrySet().iterator();
      while(iterator.hasNext()){
          Map.Entry<String,String>pair=iterator.next();
          System.out.println(pair.getValue());
      }
    }
}

/*
Коллекция Map из Object
*/

class Solution19 {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap();
        map.put("Sim", 5);
        map.put("Tom", 5.5);
        map.put("Arbus", false);
        map.put("Baby", null);
        map.put("Cat", "Cat");
        map.put("Eat", new Long(56));
        map.put("Food", new Character('3'));
        map.put("Gevey", '6');
        map.put("Hugs", 111111111111L);
        map.put("Comp", (double) 123);
        for(Map.Entry<String,Object>pair:map.entrySet()){
            System.out.println(pair.getKey()+"-"+pair.getValue());
        }


    }
}



