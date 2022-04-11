package year2022.month01;

import java.io.BufferedReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BOJ_3190_뱀 {
	static int N,K,L,cnt;
	static List<Node> snake;
//	static Deque<Node> snake;
	static Time[] timeTable;
	static int[][] map;
	
	static int[] dx = {0,1,0,-1};	// R , D , L , U
	static int[] dy = {1,0,-1,0};
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		map = new int[N][N];
		for(int i=0;i<K;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			map[x-1][y-1] = 1;
		}
		L = sc.nextInt();
		timeTable = new Time[L];
		for(int i=0;i<L;i++) {
			int t = sc.nextInt();
			char dir = sc.next().charAt(0);
			timeTable[i] = new Time(t,dir);
		}
		cnt = 0;
		snake = new LinkedList<Node>();
		// 입력완료
		
		snake.add(new Node(0, 0, 0, 0));
		map[0][0] = 2;
		dfs();
		
		System.out.println(cnt);
	}
	
	private static void dfs() {
		cnt++;
//		System.out.println(cnt + "--------------------------------------------------");
		for(int i=0;i<snake.size();i++) {
			Node cur = snake.get(i);
			for (Time td : timeTable) {
				if(cur.time == td.time) {
					if(cur.dir == 0) {
						cur.dir = td.dir == 'L' ? 3 : 1;
					}else if(cur.dir == 1) {
						cur.dir = td.dir == 'L' ? 0 : 2;
					}else if(cur.dir == 2) {
						cur.dir = td.dir == 'L' ? 1 : 3;
					}else if(cur.dir == 3) {
						cur.dir = td.dir == 'L' ? 2 : 0;
					}
//					cur.dir = td.dir;
					map[cur.x][cur.y] = 0;
				}
			}
			int nx = cur.x + dx[cur.dir];
			int ny = cur.y + dy[cur.dir];
			if(i == 0) {
				if(nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] == 2)
					return;
			}
			if(map[nx][ny] == 1) {
				snake.add(0, new Node(nx, ny, cur.time+1, cur.dir));
				map[nx][ny] = 2;
				break;
			}
			map[nx][ny] = 2;
			map[cur.x][cur.y]= 0;
			snake.set(i, new Node(nx, ny, cur.time+1, cur.dir));
//			print();
		}
		dfs();
	}

	private static void print() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("-----------------------------");
	}

	private static class Node{
		int x,y,time,dir;

		public Node(int x, int y, int time, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
			this.dir = dir;
		}
	}
	
	private static class Time{
		int time;
		char dir;
		
		public Time() {
			
		}

		public Time(int time, char dir) {
			super();
			this.time = time;
			this.dir = dir;
		}
	}
}
