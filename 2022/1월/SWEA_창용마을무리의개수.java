package year2022.month01;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SWEA_창용마을무리의개수 {
	static int T,N,M;
	static int[] parent;
	static Set<Integer> set;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			set = new HashSet<>();
			make();
			for(int i=0;i<M;i++) {
				union(sc.nextInt(),sc.nextInt());
			}
			for(int i=1;i<=N;i++) {
				set.add(find(i));
			}
			
			System.out.println("#" + tc + " " + set.size());
		}
	}

	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot != bRoot) {
			parent[aRoot] = bRoot;
		}
	}

	private static int find(int a) {
		if(a == parent[a])	return a;
		return parent[a] = find(parent[a]);
	}

	private static void make() {
		parent = new int[N+1];
		for(int i=1;i<=N;i++) {
			parent[i] = i;
		}
	}
	
}
