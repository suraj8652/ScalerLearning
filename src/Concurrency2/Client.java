package Concurrency2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class  Client {
    public static void main(String[] args) {
        //practically using 100 tread is not good practise as this jobs are very simple
        //We can use ServiceExecutor
        NumberPrinter num;
        //Thread thread;

        ExecutorService service = Executors.newFixedThreadPool(10);

        for(int i = 1; i <= 100; i++){
            num = new NumberPrinter(i);
            //thread = new Thread(num);
            service.submit(num);
            //thread.start();

        }
        service.shutdown();
    }
}
