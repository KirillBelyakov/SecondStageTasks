package JavaThreads.OptionalTask;

import java.util.concurrent.Semaphore;

public class AirportLines {


    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5, true);
        for (int i = 1; i < 11; i++)
            new Plane(semaphore, "Самолет " + i).start();
    }
}

