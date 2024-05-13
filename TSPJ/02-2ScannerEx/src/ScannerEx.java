import java.util.Scanner;

public class ScannerEx {

	/*
	static Scanner sc = new Scanner(System.in);
	클래스 안에서 어디서든 불러서 쓸 수 있다.
	스캐너는 하나만 생성해서 사용하는게 좋다.
	*/
	public static void main(String[] args) {
		/*
		Scanner sc;
		sc=new Scanner(System.in);
		
		System.out.println("이름, 도시, 나이, 몸무게, 독신여부 입력");
		String name = sc.next();
		String city = sc.next();
		int age = sc.nextInt();
		double weight = sc.nextDouble();
		boolean issingle = sc.nextBoolean();
		System.out.println("이름 :"+name);
		System.out.println("사는곳 :"+city);
		System.out.println("나이 :"+age);
		System.out.println("몸무게 :"+weight+"\n독신여부 :"+issingle);
//		System.out.print("독신여부 :"+issingle);
		
		sc.close();
		*/
		Scanner sc = new Scanner(System.in);
		System.out.print("문자?");
		String c = sc.next();
		System.out.println(c+" "+c.length());
		
		System.out.print("문자?");
		c = sc.next();
		System.out.println(c+" "+c.length());
		
		sc.nextLine(); //버퍼 개행 읽어 비우기
		System.out.print("이름?");
		c = sc.nextLine();
		System.out.println(c+" "+c.length());
		//nextLine 과하게 입력 받거나 개행만 받아온다
		
		System.out.print("성별(M/F)");
		char x = sc.next().charAt(0);
		// 문자 1개 입력 받기
		System.out.println(x);
		
		sc.close();
	}
}
