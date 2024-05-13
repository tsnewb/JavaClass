
public class CircleArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final double PI=3.14;
		double radius = 10.2;
		double area = PI*radius*radius;
		
		System.out.print("반지름"+radius+",");
		System.out.println("원의 면적 = "+area);
		System.out.printf("원의 면적 = %.5f \n", area);
		
		//int a=3.3;
		// 자바는 데이터 손일이 생기면 오류가 발생
		int a=(int)3.3; //소수 > 정수 변환 = 소수점 삭제
		float b=(float)3.14;
		// 강제 형 변환 casting
		System.out.println(a+","+b);
		
		System.out.println((char)0x12340041);
		//16진수 2자리에 1바이트 >> 2바이트 = 4자리 0x0041 만 대입
		
		
	}

}
