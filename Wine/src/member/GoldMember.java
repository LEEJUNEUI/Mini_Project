package member;

public class GoldMember extends Member{
	private String GoldMember;
	private String GoldGrade;
	private double GoldSaleRat; // 할인율
	
	public GoldMember(String GoldMember,String GoldGrade ,double GoldSaleRat) {
		this.GoldMember = GoldMember;
		this.GoldGrade = GoldGrade;
		this.GoldSaleRat = GoldSaleRat;
		
		memberGrade = "Gold"; //고객 등급 골드
		member_saleRat = 0.03; //골드 3% 할인
	}
	
	public int calPrice(int price) {
		return price-(int)(price*member_saleRat);
	}
	
	public String showGmemberInfo() {
		return memberName + " 님의 등급은 " + memberGrade + "이며, 할인율은 " + member_saleRat + "입니다.";
	}

	public String getGoldMember() {
		return GoldMember;
	}

	public void setGoldMember(String goldMember) {
		GoldMember = goldMember;
	}

	public String getGoldGrade() {
		return GoldGrade;
	}

	public void setGoldGrade(String goldGrade) {
		GoldGrade = goldGrade;
	}

	public double getGoldSaleRat() {
		return GoldSaleRat;
	}

	public void setGoldSaleRat(double goldSaleRat) {
		GoldSaleRat = goldSaleRat;
	}
	
	
}
