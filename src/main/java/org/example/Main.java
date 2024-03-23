package org.example;

class OddEvenPrinter {
    private int currentNumber = 1;
    private boolean oddTurn = true;
    private final int maxNumber;

    public OddEvenPrinter(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    public synchronized void printOdd() {
        while (currentNumber <= maxNumber) {
            while (!oddTurn) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Thread interrupted");
                }
            }
            System.out.println("Odd Thread: " + currentNumber++);
            oddTurn = false;
            notifyAll();
        }
    }

    public synchronized void printEven() {
        while (currentNumber <= maxNumber) {
            while (oddTurn) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Thread interrupted");
                }
            }
            System.out.println("Even Thread: " + currentNumber++);
            oddTurn = true;
            notifyAll();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        final OddEvenPrinter printer = new OddEvenPrinter(10);

        Thread oddThread = new Thread(printer::printOdd);
        Thread evenThread = new Thread(printer::printEven);

        oddThread.start();
        evenThread.start();

        try {
            oddThread.join();
            evenThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
