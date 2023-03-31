import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;
    
    static int sudoku[][];
    static boolean row[][], col[][], square[][];

    public static void main(String[] args) throws IOException {
    	//input = new BufferedReader(new StringReader(instr));
        sudoku = new int[9][9];
        row = new boolean[9][10];
        col = new boolean[9][10];
        square = new boolean[9][10];
        
        for (int i = 0; i < 9; i++) {
            String line = input.readLine();
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = line.charAt(j)-'0';
                //i행에 숫자가 있으면 방문처리해둠
                row[i][sudoku[i][j]]=true;
                //i열에 숫자가 있으면 방문처리해둠
                col[j][sudoku[i][j]] = true;
                //3x3격자안에 숫자 있으면 방문처리함
                square[3*(i/3)+(j/3)][sudoku[i][j]] = true; //3x3 미니격자판 위에서부터 012345678
            }
        }
        
        playSudoku(0);
    }
    
    
    private static void playSudoku(int i) {
        
        if(i==81) {
            makeOutput();
            return; //여기서 바로 끝냈는데도 시간초과 왜나느ㅏㅣㅁㄴ얾ㄴ아레[ㅂㅈㅁㅇ덴ㄴ
        }

        //1~81까지의 인덱스로 좌표 만들기 
        int r = i/9; 
        int c = i%9;
        
        //이미 숫자가 들어있으면 그 다음 수로 탐색
        if(sudoku[r][c]!=0) {
            playSudoku(i+1);
        }else {
            for (int j = 1; j < 10; j++) {
                //가로, 세로, 미니격자 중 하나라도 이미 있는 숫자면 탐색X
                if(row[r][j] || col[c][j] || square[3*(r/3)+(c/3)][j]) continue;
                
                //백트레킹
                row[r][j]=true;
                col[c][j]=true;
                square[3*(r/3)+(c/3)][j]=true;
                sudoku[r][c]=j;
                playSudoku(i+1);
                row[r][j]=false;
                col[c][j]=false;
                square[3*(r/3)+(c/3)][j]=false;
                sudoku[r][c]=0;
            }
        }
        //return;
        
    }

    //출력물 만들기
    private static void makeOutput() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                output.append(sudoku[i][j]).append("");
            }
            output.append("\n");
        }
        System.out.println(output);
        System.exit(0);
    }




    private static String instr = "103000509\r\n" + 
            "002109400\r\n" + 
            "000704000\r\n" + 
            "300502006\r\n" + 
            "060000050\r\n" + 
            "700803004\r\n" + 
            "000401000\r\n" + 
            "009205800\r\n" + 
            "804000107";

}