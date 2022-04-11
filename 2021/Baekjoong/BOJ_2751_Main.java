import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2751_Main {
    static int list[];
    static int tmp[];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        list = new int[n];
        tmp = new int[n];

        for(int i=0;i<n;i++){
            list[i] = Integer.parseInt(bf.readLine());
        }

        Arrays.sort(list);

//        MergeSSort(list,0,n-1);

        for (int i : list) {
            System.out.println(i);
        }
    }

    public static void MergeSSort(int[] list,int left,int right){
        if(left < right){
            int mid = (left + right) /2;
            MergeSSort(list,left,mid);
            MergeSSort(list,mid+1,right);
            Merrgge(list, left, mid, right);
        }
    }

    public static void Merrgge(int[] list, int left, int mid, int right){
        int idx = left;
        int M = mid + 1;
        int L = left;

        while (L<=mid && M <= right){
            if(list[L] < list[M]){
                tmp[idx++] = list[L++];
            }else{
                tmp[idx++] = list[M++];
            }
        }

        while (L<=mid){
            tmp[idx++] = list[L++];
        }
        while (M <= right){
            tmp[idx++] = list[M++];
        }
        for(int i=left;i<=right;i++){
            list[i] = tmp[i];
        }

    }

}
