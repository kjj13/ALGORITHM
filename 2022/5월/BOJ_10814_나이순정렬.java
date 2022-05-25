package year2022.month05;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BOJ_10814_나이순정렬 {
	static int N;
	static List<Node> list;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N =sc.nextInt();
		list = new ArrayList<>();
		for(int i=0;i<N;i++) {
			list.add(new Node(sc.nextInt(), sc.next(), i));
		}
		
		list.sort(Comparator.comparing(Node::getAge).thenComparing(Node::getIdx));
		
		for(int i=0;i<N;i++) {
			Node cur = list.get(i);
			System.out.println(cur.age + " " + cur.name);
		}
	}
	
	private static class Node{
		int age;
		String name;
		int idx;
		
		public Node(int age,String name,int idx) {
			this.age = age;
			this.name = name;
			this.idx = idx;
		}

		public int getAge() {
			return age;
		}

		public int getIdx() {
			return idx;
		}
		
	}
}
