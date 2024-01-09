import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    static int A, B, C;
    static long value;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        A = Integer.parseInt(tokens.nextToken());
        B = Integer.parseInt(tokens.nextToken());
        C = Integer.parseInt(tokens.nextToken());

        value = multiple(A, B, C);

        System.out.println(value);

    }

    //거듭제곱하는 수가 너무 크니까 분할정복으로 계산하는 것 
    private static long multiple(int a, int b, int mod) {
        if(b==1){
            return a%mod;
        }

        long x = multiple(a, b/2, mod);

        if(b%2==1){
            x = (x*x%mod)*a%mod;
            return x;
        }

        return (x*x)%mod;

    }
}