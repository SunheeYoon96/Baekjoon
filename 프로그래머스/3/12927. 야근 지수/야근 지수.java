import java.util.*;
import java.io.*;

class Solution {
    
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    
    public long solution(int n, int[] works) throws IOException {
        long answer = 0;
        
        for(int x : works){
            pq.offer(x);
        }
        
        while(n-- > 0){
            int now = pq.poll();
            now--;
            if(now <0) {
                pq.offer(0);    
            }else{
                pq.offer(now);
            }
            
        }
        
        while(!pq.isEmpty()){
            int val = pq.poll();
            answer += val*val;
        }
        
        return answer;
    }
}