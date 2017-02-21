import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class BinarySearch {
	
	public static int rank(int key, int[] a)
	{
		int lo = 0;
		int hi = a.length - 1;
		
		while(lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if(key < a[mid]) hi = mid - 1;
			else if(key > a[mid]) lo = mid + 1;
			else return mid;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		StdOut.println("start...");
		
		//@SuppressWarnings("deprecation")
		int[] whitelist = In.readInts(args[0]);
		Arrays.sort(whitelist);
		StdOut.println("sort...");
		Scanner stdin = null;
		try {
			stdin = new Scanner(new File("./re/tinyT.txt"));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		while(stdin.hasNext()) {
			int key = stdin.nextInt();
			if(rank(key, whitelist) < 0)
				StdOut.println(key);
		}
		
		StdOut.println("end...");
		
		stdin.close();
	}

}
