package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main_5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i= 0;i<N;i++){
            List<Character> pw = new LinkedList<>();
            ListIterator iter = pw.listIterator();
            StringBuilder sb = new StringBuilder();

            while (iter.hasNext()){
                iter.next();
            }

            String str = br.readLine();

            for(int j=0;j<str.length();j++){
                char c = str.charAt(j);
                switch (c){
                    case '<':
                        if(iter.hasPrevious())
                            iter.previous();
                        break;
                    case '>':
                        if(iter.hasNext())
                            iter.next();
                        break;
                    case '-':
                        if(iter.hasPrevious()){
                            iter.previous();
                            iter.remove();
                        }
                        break;
                    default:
                        iter.add(c);
                        break;
                }
            }
            for (Character ch : pw) {
                sb.append(ch);
            }

            System.out.println(sb);
        }
    }
}
