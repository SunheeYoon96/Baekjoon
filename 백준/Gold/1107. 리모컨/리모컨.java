import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    static int N, wrongCnt, correctNums[], ans;
    static boolean wrongNums[];

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(input.readLine());
        wrongCnt = Integer.parseInt(input.readLine());

        //예외1) 고장난 버튼이 없으면 그냥 바로 해당채널 누르고 알고리즘 종료
        //예외2) 99, 101 은 1이다.
        if(wrongCnt==0){
            int value = Math.abs(100-N);
            int len = String.valueOf(N).length();
            System.out.println(Math.min(value, len));
            System.exit(0);
        }

        wrongNums = new boolean[10];
        tokens = new StringTokenizer(input.readLine());

        for (int i = 0; i < wrongCnt; i++) {
            int num = Integer.parseInt(tokens.nextToken());
            wrongNums[num] = true;
        }

//        correctNums = new int[10-wrongCnt];
//        int idx = 0;
//        for (int i = 0; i < 10; i++) {
//            if(!wrongNums[i]) {
//                correctNums[idx++] = i;
//            }
//        }

        //중복순열 + 완탐 -> 앞자리에 0이 오면 또 피곤함.
        //0 ~ 999,999 까지 싹다 검사 -> 시간 2초 -> 가능 -> 그래서 분류에 완탐이라고 했나봄

        int value = Math.abs(100-N);

        for (int i = 0; i <= 999999; i++) {

            if(!checkButton(i)) continue;

            int tmp = 0;
            String strVal = String.valueOf(i);
            tmp += strVal.length(); //이동한 숫자 길이
            tmp += Math.abs(N-i); //목적지랑 차이
            value = Math.min(value, tmp);
        }

        System.out.println(value);

    }

    private static boolean checkButton(int i) {
        String target = String.valueOf(i);
        for (int j = 0; j < target.length(); j++) {
            if(wrongNums[target.charAt(j)-'0']) return false;
        }
        return true;
    }
}