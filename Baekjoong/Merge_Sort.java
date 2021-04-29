/**
 *  병합정렬 기본적인 구조!
 *  시간복잡도는 O(nlogn)!!
 */

public class Merge_Sort {
//    static int list[] = {5,8,3,10,1};
//    static int tmp[] = new int[5];
//
//    public static void main(String[] args) {
//        MergeSort(list,0,4);
//
//        for (int i : list) {
//            System.out.println(i);
//        }
//    }
    public int arr[];
    public int tmp[];
    public int cnt = 0;

    public void MergeSort(int[] list, int left, int right) {
        if(left < right){
            int mid = (left + right) /2;
            MergeSort(list,left,mid);
            MergeSort(list,mid+1,right);
            Merge(list,left,mid,right);
        }
    }

    public void Merge(int[] list, int left, int mid, int right) {
        int a=left;
        int m = mid+1;
        int idx = left;

        while(a<=mid && m <= right){
            if(list[a] < list[m]){
                tmp[idx++] = list[a++];
            }else{
                tmp[idx++] = list[m++];
                cnt += mid + 1 -a;
            }
        }

        while(a <= mid){
            tmp[idx++] = list[a++];
        }

        while(m <= right){
            tmp[idx++] = list[m++];
        }

        for(int i=left;i<=right;i++){
            list[i] = tmp[i];
        }

    }
}
