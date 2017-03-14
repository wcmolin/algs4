import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class TwoSum {
	public static int count(int[] a) {
		int N = a.length;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
					if (a[i] + a[j] == 0) {
						StdOut.println("a[i] = " + a[i] + " a[j] = " + a[j]);
						cnt++;
				}
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
