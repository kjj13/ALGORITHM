package Level1;

/**
 * - 2016년
 *
 * 쓰음,, 나는 왜 배열로 할 생각을 못했을까.?
 * 조건문말고 그냥 배열에다가 달마다 날짜 넣으면 되는건데
 *
 * 코드 자동 정렬 단축키 : crtl + alt + L
 */

public class Main_18 {
    public static void main(String[] args) {
        System.out.println(solution(5, 24));
    }

    public static String solution(int a, int b) {
        String answer = "";
        int day = 0;
        for (int i = 1; i < a; i++) {
            if (i == 2)
                day += 29;
            else {
                if (i <= 7) {
                    if (i % 2 == 1)
                        day += 31;
                    else
                        day += 30;
                } else {
                    if (i % 2 == 1)
                        day += 30;
                    else
                        day += 31;
                }
            }
        }

        day += (b - 1);

        switch (day % 7){
            case 0:
                answer = "FRI";
                break;
            case 1:
                answer = "SAT";
                break;
            case 2:
                answer = "SUN";
                break;
            case 3:
                answer = "MON";
                break;
            case 4:
                answer = "TUE";
                break;
            case 5:
                answer = "WED";
                break;
            case 6:
                answer = "THU";
                break;
        }

        return answer;
    }
}
