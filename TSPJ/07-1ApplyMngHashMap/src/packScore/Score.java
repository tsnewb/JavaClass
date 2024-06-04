package packScore;

import java.util.StringTokenizer;

public class Score implements InterScore {
	private String No; //응시번호
	private int sc[];
	public Score(String No){
		this.No = No;
		sc = new int[many];
	}
	public Score(String No,int size) {
		this.No = No;
		sc = new int[size];
	}
	@Override
	public String getNo() {
		return No;
	}
	@Override
	public boolean putScore(String txt) {
		StringTokenizer st = new StringTokenizer(txt, ",");
		for(int i =0;i<sc.length;i++) {
			if(!st.hasMoreTokens()) {
				System.out.println("점수입력오류");
				return false;
			}
			sc[i]=Integer.valueOf(st.nextToken().trim());
			//or Integer.parseInt() 
		}
		return true;
	}
	@Override
	public double getAvg() {
		double sum=0;
		for(int i =0;i<sc.length;i++) {
			sum+=sc[i];
		}
		//소수점 둘째자리까지 반올림
		//return Math.round(sum/sc.length*100)/100;
		return Double.parseDouble(String.format("%.2f", sum/sc.length));
	}
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer(No);
		for(int i =0;i<sc.length;i++) {
			sb.append(" "+sc[i]);
		}
		sb.append(" 평균 = "+getAvg());
		return sb.toString();
	}
}
