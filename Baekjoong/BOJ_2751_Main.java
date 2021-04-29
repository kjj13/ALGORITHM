package com.company;

import java.util.Scanner;

public class BOJ_2751_Main {
    static int list[];
    static int tmp[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        list = new int[n];
        tmp = new int [n];

        for(int i=0;i<n;i++){
//            System.out.println(sc.nextInt());
            list[i] = sc.nextInt();
        }
        MergeSort(list,0,n-1);
        for (int i : list) {
            System.out.println(i);
        }

    }

    private static void MergeSort(int[] list, int left, int right) {
        if(left < right){
            int mid = (left + right) / 2;
            MergeSort(list,left,mid);
            MergeSort(list,mid+1,right);
            Merge(list,left,mid,right);
        }
    }

    private static void Merge(int[] list, int left, int mid, int right) {
        int l = left;
        int M = mid + 1;
        int idx=left;
        while(l<=mid && M <= right){
            if(list[l] < list[M]){
                tmp[idx++] = list[l++];
            }
            else{
                tmp[idx++] = list[M++];
            }
        }
//        if(l > mid){
            while(M<=right){
                tmp[idx++] = list[M++];
            }
//        }
//        else{
            while (l <= mid) {
                tmp[idx++] = list[l++];
            }
//        }

        for(int i=left;i<=right;i++){
            list[i] = tmp[i];
        }
    }
}
