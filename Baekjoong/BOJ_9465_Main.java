import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * baekjoon 9465 : 스티커
 * DATE : 2021.04.08
 * DP문제
 */
public class BOJ_9465_Main {
    static int arr[][];
    static int DP[][];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        for(int i=0;i<n;i++){
            int k = Integer.parseInt(bf.readLine());
            int max = 0;
            arr = new int[2][k+1];
            DP = new int[2][k+1];

//            DP[0][0] = 0;
//            DP[1][0] = 0;

            for(int c=0;c<2;c++) {
                String str = bf.readLine();
                String[] s = str.split(" ");

                for (int j=1;j<=k;j++) {
                    arr[c][j] = Integer.parseInt(s[j-1]);
                }
                DP[0][1] = arr[0][1];
                DP[1][1] = arr[1][1];
            }

            for(int j=2;j<=k;j++){
                DP[0][j] = Math.max(DP[1][j-2],DP[1][j-1]) + arr[0][j];
                DP[1][j] = Math.max(DP[0][j-2],DP[0][j-1]) + arr[1][j];
            }

            System.out.println(Math.max(DP[0][k],DP[1][k]));

        }
    }
}
