import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;
    static int TC, N, M, answer;


    public static void main(String[] args) throws IOException {
        TC = Integer.parseInt(input.readLine());

        for (int tc = 0; tc < TC; tc++) {
            tokens = new StringTokenizer(input.readLine());
            N = Integer.parseInt(tokens.nextToken()); // 문서의 갯수
            M = Integer.parseInt(tokens.nextToken()); // 확인하고 싶은 문서의 위치

            tokens = new StringTokenizer(input.readLine());
            LinkedList<int[]> printQueue = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                printQueue.add(new int[] {i, Integer.parseInt(tokens.nextToken())});
            }

            answer = 0;

            while (!printQueue.isEmpty()){
                int[] now = printQueue.poll();
                boolean isImportant = true;

                for (int i = 0; i < printQueue.size(); i++) {
                    if(now[1] < printQueue.get(i)[1]){
                        printQueue.add(now);
                        for (int j = 0; j < i; j++) {
                            //현재보다 중요도가 높은 문서 전까지 뒤로 보냄
                            printQueue.add(printQueue.pollFirst());
                        }
                        isImportant = false;
                        break;
                    }
                }
                if(isImportant==false) continue;

                answer++;
                if(now[0]==M){
                    output.append(answer).append("\n");
                    break;
                }
            }

        }
        System.out.println(output);
    }


}














