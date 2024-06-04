import java.util.Scanner;

public class Clapclap2 {

	public static void main(String[] args) {
		//Scanner sc = new Scanner(System.in);
		int fst,sec;
		for(int i = 1;i<100;i++) {
			fst = i/10 != 0 ? i/10%3 : -1;
			sec = i%10 != 0 ? i%10%3 : -1;
			if(fst == 0 || sec == 0) {
				if(fst !=0 || sec != 0) {
					System.out.println(i+" 박수한번!");
				}
				else
					System.out.println(i+" 박수두번!!");
			}
		}
	}

}
