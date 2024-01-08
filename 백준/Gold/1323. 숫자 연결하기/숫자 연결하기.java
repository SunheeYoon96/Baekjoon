import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    static long N, K, value;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        N = Integer.parseInt(tokens.nextToken());
        K = Integer.parseInt(tokens.nextToken());

        //mod
        value = N;
        int cnt = 1;
        long res = N;
        int len = String.valueOf(N).length();
        boolean remains[] = new boolean[(int)K];

        while (true){
            res = value % K;
//            System.out.println(res);

            if(res==0) break;
            if(remains[(int)res]){
                cnt = -1;
                break;
            }

            value = res*(long)Math.pow(10,len) + N;
//            System.out.println(value);
            remains[(int)res] = true;
            cnt++;

        }

        System.out.println(cnt);




    }
}

//ArrayIndexOutOfBoundsException
//1000000000 99999