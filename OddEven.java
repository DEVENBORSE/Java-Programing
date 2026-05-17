class Odd extends Thread {
    public void run(){
        for(int i=1;i<30;i+=2){
            System.out.println("Odd:"+i);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Even extends Thread{
    public void run(){
        for(int j=1;j<30;j+=2){
            System.out.println("Even:"+j);
            try {
                sleep(102);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class OddEven{
    public static void main(String[] args){
        new Odd().start();
        new Even().start();
    }
}
