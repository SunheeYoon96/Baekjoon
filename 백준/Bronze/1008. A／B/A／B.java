import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        double A = Double.parseDouble(tokens.nextToken());
        double B = Double.parseDouble(tokens.nextToken());
        double ans = A/B;

        System.out.println(ans);

    }
}