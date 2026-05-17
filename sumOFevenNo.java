import java.lang.*;

class sumOFevenNo{
    public static void main(String[] args) {
        int sum = 0;
        int n=4;

        for(int i=0;i<n;i++){
            sum = sum + (2*i);
        }
        System.out.print("sum of even numbers:");
        System.out.println(sum);

    }
}