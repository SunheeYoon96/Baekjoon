import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    static int N, nums[], LISLeft[], LISRight[];

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(input.readLine());

        nums = new int[N];
        LISLeft = new int[N];
        LISRight = new int[N];
        Arrays.fill(LISLeft, 1);
        Arrays.fill(LISRight, 1);

        tokens = new StringTokenizer(input.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(tokens.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[j]<nums[i] && LISLeft[i]<LISLeft[j]+1){
                    LISLeft[i] = LISLeft[j]+1;
                }
            }
        }

        for (int i = N-1; i >=0; i--) {
            for (int j = N-1; j > i; j--) {
                if(nums[j]<nums[i] && LISRight[i]<LISRight[j]+1){
                    LISRight[i] = LISRight[j]+1;
                }
            }
        }

        int sumLIS[] = new int[N];
        int maxval = 0;

        for (int i = 0; i < N; i++) {
            sumLIS[i] = LISLeft[i]+LISRight[i]-1;
            maxval = Math.max(maxval, sumLIS[i]);
        }

//        System.out.println(Arrays.toString(LISLeft));
//        System.out.println(Arrays.toString(LISRight));

        System.out.println(maxval);




    }
}