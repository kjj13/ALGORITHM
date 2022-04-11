package algoheroes9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n1 = Integer.parseInt(st.nextToken());   // 진우
        int n2 = Integer.parseInt(st.nextToken());   // 선우
        int D = Integer.parseInt(br.readLine());

        for(int i=1;i<=D;i++){
            if(i%2 == 1){   //진우 -> 선우
                int plus2 = (n1 % 2) == 0 ? n1/2 : (n1/2) + 1;
                n1 /= 2;
                n2 += plus2;

            }else{  // 선우 -> 진우
                int plus1 = (n2 % 2) == 0 ? n2/2 : (n2/2) + 1;
                n2 /= 2;
                n1 += plus1;
            }
        }
        System.out.println(n1 + " " + n2);
    }
}
