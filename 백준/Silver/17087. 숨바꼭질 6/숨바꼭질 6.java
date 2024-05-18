import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.attribute.AclFileAttributeView;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    static int S, N, brothersDis[];

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        N = Integer.parseInt(tokens.nextToken());
        S = Integer.parseInt(tokens.nextToken());

        brothersDis = new int[N];

        tokens = new StringTokenizer(input.readLine());
        for (int i = 0; i < N; i++) {
            //동생들과의 현재거리를 구함
            brothersDis[i] = Math.abs(Integer.parseInt(tokens.nextToken()) - S);
        }

        int answer = brothersDis[0];

        //최대공약수를 구함?
        for (int i = 1; i < N; i++) {
            answer = calcGCD(answer, brothersDis[i]);
            if(answer==1) break;
        }

        System.out.println(answer);



    }

    private static int calcGCD(int num1, int num2) {
        if(num1%num2==0) return num2;
        return calcGCD(num2, num1%num2);
    }
}