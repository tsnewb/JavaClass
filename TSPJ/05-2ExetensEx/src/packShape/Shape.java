package packShape;

class Shape {
	static int serialNo; // static >> 0으로 초기화
	String name;
	private int NO;
	
	Shape(){
		serialNo++;
		NO=serialNo;
		name = "도형";
	}
	void show() {
		System.out.println("==============");
		System.out.println(name+"#"+NO);
	}
	String whoAmI() {
		return name;
	}
}

