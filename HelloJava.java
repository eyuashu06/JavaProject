import java.lang.*;

public class HelloJava extends Thread{

    private String message;
    private int duration;

    public HelloJava (){
        this.message = "Hello";
        this.duration = 1000;
    }

    public HelloJava(String message){
        this.message = message;
        this.duration= 1500;
    }

    public HelloJava(String message, int duration){
        this.message= message;
        this.duration = duration;
    }


    public void run(){
        try{
            Thread.sleep(duration);
        }
        catch(InterruptedException e){
            System.out.println(e);
        }
        System.out.println(message);
       }
    
    

    public static void main(String[] args){
        HelloJava h1 = new HelloJava();
        HelloJava h2 = new HelloJava("World");
        HelloJava h3 = new HelloJava("Java", 2000);

        h1.start();
        h2.start();
        h3.start();

    }
}