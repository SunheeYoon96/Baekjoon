import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int H = sc.nextInt();
		int M = sc.nextInt();
		int newH = 0;
		int newM = 0;
		
		if(M>=45) {
			newM = M-45;
			newH = H;
		}else {
			newM = (M+60)-45;
			if(H==0) {
				newH = 23;
			}else {
				newH = H-1;
			}
			
		}
		
		System.out.println(newH + " " + newM);
	

	}

}
