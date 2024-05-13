package packInterface;
import packShape.*;

class AbstractInterfaceTest {
    public static void main(String[] args) {
    	//생성자의 접근 지정자 고려하기
          Shape ob1 = new Rectangle(4.0, 6.5);
          Shape ob2 = new Triangle(5.5, 7.0);
          ob1.show();
          ob2.show();
          // ob2의 길이를 100으로 바꾼 후 
          //Shape 에서 triangle로 다운캐스팅 한다
          Triangle t = (Triangle)ob2;
          t.putLength(100);
          ob2.show( );
     }
}
