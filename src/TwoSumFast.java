import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class TwoSumFast {
	public static int count(int[] a) {
		// 计算和为0的整数对的数目
		Arrays.sort(a);
		int N = a.length;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (BinarySearch.rank(-a[i], a) > i) {
				StdOut.println("a[i] = " + a[i]);
				cnt++;
			}
		}
		return cnt;
	}
	public static void main(String[] args) {
		int[] a = In.readInts("re/largeW.txt");
		Stopwatch timer = new Stopwatch();
		StdOut.println(count(a));
		StdOut.println(timer.elapsedTime());
	}
}
