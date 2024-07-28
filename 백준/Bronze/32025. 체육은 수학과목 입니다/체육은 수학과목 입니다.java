import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    static int H, W;

    public static void main(String[] args) throws IOException {
        H = Integer.parseInt(input.readLine());
        W = Integer.parseInt(input.readLine());

        int r = Math.min(H,W)*100;
        int ans = r/2;
        System.out.println(ans);

    }
}