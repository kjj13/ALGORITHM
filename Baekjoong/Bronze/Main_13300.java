package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13300 {
    static int[][] arr = new int[2][7];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int cnt = 0;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y]++;
        }

        for(int i=1;i<7;i++){
            int a = arr[0][i] % K != 0 ? arr[0][i] / K +1 : arr[0][i] / K;
            int b = arr[1][i] % K != 0 ? arr[1][i] / K +1 : arr[1][i] / K;

            cnt += (a+b);
        }

        System.out.println(cnt);
    }
}
