package src.java.Cloneable;

import javax.jws.soap.SOAPBinding;
import java.util.*;

public class code {
}

/*
Глубокое клонирование карты
Обеспечь возможность клонирования объекта класса Solution используя глубокое клонирование.
Данные в карте users также должны быть клонированы.
Не забудь о методах equals и hashCode для корректного добавления элементов типа User в HashMap.
Требования:
•
Класс Solution должен поддерживать интерфейс Cloneable.
•
Класс User должен поддерживать интерфейс Cloneable.
•
В классе User должен быть корректно реализован метод clone.
•
В классе Solution должен быть корректно реализован метод clone.



Господи, ну и намучился я с этой задачкой.
Во-первый, вот
http://javaconceptoftheday.com/difference-between-shallow-copy-vs-deep-copy-in-java/
1. ОБЯЗАТЕЛЬНО в clone() возвращайте тип, который соответствует классу, в котором вы его переопределяете. Например,
 User clone(), а не Object clone().
2. Внимательнее с users (Map). При вызове super.clone новый экземпляр users не создается, а остается только ссылка на
объект в изначальной solution.
Поэтому, в методе Solution clone() необходимо создать новую Map и копировать туда значения из старой с клонированием User.
3. Alt+Insert -> equals() and hashCode() ваш лучший друг.
4. После переопределения equals() and hashCode() будет sout(solution) и sout(clone) будет показывать одно и то же,
даже если глубокое копирование прошло успешно, потому что переопределенные методы ориентируются на значения объектов,
а не на ссылки в памяти.
*/
class Solution implements Cloneable {


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Solution)) return false;
        Solution solution = (Solution) o;
        return Objects.equals(users, solution.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = (Solution) solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);
              solution.users.put("sdfsdf",new User(23,"sdfdsf"));
            System.out.println(clone.users);
            System.out.println(solution.users);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    protected Map<String, User> users = new LinkedHashMap();

    protected Object clone() throws CloneNotSupportedException {
        Solution solution=(Solution)super.clone();
    Map<String,User>map=new LinkedHashMap<>();
        Iterator<Map.Entry<String,User>>iterator=users.entrySet().iterator();
      while (iterator.hasNext()){
          Map.Entry<String,User>pair=iterator.next();
if(pair.getValue().getClass().equals(User.class)) {
    map.put(pair.getKey(), pair.getValue());
}
          }

       solution.users=map;
        return solution;
    }

    public static class User implements Cloneable{
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }
   protected Object clone() throws CloneNotSupportedException {
            return (User)super.clone();
   }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof User)) return false;
            User user = (User) o;
            return age == user.age &&
                    Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(age, name);
        }
    }
}
