package year2022.month01;

import java.util.Scanner;

public class SWEA_삼성시의버스노선 {
	static int T,N,P;
	static int[] A,B,arr,cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			N = sc.nextInt();
			A = new int[N];
			B = new int[N];
			for(int i=0;i<N;i++) {
				A[i] = sc.nextInt();
				B[i] = sc.nextInt();
			}
			P = sc.nextInt();
			arr = new int[P];
			cnt = new int[P];
			for(int i=0;i<P;i++) {
				arr[i] = sc.nextInt();
			}
			// 입력완료
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<P;j++) {
					if(arr[j] >= A[i] && arr[j] <= B[i]) {
						cnt[j]++;
					}
				}
			}
			
			System.out.print("#" + tc + " ");
			for (int n : cnt) {
				System.out.print(n + " ");
			}
			System.out.println();
		}
	}
}
