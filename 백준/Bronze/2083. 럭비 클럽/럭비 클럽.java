import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;

    public static void main(String[] args) throws IOException {

        while (true){
            tokens = new StringTokenizer(input.readLine());
            String name = tokens.nextToken();;
            int age = Integer.parseInt(tokens.nextToken());
            int weight = Integer.parseInt(tokens.nextToken());

            if(name.equals("#")) break;

            if(age>17 || weight>=80){
                output.append(name).append(" ").append("Senior").append("\n");
            }else {
                output.append(name).append(" ").append("Junior").append("\n");
            }
        }

        System.out.println(output);


    }
}