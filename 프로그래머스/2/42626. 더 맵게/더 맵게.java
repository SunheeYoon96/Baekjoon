import java.util.*;
import java.io.*;

class Solution {
    
    static int answer;
    
    public int solution(int[] scoville, int K) throws IOException {
        answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int s : scoville){
            pq.offer(s);
        }
        
        while(pq.peek() < K) {
            if(pq.size()==1) {
                answer = -1;
                break;
            }
            int min = pq.poll();
            int minSecond = pq.poll();
            pq.offer(min + minSecond*2);
            answer++;
        }
        
        return answer;
    }
}