package multiThread;

class OddEven{
    private int curr = 1;
    private final int max;
    private boolean oddTurn = true;

    public OddEven(int max){
        this.max = max;
    }

    public synchronized void printOdd()  {
        while(curr <= max){
            while(!oddTurn){
                try{
                    wait();
                }
                catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                    System.out.println("Found Exception");
                }
            }

            System.out.println("Odd Num: "+ curr++);

            oddTurn = false;
            notifyAll();

        }
    }

    public synchronized void printEven() {

        while(curr <= max){
            while(oddTurn){
                try{
                    wait();
                }
                catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                    System.out.println("Found Exception");
                }
            }
            System.out.println("Even Num: "+ curr++);
            oddTurn = true;
            notifyAll();
        }

    }

}
public class AddNumber {
    public static void main(String[] args) {

      System.out.println("Printing 2 numbers");
      final OddEven printer = new OddEven(10);

      Thread even = new Thread(printer::printEven);
      Thread odd = new Thread(printer::printOdd);

        odd.start();
      even.start();


        try {
            odd.join();
            even.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
