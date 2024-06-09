import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    static int N, K, ans, maxReadCnt;
    static List<String> words;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        N = Integer.parseInt(tokens.nextToken());
        K = Integer.parseInt(tokens.nextToken());

        words = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            words.add(input.readLine());
        }

        boolean alphabets[] = new boolean[26];
        alphabets[0] = true; //a
        alphabets[2] = true; //c
        alphabets[8] = true; //i
        alphabets[13] = true; //n
        alphabets[19] = true; //t

        maxReadCnt = -1;

        if(K<5){
            System.out.println(0);
            return;
        }else if(K==26){
            System.out.println(N);
        }else{
            combination(0,0, alphabets);
            System.out.println(maxReadCnt);
        }

    }

    private static void combination(int start, int cnt, boolean[] alphabets) {
        if(cnt==K-5){
            //최대로 읽을 수 있는 단어의 갯수 확인
            int readCnt = 0;
            for (int i = 0; i < N; i++) {
                String word = words.get(i);
                boolean canRead = true;
                for (int j = 4; j < word.length()-4 ; j++) {
                    if(!alphabets[word.charAt(j)-'a']){
                        canRead = false;
                        break;
                    }
                }
                if(canRead){
                    readCnt++;
                }
            }
            if(readCnt > maxReadCnt) maxReadCnt = readCnt;
        }

        for (int i = start; i < 26; i++) {
            if(!alphabets[i]){
                alphabets[i] = true;
                combination(i, cnt+1, alphabets);
                alphabets[i] = false;
            }
        }
    }
}