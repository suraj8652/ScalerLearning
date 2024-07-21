package addSubtractUsingSynchronisedMethod;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        Count count = new Count();

        Adder add = new Adder(count);

        Subtractor subtract = new Subtractor(count);

        Thread t1 = new Thread(add);

        Thread t2 = new Thread(subtract);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(count.getValue());
    }
}
