package MergeSort;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> listToSort = List.of(3,2,1,4,5,6);

        ExecutorService service = Executors.newCachedThreadPool();

        MergeSorter sort = new MergeSorter(listToSort, service);

        Future<List<Integer>> sortedListFuture = service.submit(sort);

        List<Integer> sortedList;
        sortedList = sortedListFuture.get();

        System.out.println(sortedList);
    }


}
