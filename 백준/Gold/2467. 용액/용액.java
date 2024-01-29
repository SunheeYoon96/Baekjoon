import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;

    static int N, nums[];

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(input.readLine());
        nums = new int[N];

        tokens = new StringTokenizer(input.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(tokens.nextToken());
        }

        int start = 0;
        int end = N-1;
        int minVal = Integer.MAX_VALUE;
        int ans1 = 0;
        int ans2 = 0;

        while (start<end && end < N){
            int tmp = nums[start] + nums[end];

            if(minVal > Math.abs(tmp)){
                ans1 = nums[start];
                ans2 = nums[end];
                minVal = Math.abs(tmp);
            }

            if(tmp > 0){
                end--;
            } else if (tmp < 0) {
                start++;
            } else if (tmp==0) {
                break;
            }
        }

        output.append(ans1).append(" ").append(ans2);
        System.out.println(output);


    }
}