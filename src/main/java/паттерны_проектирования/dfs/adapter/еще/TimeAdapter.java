package паттерны_проектирования.dfs.adapter.еще;
/*
это адаптер в другую сторону
все тоже самое.Теперь нужно найти пример с классами

 */
public class TimeAdapter implements TotalTime {
    private Time time;

    public TimeAdapter() {
    }

    public TimeAdapter(Time time) {
        this.time = time;
    }

    @Override
    public int getTotalTime() {
        return time.getHours()*60*60+time.getMinutes()*60+time.getSeconds();
    }
}
