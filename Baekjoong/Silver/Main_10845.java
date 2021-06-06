package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> arrayQueue = new ArrayList<>();
        int head = 0;
        int tail = 0;

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            String str = st.nextToken();
            if(str.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                arrayQueue.add(num);
//                tail++;
            }else if(str.equals("pop")){
                if(arrayQueue.size() > 0)
                    System.out.println(arrayQueue.remove(0));
                else
                    System.out.println(-1);
            }else if(str.equals("size")){
                System.out.println(arrayQueue.size());
            }else if(str.equals("empty")){
                if(arrayQueue.size() > 0)
                    System.out.println(0);
                else
                    System.out.println(1);
            }else if(str.equals("front")){
                if(arrayQueue.size() > 0)
                    System.out.println(arrayQueue.get(0));
                else
                    System.out.println(-1);
            }else if(str.equals("back")){
                if(arrayQueue.size() > 0)
                    System.out.println(arrayQueue.get(arrayQueue.size()-1));
                else
                    System.out.println(-1);
            }
        }
    }
}
