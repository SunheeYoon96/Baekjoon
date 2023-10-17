import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) throws IOException{
        int answer = 0;
        
        for(int i=0; i<discount.length-10+1; i++){
            HashMap<String, Integer> hashMap = new HashMap<>();
            for(int j=0; j<10; j++){
                hashMap.put(discount[i+j], hashMap.getOrDefault(discount[i+j],0)+1);
            }
            
            boolean flag=true;
            for(int j=0; j<want.length; j++){
                if(hashMap.getOrDefault(want[j], 0) != number[j]) {
                    flag = false;
                    break;
                }
            }
            
            if(flag){
               answer++; 
            }
        }
        
        return answer;
    }
}