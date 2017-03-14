import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class ThreeSumFast {
	public static int count(int[] a) {
		// 计算和为0 的三元组的数目
		Arrays.sort(a);
		int N = a.length;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if (BinarySearch.rank(-a[i] - a[j], a) > j) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		int[] a = In.readInts("re/8Kints.txt");
		StdOut.println(count(a));
	}

}
