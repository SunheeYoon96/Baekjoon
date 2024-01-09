import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;

    static int N, nums[], LIS[], answer;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(input.readLine());

        nums = new int[N];
        LIS = new int[N];
        Arrays.fill(LIS, 1);

        tokens = new StringTokenizer(input.readLine());
        for (int i = 0; i < N; i++) {
           nums[i] = Integer.parseInt(tokens.nextToken());
        }

        answer = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            for(int j=0; j<i; j++){
                if(nums[j]<nums[i]  && LIS[i]<LIS[j]+1){
                    LIS[i] = LIS[j]+1;
                }
            }
            answer = Math.max(answer, LIS[i]);
        }

        System.out.println(answer);




    }
}