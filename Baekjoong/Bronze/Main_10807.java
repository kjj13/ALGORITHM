package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10807 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int cnt = 0;

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++)
            arr[i] = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(br.readLine());

        for (int i : arr) {
            if(i == v)
                cnt++;
        }
        System.out.println(cnt);
    }
}
