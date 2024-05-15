import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    static List<String> pickedList;
    static int N,M,K, winningCnt;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        K = Integer.parseInt(tokens.nextToken());

        pickedList = new ArrayList<>();
        winningCnt = 0;

        combination(1, 0, new StringBuilder());

        for (int i = 0; i < pickedList.size(); i++) {
            String left = pickedList.get(i);
            for (int j = 0; j < pickedList.size(); j++) {
                String right = pickedList.get(j);
                int cnt = 0;
                for (int k = 0; k < M; k++) {
                    if(left.contains(right.charAt(k)+"")){
                        cnt++;
                    }
                }
                if(cnt >=K) winningCnt++;
            }
        }

        double a = pickedList.size();
        double b = (double) winningCnt;

        System.out.println(b/(a*a));

    }

    private static void combination(int start, int cnt, StringBuilder sb) {
        if(cnt==M){
//            System.out.println(sb.toString());
            pickedList.add(sb.toString());
            return;
        }

        for (int i = start; i <=N ; i++) {
            int currentLen = sb.length();
            sb.append(i);
            combination(i+1, cnt+1, sb);
            sb.setLength(currentLen); //아니면 추가했던 문자 제거
        }

    }


}