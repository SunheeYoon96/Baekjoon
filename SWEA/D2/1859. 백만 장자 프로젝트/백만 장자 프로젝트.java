import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//아이디어 대실패
//그리디로 접근하지 말자


public class Solution {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;

    static int TC, N, values[];
    static long maxBenefit;

    public static void main(String[] args) throws IOException {
        TC = Integer.parseInt(input.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            output.append("#").append(tc).append(" ");
            N = Integer.parseInt(input.readLine());
            tokens = new StringTokenizer(input.readLine());

            values = new int[N];
            maxBenefit = 0L;

            for (int i = 0; i < N; i++) {
                values[i] = Integer.parseInt(tokens.nextToken());
            }//입력완료

            int maxVal=0;

            //배열의 뒤에서부터 최대값을 갱신하며 (최대값-현재값)의 차이를 더해나가면 최대 이익이 나옴
            for (int i = N-1; i >=0 ; i--) {
                int now = values[i];
                if(now > maxVal){
                    maxVal = now;
                }
                maxBenefit += (maxVal-now);
            }

            output.append(maxBenefit).append("\n");

        }//테케 end

        System.out.println(output);

    }
}
