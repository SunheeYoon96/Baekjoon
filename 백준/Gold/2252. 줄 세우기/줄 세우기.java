import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;

    static int N, M;
    static Node[] adjList;
    static int inDegree[];

    static class Node {
        int vertex;
        Node link;

        public Node(int vertex, Node link){
            this.vertex = vertex;
            this.link = link;
        }
    }


    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());

        adjList = new Node[N+1];
        inDegree = new int[N+1];

        for (int i = 0; i < M; i++) {
            tokens = new StringTokenizer(input.readLine());
            int from = Integer.parseInt(tokens.nextToken());
            int to = Integer.parseInt(tokens.nextToken());
            adjList[from] = new Node(to, adjList[from]);
            inDegree[to]++; //진입차수 증가
        }

        ArrayList<Integer> list = topologySort();
        for(int vertex : list){
            output.append(vertex).append(" ");
        }

        System.out.println(output);


    }

    private static ArrayList<Integer> topologySort() {
        ArrayList<Integer> orderList = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N ; i++) {
            if(inDegree[i]==0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()){
            int now = queue.poll();
            orderList.add(now);

            for(Node tmp = adjList[now]; tmp!=null; tmp = tmp.link){
                if(--inDegree[tmp.vertex]==0){ //진입차수 제거 후 0인 것 큐에 넣기
                    queue.offer(tmp.vertex);
                }
            }
        }

        return orderList;

    }


}