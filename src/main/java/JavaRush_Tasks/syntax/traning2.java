package JavaRush_Tasks.syntax;

import Date_вреия_и_дата.date;
import com.sun.deploy.security.SelectableSecurityManager;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class traning2 {
}
/*
Настя или Настя?
*/


class Solution38 {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter first name: ");
        String oneName = reader.readLine();
        System.out.println("Enter second name: ");
        String twoName = reader.readLine();
        if (oneName.equals(twoName)) {
            System.out.println("имена идентичные");
        } else if (oneName.length() == twoName.length()) {
            System.out.println("длины имен одинаковые");
        }
    }
}

class Solution39 {
    public static void main(String[] args) throws Exception {

    }
}

class Solution40 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the num: ");
        int a = Integer.parseInt(reader.readLine());
        if (a > 0 && a % 2 == 0) {
            System.out.println("Число положительное и четное");
        }
        if (a > 0 && a % 2 != 0) {
            System.out.println("число положительно нечетное");
        }
        if (a < 0 && a % 2 != 0) {
            System.out.println("число отрицательное нечетное");
        }
        if (a < 0 && a % 2 == 0) {
            System.out.println("число отрицательное четное");
        }
        if (a == 0) {
            System.out.println("Число равно нулю");
        }
    }

}

class Solution41 {
    public static void main(String[] args) {
        int a = 10;
        while (a > 0) {
            System.out.println(a);
            a--;
        }

    }
}

class Solution42 {
    public static void main(String[] args) {
        int a = 10, b = 10;
        while (a > 0) {
            while (b > 0) {
                System.out.print("S");
                b--;
            }
            System.out.println();
            a--;
            b = 10;
        }
    }
}


/*
Реализовать метод fight
*/

class Cat43 {
    public int age = 4;
    public int weight = 8;
    public int strength = 10;

    public Cat43(int age, int weight, int strength) {
        this.age = age;
        this.weight = weight;
        this.strength = strength;
    }

    public Cat43() {
    }

    public boolean fight(Cat43 anotherCat) {
        boolean winner = false;
        int win_this = 1;

        if (this.age > anotherCat.age)  win_this++;
        else win_this--;
        if (this.weight > anotherCat.weight) win_this++;
        else win_this--;
        if (this.strength > anotherCat.strength) win_this++;
        else win_this--;
        if (win_this >= 2) winner=true;
        else winner=false;
        return winner;  //напишите тут ваш код
    }

    public static void main(String[] args) {
        Cat43 cat43 = new Cat43();
       // Cat43 cat431=new Cat43(2,4,12);
        cat43.age = 1;
        cat43.weight = 2;
        cat43.strength = 3;
        if (cat43.fight(cat43) == true) {
            System.out.print("Чемпион снова победил ");
        } else
            System.out.println("Победил новичек!!!");

    }
}

/*
Среднее арифметическое
*/

class Solution43 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int count=0;
        int numbers;
        double finish=0;
        while(true) {
            numbers = Integer.parseInt(reader.readLine());
            if (numbers == -1) {
                System.out.println((finish / (count)) );
                break;
            }
            finish += numbers;
            count++;



        }
    }
}
/*
По 50 000 объектов Cat и Dog
*/

 class Solution44 {
    public static void main(String[] args) {
        for (int i = 0; i <500000 ; i++) {
           new Catty();
            new Doggy();
        }
    }
}

class Catty {
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("A Cat was destroyed");
    }
}

class Doggy {
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("A Dog was destroyed");
    }
}
/*
Ставим котов на счётчик
*/

class Cat41 {
    public static int catCount = 0;

    public Cat41() {
        catCount++;
    }
//напишите тут ваш код

    public static void main(String[] args) {
        for (int i = 0; i <2000000 ; i++) {
            new Cat41();
        }
        System.out.println(catCount);
    }
    public void finalize() throws Throwable{
        //super.finalize();
catCount--;
    }
}
/*
Чётные и нечётные циферки
*/

class Solution45 {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the num: ");
        int num=Integer.parseInt(reader.readLine());
       while (num>0) {
           {
               if (num % 2 == 0) {
                   even++;
               } else odd++;
               num = num / 10;
           }
       }
        System.out.println( "Even: "+even+" Odd: "+odd);
    }
}

/*
Статические методы для кошек
*/

 class CatZero {
    private static int catCount =0;

    public CatZero() {
        catCount++;
    }

    public static int getCatCount() {
        return catCount;

    }

    public static void setCatCount(int catCount) {
       CatZero.catCount=catCount;

    }

    public static void main(String[] args) {

    }
}

/*
Расстояние между двумя точками
*/

 class Util {
    public static double getDistance(int x1, int y1, int x2, int y2) {
        double distance=Math.sqrt(Math.pow((x2-x1),2) +Math.pow((y2-y1),2));
    return distance;
    }

    public static void main(String[] args) {
        System.out.println(getDistance(-2,4,8,7));
    }
}

/*
Класс ConsoleReader
*/

class ConsoleReader {
    public static String readString() throws Exception {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        String string=reader.readLine();
        return string;

    }

    public static int readInt() throws Exception {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
  int number=Integer.parseInt(reader.readLine());
  return number;
    }

    public static double readDouble() throws Exception {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
          double munber=Double.parseDouble(reader.readLine());
          return munber;
    }

    public static boolean readBoolean() throws Exception {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
          boolean bool=Boolean.parseBoolean(reader.readLine());
          return bool;
    }

    public static void main(String[] args) throws Exception {
 BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
    }
}

/*
Класс StringHelper
*/

class StringHelper {
    public static String multiply(String s) {
        String result = "";
        for (int i = 0; i <5 ; i++) {
            result+=s;

        }
        return result;
    }

    public static String multiply(String s, int count) {
        String result = "";
        for (int i = 0; i <count ; i++) {
            result+=s;

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(multiply("hello"));
        System.out.println(multiply("by-by",12));
    }
}
/*
Деление на ноль
*/

class Solution46 {

    public static void main(String[] args) {
        try {
            divideByZero();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void divideByZero() {

            int a= 1/0;

    }
}

/*
Обратный отсчёт
*/

class Solution47 {
    public static void main(String[] args) {
        for (int i = 10; i > 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //напишите тут ваш код
        }
    }
}

/*
Метод в try..catch
*/

class Solution48 {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer>list= new LinkedList<>();
        while(true){
            System.out.println("Enter a number: ");
            try {
                list.add(Integer.parseInt(reader.readLine()));

            } catch (NumberFormatException | IOException e) {
                System.out.println("Wrong enter!");
                for (Integer z :
                        list) {
                    System.out.println(z);

                }
                System.exit(0);
            }

        }
    }
}
/*
Какое сегодня число?
*/

class Solution49 {

    public static void main(String[] args) throws Exception {

        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        String dat= "2013-08-18";
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-M-d", Locale.ENGLISH);
        Date date=dateFormat.parse(dat);
        SimpleDateFormat date2Formatter=new SimpleDateFormat("MMM d, yyyy",Locale.ENGLISH);



        System.out.println(date2Formatter.format(date).toUpperCase());

    }
}

/*
Гласные и согласные
*/

class Solution50 {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
       String str="Мама ыпав ап  а.. . . .!! мыла раму";
       char[] string=str.toCharArray();
       String one="";
       String two="";
       char three=' ';
        for (char z:string
             ) if(!(z==three)){ {if(isVowel(z)==true){
                one=one+" "+z;
        }else
            two=two+" "+z;

        }
        }
        System.out.print(one.trim()+" ");
        System.out.println();
        System.out.print(two.trim()+" ");
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char d : vowels) {  // ищем среди массива гласных
            if (c == d) {
                return true;
            }
        }
        return false;
    }
}

/*
Задача №1 на преобразование целых типов
*/

class Solution51 {
    public static void main(String[] args) {
        int a = 0;       // 0
        int b = (byte) a + 46;  //46
        byte c = (byte) (a * b); //0
        double f = (char) 1234.15;//
        long d = (long) (a + f / c + b);
        System.out.println(d);
    }
}
/*
Задача №2 на преобразование целых типов
*/

class Solution52 {
    public static void main(String[] args) {
        int a = 15;
        int b = 4;
        float c = a / b;
        double d = a * 1e-3 + c;

        System.out.println(d);
    }
}
































