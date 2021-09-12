package src.java.Многопоточность.Phaser;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.concurrent.Phaser;

//это мой пример, по мотивам видео из ютуба, того хохла, который свалил в америку
public class washing_Car {
    public static void main(String[] args) {
        Phaser phaser=new Phaser(2);
        Washer washer1=new Washer(phaser,"washer1");
       Washer washer2=new Washer(phaser,"washer2");
    }
static class Washer extends Thread{
       private Phaser ph;
       // String  name;
    public Washer(Phaser ph,String name) {
        this.ph = ph;
        setName(name);
        start();
    }

    @Override
    public void run() {
        System.out.println("помывка колес");
        for (int i = 0; i <3 ; i++) {
            try {

                System.out.println(getName()+" моет колеса машины "+i );  // а теперь добавим фазы
                ph.arriveAndAwaitAdvance();
                System.out.println("помывка салона"+ph.getPhase());
                sleep(100);
                System.out.println(getName()+" моет салон машины "+i);
                sleep(100);
                ph.arriveAndAwaitAdvance();
                System.out.println("помывка кузова"+ph.getPhase());
                System.out.println(getName()+" моет кузов машины "+i);
                sleep(100);

                ph.arriveAndAwaitAdvance();
                System.out.println("машина "+i+" чистая"+ph.getPhase());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    ph.arriveAndDeregister();
    }
}

}
