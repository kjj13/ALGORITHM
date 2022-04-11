import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11650_Main {
    static int arr[][];
    static int tmp[][];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        arr = new int[2][n];
        tmp = new int[2][n];

        for(int i=0;i<n;i++){
            arr[0][i] = sc.nextInt();
            arr[1][i] = sc.nextInt();
        }

        MergeSort(arr,0,n-1 );

        for(int i=0;i<n;i++){
            System.out.println(arr[0][i] + " " + arr[1][i]);
        }
    }

    private static void MergeSort(int[][] list, int left, int right) {
        if(left < right){
            int mid = (left + right) /2;
            MergeSort(list,left,mid);
            MergeSort(list,mid+1,right);
            Merge(list,left,mid,right);
        }
    }

    private static void Merge(int[][] list, int left, int mid, int right) {
        int a=left;
        int m = mid+1;
        int idx = left;

        while(a<=mid && m <= right){
            if(list[0][a] < list[0][m]){
                tmp[0][idx] = list[0][a];
                tmp[1][idx++] = list[1][a++];
            }else if(list[0][a] == list[0][m]){
                if(list[1][a] < list[1][m]){
                    tmp[0][idx] = list[0][a];
                    tmp[1][idx++] = list[1][a++];
                }else{
                    tmp[0][idx] = list[0][m];
                    tmp[1][idx++] = list[1][m++];
                }
            }else{
                tmp[0][idx] = list[0][m];
                tmp[1][idx++] = list[1][m++];
            }
        }

        while(a <= mid){
            tmp[0][idx] = list[0][a];
            tmp[1][idx++] = list[1][a++];
        }

        while(m <= right){
            tmp[0][idx] = list[0][m];
            tmp[1][idx++] = list[1][m++];
        }

        for(int i=left;i<=right;i++){
            list[0][i] = tmp[0][i];
            list[1][i] = tmp[1][i];
        }

    }
}
