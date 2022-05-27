package month05;

import java.util.*;

public class BOJ_10825_±¹¿µ¼ö {
	
	static int N;
    static List<Node> list;
	
	public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        list = new ArrayList<>();

        for(int i=0;i<N;i++){
            String name = sc.next();
            int kor = sc.nextInt();
            int eng = sc.nextInt();
            int math = sc.nextInt();

            list.add(new Node(name,kor,eng,math));
        }
        
        Comparator<Node> comp = new Comparator<Node>() {
			
			@Override
			public int compare(Node o1, Node o2) {
				if(o1.kor == o2.kor) {
					if(o1.eng == o2.eng) {
						if(o1.math == o2.math) {
							return o1.name.compareTo(o2.name);
						}else {
							return o2.math - o1.math;
						}
					}else {
						return o1.eng - o2.eng;
					}
				}else {
					return o2.kor - o1.kor;
				}
			}
		};
		
		Collections.sort(list,comp);
        
        
        for(Node cur : list){
            System.out.println(cur.name);
        }

    }

    private static class Node{
        String name;
        int kor,eng,math;

        public Node(String name,int kor,int eng,int math){
            this.name= name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        public String getName(){
            return this.name;
        }

        public int getKor(){
            return this.kor;
        }

        public int getEng(){
            return this.eng;
        }

        public int getMath(){
            return this.math;
        }
    }
}
