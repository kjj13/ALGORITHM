package year2022.month01;

import java.util.Scanner;

public class SWEA_최적경로 {
	static int T, N, ans;
	static Node com,home;
	static Node[] arr,tmp;
	static boolean[] check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			N = sc.nextInt();
			arr = new Node[N];
			tmp = new Node[N];
			check = new boolean[N];
			com = new Node(sc.nextInt(), sc.nextInt());
			home = new Node(sc.nextInt(), sc.nextInt());
			for(int i=0;i<N;i++) {
				arr[i] = new Node(sc.nextInt(), sc.nextInt());
			}
			ans = Integer.MAX_VALUE;
			// 입력 완료
			
			perm(0);
			
			System.out.println("#" + tc + " " + ans);
		}
	}

	private static void perm(int target) {
		if(target == N) {
			int sum = cal(com,tmp[0]);
			for(int i=0;i<N-1;i++) {
				sum += cal(tmp[i],tmp[i+1]);
			}
			sum += cal(tmp[N-1],home);
			ans = Math.min(ans, sum);
			return;
		}
		for(int i=0;i<N;i++) {
			if(check[i]) continue;
			tmp[target] = arr[i];
			check[i] = true;
			perm(target+1);
			check[i] = false;
		}
	}

	private static int cal(Node n1, Node n2) {
		return Math.abs(n1.x - n2.x) + Math.abs(n1.y - n2.y);
	}

	private static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
