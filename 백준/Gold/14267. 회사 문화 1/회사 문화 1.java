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

    static int N, M, CEO;
    static List<Integer> company[];
    static int happyPoints[];


    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());

        company = new List[N+1];
        happyPoints = new int[N+1];
        CEO = 1;
        for (int i = 1; i <= N; i++) {
            company[i] = new ArrayList<>();
        }

        tokens = new StringTokenizer(input.readLine());
        tokens.nextToken(); //1번 버리기
        for (int i = 2; i <= N; i++) {
            int x = Integer.parseInt(tokens.nextToken());
            company[x].add(i);
        }

        for (int i = 0; i < M; i++) {
            tokens = new StringTokenizer(input.readLine());
            int nowPerson = Integer.parseInt(tokens.nextToken());
            int point = Integer.parseInt(tokens.nextToken());
            happyPoints[nowPerson] += point; //한번에 다 더해서 전파해야지 시간초과 안난다.
        }

        dfs(1);
        
        for(int i=1; i<=N; i++){
            output.append(happyPoints[i]).append(" ");
        }

        System.out.println(output);
    }

    private static void dfs(int now) {
        for(int vertex : company[now]){
            happyPoints[vertex] += happyPoints[now];
            dfs(vertex);
        }
    }
}