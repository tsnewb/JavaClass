package packShape;

public class HandleShape {

	public static void main(String[] args) {
		Shape ob1 = new Shape();
		ob1.show();
//		Shape ob2 = new Shape();
//		ob2.show();
		Square ob3 = new Square(7);
		ob3.show();
		Rectangle ob4 = new Rectangle(5, 10);
		ob4.show();
		Circle ob5 = new Circle(12);
		ob5.show();
		Oval ob6 = new Oval(6, 9);
		ob6.show();
		// Object arr[] >> show 메서드 사용이 불가하다
		Shape arr[] = new Shape[5];
		arr[0] = ob1;
		arr[1] = ob3;
		arr[2] = ob4;
		arr[3] = ob5;
		arr[4] = ob6;
		for (Shape x : arr) {
			System.out.println("+++" + x.whoAmI());
		}
		for (Shape x : arr) {
			x.show();
		}
		int i=0;
		for (Shape x : arr) {
			System.out.print((i++)+"번 : ");
			if (x instanceof Circle) {
				((Circle) x).defineCircle();
				//캐스트 연산자보다 .의 연산자 우선순위가 높다
			}
			else if(x instanceof Square) {
				((Square)x).defineSquare();
			}
			else {
				System.out.println("Can not change");
			}
		}

	}

}
