import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;

    static int TC, min, N;
    static String friends[];

    public static void main(String[] args) throws IOException {

        TC = Integer.parseInt(input.readLine());

        for (int tc = 0; tc < TC; tc++) {
            N = Integer.parseInt(input.readLine());

            tokens = new StringTokenizer(input.readLine());
            friends = new String[N];
            min = Integer.MAX_VALUE;

            if(N>32) {
                min = 0;
                output.append(min).append("\n");
                continue;
            }

            for (int i = 0; i < N; i++) {
                friends[i] = tokens.nextToken();
            }

            outLoop :for (int i = 0; i < N; i++) {
                for (int j = i+1; j < N; j++) {
                    for (int k = j+1; k < N; k++) {
                        min = Math.min(min, calcDistance(friends[i], friends[j], friends[k]));
                        if(min==0){
                            //이미 최소값이 나왔으니 더 할 필요 없어
                            break outLoop;
                        }
                    }
                }
            }
            output.append(min).append("\n");
        }

        System.out.println(output);

    }

    private static int calcDistance(String friendA, String friendB, String friendC) {
        int dist = 0;
        for (int i = 0; i < 4; i++) {
//            System.out.println(dist);
            dist += friendA.charAt(i)!= friendB.charAt(i) ? 1:0;
            dist += friendA.charAt(i)!= friendC.charAt(i) ? 1:0;
            dist += friendB.charAt(i)!= friendC.charAt(i) ? 1:0;
        }
        return dist;

    }


}