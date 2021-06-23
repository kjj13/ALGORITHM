package Silver;

/**
 * 음. 최소의 경우면 일단 BFS 생각하기.
 * if(N == K) 인 경우 생각을 못했었음.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1697 {
    static boolean[] visit = new boolean[200000];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if(N == K){
            System.out.println(0);
            return;
        }

        Arrays.fill(visit,false);
        Queue<Node> Q = new LinkedList<>();
        Q.add(new Node(N,0));
        visit[N] = true;

        while (!Q.isEmpty()){
            Node cur = Q.peek();
            Q.poll();

            int mx = cur.x -1;
            int px = cur.x + 1;
            int xx = cur.x * 2;

            if(mx >= 0 && visit[mx] == false){
                Q.add(new Node(mx,cur.depth + 1));
                visit[mx] = true;
            }
            if(px < 200000 && visit[px] == false)   {
                Q.add(new Node(px,cur.depth + 1));
                visit[px] = true;
            }
            if(xx < 200000 && visit[xx] == false){
                Q.add(new Node(xx,cur.depth + 1));
                visit[xx] = true;
            }

            if(mx == K || px == K || xx ==K){
                System.out.println(cur.depth + 1);
                return;
            }
        }
    }

    public static class Node{
        int x;
        int depth;

        public Node(int x, int depth) {
            this.x = x;
            this.depth = depth;
        }
    }
}
