import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    static int N, arr[][], ans;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(input.readLine());

        arr = new int[N][5];

        for (int i = 0; i < N; i++) {
            tokens = new StringTokenizer(input.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }

        int maxFriend = -1;
        ans = 0;

        //모든 다른 학생들과 5개년동안 반을 비교하기
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if(i==j) continue;

                for (int k = 0; k < 5; k++) { //5개 학년
                    if(arr[i][k]==arr[j][k]){
                        cnt++;
                        break;
                    }
                }
            }

            if(cnt > maxFriend){
                maxFriend = cnt;
                ans = i+1;
            }
        }

        System.out.println(ans);


    }
}