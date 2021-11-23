package src.java.Compare;

import java.util.*;

public class code_Sample_Comporator {
}
/*
Почитать в инете про медиану выборки
Реализуй логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы.
Верни отсортированный массив от минимального расстояния до максимального.
Если удаленность одинаковая у нескольких чисел, то сортируй их в порядке возрастания.
Пример входящего массива:
13, 8, 15, 5, 17
медиана - 13
Отсортированный масив:
13, 15, 17, 8, 5
Требования:
•
Программа не должна выводить текст в консоль.
•
Программа не должна считывать данные с консоли.
•
Класс Solution должен содержать публичный статический метод Integer[] sort(Integer[] array).
•
Метод sort(Integer[] array) класса Solution должен сортировать данные в массиве по удаленности от его медианы.

*/
 class Solution {

    public static void main(String[] args) {
Integer[] array={13, 14, 15, 10, 10, 12, 10, 12, 13};
array=sort(array);
        for (int i = 0; i <array.length ; i++) {
            System.out.println(array[i]);
        }
    }

    public static Integer[] sort(Integer[] array) {
       //сортируем массив
        Arrays.sort(array);
        //находим медиану
        int mediana=0;
        if(!(array.length%2==0)){
            mediana=array[array.length/2];
        }else{
            mediana=(array[array.length/2]+array[array.length/2-1])/2;
        }
        System.out.println("медиана: "+mediana);
      //медиану находим четко, теперь необходимо написать сам компаратор,
        // но что выбрать?, какой интерфейс. или класс.

        int finalMediana1 = mediana;
        Comparator<Integer> comparable1=new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
               int scope=(finalMediana1 -o1)+(finalMediana1-o2);// я это сделал наугад.Но надо с этим разобраться.
            //  int scope=Math.abs(finalMediana1 - 01) - Math.abs(finalMediana1 - o2);// по моему, это не верно
               if (scope==0){
                   return o2;
               }
                return scope;
            }


      };
         Arrays.sort(array,comparable1);
         Collections.reverse(Arrays.asList(array));
        return array;
    }
}


/*
Был бы ум - будет и успех
Солдаты всегда строились, строятся и будут строиться по убыванию роста.
Отсортируй солдат, предварительно подумав, что лучше использовать при таких условиях - Comparable или Comparator.
Требования:
•
Класс Soldier должен содержать приватные поля String name и int height.
•
Класс Soldier должен содержать конструктор с двумя параметрами String name и int height.
•
Подумай, что лучше использовать, и реализуй Comparable или Comparator.
•
Класс Soldier должен содержать метод compareTo(Soldier solder).
•
Метод compareTo(Soldier solder) должен сравнивать двоих солдат, учитывая только их рост. Сравнивать объекты нужно с учетом убывания роста солдат.

Занчит тут надо с нуля создать метод сортировки, задача уровня изи, но именно такая задача и будет встречаться в работе.
*/
class Solution12 {
    public static void main(String[] args) {
        Set<Soldier> soldiers = new TreeSet<>();
        soldiers.add(new Soldier("Ivanov", 170));
        soldiers.add(new Soldier("Petrov", 180));
        soldiers.add(new Soldier("Sidorov", 175));

        for (Soldier soldier : soldiers) {
            System.out.println(soldier.name);
        }
    }

    public static class Soldier implements Comparable{
        private String name;
        private int height;

        public Soldier(String name, int height) {
            this.name = name;
            this.height = height;
        }



        @Override
        public int compareTo(Object o) {
           Soldier entry=(Soldier)o;
            return entry.height-this.height;
        }
    }
}
/*
Убежденному убеждать других не трудно
В таблице есть колонки, по которым можно сортировать.
Пользователь имеет возможность настроить под себя список колонок, которые будут сортироваться.
Напиши public static компаратор CustomizedComparator, который будет:
1. В конструкторе принимать массивкомпараторов.
2. Сортировать данные в порядке, соответствующем последовательности компараторов.
Все переданные компараторы сортируют дженерик тип Т.
В конструктор передается как минимум одинкомпаратор.
Требования:
•
Класс Solution должен содержать public static компаратор CustomizedComparator.
•
Класс CustomizedComparator должен содержать приватное поле comparators типа Comparator<T>[].
•
Класс CustomizedComparator должен содержать конструктор с параметром vararg компараторов.
•
Метод compare() класса CustomizedComparator должен сравнивать объекты в порядке, соответствующем последовательности компараторов comparators.


*/
 class Solution4 {
public static class CustomizedComparator<T> implements Comparator<T>{
private Comparator<T>[] comparator;
    @Override
    public int compare(T o1, T o2) {
       int result=2;
      // while (!(result==0)){

        for (Comparator z:comparator
                ) {
                result=2;
                    result=z.compare(o1, o2);
                    if(result==0)
                        break;

           }



        return result;
    }

    public CustomizedComparator(Comparator... comparator) {
        this.comparator = comparator;
    }
}
    public static class TestClass {
        public String x;
        public String y;
        public String z;
        public TestClass(String x, String y, String z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
        public void consoleout(){
            System.out.println(x+" "+y+" "+z);

        }
    }

    public static void main(String[] args) {
        TestClass first=new TestClass("aaa","bbb","ccc");
        TestClass second=new TestClass("baa","acc","hrt");
        TestClass third=new TestClass("adaa","cffcc","aasdfa");
        ArrayList<TestClass> list=new ArrayList<>();
        list.add(first);list.add(second);list.add(third);

        Collections.sort(list,new CustomizedComparator<TestClass>(new Comparator<TestClass>() {
            @Override
            public int compare(TestClass o1, TestClass o2) {
                return o1.x.compareTo(o2.x);
            }
        }, new Comparator<TestClass>() {
            @Override
            public int compare(TestClass o1, TestClass o2) {
                return o1.y.compareTo(o2.y);
            }
        }, new Comparator<TestClass>() {
            @Override
            public int compare(TestClass o1, TestClass o2) {
                return o1.z.compareTo(o2.z);
            }
        }));

        for (TestClass test:list) {
            test.consoleout();
        }
    }
}
//по идее, так должно быть.Ошибка в том, что пытался сразу в конструкторе передать какой то массив компараторов готовый.
