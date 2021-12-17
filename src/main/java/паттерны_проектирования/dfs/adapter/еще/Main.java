package паттерны_проектирования.dfs.adapter.еще;
/*
как пользоваться адаптерами в программе

Здесь вроде ошибочка.
Time time = new Time();
TotalTime totalTime = new TimeAdapter(time);
System.out.println(time.getTotalSeconds());

Правильно вроде так
Time time = new Time();
TotalTime totalTime = new TimeAdapter(time);
System.out.println(totaltime.getTotalSeconds());
 */
public class Main {
    public static void main(String[] args) {
        Time time= new Time() {
            @Override
            public int getSeconds() {
                return 0;
            }

            @Override
            public int getMinutes() {
                return 0;
            }

            @Override
            public int getHours() {
                return 0;
            }
        };
        TotalTime totalTime=new TimeAdapter(time);
        System.out.println(totalTime.getTotalTime());
//TotalTime totalTime1=new TotalTimeAdapter();

        
    }
}
