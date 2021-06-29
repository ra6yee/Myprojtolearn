package Static_Block;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*

А что такое статический блок?

— Если для инициализации переменных объекта нужно выполнить сложный код (например, что-то загрузить из файла),
мы можем сделать это в конструкторе. Статические переменные такой возможности лишены.
Но т.к. потребность в этом осталась, в классы можно добавить статический блок или блоки,
 которые по сути своей эквивалентны вызову статических конструкторов.

 */
public class static_block {

}
/*
Статики-1
В статическом блоке инициализировать labels 5 различными парами ключ-значение.
*/

class Solution50 {
    public static Map<Double, String> labels = new HashMap<Double, String>();
 //нужно мапу, которую заполняем, расположить раньше чем блок статик.тогда она инициализируется.
    static {
labels.put(21.0,"Hello");
labels.put(1.0,"By-BY");
labels.put(32.32,"Hi");
labels.put(98.23,"whatsApp");
labels.put(28.1,"why");
    }



    public static void main(String[] args) {
        System.out.println(labels);
    }
}

/*
Статики-2
1. В статическом блоке считайте две переменные с консоли А и В с типом int.
2. Не забыть про IOException, который надо обработать в блоке catch.12
3. Закрыть поток ввода методом close().

*/
class Solution2 {
    public static int A;
    public static int B;
static {
    BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));

    try {
        A=Integer.parseInt(reader.readLine());
        B=Integer.parseInt(reader.readLine());
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    public static final int MIN = min(A, B);

    public static void main(String[] args) {
        System.out.println(MIN);
    }

    public static int min(int a, int b) {
        return a < b ? a : b;
    }
}
/*
1. В классе Solution создай класс Cat с публичным полем name типа String.
2. В статическом блоке создай объект типа Cat и присвой его переменной cat(не забудь инициализировать поле name).
3. В классе Cat не создавай конструкторы с параметрами.
4. В статическом блоке выведи имя созданного кота на экран.

*/

 class Solution {
    public static Cat cat;

    static class Cat{
       String name;
    }
    static {
        Cat cat1=new Cat();
        cat1.name="Tommy";
        System.out.println(cat1.name);
    }
    public static void main(String[] args) {

    }
}
