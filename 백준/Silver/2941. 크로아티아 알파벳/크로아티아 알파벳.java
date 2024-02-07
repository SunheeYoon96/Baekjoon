import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {
        String str = input.readLine();
        int answer = 0;
        int len = str.length();

        String[] croatia = {"c=","c-","dz=","d-","lj","nj","s=","z="};

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == 'c' && i<len-1) {
                if(str.charAt(i+1)=='=' || str.charAt(i+1)=='-'){
                    i++;
                }
            } else if (ch=='d' && i<len-1) {
                if(str.charAt(i + 1)=='z' && i<len-2) {
                    if(str.charAt(i + 2)=='=') {
                        i += 2;
                    }
                } else if(str.charAt(i + 1)=='-') {
                    i++;
                }
            } else if (ch=='l' && i<len-1) {
                if(str.charAt(i+1)=='j'){
                    i++;
                }
            } else if (ch=='n' && i<len-1) {
                if(str.charAt(i+1)=='j'){
                    i++;
                }
            } else if (ch=='s' && i<len-1) {
                if(str.charAt(i+1)=='='){
                    i++;
                }
            } else if (ch=='z' && i<len-1) {
                if(str.charAt(i+1)=='='){
                    i++;
                }
            }
            answer++;
        }
        System.out.println(answer);


    }
}