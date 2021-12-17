package паттерны_проектирования.dfs.adapter.еще;
/*
создаем адаптер в сторону
для этого создаем класс адаптер и имплементируем в него один из наших интерфесов
далее создаем переменную для второго интерфейса
инициализируем через конструктор
Получаем доступ к методам первого интерфеййса непосредственно в нашем классе, а доступ к методам второго интерфейса
через нашу переменнную второго интерфейса.
Далее просто дополняем логику этих методов, если это необходимо
И тут конкретный подводный камени прилетел. Оказывается, необходимо эти методы почти полностью переписать
 */
public class TotalTimeAdapter implements Time {
   private TotalTime totalTime;//переменную для второго интерфейса

    public TotalTimeAdapter(TotalTime totalTime) {
        this.totalTime = totalTime;
    }

    @Override
    public int getSeconds() {
        return totalTime.getTotalTime()%60;
    }

    @Override
    public int getMinutes() {
        return totalTime.getTotalTime()%(60*60)/60;
    }

    @Override
    public int getHours() {
        return totalTime.getTotalTime()/(60*60);
    }
}
