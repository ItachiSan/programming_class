package lab_2.exercise_2;

import java.util.Random;

public class BusyDay {
    public static void main (String[] args) throws Exception {
        /* Get the number of queue animals */
        int limit = Integer.parseInt(args[0]);
        /* Get a random generator for stuff */
        Random r = new Random();

        /* Prepare the waiting room */
        WaitingRoom waitingRoom = new WaitingRoom();

        for (int i = 0; i < limit; i++) {
            /* Let the coin choose if it is a dog or a cat */
            Animal a = r.nextBoolean() ? new Dog() : new Cat();
            /* Create a thread for the new puppy */
            Thread new_animal = new Thread(
                new AnimalThread(a, waitingRoom)
            );
            /* Let the wait begin! */
            new_animal.start();
        }

    }
}

class AnimalThread implements Runnable {
    private Animal animal;
    private WaitingRoom waitingRoom;

    AnimalThread(Animal animal, WaitingRoom waitingRoom) {
        this.animal = animal;
        this.waitingRoom = waitingRoom;
    }

    public void run() throws RuntimeException {
        try {
            waitingRoom.enter(animal);
            //Thread.sleep(100);
            waitingRoom.exit(animal);
        } catch (InterruptedException ie) {
            // Try again
            this.run();
        }
    }
}