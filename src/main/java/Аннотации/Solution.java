package Аннотации;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;
//Расставь в этом классе, везде где только можно, все возможные предопределенные в Java аннотации.
//        Не должно быть избыточности.
//        Требования:
//        •
//        Класс Solution должен быть отмечен аннотацией @Deprecated.
//•
//        Класс SubSolution должен быть отмечен аннотацией @Deprecated.
//•
//        Поле arguments должно быть отмечено аннотацией @Deprecated.
//•
//        Метод main должен быть отмечен аннотацией @Deprecated.
//•
//        Метод voidMethod класса Solution должен быть отмечен аннотацией @Deprecated.
//•
//        Метод voidMethod класса SubSolution должен быть отмечен аннотациями @Deprecated и @Override.
//•
//        Конструктор класса Solution должен быть отмечен аннотациями @Deprecated и @SafeVarargs.


/*
Предопределенные типы аннотаций (Predefined Annotation Types)
*/
@Deprecated
public class Solution {
@Deprecated
    private String[] arguments;
    @Deprecated
    @SafeVarargs
    public Solution(String... arguments) {
        this.arguments = arguments;
    }
@Deprecated

    public void voidMethod() throws Exception {
    }
@Deprecated
    public static void main(String[] args) throws Exception {
        new Solution().new SubSolution().voidMethod();
    }
@Deprecated
    class SubSolution extends Solution {
@Deprecated
@Override
        public void voidMethod() throws Exception {
            super.voidMethod();
        }
    }
}


