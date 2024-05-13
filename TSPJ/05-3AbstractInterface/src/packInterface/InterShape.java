package packInterface;

public interface InterShape {
	
	double getLength();
	double getHeight();
	void putLength(double x);
	void putHeight(double x);
	
	//-----interface 에 그 밖에  가능한 예-----문제와 관련없다.------
	static int key = 16543; //final public 생략
	
	default boolean checkKey(int pk, int ID) {
		return encodeKey(pk) == ID ;
		//필드
	}// 구현했으니 default
	
	private int encodeKey(int k)
	{
		System.out.println( key ^ k );
		return key ^ k;
	}// private도 가능하다
	//---------------------------------------
}
