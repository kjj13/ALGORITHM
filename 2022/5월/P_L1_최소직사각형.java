class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int max = Integer.MIN_VALUE;
        int minMax = Integer.MIN_VALUE; 
        
        // for(int i=0;i<len;i++){
        //     if(sizes[i][0] > sizes[i][1]){
        //         max = Math.max(max,sizes[i][0]);
        //         minMax = Math.max(minMax,sizes[i][1]);
        //     }else{
        //         max = Math.max(max,sizes[i][1]);
        //         minMax = Math.max(minMax,sizes[i][0]);
        //     }
        // }
        
        /*더 깔끔하게 풀기*/
        for(int[] size : sizes){
            max = Math.max(max,Math.max(size[0],size[1]));
            minMax = Math.max(minMax,Math.min(size[0],size[1]));
        }
        
        answer = max * minMax;
        
        return answer;
    }
}
