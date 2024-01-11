import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    static int N, ans;
    static List<Integer> tree[];
    static boolean visited[];


    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(input.readLine());//정점의 갯수

        tree = new List[N+1];
        visited = new boolean[N+1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            tokens = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(tokens.nextToken());
            int b = Integer.parseInt(tokens.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        ans=0;
        dfs(1, 0);

        System.out.println(ans%2==0 ? "No" : "Yes");

    }

    private static void dfs(int now, int cnt) {
        visited[now] = true;

        for (int vertex : tree[now]) {
            if(!visited[vertex]){
                dfs(vertex, cnt+1);
            }
        }

        if(now!=1 && tree[now].size()==1){ //루트도 아니고 연결된 간선이 1개면 리프노드임
            ans += cnt;
        }
    }
}