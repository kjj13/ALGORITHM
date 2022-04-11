package year2022.month01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_14502_연구소 {
	static int N,M,ans;
	static int[][] map,initMap;
	static List<Node> empty;
	static boolean[] check;
	static boolean[][] visit;
	static Queue<Node> Q;
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		initMap = new int[N][M];
		map = new int[N][M];
		empty = new ArrayList<Node>();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				int num = sc.nextInt();
				if(num == 0) {
					empty.add(new Node(i, j));
				}
				initMap[i][j] = num;
			}
		}
		check = new boolean[empty.size()];
		// 입력완료
		
		comb(0,0);
		
		System.out.println(ans);
	}
	
	private static void comb(int target, int cnt) {
		if(cnt == 3) {
			visit = new boolean[N][M];
			Q = new LinkedList<>();
			
			makeMap();
			for(int i=0;i<empty.size();i++) {
				if(check[i]) {
					Node wall = empty.get(i);
					map[wall.x][wall.y] = 1;
				}
			}// 벽 생성
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(map[i][j] == 2) {
						Q.add(new Node(i, j));
						visit[i][j] = true;
						bfs();
					}
				}
			}
			ans = ans < safeCnt() ? safeCnt() : ans;
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

	private static int safeCnt() {
		int cnt = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] == 0)
					cnt++;
			}
		}
		return cnt;
	}

	private static void bfs() {
		while(!Q.isEmpty()) {
			Node cur = Q.poll();
			for(int dir=0;dir<4;dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || visit[nx][ny] || map[nx][ny] == 1)	continue;
				Q.add(new Node(nx, ny));
				visit[nx][ny] = true;
				map[nx][ny] = 2;
			}
		}
	}

	private static void makeMap() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j] = initMap[i][j];
			}
		}
	}

	private static class Node{
		int x,y;
		
		public Node(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
}
