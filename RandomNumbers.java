import java.util.Random;
public class RandomNumbers{
    public static void main(String[] args){
        Random random= new Random();

        boolean isHeads;
        isHeads = random.nextBoolean();
        if (isHeads) {
            System.out.println("Heads");
        } else {
            System.out.println("Tails");
        }
        System.out.println();

        int n = random.nextInt(1,7);
        System.out.println("The random no.is: "+ n);
    }
}