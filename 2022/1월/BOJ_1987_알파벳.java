package year2022.month01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1987_알파벳 {
	static int R, C, ans;
	static char[][] map;
	static boolean[][] visit;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visit = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			map[i] = str.toCharArray();
		}
		ans = Integer.MIN_VALUE;
		// 입력완료
		
		dfs(0,0,1,map[0][0]+"");
		
		System.out.println(ans);
	}

	private static void dfs(int i, int j, int cnt, String str) {
		visit[i][j] = true;
		for(int dir=0;dir<4;dir++) {
			int nx = i + dx[dir];
			int ny = j + dy[dir];
			if(nx < 0 || nx >= R || ny < 0 || ny >= C 
			|| visit[nx][ny] || str.contains(map[nx][ny] + ""))	continue;
			dfs(nx,ny,cnt+1,str+map[nx][ny]);
		}
		visit[i][j] = false;
		ans = Math.max(ans, cnt);
	}
}
