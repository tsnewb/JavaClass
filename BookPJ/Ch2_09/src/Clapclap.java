import java.util.Scanner;

public class Clapclap {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		do {
		System.out.print("1~99 사이의 정수를 입력하세요 : ");
		num = sc.nextInt();
		}while (num>99 || num < 1);
		int fst = num>9 ? num/10%3 : -1; 
		int sec = num%10%3;
		if(fst == 0 || sec == 0) {
			if(fst+sec == 0)
				System.out.println("박수짝짝!!");
			else
				System.out.println("박수짝!");
		}
		else 
			System.out.println("박수없음ㅠㅠ");
		sc.close();
	}

}
