package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 시간복잡도 생각해야됨.
 *
 * 그래서, 이중 for문 사용 불가. => O(N^2)
 *
 * 따라서, for문 하나로 해결해야됨. => O(N) !!!!
 */

public class Main_3273 {
    static int[] check = new int[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];

        int cnt = 0;

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        for(int i=1;i<n+1;i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            check[num]++;
        }
        int x = Integer.parseInt(br.readLine());

//        여기가 중요한 로직.
//        (x - 입력한 수) 인덱스가 이미 존재하는지 체크하기.
        for(int i= 1;i<n+1;i++){
            int a = x - arr[i];
            if(a > 0) {
                if (check[a] != 0)
                    cnt++;
            }
        }

        System.out.println(cnt/2);
    }
}
