package com.s3d.tech.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Special used to process callable tasks. 
 * At last get all the tasks result. 
 * @author wind.chen
 *
 * @param <T>
 */
public class MultiTaskProcessor<T> {
    private static ExecutorService taskExecutor = Executors.newCachedThreadPool();
	private List<Future<T>> futures = new ArrayList<Future<T>>();

    public static <X> List<X> runTasksWithResults(List<Callable<X>> tasks)
            throws InterruptedException, ExecutionException {
        MultiTaskProcessor<X> multiTaskProcessor = new MultiTaskProcessor<X>();
        return multiTaskProcessor.executeTasksWithResults(tasks);
    }

    public List<T> executeTasksWithResults(List<Callable<T>> tasks){
        if (tasks == null || tasks.size() == 0) {
            return null;
        }

        // run task.
        for (Callable<T> task : tasks) {
            this.addExecutedTask(task);
        }
        return getTaskResults();
    }

    public T executeTaskWithResult(Callable<T> task){
        if(task == null){
            return null;
        }
        this.addExecutedTask(task);
        List<T> results = getTaskResults();
        if(results == null || results.size() == 0){
            return null;
        }else {
            return results.get(0);
        }
    }

    /**
     * add task to task list.
     * @param task
     */
    public void addExecutedTask(Callable<T> task) {
        if (task == null) {
            return;
        }
        Future<T> future = taskExecutor.submit(task);
        this.futures.add(future);
    }

    /**
     * Get tasks' executed results.
     * @return
     */
    public List<T> getTaskResults() {
        List<T> results = new ArrayList<T>();
        for (int i = 0; i < futures.size(); i++) {
            try {
                T rtnValue = futures.get(i).get();
                if (rtnValue != null) {
                    results.add(rtnValue);
                }
            } catch (Exception e) {
                throw new RuntimeException("Failed to get value of callable object", e.getCause());
            }
        }
        return results;
    }
}
