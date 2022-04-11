package year2022.month01;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_Contact {
	static int N,start,ans;
	static boolean[][] map;
	static boolean[] visit;
	static Queue<Integer> Q;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1;tc<=10;tc++) {
			N = sc.nextInt();
			start = sc.nextInt();
			map = new boolean[101][101];
			visit = new boolean[101];
			Q = new LinkedList<Integer>();
			
			Q.add(start);
			visit[start] = true;
			
			for(int i=0;i<N/2;i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				map[from][to] = true;
			}
			// 입력 완료
			
			bfs();
			
			System.out.println("#" + tc + " " + ans);
		}
	}

	private static void bfs() {
		while(!Q.isEmpty()) {
			int size = Q.size();
			ans = 0;
			for(int s=0;s<size;s++) {
				int from = Q.poll();
				ans = Math.max(ans, from);
				for(int i=1;i<101;i++) {
					if(map[from][i] && !visit[i]) {
						Q.add(i);
						visit[i] = true;
					}
				}
			}
		}
	}
}
