import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    static int N, weights[];
    static Long answer;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(input.readLine());

        weights = new int[N];
        tokens = new StringTokenizer(input.readLine());

        for (int i = 0; i < N; i++) {
            weights[i] = Integer.parseInt(tokens.nextToken());
        }

        Arrays.sort(weights);

        Long sum = 0L;

        for (int i = 0; i < N; i++) {
            if(weights[i] > sum+1){
                break;
            }else {
                sum += weights[i];
            }
        }

        System.out.println(sum+1);

    }
}
