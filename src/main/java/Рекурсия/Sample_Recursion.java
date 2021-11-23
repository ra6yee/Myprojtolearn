package src.java.Рекурсия;
//незнаю получится ли написать рекурсию, но попробую сделать так как я это понял
public class Sample_Recursion {
    public static void main(String[] args) {
        int i=0;
        recursion(i);
    }
public static void recursion(int i){
         i++;
         if(i<10)
             recursion(i);
    System.out.println(i);
}
}
//по идее, рекурсия как стек, должна заполниться всеми значениями i  и вывести их в обратном порядке
// запускаю
// действительно, все получилось, рекурсия раскрутила все значения в обратном порядке.Замечательный пример.
