package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11328 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        for(int i= 0;i<N;i++){
            int[] arr = new int[26];
            boolean check = true;
            st = new StringTokenizer(br.readLine()," ");
            String a = st.nextToken();
            String b = st.nextToken();

//            이 부분이 중요 로직.
//            -> a~z 배열 이용해서 0이 아니면 같은 문자로 되어있지 않음.
            for(int j=0;j<a.length();j++){
                arr[a.charAt(j) - 'a']++;
            }
            for(int j=0;j<b.length();j++){
                arr[b.charAt(j) - 'a']--;
            }

            for (int item : arr) {
                if(item != 0) {
                    check = false;
                    break;
                }
            }
//            System.out.println(check);
            if(check)
                System.out.println("Possible");
            else
                System.out.println("Impossible");
        }
    }
}
