package packShape;

public abstract class Shape{

	static int serialNo=0;
	protected String name;
	private int NO;
	protected double length;
	protected double height;
	
	Shape(){
		serialNo++;
		NO=serialNo;
		name = "도형";
	
	}
	int whatNO()
	{
		return NO;
	}
	
	abstract String whoAmI();
	abstract double areaCalc();
	abstract public void show();
}
