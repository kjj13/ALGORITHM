package Gold;

/**
 * 텀 프로젝트
 *
 * 시간초과로 틀렸음.
 * DFS로 다시 풀기.!
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_9466 {
    static int[] arr;
    static boolean[] visit;
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            int size = Integer.parseInt(br.readLine());
            arr = new int[size+1];
            visit = new boolean[size+1];
            stack = new Stack<>();

            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=1;j<size+1;j++){
                arr[j] = Integer.parseInt(st.nextToken());
                visit[j] = false;
            }

            for(int j=1;j<size+1;j++){
                if(stack.contains(j))   continue;
                bfs(j);
            }
            System.out.println(size - stack.size());
        }
    }

    private static void bfs(int idx) {
        Arrays.fill(visit,false);
        Queue<Integer> Q = new LinkedList<>();
        Q.add(idx);
        visit[idx] = true;
        while (!Q.isEmpty()){
            int curIdx = Q.poll();
            int nextIdx = arr[curIdx];
            if(visit[nextIdx] == true){
                if(nextIdx == idx){
                    fillStack(idx);
                    break;
                }else{
                    break;
                }
            }
            Q.add(nextIdx);
            visit[nextIdx] = true;
        }
    }

    private static void fillStack(int idx) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(idx);
        stack.push(idx);
        while (!Q.isEmpty()){
            int curIdx = Q.poll();
            int nextIdx = arr[curIdx];
            if(nextIdx == idx)
                break;
            stack.push(nextIdx);
            Q.add(nextIdx);
        }
    }

    private static class Node{
        int id;
        int next;

        public Node(int id, int next) {
            this.id = id;
            this.next = next;
        }
    }
}
