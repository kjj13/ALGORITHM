import java.util.*;

class Solution {
    public static void main(String[] args) {
        int sum=0;
        for(int i=1;i<=5;i+=2){
            if(i%3 != 0)
                sum += i;
        }
        System.out.println(sum);
    }

    public static int[] solution(String code, String day, String[] data) {
        int[] answer = {};
        List<String[]> strData = new ArrayList<>();
        List<String[]> result = new ArrayList<>();

        for(String str : data){
            String[] datas = str.split("=| ");
            strData.add(datas);
        }

        for(int i=0;i<strData.size();i++){
            if( code.equals(strData.get(i)[3])&&
            day.equals(strData.get(i)[5].substring(0,8))){
                result.add(strData.get(i));
            }
        }

        Collections.sort(result,(a,b)-> a[1].compareTo(b[1]));

        answer = new int[result.size()];
        for(int i=0;i<result.size();i++){
            answer[i] = Integer.parseInt(result.get(i)[1]);
        }

        return answer;
    }
    public static class customer{
        private int time;
        private int rate;
        private int id;


        public customer(int time, int rate,int id) {
            this.time = time;
            this.rate = rate;
            this.id = id;
        }
    }

    public static int[] solution1(int[] t, int[] r) {
        int[] answer = {};
        answer = new int[t.length];
        List<customer> cus = new ArrayList<>();

        for(int i=0;i<t.length;i++){
            cus.add(new customer(t[i],r[i],i));
        }

        for(int i=0;i<t.length;i++){
            List<customer> result = new ArrayList<>();
            for(int j=0;j<cus.size();j++) {
                if (i >= cus.get(j).time) {
                    result.add(cus.get(j));
                }
            }
            if(result.size() > 0) {
                Collections.sort(result, (a, b) ->
                        a.rate == b.rate ? (a.time == b.time ?
                                a.id - b.id : a.time - b.time)
                                : a.rate - b.rate);

                answer[i] = result.get(0).id;
                cus.remove(result.get(0).id);
            }
        }

        return answer;
    }
}