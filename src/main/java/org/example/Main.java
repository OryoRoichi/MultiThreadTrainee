package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long n = 10000;
        int k = 10;
        long res = 0;
        int size = 0;

        List<Long> threadResults = new ArrayList<>();
        SomeCalculation calculation = new SomeCalculation();
        ExecutorService service = Executors.newFixedThreadPool(k);

        calculation.findBorder(n, k);
        calculation.printBorderList();
        size = calculation.getBorderListSize();


        for (int i = 1; i < size; i++) {

            int finalI = i;
            Future future = service.submit(new Runnable() {
                @Override
                public void run() {
                    threadResults.add(calculation.sumNumberFromTill(calculation.getFromBorderListById(finalI - 1),
                            calculation.getFromBorderListById(finalI)));
                }
            });
            future.get();
        }
        for (Long elem : threadResults) {
            res += elem;
            System.out.println(res);
        }
        service.shutdown();

    }
}