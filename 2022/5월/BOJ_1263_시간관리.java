package year2022.month05;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1263_시간관리 {
	
	static int N;
	static PriorityQueue<Node> pq;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		pq = new PriorityQueue<>();
		for(int i=0;i<N;i++) {
			pq.add(new Node(sc.nextInt(), sc.nextInt()));
		}
		Node tmp = pq.poll();
		int start = tmp.S - tmp.T;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			start = start < cur.S ? start - cur.T : cur.S - cur.T;
		}
		if(start < 0) {
			System.out.println(-1);
		}else {
			System.out.println(start);
		}
	}
	
	private static class Node implements Comparable<Node>{
		int T,S;

		public Node(int t, int s) {
			super();
			T = t;
			S = s;
		}

		@Override
		public int compareTo(Node other) {
			return other.S - this.S;
		}
	}
}
