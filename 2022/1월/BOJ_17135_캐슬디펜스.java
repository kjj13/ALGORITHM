package year2022.month01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_17135_캐슬디펜스 {
	static int N,M,D,ans,removeCnt;
	static int[][] initMap,chMap;
	static Queue<Node> Q;
	static boolean[] check;
	static boolean[][] visit;
	static List<Node> attack,remove;
	
	static int[] dx = {0,-1,0};
	static int[] dy = {-1,0,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		D = sc.nextInt();
		
		initMap = new int[N+1][M];
		chMap = new int[N+1][M];
		check = new boolean[M];	// 열에 맞춰줌.
		ans = Integer.MIN_VALUE;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				initMap[i][j] = sc.nextInt();
			}
		}
		// 입력완료
		
		comb(0,0);
		
		System.out.println(ans);
	}
	
	private static void comb(int target, int cnt) {
		if(cnt == 3) {
			map();
			attack = new ArrayList<Node>();
			removeCnt = 0;
			for(int i=0;i<M;i++) {
				if(check[i]) {
					attack.add(new Node(N, i));
				}
			}
			while(true) {
				print();
				remove = new ArrayList<Node>();
				for (Node node : attack) {
					Q = new LinkedList<Node>();
					visit = new boolean[N+1][M];
					Q.add(node);
					visit[node.x][node.y] = true;
					bfs();
				}
				down();
				if(!enemyExist())	break;
			}
			ans = Math.max(ans, removeCnt);
			return;
		}
		if(target == M) {
			return;
		}
		
		check[target] = true;
		comb(target+1,cnt+1);
		check[target] = false;
		comb(target+1,cnt);
	}

	private static void print() {
		System.out.println("print");
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(chMap[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static boolean enemyExist() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(chMap[i][j] == 1)
					return true;
			}
		}
		return false;
	}

	private static void down() {
		for (Node node : remove) {
			if(chMap[node.x][node.y] == 1) {
				removeCnt++;
				chMap[node.x][node.y] = 0;
			}
		}
		
		for(int i=N;i>=1;i--) {
			for(int j=0;j<M;j++) {
				if(chMap[i-1][j] == 1) {
					chMap[i-1][j] = 0;
					if(i != N)	
						chMap[i][j] = 1;
				}
			}
		}
	}

	private static void bfs() {
		int cnt = 0;
		boolean bfsExit = false;
		
		while(!Q.isEmpty()) {
			int size = Q.size();
			if(D <= cnt)	break;
			for(int i=0;i<size;i++) {
				Node cur = Q.poll();
				for(int dir=0;dir<3;dir++) {
					int nx = cur.x + dx[dir];
					int ny = cur.y + dy[dir];
					if(nx < 0 || nx >= N || ny < 0 || ny >= M || visit[nx][ny])	continue;
					if(chMap[nx][ny] == 1) {
						remove.add(new Node(nx, ny));
						bfsExit = true;
						break;
					}
					Q.add(new Node(nx, ny));
					visit[nx][ny] = true;
				}
				if(bfsExit)	break;
			}
			if(bfsExit)	break;
			cnt++;
		}
	}

	private static void map() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				chMap[i][j] = initMap[i][j];
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
