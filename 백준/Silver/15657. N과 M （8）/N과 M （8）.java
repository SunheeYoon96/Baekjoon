import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;

    static int N, M, nums[], picked[];

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());

        tokens = new StringTokenizer(input.readLine());
        nums = new int[N];
        picked = new int[M];

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(tokens.nextToken());
        }

        //비내림차순 정렬
        Arrays.sort(nums);

        makeDupPermutation(0, 0);

        System.out.println(output);

    }

    private static void makeDupPermutation(int nth, int start) {

        if(nth==M){
            for(int x : picked){
                output.append(x).append(" ");
            }
            output.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            picked[nth] = nums[i];
            makeDupPermutation(nth+1, i);
        }
    }
}