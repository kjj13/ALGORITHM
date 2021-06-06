package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2577 {
    static int[] arr = new int[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Long A = Long.parseLong(br.readLine());
        Long B = Long.parseLong(br.readLine());
        Long C = Long.parseLong(br.readLine());

        Long result = A*B*C;

        while (result >= 1){
            arr[(int)(result%10)]++;
            result /= 10;
        }

        for (int i : arr) {
            System.out.println(i);
        }
    }
}
