class Solution {
    int N,max,temp;
    int[] arr,tmp;
    boolean[] check;
    
    public int solution(int k, int[][] dungeons) {
        N = dungeons.length;
        temp = k;
        max = 0;
        
        init();
        perm(0,dungeons);
        
        return max;
    }
    
    public void perm(int target,int[][] d){
        if(max == N){
            return;
        }
        if(target == N){
            int cnt = 0;
            int cur = temp;
            for(int idx:tmp){
                if(cur <= 0){
                    break;
                }
                if(cur >= d[idx][0]){
                    cur -= d[idx][1];
                    cnt++;
                }
            }
            max = Math.max(max,cnt);
            return;
        }
        
        for(int i=0;i<N;i++){
            if(check[i]) continue;
            check[i] = true;
            tmp[target] = arr[i];
            perm(target+1,d);
            check[i] = false;
        }
    }
    
    public void init(){
        arr = new int[N];
        tmp = new int[N];
        check = new boolean[N];
        for(int i=0;i<N;i++){
            arr[i] = i;
        }
    }
}
