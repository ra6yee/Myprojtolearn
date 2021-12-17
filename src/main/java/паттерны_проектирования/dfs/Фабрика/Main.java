package паттерны_проектирования.dfs.Фабрика;
/*
— Т.е. мы создали специальный класс для управления созданием объектов?

— Ага.

— А какие преимущества это дает?

— Во-первых, там эти объекты можно инициализировать нужными данными.

Во-вторых, между методами можно сколько угодно передавать нужный enum, чтобы в конце концов по нему создали правильный объект.

В третьих, количество значений enum не обязательно должно совпадать с количеством классов. Типов персонажей может быть много, а классов – мало.

Например, для Mag & Warrior можно использовать один класс – Human, но с различными настройками силы и магии (параметрами конструктора).

Вот как это может выглядеть (для наглядности добавил еще темных эльфов):

Пример
public enum PersonType
{
 UNKNOWN,
 WARRIOR,
 MAG,
 TROLL,
 ELV,
 DARK_ELV
}

public class PersonFactory
{
 public static GamePerson createPerson(PersonType personType)
 {
  switch(personType)
  {
   WARRIOR:
   return new Human(10, 0); //сила, магия
   MAG:
   return new Human(0, 10); //сила, магия
   TROLL:
   OGR:
   return new Troll();
   ELV:
   return new Elv(true); //true – добрый, false – злой
   DARK_ELV:
   return new Elv(false); //true – добрый, false - злой
   default:
   throw new GameException();
  }
 }
}

В примере выше мы использовали всего три класса, чтобы создавать объекты шести разных типов. Это очень удобно. Более
того, у нас вся эта логика сосредоточена в одном классе и в одном методе.

Если мы вдруг решим создать отдельный класс для Огра, мы просто поменяем тут пару строк кода, а не будем перелопачивать
 половину приложения.

 */
public class Main {
    public static void main(String[] args) throws GameException {
GamePerson person=PersonFactory.createPerson(PersonType.Mag);
    }
}




































