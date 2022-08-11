package member;

public class DiamondMember extends Member{
	double saleRat; // 할인율
	
	public DiamondMember() {
		memberGrade = "Diamond"; //고객 등급 다이아
		member_saleRat = 0.1; //다이아 할인율
	}
	
	public int calPrice(int price) {
		return price-(int)(price*member_saleRat);
	}
	
	public String showDmemberInfo() {
		return memberName + " 님의 등급은 " + memberGrade + "이며, 할인율은 " + member_saleRat + "입니다.";
	}
}
