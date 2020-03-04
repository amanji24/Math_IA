import java.io.FileNotFoundException;
import java.sql.*;

public class Testing {

	public static void main(String[] args) {

		int[] rand = new int[100000];
		for (int i = 0; i < rand.length; i++)
			rand[i] = (int) (Math.random()*10000);
		System.out.println("Starting");
		RadixSort.sort(rand);
		System.out.println("done");
		
	}

}
