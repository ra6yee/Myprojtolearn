package src.java.Рекурсия;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class tasc {
}
//    Почитай про числа Фибоначчи.
//        Реализуй рекурсивную логику метода fibonacci, где n - это номер элемента в последовательности Фибоначчи.
//        Не создавай в классе Solutionдополнительные поля.
//        Требования:
//        •
//        В классе Solution не должны быть созданы дополнительные поля.
//        •
//        Метод fibonacci должен принимать порядковый номер искомого числа последовательности Фибоначчи и возвращать его значение.
//        •
//        Метод fibonacci не должен быть статическим.
//        •
//        Метод fibonacci должен быть рекурсивным.

/*
Числа Фибоначчи с помощью рекурсии
*/
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

      System.out.println(solution.fibonacci(9));     //34
        System.out.println(solution.fibonacci(5));     //5
        System.out.println(solution.fibonacci(2));     //1
        System.out.println(solution.fibonacci(1));     //1
    }

    public int fibonacci(int n) {
//        int count=1;
//       int begin=1;
//        int end=0;
//        end=begin+end;
//        count++;
//        if(count!=n){
//            fibonacci( n-count);
//        }
//        for (int i = 0; i <n ; i++) {
//             end+=begin;
//        }
        if(n==0){
            return 0;
        }else
                if(n==1){
                    return 1;
                } else return fibonacci(n-1)+fibonacci(n-2) ;
    }
}
//    Почитай про вычисление факториала-это произведение всех натуральных чисел в ряд.
//        Реализуй рекурсивную логику метода factorial, где n - это число, факториал которого нужно вычислить.
//        Не создавай в классе Solutionдополнительные поля.
//        Требования:
//        •
//        В классе Solution не должны быть созданы дополнительные поля.
//        •
//        Метод factorial должен возвращать факториал числа принятого в качестве параметра.
//        •
//        Метод factorial не должен быть статическим.
//        •
//        Метод factorial должен быть рекурсивным.

/*
Факториал с помощью рекурсии
*/
 class Solution1 {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        System.out.println(solution.factorial(9));     //362880
        System.out.println(solution.factorial(0));     //1
        System.out.println(solution.factorial(1));     //1
    }

    public int factorial(int n) {
        if(n==0||n==1){
            return 1;
        }else
        return n*factorial(n-1);
    }
}
//    Разложить целое число n > 1 на простые множители.
//        Вывести в консоль через пробел все множители в порядке возрастания.
//        Написать рекурсивный метод для вычисления простых множителей.
//        Не создавай в классе Solutionдополнительные поля.
//        Пример:
//        132
//        Вывод на консоль:
//        2 2 3 11
//        Требования:
//        •
//        В классе Solution не должны быть созданы дополнительные поля.
//        •
//        Метод recurse должен выводить на экран все простые множители числа полученного в качестве параметра (пример в условии).
//        •
//        Метод recurse не должен быть статическим.
//        •
//        Метод recurse должен быть рекурсивным.

/*
Разложение на множители с помощью рекурсии
*/
 class Solution3 {
    public static void main(String[] args) {
        recurse(132);
    }
    public static void recurse(int n) {
        int i=2;
        if(n/i==1);
    }
}
//    Разберись в примере.
//        Внутри метода main после создания объекта типа Monkey создай слабую ссылку (WeakReference) на него.
//        Требования:
//        •
//        В методе main должен быть создан объект типа Monkey с именем "Simka".
//        •
//        В методе main должен быть создан WeakReference на объект monkey.
//        •
//        Класс Monkey должен быть публичным.
//        •
//        Класс Monkey должен быть статическим.


/*
Слабые ссылки
*/
class Solution2 {
    public static Helper helper = new Helper();

    public static class Monkey {
        private String name;

        public Monkey(String name) {
            this.name = name;
        }

        protected void finalize() {
            Helper.isFinalized = true;
            System.out.format("Bye-Bye, %s!\n", name);
        }
    }

    public static void main(String args[]) throws InterruptedException {
        helper.startTime();

        Monkey monkey = new Monkey("Simka");
        WeakReference<Monkey> reference=new WeakReference<Monkey>(monkey);
        //Add reference here

        helper.callGC();

        monkey = null;

        helper.callGC();
        helper.consumeHeap();

        if (reference.get() == null)
            System.out.println("Finalized");

        helper.finish();
    }

    public static class Helper {
        public static boolean isFinalized;

        private long startTime;

        void startTime() {
            this.startTime = System.currentTimeMillis();
        }

        int getTime() {
            return (int) (System.currentTimeMillis() - startTime) / 1000;
        }

        void callGC() throws InterruptedException {
            System.gc();
            Thread.sleep(1000);
        }

        void consumeHeap() {
            try {
                List<Solution> heap = new ArrayList<Solution>(100000);
                while (!isFinalized) {
                    heap.add(new Solution());
                }
            } catch (OutOfMemoryError e) {
                System.out.println("An out-of-memory exception has occurred");
            }
        }

        public void finish() {
            System.out.println("Done");
            System.out.println("It took " + getTime() + " s");
        }
    }
}
//    На вход подается строка - математическое выражение.
//        Выражение включает целые и дробные числа, скобки (), пробелы, знак отрицания -, возведение в степень ^, sin(x), cos(x), tan(x)
//        Для sin(x), cos(x), tan(x) выражение внутри скобок считать градусами, например, cos(3 + 19*3)=0.5
//        Степень задается так: a^(1+3) и так a^4, что эквивалентно a*a*a*a.
//        С помощью рекурсии вычислить выражение и количество математических операций. Вывести через пробел результат в консоль.
//        Результат выводить с точностью до двух знаков, для 0.33333 вывести 0.33, использовать стандартный принцип округления.
//        Знак отрицания перед числом также считать математической операцией.
//        Не создавай в классе Solution дополнительные поля.
//        Не пиши косвенную рекурсию.
//        Пример, состоящий из операций sin * - + * +:
//        sin(2*(-5+1.5*4)+28)
//        Результат:
//        0.5 6
//        Пример, состоящий из операций tan ^:
//        tan(2025 ^ 0.5)
//        Результат:
//        1 2
//        Требования:
//        •
//        В классе Solution не должны быть созданы дополнительные поля.
//        •
//        Метод recurse должен выводить на экран результат вычисления заданного выражения (пример в условии).
//        •
//        Метод recurse не должен быть статическим.
//        •
//        Метод recurse должен быть рекурсивным.
//

/*
Рекурсия для мат. выражения
*/
class Solution32 {
    public static void main(String[] args) {
        Solution32 solution = new Solution32();
        solution.recurse("sin(2*(-5+1.5*4)+28)", 0); //expected output 0.5 6
    }

    public void recurse(final String expression, int countOperation) {
    //    List[] oper=new List[expression.split("//d")];
char[] chars=expression.toCharArray();

    }

    public Solution32() {
        //don't delete
    }
}
