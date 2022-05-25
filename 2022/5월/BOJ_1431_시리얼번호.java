package year2022.month05;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BOJ_1431_시리얼번호 {
	static int N;
	static List<Node> list;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		list= new ArrayList<>();
		for(int i=0;i<N;i++) {
			String str = sc.next();
			int sum = calc(str);
			list.add(new Node(str, sum));
		}
		
		list.sort(Comparator.comparing(Node::getLen)
				.thenComparing(Node::getSum)
				.thenComparing(Node::getStr));
		
		for(int i=0;i<N;i++) {
			System.out.println(list.get(i).str);
		}
	}
	
	private static int calc(String str) {
		int sum = 0;
		for(int i=0;i<str.length();i++) {
			char ch = str.charAt(i);
			if('1' <= ch && ch <= '9') {
				sum += ch - '0';
			}
		}
		return sum;
	}

	private static class Node{
		String str;
		int sum;
		public Node(String str, int sum) {
			super();
			this.str = str;
			this.sum = sum;
		}
		public String getStr() {
			return str;
		}
		public int getSum() {
			return sum;
		}
		public int getLen() {
			return str.length();
		}
	}
}
