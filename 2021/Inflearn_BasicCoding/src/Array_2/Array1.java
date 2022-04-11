package Array_2;

public class Array1 {
    public static void main(String[] args) {
        int arr[] = {8,2,6,5,1,7,5};
        System.out.println(solve(arr));
    }
    public static int solve(int arr[]){
        int max = 0;
        int a;
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i] < arr[j]){
                    a= arr[j] - arr[i];
                    max = Math.max(max,a);
                }
            }
        }

        return max;
    }
}
