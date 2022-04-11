package BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;

public class Basic_BFS {
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
                    bfs(grid,i,j);
                }
            }
        }
        return cnt;
    }

    public static void bfs(char[][] grid,int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int [] {x,y});

        while (!queue.isEmpty()){
            int[] point = queue.poll();
            for(int[] dir: dirs){
                int x1 = point[0] + dir[0];
                int y1 = point[1] + dir[1];
                if(x1 >=0 && y1>=0 && x1<grid.length && y1 < grid[0].length
                && grid[x1][y1] == '1'){
                    grid[x1][y1] = '0';
                    queue.offer(new int[] {x1,y1});
                }
            }
        }
    }
}
