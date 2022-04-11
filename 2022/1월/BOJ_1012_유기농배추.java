package year2022.month01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_1012_유기농배추 {
	static int T,M,N,K,ans;
	static int[][] map;
	static Queue<Node> Q;
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			Q = new LinkedList<>();
			ans = 0;
			
			map = new int[N][M];
			for(int i=0;i<K;i++) {
				st = new StringTokenizer(br.readLine()," ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = 1;
			}
			// 입력완료
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(map[i][j] == 1) {
//						Q.add(new Node(i, j));
//						map[i][j] = 0;
						ans++;
//						bfs();
						dfs(i,j);
					}
				}
			}
			
			System.out.println(ans);
		}
	}
	
	private static void dfs(int i, int j) {
		if(map[i][j] == 0)
			return;
		map[i][j] = 0;
		for(int dir=0;dir<4;dir++) {
			int nx = i + dx[dir];
			int ny = j + dy[dir];
			if(nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == 0)	continue;
			if(map[nx][ny] == 1) {
				dfs(nx,ny);
			}
		}
	}

	private static void bfs() {
		while(!Q.isEmpty()) {
			Node cur = Q.poll();
			for(int dir=0;dir<4;dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == 0)	continue;
				if(map[nx][ny] == 1) {
					Q.add(new Node(nx, ny));
					map[nx][ny] = 0;
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
