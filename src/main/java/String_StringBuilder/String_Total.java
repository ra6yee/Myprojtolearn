package String_StringBuilder;
///методы класса
public class String_Total {
    public static void main(String[] args) {
        String s="Hello World";
        // узнать длину строки
        int length=s.length();
        System.out.println("Длина строки: "+length);
        //получить символ из строки
        char n=s.charAt(0);
        System.out.println("полученный символ :"+n);
        //  Как получить символы из строки
        //char[] toCharArray()
        //Метод toCharArray возвращает массив всех символов строки.
        String ss = "Good news everyone!";
        char[]arrayOfString=ss.toCharArray();
        System.out.println(arrayOfString);
        for(char c : ss.toCharArray())
        {
            System.out.println(c);
        }
//Как сравнить строки?
//boolean equals(Object o)             boolean equalsIgnoreCase(String str)
//Метод equals проверяет, совпадают ли строки, а метод equalsIgnoreCase — совпадают ли строки, игнорируя регистр букв.
        String s2 = "cat";
        boolean test1 = s2.equals("cat");//true
        boolean test2 = s2.equals("Cat");//false
        boolean test3 = s2.equals("c"+"a"+"t");//true

       // String s = "cat";
        boolean test11 = s.equalsIgnoreCase("cat");//true
        boolean test12 = s.equalsIgnoreCase("Cat");//true
        boolean test13 = s.equalsIgnoreCase("cAT");//true
//Как превратить все буквы в строке в большие или маленькие?
//
//Метод toUpperCase возвращает копию строки, все символы которой – большие.
//
//Метод toLowerCase возвращает копию строки, все символы которой – маленькие.

        String sss = "Good news everyone!";
        sss = sss.toUpperCase();
        System.out.println(sss);
        String ssss=sss.toLowerCase();
        System.out.println(ssss);
       //Как убрать пробелы в начале и в конце строки?
        //
        //Метод trim возвращает копию строки, без «пустых» символов в начале и конце.
        String reel = "  Good news everyone!   ";
        reel = reel.trim();


    }
}
// подстрока
class Solution103 {
    public static void main(String[] args) {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";
String subS=s.substring(1);
            System.out.println(subS);
        for (int i = 0; i < 40; i++) {
            System.out.println(s.substring(i));

        }
        // repeat(40, () -> System.out.println(s));

    }
}
// узнать что строка пустая, например, при вводе, поможет булен isEmpty
