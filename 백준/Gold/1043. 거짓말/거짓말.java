import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    static int N, M, lierCnt, answer, parents[];
    static boolean knowPeoples[];
    static List<Integer>[] partyList;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());

        answer = 0;
        knowPeoples = new boolean[N+1];
        partyList = new List[M];
        for (int i = 0; i < M; i++) {
            partyList[i] = new ArrayList<>();
        }

        tokens = new StringTokenizer(input.readLine());
        lierCnt = Integer.parseInt(tokens.nextToken());

        //진실을 아는 사람들 체킹
        for (int i = 0; i < lierCnt; i++) {
            int num = Integer.parseInt(tokens.nextToken());
            knowPeoples[num] = true;
        }

        makeSet();

        for (int i = 0; i < M; i++) {
            tokens = new StringTokenizer(input.readLine());
            int memberCnt = Integer.parseInt(tokens.nextToken());
            int now = Integer.parseInt(tokens.nextToken());
            partyList[i].add(now);
            for (int j = 1; j < memberCnt; j++) {
                int next = Integer.parseInt(tokens.nextToken());
                union(now, next);
                partyList[i].add(next);
                now = next;
            }
        }

        for (int i = 1; i <= N; i++) {
            if(knowPeoples[i]){
                knowPeoples[find(i)] = true;
            }
        }

        for (int i = 0; i < M; i++) {
            int parent = find(partyList[i].get(0));
            if(!knowPeoples[parent]) answer++;
        }

        System.out.println(answer);
    }

    private static void union(int now, int next) {
        int a = find(now);
        int b = find(next);
        if(a != b){
            if(a > b){
                parents[a] = b;
            }else {
                parents[b] = a;
            }
        }
    }

    private static int find(int next) {
        if(parents[next]==next){
            return  next;
        }
        return  parents[next] = find(parents[next]);
    }

    private static void makeSet() {
        parents = new int[N+1];
        for (int i = 0; i <= N; i++) {
            parents[i] = i;
        }
    }
}