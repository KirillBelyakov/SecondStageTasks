package JavaThreads.MainTask;


public class MainParking {
    public static void main(String[] args) {
        Parking parking = new Parking(4);

        for (int i = 0; i < 8; i++) {
            new Car(parking).start();
        }
    }
}