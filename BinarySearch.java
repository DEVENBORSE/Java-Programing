
import java.util.Scanner;

public class BinarySearch {
	static int binarySearch(int arr[], int key) {
        int low = 0;
		int high = arr.length - 1;
		
		
		while(low <= high) {
			int mid = (low+high)/2;
			
			if(arr[mid] == key) {
				return mid;
			}
			else if(key < arr[mid]) {
				high = mid - 1;
			}
			else {
				low = mid +1;
			}
			
		}
        return -1;
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of array: ");
		int n = sc.nextInt();
		
		int arr[] = new int[n];
		
		System.out.println("Enter"+ n + "sorted elements");
		for(int i = 0; i<n ; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println("Enter the element to search:");
		int key = sc.nextInt(); 
		
		int result = binarySearch(arr, key);
		
	       if (result != -1) {
	            System.out.println("Element found at index: " + result);
	        } else {
	            System.out.println("Element not found in the array");
	        }

	        sc.close();
		
	}
}
