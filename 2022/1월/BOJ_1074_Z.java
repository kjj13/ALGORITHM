package month01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074_Z {
	static int N, r, col,cnt;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		cnt = 0;
		
		int M = (int) Math.pow(2,N);
//		map = new int[M][M];
		divide(0,0,M-1,M-1,N);
		
	}

	private static void divide(int a, int b, int c, int d, int N) {
		if(N == 1) {
			for(int i=a;i<=c;i++) {
				for(int j=b;j<=d;j++) {
//					map[i][j] = cnt;
					if(i == r && j == col) {
						System.out.println(cnt);
						return;
					}
					cnt++;
				}
			}
			return;
		}
		int M = (int) Math.pow(2, N-1);
		int nx = a + M;
		int ny = b + M;
		divide(a,b,nx-1,ny-1,N-1);
		divide(a,ny,nx-1,d,N-1);
		divide(nx, b, c, ny-1, N-1);
		divide(nx, ny, c, d, N-1);
	}
}
