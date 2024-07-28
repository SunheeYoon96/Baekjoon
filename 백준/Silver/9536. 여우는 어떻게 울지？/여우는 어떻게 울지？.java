import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;

    static String origin;
    static Queue<String> foxSound;
    static int TC;
    static String str;

    public static void main(String[] args) throws IOException {
        TC = Integer.parseInt(input.readLine());

        for (int t = 0; t <TC ; t++) {
            foxSound = new ArrayDeque<>();
            origin = input.readLine();

            HashSet<String> otherSound = new HashSet<>();

            boolean flag = true;

            while(flag){
                str = input.readLine();
                if(str.equals("what does the fox say?")) {
                    flag = false;
                    break;
                }

                tokens = new StringTokenizer(str);
                tokens.nextToken();
                tokens.nextToken();
                otherSound.add(tokens.nextToken());
            }

            tokens = new StringTokenizer(origin);
            while (tokens.hasMoreTokens()){
                String s = tokens.nextToken();
                if(!otherSound.contains(s)){
                    foxSound.offer(s);
                }
            }

            while (!foxSound.isEmpty()){
                output.append(foxSound.poll()).append(" ");
            }
            output.append("\n");
        }
        System.out.println(output);

    }
}