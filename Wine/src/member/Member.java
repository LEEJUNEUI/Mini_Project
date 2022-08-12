package member;

public class Member {

	protected String memberId; // 회원ID
	protected String memberPw; // 회원 비밀번호
	protected String memberName; // 회원 이름
	protected String memberTel; // 회원 전화번호
	protected String memberGrade; // 회원 등급
	protected double member_saleRat; // 할인율
	protected String role; // 권한 1 : 관리자, 0 : 사용자
	protected int price;

	public Member() {
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

	public double getMember_saleRat() {
		return member_saleRat;
	}

	public void setMember_saleRat(double member_saleRat) {
		this.member_saleRat = member_saleRat;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
