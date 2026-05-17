import java.lang.*;

public class PrintingPatternNumber{
    public static void main(String[] args) {
        int y=20;
        for(int x=0;x<=10;x++){
            System.out.println("x="+x+", y="+y);
            y =y-2;
        }
    }
}
