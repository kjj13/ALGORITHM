package year2022.month03;

import java.util.Scanner;

public class BOJ_14719_빗물_골드5 {
	static int[] arr;
	static int W,H,sum;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		H = sc.nextInt();
		W = sc.nextInt();
		arr = new int[W];
		sum = 0;
		
		for(int i=0;i<W;i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=1;i<W-1;i++) {
			int left = arr[i];
			int right = arr[i];
			for(int j=0;j<i;j++) {
				left = Math.max(left, arr[j]);
			}
			for(int j=i+1;j<W;j++) {
				right = Math.max(right, arr[j]);
			}
			int h = Math.min(left, right);
			int diff = h - arr[i];
			if(diff <= 0)	continue;
			sum += diff;
		}
		
		System.out.println(sum);
	}
}
