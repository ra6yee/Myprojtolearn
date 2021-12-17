package паттерны_проектирования.dfs.ChainRespons;

//Амиго, у нас проблема! Во время визита на планету #IND893 мы рискнули отдать на аутсорсинг автоматизацию 
//        входящих задач для членов команды. В это сложно поверить, но похоже всю работу теперь должен выполнять первый помощник!
//        Необходимо срочно исправить поведение программы, ведь полы может помыть и юнга, а приказ "к бою!" может дать 
//        только капитан.
//        P.S. Постарайся реализовать метод handleRequest таким образом, чтобы при добавлении новых должностей нам не
//        требовалось вносить в него изменения. Другие методы не трогай.
//        P.P.S. Все enum поддерживают интерфейс Comparable.
//        Требования:
//        •
//        Запрос должен быть обработан текущим членом команды, если это возможно.
//        •
//        Запрос должен быть передан по цепочке выше, если текущий член команды не может его обработать.
//        •
//        Классы CabinBoy, Engineer, FirstMate и Captain должны быть потомками класса AbstractCrewMember.
//        •
//        Класс AbstractCrewMember должен быть абстрактным.

 class FirstMate extends AbstractCrewMember {
    public FirstMate (AbstractCrewMember.CompetencyLevel competencyLevel) {
        this.competencyLevel = competencyLevel;
    }

    protected void doTheJob(String request) {
        System.out.println("The request " + request + " will be handled by first mate, let's not bother the captain with it.");
    }
}

 class CabinBoy extends AbstractCrewMember {
    public CabinBoy (AbstractCrewMember.CompetencyLevel competencyLevel) {
        this.competencyLevel = competencyLevel;
    }

    protected void doTheJob(String request) {
        System.out.println("Even the cabin boy can handle the request " + request);
    }
}

 class Captain extends AbstractCrewMember {
    public Captain (AbstractCrewMember.CompetencyLevel competencyLevel) {
        this.competencyLevel = competencyLevel;
    }

    protected void doTheJob(String request) {
        System.out.println("Only the captain can handle request " + request + ". Let's do this!");
    }
}


/*
Chain of Responsibility
*/
public class Solution {
    public static void main(String[] args) {
        SpaceShip spaceShip = new SpaceShip();
        AbstractCrewMember crewMember = spaceShip.getCrewChain();

        crewMember.handleRequest(AbstractCrewMember.CompetencyLevel.EXPERT, "ATTACK");
        System.out.println("-----------------------------------------");
        crewMember.handleRequest(AbstractCrewMember.CompetencyLevel.NOVICE, "WASH THE FLOOR");
        System.out.println("-----------------------------------------");
        crewMember.handleRequest(AbstractCrewMember.CompetencyLevel.INTERMEDIATE, "CHECK ENGINE");
        System.out.println("-----------------------------------------");
        crewMember.handleRequest(AbstractCrewMember.CompetencyLevel.ADVANCED, "SET ROUTE");
    }
}

 abstract class AbstractCrewMember {
    public enum CompetencyLevel {
        NOVICE,
        INTERMEDIATE,
        ADVANCED,
        EXPERT
    }

    protected CompetencyLevel competencyLevel;

    protected AbstractCrewMember nextCrewMember;

    public void setNextCrewMember(AbstractCrewMember nextCrewMember) {
        this.nextCrewMember = nextCrewMember;
    }

    public void handleRequest(CompetencyLevel competencyLevel, String request) {
        if (this.competencyLevel.equals(competencyLevel)) {
            doTheJob(request);
        } else if (nextCrewMember != null) {
            nextCrewMember.handleRequest(competencyLevel, request);
        }
    }

    protected abstract void doTheJob(String request);
}
 class Engineer extends AbstractCrewMember {
    public Engineer (AbstractCrewMember.CompetencyLevel competencyLevel) {
        this.competencyLevel = competencyLevel;
    }

    protected void doTheJob(String request) {
        System.out.println(request + " is a common engineering task. To the work!");
    }
}

 class SpaceShip {
    public AbstractCrewMember getCrewChain(){
        AbstractCrewMember cabinBoy = new CabinBoy(AbstractCrewMember.CompetencyLevel.NOVICE);
        AbstractCrewMember engineer = new Engineer(AbstractCrewMember.CompetencyLevel.INTERMEDIATE);
        AbstractCrewMember firstMate = new FirstMate(AbstractCrewMember.CompetencyLevel.ADVANCED);
        AbstractCrewMember captain = new Captain(AbstractCrewMember.CompetencyLevel.EXPERT);

        cabinBoy.setNextCrewMember(engineer);
        engineer.setNextCrewMember(firstMate);
        firstMate.setNextCrewMember(captain);

        return cabinBoy;
    }
}

