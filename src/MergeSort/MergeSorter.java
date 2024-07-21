package MergeSort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MergeSorter implements Callable<List<Integer>> {
    private List<Integer> listToSort;
    private ExecutorService service;

    MergeSorter(List<Integer> listToSort,ExecutorService service){
        this.listToSort = listToSort;
        this.service = service;
    }



    @Override
    public List<Integer> call() throws Exception {
        //merge sort logic
        int n = listToSort.size();

        if(n <= 1){
            return listToSort;
        }

        List<Integer> leftHalf = new ArrayList<>();
        List<Integer> rightHalf = new ArrayList<>();

        for(int i = 0; i < n/2; i++){
            leftHalf.add(listToSort.get(i));
        }

        for(int i = n/2; i < n; i++){
            rightHalf.add(listToSort.get(i));
        }

        MergeSorter leftMergeSort = new MergeSorter(leftHalf, service);
        MergeSorter rightMergeSort = new MergeSorter(rightHalf, service);

        //ExecutorService service  = Executors.newCachedThreadPool();

        Future<List<Integer>> leftSortedListFuture = service.submit(leftMergeSort);
        Future<List<Integer>> rightSortedListFuture = service.submit(rightMergeSort);

        List<Integer> leftSortedList = leftSortedListFuture.get();
        List<Integer> rightSortedList = rightSortedListFuture.get();


        int i = 0, j = 0;


        List<Integer> sortedList = new ArrayList<>();

        while(i < leftSortedList.size() && j < rightSortedList.size()){
            if(leftSortedList.get(i) < rightSortedList.get(j)){
                sortedList.add(leftSortedList.get(i));
                i++;
            }
            else{
                sortedList.add(rightSortedList.get(j));
                j++;
            }
        }

        while(i < leftSortedList.size()){
            sortedList.add(leftSortedList.get(i));
            i++;
        }

        while(j < rightSortedList.size()){
            sortedList.add(rightSortedList.get(j));
            j++;
        }

        return sortedList;





    }
}
