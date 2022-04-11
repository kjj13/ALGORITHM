class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = {};
        int N = arr1.length;
        int M = arr2[0].length;
        int K = arr2.length;
        
        answer = new int[N][M];
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                for(int c=0;c<K;c++){
                    answer[i][j] += arr1[i][c] * arr2[c][j];
                }
            }
        }
        
        return answer;
    }
}
