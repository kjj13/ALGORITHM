package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1475 {
    static int[] arr = new int[10];
    public static void main(String[] args) throws IOException {
//        System.out.println('1'-'0');
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
        int max = -1;
        String N = br.readLine();
        for(int i=0;i<N.length();i++)
            arr[N.charAt(i) - '0']++;
        for(int i=0;i<10;i++){
            if(i == 6 || i == 9) {
                continue;
            }
            else{
                max = max < arr[i] ? arr[i] : max;
            }
        }
        int sum = arr[6]+arr[9];
        if(sum % 2 == 0)
            max = max < sum/2 ? sum/2 : max;
        else
            max = max < (sum/2)+1 ? (sum/2)+1 : max;

        System.out.println(max);
    }
}
