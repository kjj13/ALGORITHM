package year2022.month01;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1759_암호만들기 {
	static int L,C;
	static char[] arr;
	static boolean[] check;
	static StringBuilder sb;
	static String str = "aeiou";
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		C = sc.nextInt();
		arr = new char[C];
		check = new boolean[C];
		sb = new StringBuilder();
		
//		String input = sc.next();
		/*
		 * sc.next() : 공백 전까지 입력받은 문자열 리턴
		 * sc.nextLine() : 엔터 치기 전까지 입력받은 문자열 리턴
		 * */
		for(int i=0;i<C;i++) {
			arr[i] = sc.next().charAt(0);
		}
		//입력 완료
		
		Arrays.sort(arr);
		comb(0,0);
		
		System.out.println(sb.toString());
	}

	private static void comb(int target, int cnt) {
		if(cnt == L) {
			String s = "";
			int count = 0;
			for(int i=0;i<C;i++) {
				if(check[i]) {
					s += arr[i];
					if(str.contains(arr[i]+"")) {
						count++;
					}
				}
			}
			if(count >= 1 && L-count >= 2) {
				sb.append(s).append("\n");
			}
			return;
		}
		if(target == C) {
			return;
		}
		
		check[target] = true;
		comb(target+1,cnt+1);
		check[target] = false;
		comb(target+1,cnt);
	}
}
