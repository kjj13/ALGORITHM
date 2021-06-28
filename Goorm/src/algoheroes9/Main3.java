package algoheroes9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main3 {
    static int arr[];
    static int DP[];
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        StringTokenizer st = new StringTokenizer(br.readLine()," ");
//        Stack<Integer>  stack = new Stack<>();
//
//        stack.push(Integer.parseInt(st.nextToken()));
//
//        int cnt = 0;
//
//        for(int i=1;i<N;i++){
//            int num = Integer.parseInt(st.nextToken());
//            if(num > stack.peek())
//                stack.push(num);
//            else{
//                cnt++;
//                int pop = stack.pop();
//                int low = num > pop ? pop : num;    //비교해서 더 작은 수
//                if(!stack.isEmpty()){
//                    if(low > stack.peek())
//                        stack.push(low);
//                    else
//                        stack.push(pop);
//                }else{
//                    stack.push(low);
//                }
//            }
//        }
//        System.out.println(cnt);
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        arr = new int[n];
        DP = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
            DP[i] = 1;
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                if(arr[i] > arr[j] && DP[i] < DP[j]+1){
                    DP[i] = DP[j] + 1;
                }
            }
        }

        Arrays.sort(DP);
        System.out.print(DP[n-1]);
    }
}
