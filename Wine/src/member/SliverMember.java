package member;

public class SliverMember extends Member{
	private String SliverMember;
	private String SliverGrade;
	private double SliverSaleRat; // 할인율
	
	public SliverMember(String SliverMember,String SliverGrade ,double SliverSaleRat) {
		this.SliverMember = SliverMember;
		this.SliverGrade = SliverGrade;
		this.SliverSaleRat = SliverSaleRat;
		
		memberGrade = "Sliver"; //고객 등급 골드
		member_saleRat = 0.01; //골드 3% 할인
	}
	
	public int calPrice(int price) {
		return price-(int)(price*member_saleRat);
	}
	
	public String showGmemberInfo() {
		return memberName + " 님의 등급은 " + memberGrade + "이며, 할인율은 " + member_saleRat + "입니다.";
	}

	public String getSliverMember() {
		return SliverMember;
	}

	public void setSliverMember(String sliverMember) {
		SliverMember = sliverMember;
	}

	public String getSliverGrade() {
		return SliverGrade;
	}

	public void setSliverGrade(String sliverGrade) {
		SliverGrade = sliverGrade;
	}

	public double getSliverSaleRat() {
		return SliverSaleRat;
	}

	public void setSliverSaleRat(double sliverSaleRat) {
		SliverSaleRat = sliverSaleRat;
	}

	
	
}
