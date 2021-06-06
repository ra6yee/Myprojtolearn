package Приведение_типов;

public class Примеры_Кода {
}
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
        int a = 15; //15
        int b = 4;  //4
        float c =(float) a / b; //3.0
        System.out.println(c);
        double d = (a * 1e-3 + c);

        System.out.println(d);
    }
}
/*
Задача №3 на преобразование целых типов
*/

class Solution53 {
    public static void main(String[] args) {
        float f = (float) 128.50; //128.5
        int i = (int) f;         //128
        int b = (byte) (i + f);    //256 для int
        System.out.println(b);
    }
}
/*
Задача №4 на преобразование целых типов
*/

class Solution54 {
    public static void main(String[] args) {
        short number = 9;
        char zero =(int) '0';
        int nine = (zero + number);
        System.out.println((char)nine);// еб твою мать, гребаный квест.
    }
}
/*
Задача №5 на преобразование целых типов
*/

class Solution55 {
    public static void main(String[] args) {
        int a = (byte) 44; //44
        int b =  300;// 46
        short c = (short) (b - a);//2
        System.out.println(c);
    }
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*
Задача №6 на преобразование целых типов
*/

 class Solution56 {
    public static void main(String[] args) {
        double d =(short) 2.50256e2d;//250
        char c = (short) 'd';         //100
        short s = (short) 2.22;        //2
        int i =  150000;         //18928
        float f =  0.50f;        //0.0
        double result = f + (i / c) - (d * s) - 500e-3;
        System.out.println("result: " + result);
    }
}
/*
Задача №7 на преобразование целых типов
*/

class Solution57 {
    public static void main(String[] args) {
        long l = (byte) 1234_564_890L;
        int x = (byte) 0b1000_1100_1010;
        double m = (byte) 110_987_654_6299.123_34;
        float f = (byte) l++ + 10 + ++x - (float) m;
        l = (long) f / 1000;
        System.out.println(l);
    }
}






