package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 *    list가 비어있는 경우를 생각 못해서 틀렸음.
 *    그리고 StringTokenizer로 구분자 여러개 하는법 하나 알아감.
 *    + 특수문자는 \\를 사용해야함.
 *    StringTokenizer st = new StringTokenizer(br.readLine(),",|\\[|\\]");
 */

public class Main_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            String p = br.readLine();
            boolean Rcheck = true;
            boolean Echeck = false;  // 비었으면 true, 안비었다면 false

            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(),",|\\[|\\]");
            LinkedList<Integer> list = new LinkedList<>();
            StringBuilder sb = new StringBuilder();

            for(int j=0;j<n;j++)
                list.add(Integer.parseInt(st.nextToken()));

            for(int j=0;j<p.length();j++){
                if(p.charAt(j) == 'R') Rcheck = !Rcheck;
                else{
                    if(!list.isEmpty()) {
//                    앞에서 뒤로
                        if (Rcheck) list.removeFirst();
//                    뒤에서 앞으로
                        else list.removeLast();
                    }else {
                        Echeck = true;
                        break;
                    }
                }
            }
            if (Echeck) System.out.println("error");
            else{
//                list가 비어있는 경우를 생각 못해서 틀렸음.
                if(!list.isEmpty()) {
                    if (Rcheck) printList(list);
                    else printRList(list);
                }else
                    System.out.println("[]");
            }

        }
    }

    public static void printList(LinkedList<Integer> list){
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        while (list.size() > 1){
            sb.append(list.removeFirst()).append(',');
        }
        sb.append(list.removeFirst()).append(']');
        System.out.println(sb);
    }

    public static void printRList(LinkedList<Integer> list){
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        while (list.size() > 1){
            sb.append(list.removeLast()).append(',');
        }
        sb.append(list.removeLast()).append(']');
        System.out.println(sb);
    }
}
