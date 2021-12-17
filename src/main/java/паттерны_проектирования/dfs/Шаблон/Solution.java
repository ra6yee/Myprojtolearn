package паттерны_проектирования.dfs.Шаблон;

//Классы Football, Basketball и Tennisописывают три популярные игры.
//        Спроси у своего любимого поисковика о паттерне Template method (Шаблонный метод) и сделай так, чтобы код
//        написанный в методе main класса Solution имел смысл.
//        P.S. Класс Game должен быть абстрактным.
//        Требования:
//        •
//        Классы Football, Basketball и Tennis должны быть потомками класса Game.
//        •
//        В классе Game должны быть определены три абстрактных метода prepareForTheGame, playGame и congratulateWinner.
//        •
//        В классе Game должен быть реализован метод run, вызывающий методы prepareForTheGame, playGame и
//        congratulateWinner в правильном порядке.
//        •
//        Класс Game должен быть абстрактным.

import java.util.ArrayList;
import java.util.List;

abstract class Game{
  public void prepareForTheGame(){};
  public void playGame(){};
  public void congratulateWinner(){};
 final public void run(){
      prepareForTheGame();
      playGame();
      congratulateWinner();
  }
          }

class Tennis extends Game {
    public void prepareForTheGame() {
        System.out.println("Preparing for the Tennis game...");
    }

    public void playGame() {
        System.out.println("Playing tennis!");
    }

    public void congratulateWinner() {
        System.out.println("Rafael Nadal wins once again!!!");
    }
}

 class Football extends Game {
    public void prepareForTheGame() {
        System.out.println("Preparing for the Football game...");
    }

    public void playGame() {
        System.out.println("Kickoff!!! Playing football!");
    }

    public void congratulateWinner() {
        System.out.println("Here is the new football CHAMPION!!!");
    }
}

 class Basketball extends Game{
    public void prepareForTheGame() {
        System.out.println("Preparing for the Basketball game...");
    }

    public void playGame() {
        System.out.println("Playing basketball!");
    }

    public void congratulateWinner() {
        System.out.println("Give it up to the NBA finals champions!!!");
    }
}



/*
Шаблонный метод
*/
public class Solution {
    public static void main(String[] args) {
        List<Game> games = new ArrayList<>();
        games.add(new Football());
        games.add(new Basketball());
        games.add(new Tennis());

        for(Game game : games) {
            game.run();
            System.out.println("---------------------------------------------");
        }
    }
}
