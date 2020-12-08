package JavaThreads.MainTask;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Car extends Thread {
    private static int counter = 1;
    private int id;
    private int waitingTime;
    private Random random;
    private Parking parking;

    public Car(Parking parking) {
        this.parking = parking;
        this.id = counter++;
        random = new Random();
        waitingTime = random.nextInt(5) + 10;
    }

    @Override
    public void run() {
        try {
            System.out.println("Машина №" + id + " приехала на стоянку");
            System.out.println("Машина №" + id + " пытается припарковаться и не будет ждать более " + waitingTime + " секунд");
            TimeUnit.MILLISECONDS.sleep(random.nextInt(15) * 1000);
            if (parking.tryParkCar(waitingTime)) {
                int timeStand = random.nextInt(20) + 10;
                System.out.println("Машина №" + id + " припарковалась на " + timeStand + " секунд");
                TimeUnit.SECONDS.sleep(timeStand);
                System.out.println("Машина № " + id + " уехала с парковки");
                parking.leaveParking();
            } else {
                System.out.println("Машина № " + id + " не может больше ждать и уезжает");
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}