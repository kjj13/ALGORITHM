package month01;

import java.util.Scanner;

public class BOJ_2839_¼³ÅÁ¹è´Ş {
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		int a = N / 5;
		for(int i=a;i>=0;i--) {
			int c = N - 5*i;
			if(c % 3 == 0) {
				int b = c / 3;
				System.out.println(i+b);
				return;
			}
		}
		System.out.println(-1);
	}
}
