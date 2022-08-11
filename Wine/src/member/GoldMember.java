package member;

public class GoldMember extends Member{
	double saleRat; // 할인율
	
	public GoldMember() {
		memberGrade = "Gold"; //고객 등급 골드
		member_saleRat = 0.03; //골드 3% 할인
	}
	
	public int calPrice(int price) {
		return price-(int)(price*member_saleRat);
	}
	
	public String showGmemberInfo() {
		return memberName + " 님의 등급은 " + memberGrade + "이며, 할인율은 " + member_saleRat + "입니다.";
	}
}
