import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    static String originStr;
    static List<String> answers;

    public static void main(String[] args) throws IOException {
        originStr = input.readLine();
        answers = new ArrayList();

        for (int i = 0; i < originStr.length(); i++) {
             String str = originStr.substring(i,originStr.length());
             answers.add(str);
        }

        Collections.sort(answers);

        for(String value : answers){
            output.append(value).append("\n");
        }

        System.out.println(output);

    }
}