import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;

    static int N, nums[], answer[];
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(input.readLine());

        nums = new int[N];
        answer = new int[N];
        stack = new Stack<>();
        tokens = new StringTokenizer(input.readLine());

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(tokens.nextToken());
        }

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && nums[i]>nums[stack.peek()]){
                answer[stack.pop()] = nums[i];
            }
            stack.push(i); //인덱스 값을 스택에 넣어서 반복해서 수를 비교해주자,.
        }

        for (int i = 0; i < N; i++) {
            if(answer[i]==0) output.append(-1).append(" ");
            else output.append(answer[i]).append(" ");
        }

        System.out.println(output);

    }
}