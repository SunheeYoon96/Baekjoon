import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    static int N, S, nums[];

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        N = Integer.parseInt(tokens.nextToken());
        S = Integer.parseInt(tokens.nextToken());

        nums = new int[N+1];
        tokens = new StringTokenizer(input.readLine());

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(tokens.nextToken());
        }

        int start=0;
        int end=0;
        long sum = 0L;
        int min = Integer.MAX_VALUE;

        while (start<=end && end<=N){
            if(sum >= S){
                sum -= nums[start++];
                min = Math.min(min, end-start+1);
            }else if(sum < S){
                sum += nums[end++];
            }
        }

        System.out.println(min==Integer.MAX_VALUE ? 0: min);


    }
}