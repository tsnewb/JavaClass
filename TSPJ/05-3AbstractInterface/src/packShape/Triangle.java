package packShape;

import packInterface.InterShape;

public class Triangle extends Rectangle implements InterShape{
	public Triangle(double leng,double heit){
	//다른 패키지에서 생성 할려면 public 이어야 한다
		super(leng,heit);
		name = "삼각형";
//		this.length = leng;
//		this.height = heit;
	}
	double areaCalc() {
		return height*length*(0.5);
		//return super.areaCalc*(0.5);
	}
	//인터페이스는 기본 public이 생략되어 있다
	//따라서 오버라이딩 할 떄 public 이어야 한다
	public double getLength() {
		return length;
	}
	public double getHeight() {
		return height;
	}
	public void putLength(double x) {
		this.length = x>0?x:(-x);
	}
	public void putHeight(double x) {
		this.height = x>0?x:(-x);
	}
}
