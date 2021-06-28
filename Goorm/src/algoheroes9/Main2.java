package algoheroes9;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();
        int cnt = 0;

        while (N > 0){
            arr.add(N%2);
            if(N % 2 == 1)  cnt++;
            N /= 2;
        }

        System.out.println(cnt);

        for(int i=0;i<arr.size();i++){
            if(arr.get(i) == 1)
                System.out.print(i + " ");
        }
    }
}
