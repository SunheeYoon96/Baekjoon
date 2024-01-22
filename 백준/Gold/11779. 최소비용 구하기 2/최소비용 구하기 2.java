import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;

    static int N, M, start, end, dist[];
    static List[] roads;
    static int preway[];
    static final int INF=Integer.MAX_VALUE;

    public static class Town implements Comparable<Town>{
        int to, weight;
        public Town(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Town other) {
            return this.weight - other.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(input.readLine());
        M = Integer.parseInt(input.readLine());

        roads = new List[N+1];
        for (int i = 0; i <= N; i++) {
            roads[i] = new ArrayList<Town>();
        }

        dist = new int[N+1];    //최소비용
        Arrays.fill(dist, INF);
        preway = new int[N+1]; //경로

        for (int i = 0; i < M; i++) {
            tokens = new StringTokenizer(input.readLine());
            int from = Integer.parseInt(tokens.nextToken());
            int to = Integer.parseInt(tokens.nextToken());
            int weight = Integer.parseInt(tokens.nextToken());
            roads[from].add(new Town(to, weight));
        }

        tokens = new StringTokenizer(input.readLine());
        start = Integer.parseInt(tokens.nextToken());
        end = Integer.parseInt(tokens.nextToken());

        dijkstra(start, end);

        output.append(dist[end]).append("\n");

        List<Integer> ways = new ArrayList<>();
        int cur = end;
        while (cur!=0){
            ways.add(cur);
            cur = preway[cur]; //역으로 거슬러 올라가면서 체크
        }
        output.append(ways.size()).append("\n");
        for (int i = ways.size()-1; i >=0 ; i--) {
            output.append(ways.get(i)).append(" ");
        }

        System.out.println(output);

    }

    private static void dijkstra(int startPoint, int endPoint) {
        PriorityQueue<Town> pq = new PriorityQueue<>();
        boolean visited[] = new boolean[N+1];
        pq.add(new Town(startPoint, 0));

        dist[startPoint] = 0; //시작~시작 -> 0

        while (!pq.isEmpty()){
            Town now = pq.poll();

            if(visited[now.to]) continue;
            visited[now.to] = true;

            for (int i = 0; i < roads[now.to].size(); i++) {
                Town next = (Town) roads[now.to].get(i);
                if(!visited[next.to]){
                    if(dist[next.to] > dist[now.to] + next.weight){
                        dist[next.to] = dist[now.to] + next.weight;
                        pq.add(new Town(next.to, dist[next.to]));
                        preway[next.to] = now.to; //직전에 방문한 도시를 기록해두자.
                    }
                }

            }
        }


    }
}