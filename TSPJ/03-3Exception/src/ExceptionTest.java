import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		while (true) {
//			System.out.print("나뉨수를 입력하시오:");
//			int dividend = sc.nextInt(); // 나뉨수 입력
//			System.out.print("나눗수를 입력하시오:");
//			int divisor = sc.nextInt(); // 나눗수 입력
//			try {
//				System.out.println(dividend + "를 " + divisor + "로 나누면 몫은 " + dividend / divisor + "입니다.");
//				break;
//			} catch (ArithmeticException e) {
//				System.out.println("0으로 나눌 수 없습니다.");
//			}
//		}
//		sc.close();

// =====잘못된 자료형 입력 =================

//		Scanner scanner = new Scanner(System.in);
//		System.out.println("정수 3개를 입력하세요");
//		int sum = 0, n = 0;
//		for (int i = 0; i < 3; i++) {
//			System.out.print(i + ">>");
//			try {
//				n = scanner.nextInt(); // 정수 입력
//			}
//			catch(InputMismatchException e){
//				System.out.println("정수가 아닙니다.");
//				i--;
//				scanner.nextLine();
// 입력 받을떄 오류가 발생하면 입력 스트립에서 나가지 못하고 남아있고
// 다음 입력때 다시 입력 스트림에서 읽으면서 오료가 발생해 
// 계속 입력 스트림에 남아 있으면서 오류를 발생시킨다
// 그래서 입력 스트림을 비워줘야 한다.
//				continue;
//			}
//			sum += n; // 합하기
//		} // for i
//		System.out.println("합은 " + sum);
//		scanner.close();

// ==========변환 오류 예외처리========
		
//		String[] stringNumber = { "23", "12", "3.141592", "ㄲ", "998" };
//		int i = 0;
//		for (i = 0; i < stringNumber.length; i++) {
//			try {


//// 변수가 괄호 안에서 선언되면 괄호 안에서만 활용 가능하다

//				int j = Integer.parseInt(stringNumber[i]);
//				System.out.println("숫자로 변환된 값은 " + j);
//			} catch (NumberFormatException e) {
//				try {
//					double j = Double.parseDouble(stringNumber[i]);
//					System.out.println(stringNumber[i] + "는 정수로 변활할 수 없습니다.");
//					System.out.println("실수로 변환된 값은 " + j);
//				} catch (NumberFormatException e2) {
//					System.out.println("숫자가 아닙니다."+stringNumber[i]);
//				}
//			}
//		} // for
		
// ============변환 오류 실습 ( 중첨 예외 처리 ) =============
		Scanner sc = new Scanner(System.in);
		System.out.print("정수,실수 또는 문자열 입력 : ");
		String input = sc.next();
		try {
			System.out.println("int : "+Integer.parseInt(input));
		}
		catch (NumberFormatException e) {
			try {
				System.out.println("double : "+Double.parseDouble(input));
			}
			catch(NumberFormatException e2) {
				System.out.println("String : "+input);
			}
		}
	}

}
