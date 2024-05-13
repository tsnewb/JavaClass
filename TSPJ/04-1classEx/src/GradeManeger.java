import java.util.Scanner;

public class GradeManeger {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String namein;
		int mathin, engin;
		System.out.print("이름 : ");
		namein = sc.nextLine();
		//sc.nextLine();
		System.out.print("수학점수 : ");
		mathin = sc.nextInt();
		System.out.print("영어점수 : ");
		engin = sc.nextInt();
		//데이터를 받고 데이터를 점검 후 객체를 생성
		Grade st1 = new Grade(namein,mathin,engin);
		st1.showGrade();
		
		System.out.print("이름 : ");
		sc.nextLine(); //버퍼 비우기
		namein = sc.nextLine();
		System.out.print("수학점수 : ");
		mathin = sc.nextInt();
		System.out.print("영어점수 : ");
		engin = sc.nextInt();
		Grade st2 = new Grade(namein,mathin,engin);
		st2.showGrade();
		
		Grade st3 =new Grade();
		st3.showGrade();
		
		double avg1=st1.average(),avg2=st2.average();
		if(avg1>avg2)
			System.out.printf("%s %.2f > %s %.2f\n",st1.name,avg1,st2.name,avg2);
		else if(avg1<avg2)
			System.out.printf("%s %.2f < %s %.2f\n",st1.name,avg1,st2.name,avg2);
		else
			System.out.printf("%s %.2f = %s %.2f\n",st1.name,avg1,st2.name,avg2);
		sc.close();
	}

}
class Grade{
	String name;
	int math;
	int eng;
	
	public Grade() {
		/*
		 * name = "입력필요"; math = -99; eng = -99;
		 */
		this("입력필요",-99,-99); 
		//this()는 생성자의 첫줄에 적는다 
	}
	public Grade(String name,int math,int eng) {
		// 매개변수와 멤버 변수의 이름을 같게하고 구분하기 위해
		this.name = name;
		this.math = math;
		this.eng = eng;
	}
	
	double average() {
		return (double)(math+eng)/2;
	}
	void showGrade() {
		System.out.println("==========");
		System.out.println("Name : "+name);
		System.out.println("Math : "+math+", English : "+eng);
		System.out.println("Average : "+average());
		System.out.println("==========");
		
	}
}