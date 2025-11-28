import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuteProgram {
    public static void main(String[] args){
        ExecutorService pool = Executors.newFixedThreadPool(3);

        for(int i=0; i<5; i++){
            int taskId = i;

            Runnable task = () -> {
                System.out.println("Task " + taskId + " is running on "+ Thread.currentThread().getName());
                try{
                    Thread.sleep(500);
                }catch(InterruptedException e){
                    System.out.println(e);
                }
                System.out.println("Task " + taskId + " finished");
            };

            pool.execute(task);
        }
        pool.shutdown();
}
}
