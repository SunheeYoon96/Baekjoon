import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    static int TC, N;
    static String numbers[];


    public static void main(String[] args) throws IOException {
        TC = Integer.parseInt(input.readLine());

        for (int i = 0; i < TC; i++) {
            N = Integer.parseInt(input.readLine());

            numbers = new String[N];
            for (int j = 0; j < N; j++) {
                numbers[j] = input.readLine();
            }

            Arrays.sort(numbers);

            boolean flag = false;

            for (int j = 0; j < N-1; j++) {
                if(numbers[j+1].startsWith(numbers[j])){
                    flag = true;
                    break;
                }
            }

            if(flag) {
                output.append("NO").append("\n");
            }else {
                output.append("YES").append("\n");
            }

        }//end TC

        System.out.println(output);
    }
}
