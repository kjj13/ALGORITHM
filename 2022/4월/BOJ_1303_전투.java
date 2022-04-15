package month04;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1303_¿¸≈ı {
	static int N,M,wSum,bSum;
	static char[][] map;
	static boolean[][] visit;
	static Queue<Node> Q;
	
	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		map = new char[N][M];
		visit = new boolean[N][M];
		Q = new LinkedList<Node>();
		wSum = 0;
		bSum = 0;
		
		for(int i=0;i<N;i++) {
			String str = sc.next();
			map[i] = str.toCharArray();
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(!visit[i][j]) {
					Q.add(new Node(i, j));
					visit[i][j] = true;
					int cnt = bfs();
					if(map[i][j] == 'W') {
						wSum += (cnt * cnt);
					}else if(map[i][j] == 'B') {
						bSum += (cnt * cnt);
					}
				}
			}
		}
		
		System.out.println(wSum + " " + bSum);
	}
	
	private static int bfs() {
		int cnt = 0;
		while(!Q.isEmpty()) {
			Node cur = Q.poll();
			cnt++;
			for(int dir = 0;dir<4;dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || visit[nx][ny]
						|| map[nx][ny] != map[cur.x][cur.y])
					continue;
				visit[nx][ny] = true;
				Q.add(new Node(nx, ny));
			}
		}
		return cnt;
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
