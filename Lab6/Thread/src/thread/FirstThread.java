package thread;

public class FirstThread implements Runnable{

    public void run() {
        
        System.out.println("Hello");
        for(int i=0; i<1000; i++)
            System.out.println("First Thread " + i);
        
    }
}
