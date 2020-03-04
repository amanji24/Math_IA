

import java.util.Arrays;
import java.util.Collections;

public class RadixSort {

	public static void main(String[] args) {
		
		int[] rand = new int[1000];
		for (int i = 0; i < rand.length; i++) {
			rand[i] = (int) (Math.random()*100);
			System.out.print(rand[i] + ",");
		}
		System.out.println();
		sort(rand);
		for (int i = 0; i < rand.length; i++)
			System.out.print(rand[i] + ",");
		
	}
	
	public static void sort(int arr[]) 
	{ 
		
		int n = arr.length;
	    // Find the maximum number to know number of digits 
		int m = getMax(arr); 
		  
        // Do counting sort for every digit. Note that instead 
        // of passing digit number, exp is passed. exp is 10^i 
        // where i is current digit number 
        for (int exp = 1; m/exp > 0; exp *= 10) 
            countSort(arr, n, exp);
	} 
	
	public static void countSort(int arr[], int n, int exp) { 
        int output[] = new int[n]; // output array 
        int i; 
        int count[] = new int[10]; 
        Arrays.fill(count,0); 
  
        // Store count of occurrences in count[] 
        for (i = 0; i < n; i++) 
            count[ (arr[i]/exp)%10 ]++; 
  
        // Change count[i] so that count[i] now contains 
        // actual position of this digit in output[] 
        for (i = 1; i < 10; i++) 
            count[i] += count[i - 1]; 
  
        // Build the output array 
        for (i = n - 1; i >= 0; i--) 
        { 
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i]; 
            count[ (arr[i]/exp)%10 ]--; 
        } 
  
        // Copy the output array to arr[], so that arr[] now 
        // contains sorted numbers according to curent digit 
        for (i = 0; i < n; i++) 
            arr[i] = output[i];
	 
	}
	
	public static int getMax(int[] nums) {
		
		int max = nums[0];
		
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > max)
				max = nums[i];
		}
		
		return max;
		
	}
	
	
//*/	
}
