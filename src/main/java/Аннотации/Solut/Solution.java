package Аннотации.Solut;


//Исправь неверные аннотации. Код должен компилироваться без ошибок и предупреждений.
//        Избегай избыточности. Не нужно писать подряд все знакомые тебе аннотации.
//        Требования:
//        •
//        Аннотация @Main должна использоваться только для аннотирования методов.
//        •
//        Метод main класса Solution должен быть отмечен только аннотацией @Main.
//•
//        Метод overriddenMethod класса SubSolution должен быть отмечен только аннотацией @Override.
//•
//        В методе uncheckedCall должны быть подавлены unchecked warnings с помощью аннотации.


import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;


/*
Неверные аннотации
*/

public class Solution {

    @Main
    public static void main(String[] args) {
        Solution solution = new Solution().new SubSolution();
        solution.overriddenMethod();
    }

    public void overriddenMethod() {
    }

    public class SubSolution extends Solution {

        @Override
        public void overriddenMethod() {
            System.out.println(uncheckedCall());
        }

        @SuppressWarnings(value = "unchecked")
        List uncheckedCall() {
            List list = new ArrayList();
            list.add("hello");
            return list;
        }
    }


}


@Target(ElementType.METHOD)
@interface Main {
}
