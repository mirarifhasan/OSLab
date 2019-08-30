package thread;

public class SecondThread implements Runnable{

    @Override
    public void run() {
        
        System.out.println("hi");
        for(int i=0; i<1000; i++)
            System.out.println("Second Thread " + i);
    }
}
