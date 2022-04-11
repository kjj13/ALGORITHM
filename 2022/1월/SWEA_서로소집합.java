package year2022.month01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_서로소집합 {
	static int T,n,m;
	static int[] parent;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			parent = new int[n+1];
			sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			make();
			
			for(int i=0;i<m;i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int num = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(num == 0) {
					union(a,b);
				}else {
					if(find(a) == find(b)) {
						sb.append("1");
					}else {
						sb.append("0");
					}
				}
			}
			
			System.out.println(sb.toString());
		}
	}

	private static void union(int a, int b) {
		int x = find(a);
		int y = find(b);
		if(x != y) {
			parent[x] = y;
		}
	}

	private static int find(int a) {
		if(a == parent[a])	return a;
		return parent[a] = find(parent[a]);	// 이 부분이 중요..
	}

	private static void make() {
		for(int i=1;i<=n;i++) {
			parent[i] = i;
		}
	}
}
