package паттерны_проектирования.dfs.Фабрика;
//Во-вторых, сделать специальный класс – Factory, у которого будет статический метод или методы, которые и будут
// заниматься созданием объекта(ов) в зависимости от enum’а.
public class PersonFactory {
  public static GamePerson createPerson(PersonType personType) throws GameException {
     switch (personType){
         case Mag:return new Mag();
         case Elv:return new Elv();
         case Troll:return new Troll();
         case Warrior:return new Warrior();
         default:throw new GameException();

     }
    }
}
