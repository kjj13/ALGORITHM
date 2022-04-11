package month02;

import java.util.Scanner;

public class SWEA5356_의석이의세로로말해요 {
	static int T;
	static String[] strArr;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			strArr = new String[5];
			sb = new StringBuilder();
			for(int i=0;i<5;i++) {
				strArr[i] = sc.next();
			}
			int idx = 0;
			
			while(true) {
				boolean check = false;
				for(int i=0;i<5;i++) {
					int len = strArr[i].length();
					if(idx > len-1) {
						continue;
					}else {
						sb.append(strArr[i].charAt(idx));
						check = true;
					}
				}
				if(!check) {
					System.out.println("#" + tc + " " + sb.toString());
					break;
				}
				idx++;
			}
		}
	}
}
