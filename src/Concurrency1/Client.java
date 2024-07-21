package Concurrency1;

public class Client {
    public static void main(String[] args) {
        //We want to print number from 1 to 100 using multithreading
        NumberPrinter num;
        Thread thread;

        for(int i = 1; i <= 100; i++){
            num = new NumberPrinter(i);
            thread = new Thread(num);
            thread.start();

        }
    }
}
