package Коллекции_массивы;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
это описание и примеры работы с массивами, не с коллекциями.
— Основные факты о массивах:

1) Java массив состоит из множества ячеек.

2) Доступ к конкретной ячейке идёт через указание её номера.

3) Все ячейки одного типа.

4) Начальное значение для всех ячеек – null, для примитивных типов – 0, 0.0 (для дробных), false (для типа boolean).
 Точно такое же, как и у простых неинициализированных переменных.

5) String[] list — это просто объявление переменной.
 Сначала нужно создать массив (контейнер) и положить его в эту переменную, а потом уже им пользоваться. См. пример ниже.

6) Когда мы создаём объект массив (контейнер), нужно указать, какой он длины – сколько в нем ячеек.
 Это делается командой вида: new TypeName[n];
 */
public class array_one {
    public static void main(String[] args) {
        String[] list = new String[5];
        int length=list.length;
        // заплним массив
        list[1] = "green";
        list[2]="black";
        list[3]="blue";
        list[4]="red";
        list[0]="white";
        String s = list[1];
           // выведем все элементы массива в консоль используя перебор for each
        for (String x:list) { System.out.println(x); }
        System.out.println(length);
        //можно вывести массив в таком цикле
        for (int i = 0; i < list.length; i++)
        {
            System.out.println(list[i]);
        }

    }
}
////////////////////////////////////////////////////////////////////////

 //   Заполнение массива из 10 чисел, числами от 1 до 10:
 class MainClass1
{
    public static void main(String[] args)
    {
       int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++)
        {
            numbers[i] = i + 1;
        }
    ///////////////////////////
        int i=0;
        for (int x:numbers  // не работает
             ) {
            i++;

        }
        for (int x:numbers
             ) {
            System.out.println(x);

        }
    }
}
   // Заполнение массива из 10 чисел, числами от 10 до 1:
class MainClass2
{
    public static void main(String[] args)
    {
        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++)
        {
            numbers[i] = 10 - i;
        }
    }
}
   // Заполнение массива из 10 чисел, числами от 0 до 9:
 class MainClass3
{
    public static void main(String[] args)
    {
        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++)
        {
            numbers[i] = i;
        }
    }
}
  //  Заполнение массива из 10 чисел, числами от 9 до 0:
 class MainClass4
{
    public static void main(String[] args)
    {
        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++)
        {
            numbers[i] = 9 - i;
        }
    }
}
//Пример 2.
//        Ввод 10 строк с клавиатуры
class MainClass5
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] list = new String[10];

        for (int i = 0; i < list.length; i++)
        {
            list[i] = reader.readLine();
        }
    }
}
//Ввод 10 чисел с клавиатуры
class MainClass6
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] list = new int[10];

        for (int i = 0; i < list.length; i++)
        {
            String s = reader.readLine();
            list[i] = Integer.parseInt(s);
        }
    }
}
//Пример 3.
//        Вывод массива на экран
class MainClass7
{
    public static void main(String[] args) throws IOException
    {
        int[] list = new int[10];

        //заполнение массива
        for (int i = 0; i < list.length; i++)
            list[i] = i;

        //вывод на экран
        for (int i = 0; i < list.length; i++)
            System.out.println(list[i]);
    }
}
//Пример 4.
//        Быстрая (статическая) инициализация. Сумма элементов массива:
 class MainClass8
{
    public static void main(String[] args) throws IOException
    {
        //это статическая инициализация
        int[] list = {5, 6, 7, 8, 1, 2, 5, -7, -9, 2, 0};

        //подсчёт суммы элементов
        int sum = 0;
        for (int i = 0; i < list.length; i++)
            sum += list[i];

        System.out.println("Sum is " + sum);
    }
}
//Пример 5.
//        Поиск минимального элемента в массиве:
class MainClass9
{
    public static void main(String[] args) throws IOException
    {
        int[] list = {5, 6, 7, 8, 1, 2, 5, -7, -9, 2, 0};

        int min = list[0];
        for (int i = 1; i < list.length; i++)
        {
            if (list[i] < min)
                min = list[i];
        }

        System.out.println ("Min is " + min);
    }
}