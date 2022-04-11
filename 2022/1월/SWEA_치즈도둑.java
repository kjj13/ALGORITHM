package year2022.month01;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_치즈도둑 {
	static int T,N,maxT,ans;
	static int[][] map;
	static boolean[][] visit;
	static Queue<Node> Q;
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			N = sc.nextInt();
			map = new int[N][N];
			Q = new LinkedList<Node>();
			ans = Integer.MIN_VALUE;
			maxT = Integer.MIN_VALUE;
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					int num = sc.nextInt();
					maxT = Math.max(maxT, num);
					map[i][j] = num;
				}
			}
			// 입력완료
			if(maxT == 1) {
				System.out.println("#" + tc + " " + 1);
				continue;
			}
			for(int s=1;s<=maxT;s++) {
				remove(s);
				int cnt = 0;
				visit = new boolean[N][N];
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						if(map[i][j] > 0 && !visit[i][j]) {
							cnt++;
							Q.add(new Node(i,j));
							visit[i][j] = true;
							bfs();
						}
					}
				}
				ans = Math.max(ans, cnt);
			}
			
			System.out.println("#" + tc + " " + ans);
		}
	}
	
	private static void bfs() {
		while(!Q.isEmpty()) {
			Node cur = Q.poll();
			for(int dir=0;dir<4;dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];
				if(nx < 0 || nx >= N || ny < 0 || ny >= N || visit[nx][ny] || map[nx][ny] == 0)	continue;
				Q.add(new Node(nx, ny));
				visit[nx][ny] = true;
			}
		}
	}

	private static void remove(int s) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j] == s) {
					map[i][j] = 0;
				}
			}
		}
	}

	private static class Node{
		int x,y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
