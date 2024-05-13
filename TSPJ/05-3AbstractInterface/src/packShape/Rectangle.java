package packShape;

public class Rectangle extends Shape {
	
	public Rectangle(double length,double height){
	//다른 패키지에서 생성 할려면 public 이어야 한다
		name = "직사각형";
		this.height = height;
		this.length = length;
		
	}
	String whoAmI() {
		return name+"#"+length+"x"+height;
	}
	double areaCalc() {
		return height*length;
	}
	public void show() {
		System.out.println("==============");
		System.out.print("#"+whatNO()+" "+whoAmI());
		System.out.printf(" 면적: %.3f\n",areaCalc());
	}

	
}
