import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    static int N, arr[], X, cnt;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(input.readLine());
        arr = new int[N];

        tokens = new StringTokenizer(input.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(tokens.nextToken());
        }

        X = Integer.parseInt(input.readLine());

        Arrays.sort(arr);

        int startIdx = 0;
        int endIdx = N-1;
        cnt = 0;

        while (startIdx < endIdx){
            int val = arr[startIdx] + arr[endIdx];

            if(val==X) {
                cnt++;
                startIdx++;
                endIdx--;
            } else if (val < X) {
                startIdx++;
            }else if(val > X){
                endIdx--;
            }
        }

        System.out.println(cnt);

    }
}