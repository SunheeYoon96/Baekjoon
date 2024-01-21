import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;

    static int N, M, K, X, dist[];
    static List<List<Integer>> nodes;
    static List<Integer> answer;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        K = Integer.parseInt(tokens.nextToken());
        X = Integer.parseInt(tokens.nextToken());

        nodes = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            nodes.add(new ArrayList());
        }

        for (int i = 0; i < M; i++) {
            tokens = new StringTokenizer(input.readLine());
            int from = Integer.parseInt(tokens.nextToken());
            int to = Integer.parseInt(tokens.nextToken());
            nodes.get(from).add(to);
        }

        dist = new int[N+1];
        Arrays.fill(dist, -1);

        answer = new ArrayList<>();
        
        bfs(X);

        Collections.sort(answer);
        for(int x : answer){
            output.append(x).append("\n");
        }

        System.out.println(!answer.isEmpty() ? output : "-1");
    }

    private static void bfs(int start) {
        dist[start] = 0;
        Queue<Integer> que = new ArrayDeque<>();
        que.add(start);

        while (!que.isEmpty()){
            int now = que.poll();

            if (dist[now] > K) return;
            if (dist[now] == K) answer.add(now);

            for(int vertex : nodes.get(now)){
                if (dist[vertex] == -1) { //방문한 적이 없음.
                    que.add(vertex);
                    dist[vertex] = dist[now]+1;
                }
            }
        }

    }
}