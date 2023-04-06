import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution {
     
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;
     
    static int T, N, R;
    static final int mod = 1234567891;
    static long factorial[], answer;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        T = Integer.parseInt(input.readLine());
         
        for (int t = 1; t <= T; t++) {
             
            output.append("#").append(t).append(" ");
             
            tokens = new StringTokenizer(input.readLine());
            N = Integer.parseInt(tokens.nextToken());
            R = Integer.parseInt(tokens.nextToken());
             
            factorial = new long[N+1];
             
            answer = nCr(N, R, mod );
             
            output.append(answer).append("\n");
             
        }
         
        System.out.println(output);
         
    }
 
    private static long nCr(long n, long r, int mod) {
        if(r==0) return 1L;
         
        factorial[0] = 1;
         
        for (int i = 1  ; i <=N; i++) {
            factorial[i] = factorial[i-1] *i % mod;
        }
         
        long ans = factorial[N] * pow(factorial[N-R], mod-2, mod)%mod * pow(factorial[R], mod-2, mod)%mod ;
         
        return ans;
    }
     
    private static long pow(long base, int exp, int mod) {
        if(exp==1) return base;
        if(exp==0) return 1;
         
        long res = pow(base, exp/2, mod);
        res = (res*res)%mod;
         
        if(exp%2==1) {
            res = (res*base)%mod;
        }
         
        return res;
    }
 
}