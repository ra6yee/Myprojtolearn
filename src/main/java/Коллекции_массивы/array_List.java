package Коллекции_массивы;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

/*
это замена массива, тот же массив, но можно не заботиться о его длине, он сам разростается и можно заполнять элементами\
 в любую ячейку, хоть в начало, ххоть в середину , хоть в конец.

 не используем квадратные скобочки при работе с Class ArrayList. Вместо них мы используем методы get, set и add.

 ArrayList позволяет вставлять данные не только в конец массива, но и в любую ячейку по индексу.
Для этого у него есть два метода:
add(int index, Cat element)
set(int index, Cat element)
В оба ты передаешь индекс ячейки, в которую нужно сделать вставку, и ссылку на сам объект.
Разница в том, что вставка через set() затирает старое значение, хранящееся в ячейке.
А вставка через add() сначала сдвигает все элементы начиная с [index] к концу массива,
 а в образовавшуюся пустую ячейку добавляет нужный тебе объект.

 */
public class array_List {
    public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<String>();
        int sizeOfList = list.size(); // размер списка
        String s = list.get(1);// достать из списка элемент
        String one = "world";
        list.set(1, one);// положили в ячейку один  переменную s
        list.add(one);// этот элемент добавляется в конец списка
        String two = "Hello";
        list.add(0, two);//вставка в начало массива
        list.add(15, "by-by");// вставка в ячейку под номером 15, в 16 место массива списочного
        list.remove(11);// удаление из 11  ячейки

        Reader r = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(r);

//ввод строк с клавиатуры

        for (int i = 0; i < 10; i++) {
            String ss = reader.readLine();
            list.add(ss);
        }

//вывод содержимого коллекции на экран
        for (int i = 0; i < list.size(); i++) {
            int j = list.size() - i - 1;
            System.out.println(list.get(j));
        }
    }
}

class second{
    public static void main(String[] args) {


    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in) );
    ArrayList<Integer> list = new ArrayList<Integer>();

    list.add(1);
            list.add(7);
            list.add(11);
            list.add(3);
            list.add(15);

            for (int i = 0; i < list.size(); ) //убрали увеличение i внутрь цикла
        {
        if (list.get(i) > 5)
        list.remove(i);  //не увеличиваем i, если удалили текущий  элемент!!!!!!!!!!!!!!!!!!!!!!!
        else
        i++;
        }
        }
}


/*
Arrays.sort()
Collections.sort()
 Правильно ли я понимаю, что для массивов мы используем только Arrays, а для коллекций Collections ?

 */