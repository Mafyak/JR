package test;

import java.util.ArrayList;

public class Hippodrome {

    private static ArrayList<Horse> horses = new ArrayList<>();
    public boolean running = true;

    public static void main(String[] args) throws InterruptedException {
        Hippodrome game = new Hippodrome();
        horses.add(new Horse("Bobby", 2, 0));
        horses.add(new Horse("Jim", 2, 0));
        horses.add(new Horse("Diego", 2, 0));

        game.run();
    }

    public Horse getWinner() {
        double max = 0;
        Horse winner = null;
        for (Horse horse : horses) {
            if (horse.getDistance() > max) {
                max = horse.getDistance();
                winner = horse;
            }
        }
        return winner;
    }

    public void printWinner() {
        System.out.println("Winner is: " + getWinner().getName());
        System.out.println("WWWwhhhhoooaaaahhh");
    }

    public void run() throws InterruptedException {
            while (running) {
                move();
                Thread.sleep(200);
        }
    }

    public void move() {
        for (Horse horse : horses) {
            if(running){
                horse.move();
                horse.print();
            }
            if (Horse.totalDist - horse.getDistance() < 0) {
                getWinner();
                printWinner();
                running = false;
            }
        }
        System.out.println();
    }
}
