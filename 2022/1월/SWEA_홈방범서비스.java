package year2022.month01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SWEA_홈방범서비스 {
	static int T,N,M,ans;
	static List<Node> home;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			N = sc.nextInt();	// 크기
			M = sc.nextInt();	// 비용
			home = new ArrayList<Node>();
			ans = Integer.MIN_VALUE;
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					int num = sc.nextInt();
					if(num == 1) {
						home.add(new Node(i, j));
					}
				}
			}
			// 입력 완료
			
			int c=N+N/2;
			boolean check = false;
			for(int k=c;k>=0;k--) {
				int service = (k*k) + ((k-1) * (k-1));
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						int result = 0;
						int cnt = 0;
						for (Node cur : home) {
							int diff = Math.abs(i - cur.x) + Math.abs(j - cur.y) + 1;
							if(diff <= k) {
								result += M;
								cnt++;
							}
						}
						if(result >= service) {
							ans = Math.max(ans, cnt);
						}
					}	// end for j
				}	// end for i
			}	// end for k
			System.out.println("#" + tc + " " + ans);
		}
	}
	
	private static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
