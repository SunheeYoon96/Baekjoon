import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    static int N;
    static PriorityQueue<SerialNum> serials;

    static class SerialNum implements Comparable<SerialNum> {
        String originSerial;
        int len;

        public SerialNum(String originSerial, int len) {
            this.originSerial = originSerial;
            this.len = len;
        }

        public int add () {
            return originSerial.chars()
                    .filter(Character::isDigit)
                    .map(c -> c-'0')
                    .sum();
        }

        @Override
        public int compareTo(SerialNum o) {
            if (this.len != o.len) {
                return this.len - o.len;
            }
            if (this.add() != o.add()) {
                return this.add() - o.add();
            }
            return this.originSerial.compareTo(o.originSerial);
        }
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(input.readLine());
        serials = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            String serialNum =  input.readLine();
            serials.add(new SerialNum(serialNum, serialNum.length()));
        }

        while (!serials.isEmpty()) {
            output.append(serials.poll().originSerial).append("\n");
        }

        System.out.println(output);




    }
}
