import java.util.Scanner;

public class BOJ_1517_Main {
    public static void main(String[] args){
        Merge_Sort MS = new Merge_Sort();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        MS.arr = new int[n];
        MS.tmp = new int[n];

        for(int i=0;i<n;i++){
            MS.arr[i] = sc.nextInt();
        }

        MS.MergeSort(MS.arr,0,n-1);

        System.out.println(MS.cnt);
    }
}
