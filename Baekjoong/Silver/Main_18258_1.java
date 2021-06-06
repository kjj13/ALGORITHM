//package Silver;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class Main_18258_1 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//
//        Queue<Integer> queue = new LinkedList<>();
//
////        queue q = new queue(N);
//        StringTokenizer st;
//
//        for(int i=0;i<N;i++){
//            st = new StringTokenizer(br.readLine()," ");
//            String str = st.nextToken();
//            if(str.equals("push")){
//                Integer num = Integer.parseInt(st.nextToken());
//                queue.offer(num);
//            }else if(str.equals("pop")){
//                if(queue.isEmpty())
//                    System.out.println(-1);
//                else
//                    System.out.println(queue.poll());
//            }else if(str.equals("size")){
//                System.out.println(queue.size());
//            }else if(str.equals("empty")){
//                if(queue.isEmpty())
//                    System.out.println(1);
//                else
//                    System.out.println(0);
//            }else if(str.equals("front")){
//                if(queue.isEmpty())
//                    System.out.println(1);
//                else
//                    System.out.println(queue.peek());
//            }else if(str.equals("back")){
//                if(queue.isEmpty())
//                    System.out.println(1);
//                else
//                    System.out.println(queue.peekLast());
//            }
//        }
//    }
//}
