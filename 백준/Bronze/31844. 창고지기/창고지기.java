import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    static String storage;
    static int ans;

    public static void main(String[] args) throws IOException {
        storage = input.readLine();
        ans = -1;

        int robotIdx=0, boxIdx=0, targetIdx=0;

        for (int i = 0; i < storage.length(); i++) {
            char c = storage.charAt(i);
            if(c=='@') robotIdx = i;
            else if (c=='#') boxIdx = i;
            else if(c=='!') targetIdx = i;
        }

        if((boxIdx>targetIdx && boxIdx<robotIdx) || (boxIdx>robotIdx && boxIdx<targetIdx)){
            ans = Math.abs(targetIdx-robotIdx)-1;
            System.out.println(ans);
        }else{
            System.out.println(ans);
        }

    }
}