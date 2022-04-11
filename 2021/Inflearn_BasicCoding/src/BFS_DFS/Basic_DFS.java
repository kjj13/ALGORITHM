package BFS_DFS;

public class Basic_DFS {
    public static void main(String[] args) {
        char[][] grid = {
                { '1', '1', '0', '0', '1' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' },
                { '0', '0', '0', '1', '1' } };

        System.out.println(solve(grid));
    }
    static int m,n = 0;
    static int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};

    public static int solve(char[][] grid){
        int cnt = 0;
        m = grid.length;
        n = grid[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1'){
                    cnt++;
                    dfs(grid,i,j);
                }
            }
        }
        return cnt;
    }

    public static void dfs(char[][] grid,int x, int y){
//        1.error 처리 (재귀 나가는 조건)
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length ||
        grid[x][y] != '1')
            return;
//        방문처리
        grid[x][y] = 'X';
//        재귀로 1이 아닌거까지 들어가기.
        for(int[] dir : dirs){
            dfs(grid,x+dir[0], y+dir[1]);
        }
    }
}
