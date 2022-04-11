package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10804 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int arr[] = new int[21];

        for(int i=1;i<21;i++){
            arr[i] = i;
        }
        for(int i=0;i<10;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = b;
            int tmp;
            int mid = (a+b) % 2 == 0 ? (a+b)/2 : (a+b)/2 + 1;

            for(int j=a;j<mid;j++){
                tmp = arr[j];
                arr[j] = arr[c];
                arr[c--] = tmp;
            }
        }
        for(int i=1;i<21;i++)
            System.out.print(arr[i] + " ");
    }
}
