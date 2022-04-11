package year2022.month01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SWEA_요리사 {
	static int T, N, ans;
	static List<Integer> A, B;
	static int[][] taste;
	static boolean[] check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			check = new boolean[N];
			taste = new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					taste[i][j] = sc.nextInt();
				}
			}
			ans = Integer.MAX_VALUE;
			// 입력완료
			
			for(int i=2;i<=N-2;i++) {
				comb(0,0,i);
			}
			
			System.out.println("#" + tc + " " + ans);
		}
	}

	private static void comb(int target, int cnt, int R) {
		if(cnt == R) {
			A = new ArrayList<Integer>();
			B = new ArrayList<Integer>();
			for(int i=0;i<N;i++) {
				if(check[i])
					A.add(i);
				else
					B.add(i);
			}
			int aSum = calSum(A);
			int bSum = calSum(B);
			int diff = Math.abs(aSum - bSum);
			ans = Math.min(ans, diff);
			return;
		}
		if(target == N) {
			return;
		}
		
		check[target] = true;
		comb(target+1,cnt+1,R);
		check[target] = false;
		comb(target+1,cnt,R);
	}

	private static int calSum(List<Integer> list) {
		int sum = 0;
		
		for (Integer i : list) {
			for (Integer j : list) {
				sum += taste[i][j];
			}
		}
		
		return sum;
	}
}
