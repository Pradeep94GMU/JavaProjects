package deque;

public class DequePrac {

    //what i need
    static final int max = 100;
    int[] arr;
    int front;
    int rear;
    int size;

    public DequePrac(int size){
        arr = new int[size];
        front = -1;
        rear = 0;
        this.size = size;
    }

    //functions for our app
    /*
    insertFront();
    insertRear();
    deleteFront();
    deleteRear();
    getFront();
    getRear();
    isFull();
    isEmpty();
     */

    boolean isFull(){
        //if both front and rear are at beggining and end then full or front is next to rear
        return (front == 0 && rear == size - 1) || (front == rear + 1);
    }

    boolean isEmpty(){
        return (front == -1);
    }

    //insertFront
    public void insertFront(int key){
        //insert krne se phle, check if we have any spot to insert
        if(isFull()){
            System.out.println("No spot left, overflow");
            return;
        }

        //or check if no entry till
        if(front == -1){
            front = 0;
            rear = 0;
        }
        //dono ab saame spot pe aa gye, now we can insert
        else if(front == 0){
            //to hame last index pe move krna prega , key daalne se phle
            front = size - 1;
        }
        else{
            front = front - 1;
        }

        arr[front] = key;
    }

    //insertRear
    public void insertRear(int key){
        if(isFull()){
            System.out.println("Overflow");
            return;
        }

        if(front == -1){
            front = 0;
            rear = 0;
        }

        else if (rear == size-1){
            rear = 0;
        }
        else{
            rear++;
        }

        arr[rear] = key;
    }

    public int getFront(){
        if(front == -1){
            System.out.println("Empty Queue");
            return -1;
        }
        return arr[front];
    }
    public int getRear(){
        if(front == -1){
            System.out.println("Empty Queue");
            return -1;
        }
        return arr[rear];
    }

    //deleteFront
    public void deleteFront(){
        if(isEmpty()){
            System.out.println("Underflow");
            return;
        }

        //edge case
        //only 1 element
        if(front == rear){
            front = -1;
            rear = -1;
        }
        else if(front == size - 1){
            front = 0;
        }
        else{
            front++;
        }
    }

    //deleteRear
    public void deleteRear(){
        if(isEmpty()){
            System.out.println("Underflow");
            return;
        }

        //edge case
        //only 1 element
        if(front == rear){
            front = -1;
            rear = -1;
        }
        else if(rear == 0){
            rear = size - 1;
        }
        else{
            rear--;
        }
    }



    public static void main(String[] args) {

        DequePrac dequePrac = new DequePrac(5);
        boolean res = dequePrac.isEmpty();
        System.out.println(res);
         boolean full = dequePrac.isFull();
        System.out.println(full);

        dequePrac.insertRear(4);
        dequePrac.insertFront(5);
        dequePrac.insertFront(25);
        dequePrac.insertFront(45);
        dequePrac.insertRear(14);



        dequePrac.insertRear(134);

        int fVal = dequePrac.getFront();
        System.out.println(fVal);

        int rVal = dequePrac.getRear();
        System.out.println(rVal);

        dequePrac.deleteFront();
        dequePrac.deleteRear();
        dequePrac.deleteRear();

    }
}
