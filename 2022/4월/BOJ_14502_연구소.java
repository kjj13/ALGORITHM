package year2022.month04;

import java.util.*;

public class BOJ_14502_연구소 {
	static int N,M,max;
	static int[][] map,copyMap;
	static boolean[][] visit;
	static List<Node> empty;
	static boolean[] check;
	static Queue<Node> Q;
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		empty = new ArrayList<>();
		max = Integer.MIN_VALUE;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				int num = sc.nextInt();
				if(num == 0) {
					empty.add(new Node(i, j));
				}
				map[i][j] = num;
			}
		}
		check = new boolean[empty.size()];
		comb(0,0);
		
		System.out.println(max);
	}
	
	private static void comb(int target, int cnt) {
		if(cnt == 3) {
			mapCopy();
			for(int i=0;i<empty.size();i++) {
				if(check[i]) {
					Node cur = empty.get(i);
					copyMap[cur.x][cur.y]= 1; 
				}
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(copyMap[i][j] == 2 && !visit[i][j]) {
						Q.add(new Node(i, j));
						visit[i][j] = true;
						bfs();
					}
				}
			}
			max = Math.max(max, countZero());
			return;
		}
		if(target == empty.size()) {
			return;
		}
		
		check[target] = true;
		comb(target+1,cnt+1);
		check[target] = false;
		comb(target+1,cnt);
	}

	private static int countZero() {
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

	private static void bfs() {
		while(!Q.isEmpty()) {
			int size = Q.size();
			for(int i=0;i<size;i++) {
				Node cur = Q.poll();
				for(int dir=0;dir<4;dir++) {
					int nx = cur.x + dx[dir];
					int ny = cur.y + dy[dir];
					if(nx < 0 || nx >= N || ny < 0 || ny >= M ||
							visit[nx][ny] || copyMap[nx][ny] == 1)
						continue;
					copyMap[nx][ny] = 2;
					Q.add(new Node(nx, ny));
					visit[nx][ny] = true;
				}
			}
		}
	}

	private static void mapCopy() {
		visit = new boolean[N][M];
		Q = new LinkedList<Node>();
		copyMap = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				copyMap[i][j] = map[i][j];
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
