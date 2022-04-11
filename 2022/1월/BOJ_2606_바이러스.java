package year2022.month01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_2606_바이러스 {
	static int N,C,cnt;
	static List<Integer>[] arr;
	static boolean[] visit;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		C = sc.nextInt();
		/* 인접리스트 크기 설정하는 방법.!!*/
		arr = new ArrayList[N+1];	
		for(int i=0;i<N+1;i++) {
			arr[i] = new ArrayList<>();
		}
		/* 인접리스트 크기 설정하는 방법.!!*/
		visit = new boolean[N+1];
		cnt= -1;
		
		for(int i=0;i<C;i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			arr[from].add(to);
			arr[to].add(from);
		}
		// 입력완료
		
		dfs(1);
		
		System.out.println(cnt);
	}

	private static void dfs(int i) {
		if(visit[i])	return;
		cnt++;
		visit[i] = true;
		
		for (int a : arr[i]) {
			dfs(a);
		}
	}
}
