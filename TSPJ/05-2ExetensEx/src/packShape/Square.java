package packShape;


class Square extends Shape{
	int length;
	//String name; 부모 클래스의 멤버와 중복
	Square(int length){
		//super(); 생략가능, 기본 생성자 포함되어 있다
		this.length = length;
		name = "정사각형";
	}
	int areaCalc() {
		return length*length;
	}
	void show(){
		super.show();
		System.out.println("면적="+areaCalc());
		System.out.println("너비="+length);
	}
	void defineSquare() {
		System.out.println("너비 "+length+"의 사각형");
	}
}

class Rectangle extends Square{
	int height;
	Rectangle(int leng,int h){
		super(leng);
		name = "직사각형";
		//length = leng;
		height = h;
	}
	int areaCalc() {
		return length*height;
	}
	void show() {
		super.show();
//		System.out.println("면적="+areaCalc());
//		System.out.println("너비="+length);
		System.out.println("높이="+height);
	}
}