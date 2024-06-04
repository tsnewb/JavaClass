package packMain;

import java.util.Random;

class Point{
	int x,y;
	
	Point(int a,int b){
		x=a; y=b;
	}
	@Override
	public String toString() {
		return "("+x+","+y+")";
	}
	@Override
	public boolean equals(Object obj) {
		if(x==((Point)obj).x&&y==((Point)obj).y)
			return true;
		else
			return false;
	}
}

public class Main {

	public static void main(String[] args) {
		Point p = new Point(7, 2);
		Point q = new Point(7, 2);
		System.out.println(p); 
		//"출력문"에 객체 변수를 부르면 자동으로 toString이 호출된다
		System.out.println(p.toString());
		int x = p.hashCode();
		System.out.println(x);
		Object t = p;
		System.out.println(t.hashCode());
		System.out.println(p.getClass().getName());
		System.out.println(t.getClass().getName());
		//class Class //Class 의 getname매서드
		if(p==q) System.out.println("same");
		//equals 매서드를 오버라이딩해서 두 래퍼런스가 가리키틑 실 객체는 다르지만 same2가 출력된다
		if(p.equals(q))System.out.println("same2");
		
		//String s;
		//s.split(s);
		//s.split(s, x);
		
		int i = Integer.MAX_VALUE;
		
		Random r = new Random();
		r.nextInt(0, i);
		System.out.println(r);
	}
	//String의 hashcode()매서드는 오버라이딩되어 문자열의 변환 결과다
	//스트링의 객체는 수정 불가능하고 객체가 새로 생성되며 수정된다.
	//따라서 문자열 연산이 많을수록 가비지가 많이 생성된다
	//가변 버퍼를 가지고 있어 문자열 변경 가능한 StringBuffer 클래스 이용
	
	//String.format("k=%d, x=%.2f", k,x)
	//형식에 맞게 변환한 스트링을 반환한다
}
