import java.util.Scanner;
import java.lang.Math;

public class Cylinder {
	final double PI = 3.14;
	double area, vol;
	int r,h;
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		Cylinder cy = new Cylinder();
		for(int i=0;i<5;i++) {
			cy.ShowResult();
			cy.Init();
		}
	}
	public Cylinder() {
		Init();
		System.out.println("20233102 김태수");
	}
	void Init() {
		this.r = (int) (Math.random()*20);
		this.h = (int) (Math.random()*20);
		this.area = Area();
		this.vol = Volume();
	}
	double Area() {
		double ar = r*r*PI*2 + 2*PI*r*h;
		return ar;
	}
	double Volume() {
		double vol = r*r*PI*h;
		return vol;
	}
	void ShowResult() {
		System.out.println("반지름:"+r+"/높이:"+h+"/겉넓이:"+area+"/부피:"+vol);
	}

}
