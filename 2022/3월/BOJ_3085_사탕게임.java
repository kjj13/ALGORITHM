package year2022.month03;

import java.util.Scanner;

public class BOJ_3085_사탕게임 {
	static int N,max;
	static char[][] map,copyMap;
	static boolean[][] visit;
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new char[N][N];
		for(int i=0;i<N;i++) {
			String str = sc.next();
			map[i] = str.toCharArray();
		}
		max = Integer.MIN_VALUE;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				for(int dir=0;dir<4;dir++) {
					int nx = i + dx[dir];
					int ny = j + dy[dir];
					if(nx < 0 || nx >= N || ny < 0 || ny >= N || map[i][j] == map[nx][ny])	continue;
					mapCopy();
					char tmp = copyMap[i][j];
					copyMap[i][j] = copyMap[nx][ny]; 
					copyMap[nx][ny] = tmp;
					visit = new boolean[N][N];
					for(int x=0;x<N;x++) {
						for(int y=0;y<N;y++) {
//							if(visit[x][y])	continue;
							for(int d=0;d<4;d++) {
								dfs(x,y,d,1);
								if(max == N) {
									System.out.println(N);
									return;
								}
							}
						}
					}
				}
			}
		}
		max = max == Integer.MIN_VALUE ? N : max;
		System.out.println(max);
	}

	private static void dfs(int x, int y, int d, int cnt) {
		max = Math.max(max, cnt);
		visit[x][y] = true;
		int nx = x + dx[d];
		int ny = y + dy[d];
		if(nx < 0 || nx >= N || ny < 0 || ny >= N || copyMap[x][y] != copyMap[nx][ny]) return;
		dfs(nx,ny,d,cnt+1);
	}

	private static void mapCopy() {
		copyMap = new char[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				copyMap[i][j] = map[i][j];
			}
		}
	}
}
