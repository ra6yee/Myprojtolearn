package src.java.Многопоточность.Phaser;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Phaser;
import java.util.concurrent.ThreadLocalRandom;
public class phaser {
}

// /1. Почитай про java.util.concurrent.Phaser.
//2. Расставь методы в нужных местах:
//        - arriveAndDeregister() - начинает запускать методы run у тасок,
//        - arriveAndAwaitAdvance() - ждет, когда все трэды будут созданы.
//        Пример вывода см. в output.txt.
//        Логика:
//        Сначала все персонажи присоединяются к игре.
//        После того, как все персонажи присоединятся к игре и готовы играть, выводится фраза "Игра началась!".
//        После этого персонажи вступают в игру, после чего умирают.
//        Требования:
//        •
//        Класс Character менять не нужно.
//        •
//        Классы Plant и Zombie менять не нужно.
//        •
//        В классе Solution вызови метод phaser.arriveAndDeregister в правильном месте.
//        •
//        В классе Solution вызови метод phaser.arriveAndAwaitAdvance в правильном месте.
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////package com.javarush.task.task28.task2809;



/*
Plants vs Zombies
*/
 class Solution {
    public static void main(String[] args) throws InterruptedException {
        List<Character> characters = new ArrayList<>();
        characters.add(new Plant());
        characters.add(new Plant());
        characters.add(new Zombie());
        characters.add(new Zombie());
        characters.add(new Zombie());
        start(characters);
    }

    private static boolean isEveryoneReady = false;

    private static void start(List<Character> characters) throws InterruptedException {
        final Phaser phaser = new Phaser(1 + characters.size());
        phaser.arriveAndDeregister();
        for (final Character character : characters) {
            final String member = character.toString();
            System.out.println(member + " присоединился к игре");
            new Thread() {
                @Override
                public void run() {
                    System.out.println(member + " готовится играть");
                    phaser.arriveAndAwaitAdvance();

                    if (!isEveryoneReady) {
                        isEveryoneReady = true;
                        System.out.println("Игра началась!");
                    }

                    character.run();
                }
            }.start();
        }
    }
}

//////////////////////////////////////////////////////////////////////////////////////////////////////


 class Zombie extends Character {
    private final static AtomicInteger idSequence = new AtomicInteger();
    private final int id = idSequence.incrementAndGet();

    protected int getId() {
        return id;
    }
}

/////////////////////////////////////////////////////////////////////////////////////////////////////


 abstract class Character implements Runnable {
    protected abstract int getId();

    public void run() {
        System.out.println(toString() + " вступил в игру");
        doSomething();
        System.out.println(toString() + " умер");
    }

    private void doSomething() {
        try {
            Thread.currentThread().sleep(ThreadLocalRandom.current().nextInt(10, 100));
        } catch (InterruptedException ignored) {
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " #" + getId();
    }

}

////////////////////////////////////////
// /Plant #1 присоединился к игре
//Plant #2 присоединился к игре
//        Plant #1 готовится играть
//        Zombie #1 присоединился к игре
//        Zombie #2 присоединился к игре
//        Zombie #3 присоединился к игре
//        Plant #2 готовится играть
//        Zombie #2 готовится играть
//        Zombie #1 готовится играть
//        Zombie #3 готовится играть
//        Игра началась!
//        Zombie #1 вступил в игру
//        Zombie #3 вступил в игру
//        Plant #1 вступил в игру
//        Zombie #2 вступил в игру
//        Plant #2 вступил в игру
//        Zombie #2 умер
//        Plant #2 умер
//        Plant #1 умер
//        Zombie #3 умер
//        Zombie #1 умер
//////////////////////////////////////////////////////////////////////////////////////////


 class Plant extends Character {
    private final static AtomicInteger idSequence = new AtomicInteger();
    private final int id = idSequence.incrementAndGet();

    protected int getId() {
        return id;
    }
}
