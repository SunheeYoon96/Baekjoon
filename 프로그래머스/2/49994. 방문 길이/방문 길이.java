import java.util.*;
import java.io.*;

class Solution {
    
    static boolean map[][][];
    static int deltas[][] = {{-1,0},{1,0},{0,1},{0,-1}};
    
    public int solution(String dirs) throws IOException {
        int answer = 0;
        
        map = new boolean[11][11][4];
        int r = 5;
        int c = 5;
        
        for(int i=0; i<dirs.length(); i++){
            char dir = dirs.charAt(i);
            int nr = r;
            int nc = c;
            
            if(dir=='U'){
                nr = r + deltas[0][0];
                nc = c + deltas[0][1];
                
                if(!isIn(nr,nc)) continue;
                
                if(!map[nr][nc][0]){
                    map[nr][nc][0] = true;
                    map[r][c][1] = true; //왕복으로 체크
                    answer++;
                }
            }else if(dir=='D') { 
                nr = r + deltas[1][0];
                nc = c + deltas[1][1];
                
                if(!isIn(nr,nc)) continue;
                if(!map[nr][nc][1]){
                    map[nr][nc][1] = true;
                    map[r][c][0] = true; //왕복으로 체크
                    answer++;
                }
            
            }else if(dir=='R') {
                nr = r + deltas[2][0];
                nc = c + deltas[2][1];
                
                if(!isIn(nr,nc)) continue;
                if(!map[nr][nc][2]){
                    map[nr][nc][2] = true;
                    map[r][c][3] = true; //왕복으로 체크
                    answer++;
                }
                
            }else if(dir=='L') {
                nr = r + deltas[3][0];
                nc = c + deltas[3][1];
                
                if(!isIn(nr,nc)) continue;
                if(!map[nr][nc][3]){
                    map[nr][nc][3] = true;
                    map[r][c][2] = true; //왕복으로 체크
                    answer++;
                }
                
            }
            
            r = nr;
            c = nc;
        }
        
        return answer;
    }
    
    public static boolean isIn(int nr, int nc) {
        if(nr<0 || nr>=11 || nc<0 || nc>=11) return false;
        return true;
    }
}