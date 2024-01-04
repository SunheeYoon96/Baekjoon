import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;

    static int TestCase;

    public static void main(String[] args) throws IOException {
        TestCase = Integer.parseInt(input.readLine());

        for (int tc = 0; tc < TestCase; tc++) {
            int N = Integer.parseInt(input.readLine());

            HashMap<String, Integer> hashMap = new HashMap();

            for (int i = 0; i < N; i++) {
                tokens = new StringTokenizer(input.readLine());
                tokens.nextToken();
                String type = tokens.nextToken();

                if(hashMap.containsKey(type)){
                    hashMap.put(type, hashMap.get(type)+1);
                }else {
                    hashMap.put(type, 1);
                }
            }

            int answer = 1;

            for(int val : hashMap.values()){
                answer *= (val+1); //착용 안 한 경우 포함
            }

            answer -= 1; //아무것도 안입은 경우
            output.append(answer).append("\n");
        }

        System.out.println(output);





    }
}