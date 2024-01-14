import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BigInteger A = new BigInteger(input.readLine());
        BigInteger B = new BigInteger(input.readLine());

        output.append(A.add(B)).append("\n");
        output.append(A.subtract(B)).append("\n");
        output.append(A.multiply(B)).append("\n");

        System.out.println(output);
    }

}