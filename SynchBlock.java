import java.util.*;

public class SynchBlock {
    private final List<Integer> list = new LinkedList<Integer>();
    private final int limit = 5;
    public void produce(int value)throws InterruptedException{
        synchronized(this){
            while(list.size() == limit){
                    System.out.println("Buffer full -> Producer waiting ... ");
                    list.wait();
            }

            list.add(value);
            System.out.println("Produce:" + value);
            list.notify();

        }
        }
        public int consume()throws InterruptedException{
            synchronized(this){
                while(list.isEmpty()){
                    System.out.println("Buffer empty -> Consumer waitingg ... ");
                    list.wait();
                }

                int value = list.remove(0);
                System.out.println("Consume:"+ value);

                list.notify();

                return value;
            }
        }

        static class Produce implements Runnable{
            private SynchBlock buffer;

            Produce(SynchBlock buffer){
                this.buffer = buffer;
            }

            public void run(){
                int value = 1;
                while(value<10){
                    try{
                        buffer.produce(value);
                        value++;
                        Thread.sleep(500);
                    }catch(InterruptedException e){
                        System.out.println(e);
                    }
                }
            }
        }

        static class Consume implements Runnable{
            private SynchBlock buffer;

            Consume(SynchBlock buffer){
                this.buffer = buffer;
            }

            public void run(){
                while(true){
                    
                    try{
                        buffer.consume();
                        Thread.sleep(500);
                    }catch(InterruptedException e){
                        System.out.println(e);
                    }
                }
            }
        }

    
        public static void main(String[] args){
            SynchBlock sync = new SynchBlock();
            Thread produce = new Thread(new Produce(sync));
            Thread consume = new Thread(new Consume(sync));

            produce.start();
            consume.start();
        }
    }    
        


