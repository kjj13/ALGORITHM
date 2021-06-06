package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1919 {
    static int[] arr = new int[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();
        int cnt = 0;

        for(int i=0;i<a.length();i++){
            arr[a.charAt(i) - 'a']++;
        }
        for(int i=0;i<b.length();i++){
            arr[b.charAt(i) - 'a']--;
        }
        for (int i : arr) {
            if(i != 0){
                cnt = i > 0 ? cnt + i : cnt - i;
            }
        }
        System.out.println(cnt);
    }
}
