import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;

    static int N;
    static Student[] students;

    static class Student implements Comparable<Student>{
        String name;
        int kor, eng, math;

        public Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }


        @Override
        public int compareTo(Student o) {
            if(this.kor == o.kor){
               if(this.eng == o.eng){
                   if(this.math == o.math) {
                       return this.name.compareTo(o.name);
                   }else{
                       return o.math - this.math;
                   }
               }else{
                   return this.eng - o.eng;
               }
            }
            return o.kor - this.kor;
        }
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(input.readLine());

        students = new Student[N];

        for (int i = 0; i < N; i++) {
            tokens = new StringTokenizer(input.readLine());
            String name = tokens.nextToken();
            int kor = Integer.parseInt(tokens.nextToken());
            int eng = Integer.parseInt(tokens.nextToken());
            int math = Integer.parseInt(tokens.nextToken());
            students[i] = new Student(name, kor, eng, math);
        }

        Arrays.sort(students);

        for (Student s : students) {
            String name = s.name;
            output.append(name).append("\n");
        }

        System.out.println(output);


    }
}
