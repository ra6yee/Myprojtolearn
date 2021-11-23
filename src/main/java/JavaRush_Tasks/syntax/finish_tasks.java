package src.java.JavaRush_Tasks.syntax;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class finish_tasks {
    public static void main(String[] args) {

    }
}
/*
Правильный ответ: d = 2.941
*/

 class Solution100 {
    public static void main(String[] args) {
        int a = 50;
        int b = 17;
        double d =(double) a / b;
        System.out.println(d);
    }
}
/*
Правильный ответ: d = 1.0
*/
class Solution102 {
    public static void main(String[] args) {
        int a = 257;
        int b = 4;
        int c = 3;
        int e = 2;
        double d =(byte) a + b / c / e;

        System.out.println(d);
    }
}
/*
Большая зарплата
*/

 class Solution103 {
    public static void main(String[] args) {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";
//String subS=s.substring(1);
  //      System.out.println(subS);
        for (int i = 0; i <40 ; i++) {
            System.out.println(i+1+" "+s.substring(i));

        }
       // repeat(40, () -> System.out.println(s));

    }

}
class RepeatDemo {
    public static void main(String[] args) {
        // Повтор одной строки
        repeat(10, () -> System.out.println("HELLO"));

        // Повтор нескольких строк
        repeat(10, () -> {
            System.out.println("HELLO");
            System.out.println("WORLD");
        });
    }

    static void repeat(int n, Runnable r) {
        for (int i = 0; i < n; i++)
            r.run();
    }
}
/*
Количество букв
*/

class Solution104 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Алфавит
        List<Character> alphabet = Arrays.asList(
                'а','б','в','г','д','е','ё','ж',
                'з','и','й','к','л','м','н','о',
                'п','р','с','т','у','ф','х','ц',
                'ч','ш','щ','ъ','ы','ь','э','ю','я');

        // Ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }

        Map<Character,Integer>map=new LinkedHashMap<>();
        for (int i = 0; i <alphabet.size() ; i++) {
            map.put(alphabet.get(i),0);

        }
      //  System.out.println(map);

        for (int i = 0; i <list.size() ; i++) {
            String s=list.get(i);
           char[] ss= s.toCharArray();
            try {
                for (int j = 0; j <ss.length ; j++) {
                       int key_value=map.get(ss[j]);
                         key_value++;
                         map.put(ss[j],key_value);
                  //  System.out.println(key_value);


                }
            } catch (NullPointerException e) {
                System.out.println("введенные данные неверны!!! Это не латинница! Это не буквы!!");
                System.exit(12);
            }

        }
       map.forEach((key,value)-> System.out.println(key+"-"+value));
        }
    
    }

/*
Массив списков строк
*/

class Solution105 {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
       ArrayList<String> [] list=new ArrayList[2];
String one="dfdsf";
ArrayList<String>oneList=new ArrayList<>();
ArrayList<String>twoList=new ArrayList<>();
oneList.add("kushdfjsd");
oneList.add("sdfdsfds");
twoList.add("dfsdfsd");
twoList.add("sdfsdfjh");
       //list[0]=new ArrayList<String>();
list[0]=oneList;
list[1]=twoList;
        return list;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}

/*
Одинаковые слова в списке
*/

class Solution106 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> words = new ArrayList<String>();
words.add("Привет");
words.add("Привет");
words.add("Пока");
words.add("Осень");
words.add("Кружка");
words.add("Снег");
words.add("процессор");
words.add("сопромат");
words.add("тема");
words.add("вода");
words.add("мясо");
words.add("гербарий");
words.add("гербарий");
words.add("гербарий");
words.add("гербарий");
words.add("референдум");
words.add("актер");
words.add("церковь");
words.add("яблоко");
words.add("блок");
words.add("серво");
words.add("меч");
words.add("мост");
//        for (String a:words
//                  ) {
//            System.out.println(a);
//
//        }

//        for (int i = 0; i < 20; i++) {
//            words.add(reader.readLine());
//        }

        Map<String, Integer> map = countWords(words);

        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }

    public static Map<String, Integer> countWords(ArrayList<String> list) {
        HashMap<String, Integer> result = new HashMap<String, Integer>();

        for (int i = 0; i <list.size() ; i++) {
            String one=list.get(i);
            int count=1;
           result.putIfAbsent(one,count);
            for (int j = 0; j <list.size() ; j++) {
                if(one==list.get(j)){

                    result.put(one,count++);}

            }

        }



        return result;
    }

}






