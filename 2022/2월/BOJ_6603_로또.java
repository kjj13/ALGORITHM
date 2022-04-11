package year2022.month02;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_6603_로또 {
	static int k;
	static int[] arr;
	static boolean[] check;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		while(true) {
			k = sc.nextInt();
			if(k == 0) {
				System.out.println(sb.toString());
				return;
			}
			arr = new int[k];
			check = new boolean[k];
			for(int i=0;i<k;i++) {
				arr[i] = sc.nextInt();
			}
			
			Arrays.sort(arr);
			
			comb(0,0);
			sb.append("\n");
		}
	}

	private static void comb(int target, int cnt) {
		if(cnt == 6) {
			for(int i=0;i<k;i++) {
				if(check[i]) {
					sb.append(arr[i]).append(" ");
				}
			}
			sb.append("\n");
			return;
		}
		if(target==k) {
			return;
		}
		
		check[target] = true;
		comb(target+1,cnt+1);
		check[target] = false;
		comb(target+1,cnt);
	}
}
