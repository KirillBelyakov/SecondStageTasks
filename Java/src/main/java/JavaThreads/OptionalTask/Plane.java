package JavaThreads.OptionalTask;

import java.util.concurrent.Semaphore;

public class Plane extends Thread {
    private Semaphore semaphore;
    private String name;

    Plane(Semaphore semaphore, String name) {
        this.semaphore = semaphore;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println(name + " начал выход на полосу");
            System.out.println("Полоса приняла " + name);
            sleep(3000);
            System.out.println(name + " Самолет взлетел");

            System.out.println("Полоса освободилась");
            semaphore.release();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}