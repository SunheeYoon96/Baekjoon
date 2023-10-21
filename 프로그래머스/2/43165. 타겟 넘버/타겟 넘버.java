import java.util.*;
import java.io.*;

class Solution {
    static int answer;
    public int solution(int[] numbers, int target) throws IOException {
        answer = 0;
        dfs(numbers, 0, target, 0);
        return answer;
    }
    
    public static void dfs(int[] numbers, int depth, int target , int sum) {
        if(depth == numbers.length){
            if(target==sum){
                answer++;
            }
            return;
        }
            
        int plusVal = sum + numbers[depth];
        int minumVal = sum - numbers[depth];
            
        dfs(numbers, depth+1, target, plusVal);
        dfs(numbers, depth+1, target, minumVal);
    }
}