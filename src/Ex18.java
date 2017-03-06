import edu.princeton.cs.algs4.In;

/**
 * Á·Ï°2.1.18
 * @author wangchao
 *
 */
public class Ex18 {

	public static void main(String[] args) {
		String[] a = In.readStrings("re/tiny.txt");
		String sort = "insertion";
		if (sort.equals("selection")) {
			Selection.drawSort(a);
		} else if (sort.equals("insertion")) {
			Insertion.drawSort(a);
		}
	}

}
