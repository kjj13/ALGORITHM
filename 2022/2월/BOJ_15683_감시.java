package year2022.month01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_15683_감시 {
	static int N,M,ans,dir;
	static int[][] map,copyMap;
	static List<Point> arr;
	static Point[] tmp;
	static boolean[] check;
	
	static Node[][] cctv = {
			{new Node(1,0,0,0),new Node(0,1,0,0),new Node(0,0,1,0),new Node(0,0,0,1)},
			{new Node(1,1,0,0),new Node(0,0,1,1),new Node(1,1,0,0),new Node(0,0,1,1)},
			{new Node(1,0,0,1),new Node(0,1,0,1),new Node(0,1,1,0),new Node(1,0,1,0)},
			{new Node(1, 1, 1, 1),new Node(1, 1, 1, 1),new Node(1, 1, 1, 1),new Node(1, 1, 1, 1)}
	};
	// 상 하 좌 우
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		copyMap = new int[N][M];
		arr = new ArrayList<Point>();
		ans = Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				int num = sc.nextInt();
				if(1<= num && num <= 5) {
					arr.add(new Point(i, j, num));
				}
				map[i][j] = num;
			}
		}
		tmp = new Point[arr.size()];
		check = new boolean[arr.size()];
		// 입력완료
		
		perm(0);
		
		System.out.println(ans);
	}
	
	private static void perm(int target) {
		int size = arr.size();
		if(target == size) {
			mapCopy();
			for(int i=0;i<size;i++) {
				Node cDir = cctv[tmp[i].num-1][i];
				if(cDir.a == 1) {
					dir = 0;
					dfs(tmp[i].x,tmp[i].y);
				}
				if(cDir.b == 1) {
					dir = 1;
					dfs(tmp[i].x,tmp[i].y);
				}
				if(cDir.c == 1) {
					dir = 2;
					dfs(tmp[i].x,tmp[i].y);
				}
				if(cDir.d == 1) {
					dir = 3;
					dfs(tmp[i].x,tmp[i].y);
				}
			}
			ans = Math.min(ans, count());
			return;
		}
		
		for(int i=0;i<size;i++) {
			if(check[i])	continue;
			check[i] = true;
			tmp[target] = arr.get(i);
			perm(target+1);
			check[i] = false;
		}
	}

	private static int count() {
		int cnt = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(copyMap[i][j] == 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	private static void dfs(int x,int y) {
		copyMap[x][y] = -1;
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		if(nx < 0 || nx >= N || ny < 0 || ny >= M || copyMap[nx][ny] == 6)
			return;
		dfs(nx,ny);
	}

	private static void mapCopy() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				copyMap[i][j] = map[i][j];
			}
		}
	}

	private static class Node{
		int a,b,c,d;

		public Node(int a, int b, int c, int d) {
			super();
			this.a = a;
			this.b = b;
			this.c = c;
			this.d = d;
		}
	}
	
	private static class Point{
		int x,y,num;

		public Point(int x, int y, int num) {
			super();
			this.x = x;
			this.y = y;
			this.num = num;
		}
	}
}
