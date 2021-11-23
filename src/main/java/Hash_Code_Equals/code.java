package src.java.Hash_Code_Equals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class code {
}
/*
Equals and HashCode
В классе Solution исправить пару методов equals/hashCode в соответствии с правилами реализации этих методов(детали
 уточни у своего любимого поисковика).
Обе строки first и last должны принимать участие в сравнении с помощью метода equals и вычислении hashcode.
Метод main не участвует в тестировании.
Требования:
•
Хешкоды одинаковых объектов должны быть равны.
•
Метод equals должен проверять равен ли переданный объект текущему(сравнение через ==).
•
Метод equals должен проверять является ли переданный объект объектом класса Solution.
•
Метод equals должен возвращать true в случае, если поля first и last равны у переданного объекта и текущего(не забудь
что они могут быть равны null).
•
Должно быть обеспечено корректное поведение HashSet с типом элементов Solution.

*/
class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object n) {
       if(n==null){return false;}
       if(!(n.getClass()==this.getClass())){return false;}
      //создаем новый объект сравниваемого класса и приводим к нему n
       Solution solution=(Solution)n;
       //теперь через поля нового объекта сравниваем их с полями текущего объекта.
        return solution.first.equals(first) && solution.last.equals(last);
                // если объекты одинаковые, то и поля в них одинаковые.Следовательно, метод вернет true.


    }
    @Override
    public int hashCode() {

        return 31 * first.hashCode() + last.hashCode();
        //а тут просто вычисляется число которое и будет хешкодом объекта
        // но  тут явно нужно что то еще дописать. Хотя... нет, сначала будет вычислен в этом методе
        // хеш код объекта, который будет сравнивать, а уж потом по его подобию будут сравниваться остальные объекты.
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
        System.out.println(s.size());
    }
}

/*
Исправить ошибку. Сравнение объектов
Сравнение объектов Solution не работает должным образом. Найти ошибку и исправить.
Метод main не участвует в тестировании.
Требования:
•
Хешкоды одинаковых объектов должны быть равны.
•
Метод equals должен проверять равен ли переданный объект равен текущему(сравнение через ==).
•
Метод equals должен проверять является ли переданный объект объектом класса Solution.
•
Метод equals должен возвращать true в случае, если поля first и last равны у переданного объекта и текущего(не забудь
что они могут быть равны null).
•
Должно быть обеспечено корректное поведение HashSet с типом элементов Solution.
•
В классе Solution должен быть реализован метод hashCode.

*/
 class Solution1 {
    private final String first, last;

    public Solution1(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if (!(o.getClass()==Solution1.class ))
            return false;
        if(o==null)return false;
        Solution1 n = (Solution1) o;

        return n.first.equals(first) && n.last.equals(last);
    }

    @Override
    public int hashCode() {
       return 31*(((first!=null)?first.hashCode():0)+last!=null? last.hashCode():0);
        // return Objects.hash(first, last); это новый и лучшиф вариант хешкода.
    }

    public static void main(String[] args) {
        Set<Solution1> s = new HashSet<>();
        s.add(new Solution1("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution1("Mickey", "Mouse")));
    }
}
/*
Ошибка в equals/hashCode
Исправьте ошибки реализаций методов equals и hashCode для класса Solution.
Требования:
•
Хешкоды одинаковых объектов должны быть равны.
•
Метод equals должен проверять равен ли переданный объект равен текущему (сравнение через ==).
•
Метод equals должен проверять является ли переданный объект объектом класса Solution.
•
Метод equals должен проверять значения всех полей у переданного объекта и текущего (учти что некоторые из них могут быть равны null).
•
Должно быть обеспечено корректное поведение HashSet с типом элементов Solution.
•
В классе Solution должен быть реализован метод hashCode.

*/
class Solution3 {
    private int anInt;
    private String string;
    private double aDouble;
    private Date date;
    private Solution3 solution;

    public Solution3() {
    }

    public Solution3(int anInt, String string, double aDouble, Date date, Solution3 solution) {
        this.anInt = anInt;
        this.string = string;
        this.aDouble = aDouble;
        this.date = date;
        this.solution = solution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o.getClass() == Solution3.class)) return false;

        Solution3 solution1 = (Solution3) o;

        if (Double.compare(solution1.aDouble, aDouble) != 0) return false;
        if (anInt != solution1.anInt) return false;
        if (date != null ? !date.equals(solution1.date) : solution1.date !=null) return false;
        if (solution != null ? !solution.equals(solution1.solution) : solution1.solution != null) return false;
        if (string != null ? !string.equals(solution1.string) : solution1.string != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = anInt;
        temp = aDouble != +0.0d ? Double.doubleToLongBits(aDouble) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (solution != null ? solution.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) throws ParseException {
        Set<Solution3> set = new HashSet<>();

        Solution3 solution = new Solution3(5, "Ooops!", 2.5d, new SimpleDateFormat("dd.MM.yyyy").parse("24.03.2020"), new Solution3());

        set.add(solution);

        System.out.print(set.contains(new Solution3(5, "Ooops!", 2.5d, new SimpleDateFormat("dd.MM.yyyy").parse("24.03.2020"), new Solution3())));


    }
}
/*
Первые две строки не вызывают сложностей, они очевидны. По поводу остальных - их можно расписать как череду условий и
тогда появится понимание того, что вообще происходит. Давайте начнём:
1) В строках 3-5 внутри if находится тернарный оператор. Он имеет следующий вид:
int a;
int b;
int c = a > b ? a : b;

c будет присвоено значение a в случае, если условие a > b выполняется, иначе c будет присвоено значение b.
2) Теперь распишем по шагам что происходит внутри if. Распишу на примере строки 3.
2.1) Сначала идёт проверка условия_1:
//Условие_1
date != null

Если условие_1 выполняется, то переходим к 2.2, иначе к 2.3.
2.2) Проверяем условие_2:
//Условие_2
!date.equals(solution1.date)

Если условие_2 вернёт нам true, то мы выполним условие if и перейдём к выполнению
return false;

Таким образом, наш метод equals вернёт false.
Если условие_2 вернёт нам false - мы перейдём к следующему if.

2.3) Здесь проверяем условие_3:

//Условие_3
solution1.date == null

Если условие_3 вернёт нам true, то мы выполним условие if и перейдём к выполнению
return false;

Если условие_3 вернёт нам false - мы перейдём к следующему if.

 */