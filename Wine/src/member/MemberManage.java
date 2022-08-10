package member;

import common.DAO;

public class MemberManage extends DAO {

	// 싱글톤
	private static MemberManage mm = new MemberManage();

	private MemberManage() {

	}

	public static MemberManage getInstance() {
		return mm;
	}

	// 로그인 메소드
	public Member loginInfo(String id) {
		Member member = null;
		try {
			conn();
			String sql = "select * from winemember where member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setMemberPw(rs.getString("member_pw"));
				member.setMemberName(rs.getString("member_name"));
				member.setMemberTel(rs.getString("member_tel"));
				member.setMemberGrade(rs.getString("member_grade"));
				member.setBonusRat(rs.getDouble("bonus_Rat"));
				member.setRole(rs.getString("role"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return member;
	}
	
	// 회원 등록 메소드
	public int registCustomer(Member member) {
		int result = 0;
		try {
			conn();
			String sql = "insert into winemember (member_id,member_pw, member_name, member_tel,member_grade, role) values (?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getMemberTel());
			pstmt.setString(5, member.getMemberGrade());
			pstmt.setString(5, member.getRole());
			
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return result;
	}
	
	// 회원 조회
	public Member getList(String memberName) {
		Member member = null;
		try {
			conn();
			String sql = "SELECT * from winemember Where member_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberName);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) 
			member = new Member();
			member.setMemberId(rs.getString("member_id"));
			member.setMemberPw(rs.getString("member_pw"));
			member.setMemberName(rs.getString("member_name"));
			member.setMemberTel(rs.getString("member_tel"));
			member.setMemberGrade(rs.getString("member_grade"));
			member.setBonusRat(rs.getDouble("bonus_Rat"));
			member.setRole(rs.getString("role"));
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return member;
	}
	
	// 회원 등급 변경
		public int updateGrade(String memberGrade) {
			int result = 0;
			try {
				conn();
				String sql = "UPDATE wine set memeber_grade = ? where member_id = ? ";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, memberGrade);
				
				result = pstmt.executeUpdate();
				
			}catch (Exception e){
				e.printStackTrace();
			}finally {
				disconnect();
			}
			return result;
		}
	// 회원 삭제
		public int deleteMember(String memberName) {
			int result = 0;
			try {
				conn();
				String sql = "delete from wine where member_id = ? ";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, memberName);
				result = pstmt.executeUpdate();
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				disconnect();
			}
			return result;
		}
	

}
