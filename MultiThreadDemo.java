class NumberPrinter extends Thread{
    private String threadName;

    NumberPrinter(String name){
        threadName = name;
    }

    public void run(){
        for (int i=1;i<=5;i++){
            System.out.println(threadName+"prints:"+i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(threadName+"interrupted");
            }
        }
    }
}

public class MultiThreadDemo{
    public static void main(String[] args) {
        NumberPrinter thread1 = new NumberPrinter("Thread-1");
        NumberPrinter thread2 = new NumberPrinter("Thread-2");
        NumberPrinter thread3 = new NumberPrinter("Thread-3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}