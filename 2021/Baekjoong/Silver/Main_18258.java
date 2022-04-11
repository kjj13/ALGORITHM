package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        queue q = new queue(N);

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            String str = st.nextToken();
            StringBuilder sb = new StringBuilder();

            if(str.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                q.push(num);
            }else if(str.equals("pop")){
                sb.append(q.pop());
//                System.out.println(q.pop());
            }else if(str.equals("size")){
                sb.append(q.size());
//                System.out.println(q.size());
            }else if(str.equals("empty")){
                sb.append(q.isEmpty());
//                System.out.println(q.isEmpty());
            }else if(str.equals("front")){
                sb.append(q.front());
//                System.out.println(q.front());
            }else if(str.equals("back")){
                sb.append(q.back());
//                System.out.println(q.back());
            }
            System.out.println(sb);
        }
    }

    public static class queue{
        private int[] arr;
        private int head;
        private int tail;

        public queue(int size){
            arr = new int[size];
            head = 0;
            tail = 0;
        }

        public void push(int num){
            arr[tail++] = num;
        }

        public int pop(){
            if(isEmpty() == 1)
                return -1;
            else
                return arr[head++];
        }

        public int size(){
            return tail - head;
        }

        public int isEmpty(){
            if(head == tail)
                return 1;
            else
                return 0;
        }

        public int front(){
            if(isEmpty() == 1)
                return -1;
            else
                return arr[head];
        }

        public int back(){
            if(isEmpty() == 1)
                return -1;
            else
                return arr[tail-1];
        }
    }
}
