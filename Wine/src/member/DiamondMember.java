package member;

public class DiamondMember extends Member{
	double saleRat; // 할인율
	
	public DiamondMember() {
		memberGrade = "Diamond"; //고객 등급 다이아
		memeber_bonusRat = 0.10; //다이아 포인트 적립비율
	}
	
	public int calPrice(int price) {
		bonusPoint += price * memeber_bonusRat; //포인트 계산
		return bonusPoint;
	}
	
	public String showDmemberInfo() {
		return memberName + " 님의 등급은 " + memberGrade + "이며, 보너스 포인트는 " + bonusPoint + "입니다.";
	}
}
