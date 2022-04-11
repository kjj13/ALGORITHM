package year2022.month01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_17141_연구소2 {
	static int N,M,ans;
	static int[][] map,initMap;
	static List<Node> virus;
	static boolean[] check;
	static boolean[][] visit;
	static Queue<Node> Q;
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N =sc.nextInt();
		M = sc.nextInt();
		
		initMap = new int[N][N];
		map = new int[N][N];
		virus = new ArrayList<Node>();
		ans = Integer.MAX_VALUE;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int num = sc.nextInt();
				if(num == 2) {
					virus.add(new Node(i, j));
				}
				initMap[i][j] = num;
			}
		}
		check = new boolean[virus.size()];
		// 입력완료
		
		comb(0,0);
		
		ans = ans == Integer.MAX_VALUE ? -1 : ans;
		
		System.out.println(ans);
	}
	
	private static void comb(int target, int cnt) {
		if(cnt == M) {
			makeMap();
			visit = new boolean[N][N];
			Q = new LinkedList<Node>();
			for(int i=0;i<virus.size();i++) {
				if(check[i]) {
					Node v = virus.get(i);
					Q.add(v);
					visit[v.x][v.y] = true;
				}
			}
			
			bfs();
			return;
		}
		if(target == virus.size()) {
			return;
		}
		
		check[target] = true;
		comb(target+1,cnt+1);
		check[target] = false;
		comb(target+1,cnt);
	}

	private static void bfs() {
		int time = -1;
		while(!Q.isEmpty()) {
			int size = Q.size();
			time++;
			for(int i=0;i<size;i++) {
				Node cur = Q.poll();
				for(int dir=0;dir<4;dir++) {
					int nx = cur.x + dx[dir];
					int ny = cur.y + dy[dir];
					if(nx < 0 || nx >= N || ny < 0 || ny >= N || visit[nx][ny] || map[nx][ny] == 1)
						continue;
					Q.add(new Node(nx, ny));
					visit[nx][ny] = true;
					map[nx][ny] = 2;
				}
			}
		}
		if(mapCheck()) {
			ans = Math.min(ans, time);
		}
	}

	private static boolean mapCheck() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	private static void makeMap() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j] = initMap[i][j];
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
