package year2022.month01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class JUNGOL_1828_냉장고 {
	static int N, cnt, max;
	static Node[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		cnt = 1;
		arr = new Node[N];
		if(N == 1) {
			System.out.println(1);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[i] = new Node(x,y);
//			if(i == 0) {
//				max = y;
//			}else {
//				if(x > max) {
//					max = y;
//					cnt++;
//				}
//			}
		}
		Arrays.sort(arr);
		
		max = arr[0].y;
		for(int i=1;i<N;i++) {
			if(arr[i].x > max) {
				max = arr[i].y;
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

	private static class Node implements Comparable<Node>{
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Node o) {
			return this.y - o.y;
		}
	}
}
