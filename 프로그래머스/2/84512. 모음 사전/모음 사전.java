import java.util.*;
import java.io.*;

class Solution {
    
    static int answer;
    static String vowels[] = {"A","E","I","O","U"};
    static List<String> dictList = new ArrayList<>();
    
    public int solution(String word) throws IOException {
        answer = 0;
        dfs("",0);
        
        for(int i=0; i<dictList.size(); i++){
            if(dictList.get(i).equals(word)){
                answer = i;
            }
        }
            
        return answer;
    }
    
    public static void dfs(String str, int len){
        dictList.add(str);
        if(len==5) return;
        
        for(int i=0; i<vowels.length; i++) {
            dfs(str+vowels[i], len+1);
        }
    }
}