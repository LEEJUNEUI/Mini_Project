package member;

public class GoldMember extends Member{
	double saleRat; // 할인율
	
	public GoldMember() {
		memberGrade = "Gold"; //고객 등급 골드
		memeber_bonusRat = 0.05; //골드 포인트 적립비율
	}
	
	public int calPrice(int price) {
		bonusPoint += price * memeber_bonusRat; //포인트 계산
		return bonusPoint;
	}
	
	public String showGmemberInfo() {
		return memberName + " 님의 등급은 " + memberGrade + "이며, 보너스 포인트는 " + bonusPoint + "입니다.";
	}
}
