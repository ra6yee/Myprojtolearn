package src.java.Cloneable;
import java.util.HashMap;
import java.util.Iterator;
public class пример_клонирований {
}


 class CloneTest implements Cloneable {

    private int id;
    private String name;
    private HashMap props;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap getProps() {
        return props;
    }

    public void setProps(HashMap props) {
        this.props = props;
    }

    /*
    public CloneTest clone() {
      System.out.println("Вызываем переопределенный метод clone()");
      HashMap hm = new HashMap();
      String key;
      Iterator it = this.props.keySet().iterator();
      // глубокое копирование объекта Java
      while (it.hasNext()) {
          key = it.next();
          hm.put(key, this.props.get(key));
      }
        CloneTest ct = new CloneTest();
        ct.setId(this.id);
        ct.setName(this.name);
        ct.setProps(hm);
      return ct;
    }
    */
    public static void main(String[] args) throws CloneNotSupportedException {

        CloneTest ct1 = new CloneTest();
        ct1.setId(1);
        ct1.setName("первый");
        HashMap hm = new HashMap();
        hm.put("1", "first");
        hm.put("2", "second");
        hm.put("3", "third");
        ct1.setProps(hm);
// Используем стандартную реализацию метода clone()
        CloneTest ct2 = (CloneTest) ct1.clone();

// Проверяем атрибуты ct1 и ct2 на равенство
        System.out.println("ct1 и ct2 HashMap == test: "
                + (ct1.getProps() == ct2.getProps()));
// Смотрим эффект от использования стандартной реализации метода clone()
        ct1.getProps().put("4", "fourth");
        System.out.println("ct2 props:" + ct2.getProps());
        ct1.setName("new");
        System.out.println("ct2 name:" + ct2.getName());
    }

}
  /*  В результате получается такой вывод в консоль:


        ct1 и ct2 HashMap == test: true
        ct2 props:{3=third, 2=second, 1=first, 4=fourth}

        Из результатов выполнения программы видно, что стандартная реализация метода clone() использует неполную копию
        и ct2 зависит от каких-либо изменений в атрибутах ct1, поэтому мы должны переопределить метод clone().

        Важное замечание по клонированию объектов в Java
        Если ваш класс содержит изменяемые объекты, то вам нужно обеспечить надлежащее выполнение метода clone() с
        использованием глубокого копирования. Раскомментируйте метод clone() и запустите программу снова.

        Теперь результат будет таким:


        Вызываем переопределенный метод clone():

        ct1 и ct2 HashMap == test: false
        ct2 props:{3=third, 2=second, 1=first}

        Теперь оба объекты не влияют друг на друга и клонирование работает корректно.

     */
  /*
Клонирование растений
Класс Plant не должен реализовывать интерфейс Cloneable
Реализуй механизм глубокого клонирования для Tree.
Требования:
•
Класс Plant не должен поддерживать интерфейс Cloneable.
•
Класс Tree должен поддерживать интерфейс Cloneable.
•
Класс Tree должен быть потомком класса Plant.
•
В классе Tree должен быть корректно реализован метод clone.


*/
   class Solution2 {
      public static void main(String[] args) throws CloneNotSupportedException {
          Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
          Tree clone = null;
          clone = tree.clone();

          System.out.println(tree);
          System.out.println(clone);

          System.out.println(tree.branches);
        // tree.add("one");
          System.out.println(clone.branches);
      }

      public static class Plant{
          private String name;

          public Plant(String name) {
              this.name = name;
          }

          public String getName() {
              return name;
          }
      }

      public static class Tree extends Plant implements Cloneable {
          private String[] branches;

          public Tree(String name, String[] branches) {
              super(name);
              this.branches = branches;
          }

          public void add(String s){
              int branchSize=branches.length;
              branches[branchSize]=s;
          }

          public String[] getBranches() {
              return branches;
          }
     public Tree clone() throws CloneNotSupportedException {
         String[] branches2=this.getBranches();
          Tree tree=new Tree(this.getName(),branches.clone()); //опааааа, вот это поворот
     return tree;
          }

      }
  }





