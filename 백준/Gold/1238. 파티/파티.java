import org.omg.CORBA.MARSHAL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    static int N, M, X, originDist[], reverseDist[];
    static List<List<Town>> originRoad, reverseRoad;
    static final int INF=Integer.MAX_VALUE;

    static class Town implements Comparable<Town>{
        int to, time;

        public Town(int to, int time){
            this.to = to;
            this.time = time;
        }

        @Override
        public int compareTo(Town other) {
            return this.time - other.time;
        }
    }


    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        X = Integer.parseInt(tokens.nextToken());

        originRoad = new ArrayList<>();
        reverseRoad = new ArrayList<>();

        // 초기화 ( 미리 노드들 생성 )
        for (int i = 0; i <= N; i++) {
            originRoad.add(new ArrayList<>());
            reverseRoad.add(new ArrayList<>());
        }
        
        // 비용 최대로 초기화
        originDist = new int[N+1];
        reverseDist = new int[N+1];
        Arrays.fill(originDist, INF);
        Arrays.fill(reverseDist, INF);
        
        //입력받기
        for (int i = 1; i <= M; i++) {
            tokens = new StringTokenizer(input.readLine());
            int from = Integer.parseInt(tokens.nextToken());
            int to = Integer.parseInt(tokens.nextToken());
            int time = Integer.parseInt(tokens.nextToken());
            originRoad.get(from).add(new Town(to, time));
            reverseRoad.get(to).add(new Town(from, time));
        }
        
        //가는것 다익스트라
        dijkstra(originRoad, originDist, X);
        //오는것 다익스트라
        dijkstra(reverseRoad, reverseDist, X);

        int answer = -1;
        for (int i = 1; i <=N ; i++) {
            answer = Math.max(answer, originDist[i] + reverseDist[i]);
        }

        System.out.println(answer);

    }

    private static void dijkstra(List<List<Town>> road, int[] dist, int target) {
        boolean visited[] = new boolean[N+1];
        PriorityQueue<Town> pq = new PriorityQueue<>();
        pq.add(new Town(target, 0));

        dist[target] = 0;

        while (!pq.isEmpty()){
            Town now = pq.poll();

            if(visited[now.to]) continue;
            visited[now.to] = true;

            for (Town vertex : road.get(now.to)){
                if(dist[vertex.to] > dist[now.to] + vertex.time){
                    dist[vertex.to] = dist[now.to] + vertex.time;
                    pq.add(new Town(vertex.to, dist[vertex.to]));
                }
            }
        }
    }

}