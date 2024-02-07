import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static Map<String, Integer> bookMap;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(input.readLine());
        bookMap = new HashMap<>();
        int max = 1;

        for (int i = 0; i < N; i++) {
            String bookName = input.readLine();
            if(bookMap.containsKey(bookName)){
                int cnt = bookMap.get(bookName)+1;
                bookMap.put(bookName, cnt);
                max = Math.max(max, cnt);
            }else{
                bookMap.put(bookName, 1);
            }
        }

        ArrayList<String> list = new ArrayList<>(bookMap.keySet());
        ArrayList<String> answerList = new ArrayList<>();

        for(String str : list){
            if(bookMap.get(str)==max){
                answerList.add(str);
            }
        }

        Collections.sort(answerList);

        System.out.println(answerList.get(0));

    }
}