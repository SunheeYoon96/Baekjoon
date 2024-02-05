import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;

    static int TC, N, K, target, buildingsCost[];
    static Building buildingList[];
    static int inDegree[], totalCost[];

    static class Building {
        int vertex;
        Building link;
        public Building (int vertex, Building link) {
            this.vertex = vertex;
            this.link = link;
        }
    }

    public static void main(String[] args) throws IOException {
        TC = Integer.parseInt(input.readLine());

        for (int tc = 0; tc < TC; tc++) {
            tokens = new StringTokenizer(input.readLine());
            N = Integer.parseInt(tokens.nextToken());
            K = Integer.parseInt(tokens.nextToken());

            buildingList = new Building[N+1];
            inDegree = new int[N+1];
            buildingsCost = new int[N+1];
            totalCost = new int[N+1];

            tokens = new StringTokenizer(input.readLine());
            for (int i = 1; i <= N; i++) {
                buildingsCost[i] = Integer.parseInt(tokens.nextToken());
            }

            for (int i = 0; i < K; i++) {
                tokens = new StringTokenizer(input.readLine());
                int from = Integer.parseInt(tokens.nextToken());
                int to = Integer.parseInt(tokens.nextToken());
                buildingList[from] = new Building(to, buildingList[from]);
                inDegree[to]++;
            }

            target = Integer.parseInt(input.readLine());

            topologySort();
            output.append(totalCost[target]).append("\n");
        }

        System.out.println(output);

    }

    private static void topologySort() {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if(inDegree[i]==0) {
                totalCost[i] = buildingsCost[i];
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()){
            int now = queue.poll();

            for(Building tmp = buildingList[now]; tmp!=null; tmp = tmp.link){
                int next = tmp.vertex;
                totalCost[next] = Math.max(totalCost[now]+buildingsCost[next], totalCost[next]);
                if(--inDegree[next]==0){
                    queue.offer(next);
                }
            }
        }



    }
}