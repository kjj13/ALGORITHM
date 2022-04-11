package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 동규는 세수를 하다가 정렬이 하고싶어졌다.
 * 숫자 세 개를 생각한 뒤에, 이를 오름차순으로 정렬하고 싶어 졌다.
 * 숫자 세 개가 주어졌을 때, 가장 작은 수, 그 다음 수, 가장 큰 수를 출력하는 프로그램을 작성하시오.
 */

public class Main_2752 {
    static int[] arr = new int[3];
    static int[] result = new int[]{1000001,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        for(int i=0;i<arr.length;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<3;i++){
            result[0] = result[0] > arr[i] ? arr[i] : result[0];
            result[2] = result[2] < arr[i] ? arr[i] : result[2];
        }
        for(int i=0;i<3;i++){
            if(arr[i] == result[0] || arr[i] == result[2])
                continue;
            else {
                result[1] = arr[i];
                break;
            }
        }
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
