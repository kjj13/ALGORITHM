package year2022.month01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_16234_인구이동 {
	static int N,L,R,ans;
	static int[][] map;
	static boolean[][] check;
	static List<Node> list;
	static int dfsCnt,dfsSum;
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		map = new int[N][N];
		ans = 0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		while(true) {
			check = new boolean[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(!check[i][j]) {
						list = new ArrayList<>();
						dfsCnt = 0;
						dfsSum = 0;
						dfs(i,j);
						if(dfsCnt == 1) {
							check[i][j] = false;
							continue;
						}
						int avg = dfsSum / dfsCnt;
						for (Node node : list) {
							map[node.x][node.y] = avg;
						}
					}
				}
			}
			if(!factCheck()) break;
			ans++;
		}
		
		System.out.println(ans);
	}
	
	private static void dfs(int i, int j) {
		dfsCnt++;
		dfsSum += map[i][j];
		check[i][j] = true;
		list.add(new Node(i, j));
		for(int dir=0;dir<4;dir++) {
			int nx = i + dx[dir];
			int ny = j + dy[dir];
			if(nx < 0 || nx >= N || ny < 0 || ny >= N || check[nx][ny])	continue;
			int diff = Math.abs(map[i][j] - map[nx][ny]);
			if(L <= diff && diff <= R)
				dfs(nx,ny);
		}
	}

	private static boolean factCheck() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(check[i][j]) {
					return true;
				}
			}
		}
		return false;
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
