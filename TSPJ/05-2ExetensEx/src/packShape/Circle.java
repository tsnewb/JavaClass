package packShape;

class Circle extends Shape{
	int radius;
	Circle (int radius){
		this.radius = radius;
		this.name = "원";
	}
	double areaCalc() {
		return radius*radius*Math.PI;
	}
	void show() {
		super.show();
		System.out.printf("면적=%.4f\n",areaCalc());
		System.out.println("반지름="+radius);
	}
}
class Oval extends Circle{
	int radiusLong;
	Oval(int radius, int radiuslong){
		super(radius);
		this.radiusLong = radiuslong;
		this.name = "타원";
	}
	double areaCalc() {
		return Math.PI*radius*radiusLong;
	}
	void show() {
		super.show(); 
		//부모의 show의 areaCalc가 실 객체의 메소드를 우선한다
		System.out.println("긴 반지름="+radiusLong);

	}
}