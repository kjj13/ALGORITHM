package year2022.month03;

import java.util.Scanner;

public class BOJ_1789_수들의합 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Long S = sc.nextLong();
		Long N = 1L;
		while(true) {
			Long sum = (N * (N+1)) / 2;
			if(sum > S)	break;
			else N++;
		}
		System.out.println(N-1);
	}
}
