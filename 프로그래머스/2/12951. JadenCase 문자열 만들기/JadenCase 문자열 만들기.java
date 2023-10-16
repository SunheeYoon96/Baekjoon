import java.util.*;
import java.io.*;

class Solution {
    
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;
    
    public String solution(String s) {
        String answer = "";
        
        s = s.toLowerCase();
        
        tokens = new StringTokenizer(s," ", true);
        
        while(tokens.hasMoreTokens()){
            String str = tokens.nextToken();
            
            if(str.equals(" ")){
                output.append(str);
            }else{
                str = str.substring(0, 1).toUpperCase() + str.substring(1);
                output.append(str);
            }
            
        }
        
        return output.toString();
    }
}