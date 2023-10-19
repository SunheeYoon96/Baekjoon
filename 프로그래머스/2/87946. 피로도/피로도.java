import java.util.*;
import java.io.*;

class Solution {
    static boolean visited[];
    static int answer;
    
    public int solution(int k, int[][] dungeons) throws IOException {
        answer = -1;
        visited = new boolean[dungeons.length];
        
        makePermutation(0, k, dungeons);
        
        return answer;
    }
    
    public void makePermutation(int nth, int power, int[][] dungeons){
        for(int i=0; i< dungeons.length; i++){
            //이미 방문한 던전이거나 최소피로도 보다 낮을 경우 안간다.
            if(visited[i] || dungeons[i][0] > power) {
                continue;
            }
            visited[i] = true;
            makePermutation(nth+1, power - dungeons[i][1], dungeons);
            visited[i] = false;
        }
        answer = Math.max(answer, nth);
        
        
    }
}