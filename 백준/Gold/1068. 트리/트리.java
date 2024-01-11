import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    static int N, answer, HEAD, deleted;
    static List<Integer> tree[];
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(input.readLine());

        tree = new List[N];

        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }

        tokens = new StringTokenizer(input.readLine());
        HEAD = -1;

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(tokens.nextToken());
            if(x==-1){
                HEAD = i;
            }else{
                tree[x].add(i);
                tree[i].add(x);
            }
        }

        deleted = Integer.parseInt(input.readLine());
        visited = new boolean[N];
        answer = 0;

        if (deleted == HEAD) {
            System.out.println(0);
            return;
        } else {
            dfs(HEAD);
        }
        System.out.println(answer);

    }

    private static void dfs(int node) {
        visited[node] = true;
        int nodes = 0;
        for (int vertex : tree[node]) {
            // 연결 노드 탐색
            if (vertex != deleted && !visited[vertex]) {
                nodes++;
                dfs(vertex);
            }
        }
        if (nodes == 0) {
            answer++; // 자식 노드가 하나도 없으면 리프 노드임
        }

    }


}