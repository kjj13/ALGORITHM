package year2022.month03;

import java.util.Scanner;

public class BOJ_2293_동전1 {
	static int n,k;
	static int[] DP,arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		arr = new int[n];
		DP = new int[k+1];
		DP[0] = 1;
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=0;i<n;i++) {
			for(int j=arr[i];j<=k;j++) {
				DP[j] = DP[j] + DP[j-arr[i]];
			}
		}
		
		System.out.println(DP[k]);
	}
}
