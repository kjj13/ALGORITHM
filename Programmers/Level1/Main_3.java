package Level1;

/**
 * - 로또의 최고 순위와 최저 순위
 */

public class Main_3 {

    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int cnt = 0;
        int cnt0 = 0;

        for (int l : lottos) {
            if (l == 0) {
                cnt0++;
                continue;
            }
            for (int w : win_nums) {
                if (l == w)
                    cnt++;
            }
        }

        int max = cnt + cnt0;
        answer[0] = rank(max);
        answer[1] = rank(cnt);

        return answer;
    }

    public int rank(int i) {
        int result = -1;
        switch (i) {
            case 0:
            case 1:
                result = 6;
                break;
            case 2:
                result = 5;
                break;
            case 3:
                result = 4;
                break;
            case 4:
                result = 3;
                break;
            case 5:
                result = 2;
                break;
            case 6:
                result = 1;
                break;
        }
        return result;
    }
}