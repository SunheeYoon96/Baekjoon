import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    static int cnt;

    public static void main(String[] args) throws IOException {

        while (true){
            String str = input.readLine();
            cnt = 0;

            if(str.equals("#")){
                break;
            }

            for (int i = 0; i < str.length(); i++) {
                String s = str.charAt(i)+"";
                if("aeiou".contains(s) || "AEIOU".contains(s)){
                    cnt++;
                }
            }
            output.append(cnt).append("\n");
        }

        System.out.println(output);

    }
}