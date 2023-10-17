import java.util.*;
import java.io.*;

class Solution {
    public int solution(int k, int[] tangerine) throws IOException {
        int answer = 0;
        
        Map<Integer, Integer> tangerineSize=new HashMap<>();
        
        for(int t:tangerine){
            tangerineSize.put(t,tangerineSize.getOrDefault(t, 0)+1);
        }

        List<Integer> list=new ArrayList<>(tangerineSize.values());
        Collections.sort(list, Collections.reverseOrder());
        
        int typeCnt = k;
        
        for(int t : list){
            if(typeCnt<=0) break;
            answer++;
            typeCnt -= t;
        }
        
        
        return answer;
    }
}