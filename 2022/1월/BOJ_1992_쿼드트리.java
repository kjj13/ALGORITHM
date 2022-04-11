package year2022.month01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ_1992_쿼드트리 {
	static int N;
	static int[][] map;
	static StringBuilder sb;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		sb = new StringBuilder();
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		divide(0,0,N);
		
		System.out.println(sb.toString());
	}

	private static void divide(int x, int y, int N) {
		int sum = 0;
		for(int i=x;i<x+N;i++) {
			for(int j=y;j<y+N;j++) {
				sum += map[i][j];
			}
		}
		if(sum == N*N) {
			sb.append('1');
			return;
		}else if(sum == 0) {
			sb.append('0');
			return;
		}
		sb.append("(");
		int mid = N/2;
		divide(x, y, mid);
		divide(x, y+mid, mid);
		divide(x+mid, y, mid);
		divide(x+mid, y+mid, mid);
		sb.append(')');
	}
}
