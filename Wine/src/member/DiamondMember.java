package member;

public class DiamondMember extends Member{
	
	private String DiaMember;
	private String DiaGrade;
	private double DiaSaleRat; // 할인율
	
	public DiamondMember(String DiaMember, String DiaGrade, double DiaSaleRat) {
		this.DiaMember = DiaMember;
		this.DiaGrade = DiaGrade;
		this.DiaSaleRat = DiaSaleRat;
		
		memberGrade = "Diamond"; //고객 등급 다이아
		member_saleRat = 0.05; //다이아 5% 할인율
	}
	
	public int calPrice(int price) {
		return price-(int)(price*member_saleRat);
	}
	
	public String showDmemberInfo() {
		return memberName + " 님의 등급은 " + memberGrade + "이며, 할인율은 " + member_saleRat + "입니다.";
	}

	public String getDiaMember() {
		return DiaMember;
	}

	public void setDiaMember(String diaMember) {
		DiaMember = diaMember;
	}

	public String getDiaGrade() {
		return DiaGrade;
	}

	public void setDiaGrade(String diaGrade) {
		DiaGrade = diaGrade;
	}

	public double getDiaSaleRat() {
		return DiaSaleRat;
	}

	public void setDiaSaleRat(double diaSaleRat) {
		DiaSaleRat = diaSaleRat;
	}
	
	
}
