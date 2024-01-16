import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String str = input.readLine();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if(Character.isUpperCase(c)){
                String s = c+"";
                output.append(s.toLowerCase());
            }else if (Character.isLowerCase(c)){
                String s = c+"";
                output.append(s.toUpperCase());
            }
        }

        System.out.println(output);

    }
}