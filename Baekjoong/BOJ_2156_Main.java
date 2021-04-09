import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2156_Main {
    static int arr[];
    static int DP[];

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        arr = new int[n+1];
        DP = new int[n+1];

        for(int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(bf.readLine());
        }
//        DP[0] = 0;

        if(n==1){
            DP[1] = arr[1];
        }
        if(n==2){
            DP[2] = arr[1] + arr[2];
        }
        if(n>=3){
            DP[1] = arr[1];
            DP[2] = arr[1] + arr[2];
            for(int i=3;i<=n;i++){
                DP[i] = Math.max(Math.max(DP[i-1],DP[i-2]+arr[i]),DP[i-3]+arr[i-1]+arr[i]);
            }
        }

        System.out.println(DP[n]);
    }

}
