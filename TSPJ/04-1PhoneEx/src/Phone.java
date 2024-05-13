import java.util.Scanner;

public class Phone {
	String name;
	String tel;
	int age;

	//생성자를 작성 하지 않으면 공백의 생성자가 디폴트로 컴파일 된다
	// 생성자의 선언은 "클래스이름 ()"
	public Phone(String name, String tel, int age) {
		this.name = name;
		this.tel = tel;
		this.age = age;
	}

	public Phone(String name, String tel) {
		this(name, tel, 0);
	}

	public Phone(String name, int age) {
		this(name, "입력필요", age);
	}
	public Phone(String name) {
		this(name, "입력필요", 0);
	}
	public Phone(int age) {
		this("입력필요", "입력필요", age);
	}
	public Phone() {
		this("입력필요", "입력필요", 0);
	}

	void showPhone() {
		System.out.println("============");
		System.out.println("name : " + name);
		System.out.println("tel : " + tel);
		System.out.println("age : " + age);
	}

	void getTel() {
		System.out.println("#tel : " + tel);
	}

	//메인의 위치는 아무 class 안이나 가능
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Phone m1 = new Phone("테스트", "01000000000");
		m1.showPhone();
		Phone m2, m3;
		m2 = infoIn(sc);
		m3 = infoIn(sc);
		m2.showPhone();
		m3.showPhone();
		m1.getTel();

	}
	// class 이름의 리턴 == 해당 클래스의 객체 레퍼런스를 반환 하겠다.
	public static Phone infoIn(Scanner sc) {
		System.out.print("이름 입력: ");
		String nameIn= sc.nextLine();
		System.out.print("전화 입력(숫자만 입력): ");
		String telIn= sc.nextLine();
		System.out.print("나이 입력(숫자만 입력): ");
		String agestr = sc.nextLine();
		int ageIn;
		//if(telIn.equals(null)) System.out.println("공백 일치 확인");
		if(!agestr.equals(null)&& agestr.matches("[0-9.]+"))
			ageIn = Integer.parseInt(agestr);
		else
			ageIn = 0;
		Phone tmp;
		if(telIn.equals("") || agestr.equals("")) {
			if(!telIn.equals("")) { //나이 입력이 공백				
				tmp = new Phone(nameIn, telIn);
			}
			else if(!agestr.equals("")) { //전화 입력이 공백
				tmp = new Phone(nameIn, ageIn);
			}
			else { // 나이, 전화 둘 다 공백
				tmp = new Phone(nameIn); 
			}
			
		}
		else
			tmp = new Phone(nameIn, telIn, ageIn);
		//sc.nextLine();
		return tmp;
	}

}
