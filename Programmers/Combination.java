/**
 * - 조합
 *  n개 중에서 r개 고르기.
 */

public class Combination {
    public static void main(String[] args) {
        int n = 4;
        int[] arr = {1, 2, 3, 4};
        boolean[] visited = new boolean[n];

        for (int i = 1; i <= n; i++) {
            System.out.println("\n" + n + " 개 중에서 " + i + " 개 뽑기");
            combination(arr, visited, 0, n, i);
        }
    }

    private static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if(r == 0){
            print_arr(arr,visited);
            return;
        }
        for(int i=start;i<n;i++){
            visited[i] = true;
            combination(arr,visited,i+1,n,r-1);
            visited[i] = false;
        }

    }

    private static void print_arr(int[] arr, boolean[] visited) {
        for(int i=0;i<arr.length;i++){
            if(visited[i]){
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }

}
