package паттерны_проектирования.dfs.Фабрика;

public class GameException extends Exception {
    @Override
    public String toString() {
        return "GameException{} такого персонажа не существует";
    }
}
