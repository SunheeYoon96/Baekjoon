import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;

    public static void main(String[] args) throws IOException {
        HashMap hashMap = new HashMap<String, Integer>();
        int totalCnt = 0;

        while (true){
            String str = input.readLine();
            if(str==null || str.length()==0){
                break;
            }
            hashMap.put(str, (int)hashMap.getOrDefault(str, 0)+1);
            totalCnt++;
        }

        List<String> treeList = new ArrayList<>(hashMap.keySet());
        Collections.sort(treeList);

        for(String s : treeList){
            int treeCnt = (int) hashMap.get(s);
            double d = (double) treeCnt*100.0/totalCnt;

            output.append(s)
                    .append(" ")
                    .append(String.format("%.4f",d))
                    .append("\n");
        }

        System.out.println(output);






    }
}