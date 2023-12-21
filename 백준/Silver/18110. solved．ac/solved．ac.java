import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(input.readLine());
        int levels[] = new int[N];

        for (int i=0; i<N; i++){
            int value = Integer.parseInt(input.readLine());
            levels[i] = value;
        }

        Arrays.sort(levels);

        int cutline = (int)Math.round(N*0.15);
        double sum = 0; //미리 바꿔놓기

        for(int i=cutline; i<N-cutline; i++){
            sum += levels[i];
        }

        System.out.println((int)Math.round(sum/(N-2*cutline)));
    }
}