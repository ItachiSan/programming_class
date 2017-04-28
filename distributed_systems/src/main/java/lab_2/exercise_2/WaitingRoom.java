package lab_2.exercise_2;

import java.util.ArrayList;
import java.util.List;

class WaitingRoom {
    private List<Animal> queue;

    WaitingRoom() {
        queue = new ArrayList<Animal>(4);
    }

    synchronized void enter(Animal a) throws InterruptedException {
        //wait();
        while (!canEnter(a))
            wait();
        queue.add(a);
        System.out.println("A " + a + " gets in -> \t" + queue);
    }

    synchronized void exit(Animal a) {
        queue.remove(a);
        System.out.println("A " + a + " exits   -> \t" + queue);
        notifyAll();
    }

    private synchronized boolean canEnter(Animal a) {
        if (a instanceof Cat)
            return queue.size() == 0;
        else if (a instanceof Dog)
            return queue.size() < 4 && !hasOneCat();
        else
            return false;
    }

    private synchronized boolean hasOneCat() {
        for (Animal a : queue)
            if (a instanceof Cat)
                return true;
        // else
        return false;
    }
}