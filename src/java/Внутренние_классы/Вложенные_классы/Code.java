package src.java.Внутренние_классы.Вложенные_классы;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Code {
}
/*
Inner
Реализовать метод getTwoSolutions, который должен возвращать массив из 2-х экземпляров класса Solution.
Для каждого экземпляра класса Solution инициализировать поле innerClasses двумя значениями.
Инициализация всех данных должна происходить только в методе getTwoSolutions.
Требования:
•
В классе Solution должен быть реализован метод getTwoSolutions.
•
Метод getTwoSolutions должен быть статическим.
•
Метод getTwoSolutions должен быть публичным.
•
Метод getTwoSolutions должен возвращать массив типа Solution заполненный согласно заданию.

*/
 class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] twoSolution=new Solution[2];
        Solution sol1=new Solution();
        Solution sol2=new Solution();
       sol1.innerClasses[1]=sol1.new InnerClass();
       sol1.innerClasses[2]=sol1.new InnerClass();
       sol2.innerClasses[2]=sol2.new InnerClass();
       sol2.innerClasses[2]=sol2.new InnerClass();
        twoSolution[1]=sol1;
        twoSolution[2]=sol2;

        //sol1.innerClasses[1]=new Solution.InnerClass();
      //  InnerClass inn1=sol1.new InnerClass();
       // twoSolution[1]=sol.;
        return twoSolution;
    }

    public static void main(String[] args) {

           }
    }
/*
Inner 2
В классе SuperUser метод getDescription должен учитывать страну и город, т.е. возвращать результат аналогичный следующему:
My name is George. I'm from Seattle in the United States.
Используй возможности иннер класса.
Требования:
•
Класс SuperUser должен быть приватным.
•
Класс SuperUser должен содержать метод getDescription.
•
Метод getDescription в классе SuperUser должен быть публичным.
•
Метод getDescription в классе SuperUser должен возвращать строку учитывающую имя, страну и город пользователя
форматированную согласно условию задачи.
•
Метод getTrickyUser должен возвращать объект типа SuperUser.



*/
 class Solutionq {
    private String country;
    private String city;

    public Solutionq(String country, String city) {
        this.country = country;
        this.city = city;
    }

    /*т.к. модификатор иннер класса private, то чтобы вызвать метод getDescription из другого внешнего класса,
    нужно обернуть его вызов в какой-то public метод*/
    public String getUserDescription(String name) {
        return getTrickyUser(name).getDescription();
    }

    public SuperUser getTrickyUser(String name) {
        return new SuperUser(name);
    }

    private class SuperUser {
        private String name;

        //доступ к этому методу возможен только внутри класса Solution, т.к. модификатор иннер класса private
        public SuperUser(String name) {
            this.name = name;
        }

        //доступ к этому методу возможен только внутри класса Solution, т.к. модификатор иннер класса private
        public String getDescription() {
            return String.format("My name is %s.I'm from %s in  %s", this.name,Solutionq.this.city,Solutionq.this.country);
        }
    }

    public static void main(String[] args) {
        Solutionq solution = new Solutionq("the United States", "Seattle");
        //внутри класса Solution (а сейчас мы внутри) к методу getDescription можно обращаться обоими способами
        System.out.println(solution.getTrickyUser("George").getDescription());
        //а из любого другого внешнего класса только так:
        System.out.println(solution.getUserDescription("George"));
    }
}
/*
По умолчанию из внутреннего приватного класс может обращаться к переменным внешнего просто по имени, но лучше делать
через Solution.this.country, потому что если у нас будут две одинаково названные переменные во внешнем и внутреннем,
то по умолчанию при вызове из внутреннего будет браться внутренняя переменная.
 */
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*
Inner 3
Внутри класса Solution:
1) реализуйте private class TaskDataProvider используя Task и MockDB, цель которого - обновить поле tasks.
2) реализуйте private class NameDataProvider используя String и MockDB, цель которого - обновить поле names.
Требования:
•
Класс TaskDataProvider должен быть создан внутри класса Solution и быть приватным.
•
Класс NameDataProvider должен быть создан внутри класса Solution и быть приватным.
•
Класс TaskDataProvider должен реализовывать интерфейс DbDataProvider с параметром типа Task.
•
Класс NameDataProvider должен реализовывать интерфейс DbDataProvider с параметром типа String.
•
Метод refreshAllData в классе TaskDataProvider должен сохранять в список tasks результат работы метода getFakeTasks класса MockDB.
•
Метод refreshAllData в классе NameDataProvider должен сохранять в список names результат работы метода getFakeNames класса MockDB.


*/
 class Solution3 {

    private List<Task> tasks;
    private List<String> names;

    private DbDataProvider taskDataProvider = new TaskDataProvider();
    private DbDataProvider nameDataProvider = new NameDataProvider();

    private class TaskDataProvider implements DbDataProvider<Task>{

        @Override
        public void refreshAllData(Map criteria) {
         tasks=MockDB.getFakeTasks(criteria);


        }
    }

    private class NameDataProvider implements DbDataProvider<String>{

        @Override
        public void refreshAllData(Map criteria) {
names=MockDB.getFakeNames(criteria);
        }
    }

    public void refresh() {
        Map taskCriteria = MockView.getFakeTaskCriteria();
        taskDataProvider.refreshAllData(taskCriteria);

        Map nameCriteria = MockView.getFakeNameCriteria();
        nameDataProvider.refreshAllData(nameCriteria);
    }

    private interface DbDataProvider<T> {
        void refreshAllData(Map criteria);
    }

    class Task {
    }

    public static void main(String[] args) {

    }
}

 class MockDB {
    private static final List<Solution3.Task> FAKE_TASKS = new ArrayList<>();
    private static final List<String> FAKE_NAMES = new ArrayList<>();

    public static List<Solution3.Task> getFakeTasks(Map criteria) {
        return MockView.getFakeTaskCriteria().equals(criteria) ? FAKE_TASKS : null;
    }

    public static List<String> getFakeNames(Map criteria) {
        return MockView.getFakeNameCriteria().equals(criteria) ? FAKE_NAMES : null;
    }
}


 class MockView {
    private static final Map FAKE_TASK_CRITERIA = new HashMap();
    private static final Map FAKE_NAME_CRITERIA = new HashMap();

    public static Map getFakeTaskCriteria() {
        return FAKE_TASK_CRITERIA;
    }

    public static Map getFakeNameCriteria() {
        return FAKE_NAME_CRITERIA;
    }
}
// я в ахуе, просто с АХУЕ!!!!!!





