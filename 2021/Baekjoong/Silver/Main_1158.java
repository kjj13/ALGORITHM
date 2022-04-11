package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        LinkedList<Integer> list = new LinkedList<>();
        int idx = 0;

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for(int i=1;i<=N;i++)
            list.add(i);

        System.out.print("<");
        while (!list.isEmpty()){
            idx += K - 1;
            int size = list.size();
            /*이 부분 생각 못했음.. 흠..*/
            while(idx >= size)
                idx -= size;
            /*이 부분 생각 못했음.. 흠..*/
            System.out.print(list.remove(idx));
            if(!list.isEmpty())
                System.out.print(", ");
            else
                System.out.print(">");
        }
    }
}
