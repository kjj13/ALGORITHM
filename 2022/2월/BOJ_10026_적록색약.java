package year2022.month02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_10026_적록색약 {
	static int N,ans1,ans2;
	static char[][] map;
	static boolean[][] check;
	static Queue<Node> Q;
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new char[N][N];
		ans1 = 0;
		ans2 = 0;
		Q = new LinkedList<Node>();
		
		for(int i=0;i<N;i++) {
			String str = sc.next();
			map[i] = str.toCharArray();
		}
		
		check = new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!check[i][j]) {
					ans1++;
					Q.add(new Node(i, j));
					check[i][j] = true;
					bfs1();
				}
			}
		}
		
		check = new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!check[i][j]) {
					ans2++;
					Q.add(new Node(i, j));
					check[i][j] = true;
					if(map[i][j] == 'B') {
						bfs1();
					}else {
						bfs2();
					}
				}
			}
		}
		
		System.out.println(ans1 + " " + ans2);
	}
	
	private static void bfs2() {
		while(!Q.isEmpty()) {
			Node cur = Q.poll();
			for(int dir=0;dir<4;dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];
				if(nx < 0 || nx >= N || ny < 0 || ny >=N || 
						check[nx][ny] || map[nx][ny] == 'B')
					continue;
				Q.add(new Node(nx, ny));
				check[nx][ny] = true;
			}
		}
	}

	private static void bfs1() {
		while(!Q.isEmpty()) {
			Node cur = Q.poll();
			for(int dir=0;dir<4;dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];
				if(nx < 0 || nx >= N || ny < 0 || ny >=N || 
						check[nx][ny] || map[nx][ny] != map[cur.x][cur.y])
					continue;
				Q.add(new Node(nx, ny));
				check[nx][ny] = true;
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
