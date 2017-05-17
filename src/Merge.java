import javax.activation.CommandInfo;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * 归并排序
 * @author wangchao
 *
 */
public class Merge {
	private static Comparable[] aux; // 归并所需的辅助数组
	
	public static void sort(Comparable[] a) {
		aux = new Comparable[a.length];
		sort(a, 0, a.length-1);
	}
	
	public static void sort(Comparable[] a, int lo, int hi) {
		// 将数据a[lo..hi]排序
		if (hi <= lo) return;
		int mid = lo + (hi - lo) / 2;
		sort(a, lo, mid);
		System.out.println("Sort(lo = " + lo+", mid = " + mid);
		sort(a, mid+1, hi);
		System.out.println("Sort(mid+1 = " + (mid+1)+", hi = " + hi);
		merge(a, lo, mid, hi);
		System.out.println("Merge(lo = " + lo+", mid = " + mid + ", hi = " + hi);
		System.out.println("----------");
	}
	
	public static void merge(Comparable[] a, int lo, int mid, int hi) {
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			// 将a[lo..hi]复制到aux[lo..hi]
			aux[k] = a[k];
		}
		for (int k = lo; k <= hi; k++) {
			// 归并回到a[lo..hi]
			if (i > mid) {
				System.out.printf("i > mid | i = %d, mid = %d\n", i, mid);
				a[k] = aux[j++];
			}
			else if (j > hi) {
				System.out.printf("j > hi | j = %d, hi = %d\n", j, hi);
				a[k] = aux[i++];
			}
			else if (less(aux[j], aux[i])) {
				System.out.printf("aux[j] < aux[i], aux[j] = %s, aux[i] = %s\n", aux[j], aux[i]);
				a[k] = aux[j++];
			}
			else a[k] = aux[i++];
		}
	}
	
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			StdOut.print(a[i] + " ");
		}
		StdOut.println();
	}
	
	public static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			if (less(a[i], a[i-1])) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String[] a = In.readStrings("re/tiny.txt");
		sort(a);
		assert isSorted(a);
		show(a);
	}
}
