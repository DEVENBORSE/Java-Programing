import java.lang.*;

class TableOfNumber{
    public static void main(String[] args) {
        int n=5;
        for(int i=1;i<=10;i++){
            System.out.println(n+"*"+i+"="+n*i);
        }

        System.out.println();

        System.out.println("In reverse order");

        //In reverse order
        int s=2;
        for(int i=10;i>=1;i--){
            System.out.println(s+"*"+i+"="+s*i);
        }

    }
}