package member;

public class Member {
	
	protected String memberId; // 회원ID
	protected String memberPw; // 회원 비밀번호
	protected String memberName; // 회원 이름
	protected String memberTel; // 회원 전화번호
	protected String memberGrade; // 회원 등급
	protected double bonusRat; // 적립비율
	protected String role; //권한 1 : 관리자, 0 : 사용자
	int bonusPoint; // 보너스포인트
	int price; 
	
	public Member(String memberName) {
		this.memberName = memberName;
		memberGrade = "SILVER"; //기본 등급
		bonusRat = 0.01; // 포인트 1%적립
	}
	
	

	public Member() {
	}



	public int calPrice(int price) {
		bonusPoint += price * bonusRat;
		this.price = price;
		return price;
	}
	
	public void showMemberInfo() {
		System.out.println(memberName + " 님의 등급은 " + memberGrade + "이며, 보너스 포인트는 " + bonusPoint + "입니다.");
	}
	
	public void showStatement() {
		System.out.println(memberName + " 님의 등급은 " + memberGrade + "이며, 지불해야 하는 금액은 " + price + "입니다.");
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberTel() {
		return memberTel;
	}

	public void setMemberTel(String memberTel) {
		this.memberTel = memberTel;
	}

	public String getMemberGrade() {
		return memberGrade;
	}

	public void setMemberGrade(String memberGrade) {
		this.memberGrade = memberGrade;
	}

	public double getBonusRat() {
		return bonusRat;
	}

	public void setBonusRat(double bonusRat) {
		this.bonusRat = bonusRat;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getBonusPoint() {
		return bonusPoint;
	}

	public void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	

	
}
