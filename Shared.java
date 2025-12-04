//import java.util.concurrent.Object.*;
import java.lang.*;

public class Shared {
    private int data;
    private boolean hasData = false;

    synchronized void produce(int value){
        while(hasData){
            try{
                wait();
            }
            catch(InterruptedException e){
                System.out.println(e);
                Thread.currentThread().interrupt();
                return;
            }
        }
    
        data = value;
        hasData = true;
        System.out.println("Produced:" + value);
        notify();
    }

    synchronized int consumer(){
        while(!hasData){
            try{
                wait();
            }
            catch(InterruptedException e){
                System.out.println(e);;
                Thread.currentThread().interrupt();
                return -1;
            }
        }
        hasData = false;
        System.out.println("Consumes: " + data);
        notify();
        return data;
    }

    static class Produce implements Runnable{
        private Shared buffer;

        Produce(Shared buffer){
            this.buffer = buffer;
        }

        public void run(){
            for(int i=0;i<5;i++){
                buffer.produce(i);
                try{
                    Thread.sleep(500);
                }catch(InterruptedException e){
                    System.out.println(e);
                }
            }
        }
    }

    static class Consume implements Runnable{
        private Shared buffer;

        Consume(Shared buffer){
            this.buffer = buffer;
        }

        public void run(){
            for(int i=0;i<5;i++){
                buffer.consumer();
                try{
                    Thread.sleep(500);
                }catch(InterruptedException e){
                    System.out.println(e);
                }
            }
        }
    }

    public static void main(String[] args){
        Shared share = new Shared();
        Thread producerThread = new Thread(new Produce(share));
        Thread consumeThread = new Thread(new Consume(share));

        producerThread.start();
        consumeThread.start();
    }
}
