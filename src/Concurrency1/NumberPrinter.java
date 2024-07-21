package Concurrency1;

public class NumberPrinter implements Runnable{

    int number;

    public NumberPrinter(int number){
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println(number + " Current Thread is : " + Thread.currentThread().getName());

    }
}
