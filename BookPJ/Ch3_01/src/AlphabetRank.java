import java.util.Scanner;

public class AlphabetRank {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("알파벳 한 문자를 입력 : ");
		String stra = sc.next();
		char chra = stra.charAt(0);
		for(char i = 'a';i<=chra;i++) {
			for(char e = i;e<=chra;e++) {
				System.out.print(e);
			}
			System.out.println();
		}
	}

}
