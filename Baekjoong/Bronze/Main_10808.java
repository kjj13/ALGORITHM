package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10808 {
    static int[] arr = new int[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

//        s.toCharArray()

        for(int i=0;i<s.length();i++){
            arr[s.charAt(i) - 'a']++;
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
