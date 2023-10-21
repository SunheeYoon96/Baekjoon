import java.util.*;
import java.io.*;

class Solution {
    
    static int answer;
    static int dp[][];
    
    int solution(int[][] land) throws IOException {
        answer = 0;

        dp = new int[land.length][4];
        
        for(int i=0; i<4; i++) {
            dp[0][i] = land[0][i];
        }
        
        for(int i=1; i<land.length; i++){
            for(int j=0; j<4; j++){
                if(j==0){
                    dp[i][0] = Math.max(dp[i][0], land[i][0] + dp[i-1][1]);
                    dp[i][0] = Math.max(dp[i][0], land[i][0] + dp[i-1][2]);
                    dp[i][0] = Math.max(dp[i][0], land[i][0] + dp[i-1][3]);
                }else if(j==1) {
                    dp[i][1] = Math.max(dp[i][1], land[i][1] + dp[i-1][0]);
                    dp[i][1] = Math.max(dp[i][1], land[i][1] + dp[i-1][2]);
                    dp[i][1] = Math.max(dp[i][1], land[i][1] + dp[i-1][3]);
                }else if(j==2) {
                    dp[i][2] = Math.max(dp[i][2], land[i][2] + dp[i-1][1]);
                    dp[i][2] = Math.max(dp[i][2], land[i][2] + dp[i-1][0]);
                    dp[i][2] = Math.max(dp[i][2], land[i][2] + dp[i-1][3]);
                }else if(j==3) {
                    dp[i][3] = Math.max(dp[i][3], land[i][3] + dp[i-1][1]);
                    dp[i][3] = Math.max(dp[i][3], land[i][3] + dp[i-1][2]);
                    dp[i][3] = Math.max(dp[i][3], land[i][3] + dp[i-1][0]);
                }
            }
        }
        
        for(int i=0; i<4; i++) {
            answer = Math.max(answer, dp[land.length-1][i]);
        }

        return answer;
    }
}