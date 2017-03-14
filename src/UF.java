import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UF {
	private int[] id; //分量id(以触点作为索引)
	private int count; // 分量数量
	/**
	 * 以整数标识（0到N-1）初始化N个触点
	 * @param N
	 */
	public UF(int N) {
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}
	
	/**
	 * 在p和q之间添加一条连接
	 * @param p
	 * @param q
	 */
	public void union(int p, int q) {
		/*quick-find算法
		 * // 将p和q归并到相同的分量中
		int pID = find(p);
		int qID = find(q);
		
		// 如果p和q已经在相同的分量之中则不需要采取任何行动
		if (pID == qID) return;
		
		// 将p的分量重命名为q的名称
		for (int i = 0; i < id.length; i++) {
			if (id[i] == pID) id[i] = qID;
		}
		count--;*/
		int pRoot = find(p);
		int qRoot = find(q);
		if (pRoot == qRoot) return;
		id[pRoot] = qRoot;
		count--;
		
	}
	
	/**
	 * p（0到N-1）所在的分量的标识符
	 * @param p
	 * @return
	 */
	public int find(int p) {
		/* quick-find算法
		 * return id[p];*/
		while (p != id[p]) p = id[p];
		return p;
	}
	
	/**
	 * 如果p和q存在于同一个分量中则返回true
	 * @param p
	 * @param q
	 * @return
	 */
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
	
	/**
	 * 连通分量的数量
	 * @return
	 */
	public int count() {
		return count;
	}
	
	public static void main(String[] args) {
		int N = StdIn.readInt();
		UF uf = new UF(N);
		while (!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if (uf.connected(p, q)) continue;
			uf.union(p, q);
			StdOut.println(p + " " + q);
		}
		StdOut.println(uf.count() + " components");
	}

}
