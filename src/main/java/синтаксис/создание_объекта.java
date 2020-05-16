package синтаксис;
// объект может быть только экземпляром класса
//т е сначала создаетсякласс, потом его объект
public class создание_объекта {

}
class Solution{
    String sex;
    int age;

    public Solution() {
    }

    public Solution(String sex, int age) {
        this.sex = sex;
        this.age = age;
    }
}
// объект создается в классе с точкой входа в программу.
// объект можно инициализировать полями через создание конструкторов
// в классе, объект которого созадется.
// Конструкторы и геттеры с сеттерками можно сождать через сочетание
// альт + инсерт
class main{
    public static void main(String[] args) {
        Solution solution = new Solution();
    solution.age=23;
    solution.sex="Male";
// создаем через конструктор
        Solution sol2=new Solution("Female",40);

    }
}