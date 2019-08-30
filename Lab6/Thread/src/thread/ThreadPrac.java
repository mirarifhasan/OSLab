package thread;


public class ThreadPrac {

    public static void main(String[] args) {
        
        Thread t = new Thread(new FirstThread());
        Thread tt = new Thread(new SecondThread());
        
        t.start();
        tt.start();
        
    }    
}
