import java.util.Scanner;

class Leader {
    public static void main(String[] args) {
        System.out.println("Leader Program");
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("give the number of elements you want to add into array: ");
        int n = sc.nextInt();
        
        System.out.println("Enter the Values :");
        
        /* initializing the array */
        int arr[] = new int[n];
        
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        
        /* initializing the maxSoFar for bigger element */
        int count=0;
        int maxSoFar = Integer.MIN_VALUE;
        
        for(int i=0; i < n; i++){
            if(arr[i] > maxSoFar){
                count++;
                maxSoFar = arr[i];
            }
        }
        System.out.println("the total count is: " + count);
    }
}