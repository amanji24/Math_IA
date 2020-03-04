

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Runner {
	
	static int num = (int) (Math.random()*3)+3;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		System.setOut(new PrintStream(new File("files/binaryTree/random.txt")));
		
		long[] data = new long[1000];
		
		float mean;
		float stdev;
		float variance;
				
		for (int j = 0; j < data.length; j++)
			data[j] = run();
		
		
		//printArray(data);
		
		//System.out.println();
		
		System.out.println("With Outliers:\n");
				
		ArrayList<Integer> outs = Stats.getOutliers(data);
				
		ArrayList<Long> finals = new ArrayList<Long>();
		
		for (long d : data) {
			//if (!outs.contains((int) d))
				finals.add(d);
		}
		
		mean = Stats.getMean(finals);
		stdev = Stats.getStdDev(finals, mean);
		variance = (float) Stats.square(stdev);

		printInfo(mean, stdev, variance);
		
		System.out.println("\n––––––––––\n\nWithout Outliers:\n");
		
		finals.clear();
		
		for (long d : data) {
			if (!outs.contains((int) d))
				finals.add(d);
		}
		
		mean = Stats.getMean(finals);
		stdev = Stats.getStdDev(finals, mean);
		variance = (float) Stats.square(stdev);

		printInfo(mean, stdev, variance);
		
		
		// Sorting data as it comes in, then searching
		// vs.
		// adding data to a list
		
		// linear search vs. binary
		//     (unsorted vs. sorted)

		// types of sorts
		
		// * big omega notation
		
	}
	
	public static long run() {
		
		int[] randArr = new int[100000];
		
		/*for (int i = 0; i < randArr.length; i++) {
			if (i % num == 0 && i != 0) {
				randArr[i] = (int) (Math.random()*100000);
				num = (int) (Math.random()*3)+3;
			} else
				randArr[i] = i;
		}
		//*/
		
		for (int i = 0; i < randArr.length; i++)
			randArr[i] = (int) (Math.random()*100000);
		//*/
		
		//printArray(randArr);
		//System.out.println();
		
		long t = System.currentTimeMillis();
				
		BinaryTree.sort(randArr);
		
		//Arrays.sort(randArr);
		
		//RadixSort.sort(randArr);
		
		return System.currentTimeMillis() - t;
	}
	
	public static int[] reverse(int[] a) {
		int[] b = new int[a.length];
		for (int i = 0; i < a.length; i++)
			b[i] = a[a.length-i-1];
		return Arrays.copyOf(b, b.length);
	}
	
	public static void printArray(int[] a) {
		System.out.print("(");
		for (int j = 0; j < a.length; j++) {
			System.out.print(a[j]);
			if (j != a.length-1)
				System.out.print(",");
		}
		System.out.println(")");
	}
	
	public static void printArray(long[] a) {
		System.out.print("(");
		for (int j = 0; j < a.length; j++) {
			System.out.print(a[j]);
			if (j != a.length-1)
				System.out.print(",");
		}
		System.out.println(")");
	}
	
	public static void printInfo(float mean, float stdev, float var) {
		
		System.out.println("Mean: " + mean + "\nStandard Deviation: " + stdev + "\nVariance: " + var);
		
	}

}
