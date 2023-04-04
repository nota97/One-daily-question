package oneDailyQuestion.Solution0025.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class test1 {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(String.valueOf(i));
        }

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < list.size(); i += 1000) {
            List<String> batchList = list.subList(i, Math.min(i + 1000, list.size()));
            Runnable syncRunnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println(batchList.size());
                    System.out.println("111111111111");
                    //System.out.println(Thread.currentThread().getName());
                }
            };
            executorService.execute(syncRunnable);
        }
        executorService.shutdown();
    }
}
