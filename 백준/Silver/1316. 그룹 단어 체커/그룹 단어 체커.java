import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    static int N, answer;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(input.readLine());

        for (int i = 0; i < N; i++) {
            String str = input.readLine();
            if(check(str)){
                answer++;
            }
        }

        System.out.println(answer);


    }

    private static boolean check(String str) {
        boolean alphabet[] = new boolean[26];
        char now = str.charAt(0);
        alphabet[now-'a'] = true;
        for (int j = 1; j < str.length(); j++) {
            char next = str.charAt(j);
            if(now!=next){
                if(alphabet[next-'a']) {
                    return false;
                } else {
                    alphabet[next-'a'] = true;
                    now = next;
                }
            }
        }
        return true;
    }
}