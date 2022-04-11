package month01;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1753_최단경로 {
	static int V,E,K;
	static int[][] map;
	static int[] DP;
	static Queue<Integer> Q;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		K = sc.nextInt();
		map = new int[V+1][V+1];
		DP = new int[V+1];
		Q = new LinkedList<>();
		
		for(int i=0;i<E;i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			map[u][v] = w;
		}
		// 입력 완료
		
		Q.add(K);
		DP[K] = 0;
		
		bfs();
		
		for(int i=1;i<=V;i++) {
			if(i != K && DP[i] == 0) {
				System.out.println("INF");
			}else {
				System.out.println(DP[i]);
			}
		}
	}

	private static void bfs() {
		while(!Q.isEmpty()) {
			int from = Q.poll();
			for(int i=1;i<=V;i++) {
				if(map[from][i]>0) {
					int sum = DP[from] + map[from][i];
					if(DP[i] == 0 || DP[i] > sum) {
						DP[i] = sum;
						Q.add(i);
					}
				}
			}
		}
	}
}
