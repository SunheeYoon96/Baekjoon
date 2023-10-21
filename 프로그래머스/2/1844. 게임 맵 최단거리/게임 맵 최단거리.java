import java.util.*;
import java.io.*;

class Solution {
    
    static int answer, R, C;
    static int deltas[][] = {{1,0},{0,-1},{0,1},{-1,0}};
    static boolean visited[][];
    static Queue<Loc> que;
    
    static class Loc {
        int r, c, dist;
        
        public Loc(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
    
    public int solution(int[][] maps) throws IOException {
        answer = -1;
        //난(0,0) 상대는 (n,m)
        
        R = maps.length;
        C = maps[0].length;
        visited = new boolean[R][C];
        
        answer = bfs(maps);
        
        return answer;
    }
    
    public static int bfs(int [][] maps) {
        que = new ArrayDeque<Loc>();
        que.offer(new Loc(0,0,1));
        visited[0][0] = true;
        
        while(!que.isEmpty()){
            Loc now = que.poll();
            
            if((now.r==R-1) && (now.c==C-1)) return now.dist;
            
            for(int d=0; d<deltas.length; d++){
                int nr = now.r + deltas[d][0];
                int nc = now.c + deltas[d][1];
                
                if(isIn(nr, nc)){
                    if(maps[nr][nc]==1 && !visited[nr][nc]){
                        que.add(new Loc(nr, nc, now.dist+1));
                        visited[nr][nc] = true;
                    }
                }
                
            }
        }
        return answer;
        
    }
    
    public static boolean isIn(int nr, int nc){
        if(nr<0 || nr>=R || nc<0 || nc>=C) return false;
        return true;
    }
}