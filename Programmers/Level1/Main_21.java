package Level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * - 비밀지도
 * * 풀이법 : 각 자리를 이진수로 나타낸 다음 서로 "OR 비트연산"을 통해 풀었음.
 *
 * 배열 간단하게 출력하는법
 * : Arrays.toString(배열)
 *
 *
 * 매개변수	값
 * n	5
 * arr1	[9, 20, 28, 18, 11]
 * arr2	[30, 1, 21, 17, 28]
 * 출력	["#####","# # #", "### #", "# ##", "#####"]
 * 매개변수	값
 * n	6
 * arr1	[46, 33, 33 ,22, 31, 50]
 * arr2	[27 ,56, 19, 14, 14, 10]
 * 출력	["######", "### #", "## ##", " #### ", " #####", "### # "]
 */

public class Main_21 {
    public static void main(String[] args) {
        int a1[] = {46, 33, 33 ,22, 31, 50};
        int a2[] = {27 ,56, 19, 14, 14, 10};
        String[] arr = solution(6,a1,a2);

        System.out.println(Arrays.toString(arr));

//        for (String s : arr) {
//            System.out.print(s + " ");
//        }
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            int[][] a1 = new int[2][n];
            int[] result = new int[n];

            makeArr(n,a1,arr1[i],arr2[i]);

            for(int j=0;j<n;j++){
                result[j] = a1[0][j] | a1[1][j];
            }
            for(int j=n-1;j>-1;j--){
                if(result[j] == 1){
                    sb.append('#');
                }else {
                    sb.append(' ');
                }
            }
            answer[i] = sb.toString();
        }

        return answer;
    }

    private static void makeArr(int n, int[][] a1, int arr1, int arr2) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        while(arr1 > 0){
            list.add(arr1 % 2);
            arr1 /= 2;
        }
        for(int i=0;i<list.size();i++){
            a1[0][i] = list.get(i);
        }
        for(int i=list.size();i<n;i++){
            a1[0][i] = 0;
        }

        while(arr2 > 0){
            list1.add(arr2 % 2);
            arr2 /= 2;
        }
        for(int i=0;i<list1.size();i++){
            a1[1][i] = list1.get(i);
        }
        for(int i=list1.size();i<n;i++){
            a1[1][i] = 0;
        }
    }
}
