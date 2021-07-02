package Date_вреия_и_дата;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class date {
    public static void main(String[] args) throws Exception
    {
        Date today = new Date();
        System.out.println("Current date: " + today);           // текущая дата.
   /////////////////////////////////////////////////////////////////
        Date currentTime = new Date();           //получаем текущую дату и время
        Thread.sleep(3000);                      //ждём 3 секунды – 3000 миллисекунд
        Date newTime = new Date();               //получаем новое текущее время

        long msDelay = newTime.getTime() - currentTime.getTime(); //вычисляем разницу
        System.out.println("Time distance is: " + msDelay + " in ms");
/////////////////////////////////////////////////////////////////////////////////////////
      /*
      Наступило ли уже некоторое время
       */

        Date startTime = new Date();

        long endTime = startTime.getTime() + 5000;   //    +5 секунд
        Date endDate = new Date(endTime);

        Thread.sleep(3000);              // ждем 3 секунды

        Date currentTime1 = new Date();
        if(currentTime1.after(endDate))//проверяем что время currentTime после endDate
        {
            System.out.println("End time!");
        }
//////////////////////////////////////////////////////////////////
      /*
      сколько времени прошло с начала дня
       */

        Date currentTime2 = new Date();
        int hours = currentTime2.getHours();
        int mins = currentTime2.getMinutes();
        int secs = currentTime2.getSeconds();

        System.out.println("Time from midnight " + hours + ":" + mins + ":" + secs);
        ////////////////////////////////////////////////////////////////////////////////////////////////////

        Date yearStartTime = new Date();
        yearStartTime.setHours(0);
        yearStartTime.setMinutes(0);
        yearStartTime.setSeconds(0);

        yearStartTime.setDate(1);      // первое число
        yearStartTime.setMonth(0);     // месяц январь, нумерация для месяцев 0-11

        Date currentTime3 = new Date();
        long msTimeDistance = currentTime3.getTime() - yearStartTime.getTime();
        long msDay = 24 * 60 * 60 * 1000;  //сколько миллисекунд в одних сутках

        int dayCount = (int) (msTimeDistance/msDay); //количество целых дней
        System.out.println("Days from start of year: " + dayCount);



    }
}
class Solution49 {

    public static void main(String[] args) throws Exception {
// что бы распарсимть строку, шаблон должен с ней совпадать.


        String dat= "2013-08-18";
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-M-d", Locale.ENGLISH);// парсим строку
        Date date=dateFormat.parse(dat);
        SimpleDateFormat date2Formatter=new SimpleDateFormat("MMM d, yyyy",Locale.ENGLISH);// это итоговый шаблон



        System.out.println(date2Formatter.format(date).toUpperCase());

    }
}

class LocalTime{
    public static void main(String[] args) {
        LocalDate today=LocalDate.now();
        System.out.println(today);
        LocalDate myBirthday=LocalDate.of(1979,3,19);
        System.out.println(myBirthday.getDayOfWeek());

    }
}