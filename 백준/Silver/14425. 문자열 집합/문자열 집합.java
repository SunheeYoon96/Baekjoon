import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int N, M, ans;
    static String strs[], values[];

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());

        HashMap<String, Integer> stringHashMap = new HashMap<>();
        ans = 0;

        for (int i = 0; i < N; i++) {
            stringHashMap.put(input.readLine(), 0);
        }

        for (int i = 0; i < M; i++) {
            String str = input.readLine();
            if(stringHashMap.containsKey(str)) {
                ans++;
            }
        }


        System.out.println(ans);


    }
}
