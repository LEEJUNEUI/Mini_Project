package member;

import java.util.ArrayList;
import java.util.List;

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
				member.setMemeber_bonusRat(rs.getDouble("member_bonusRat"));
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
	public int registMember(Member member) {
		int result = 0;
		try {
			conn();
			String sql = "insert into winemember (member_id,member_pw, member_name, member_tel,member_grade,member_bonusRat, role) values (?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getMemberTel());
			pstmt.setString(5, member.getMemberGrade());
			pstmt.setDouble(6, member.getMemeber_bonusRat());
			pstmt.setString(7, member.getRole());

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}

	// 회원 전체 조회
	public List<Member> getDetailMemberList() {
		List<Member> list = new ArrayList<>();
		Member member = null;
		try {
			conn();
			String sql = "SELECT * from winemember";
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setMemberPw(rs.getString("member_pw"));
				member.setMemberName(rs.getString("member_name"));
				member.setMemberTel(rs.getString("member_tel"));
				member.setMemberGrade(rs.getString("member_grade"));
				member.setMemeber_bonusRat(rs.getDouble("member_bonusRat"));
				member.setRole(rs.getString("role"));
				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 이름 조회
	public List<Member> getMemberList() {
		List<Member> list = new ArrayList<>();
		Member member = null;
		try {
			conn();
			String sql = "SELECT member_name from winemember";
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setMemberPw(rs.getString("member_pw"));
				member.setMemberName(rs.getString("member_name"));
				member.setMemberTel(rs.getString("member_tel"));
				member.setMemberGrade(rs.getString("member_grade"));
				member.setMemeber_bonusRat(rs.getDouble("member_bonusRat"));
				member.setRole(rs.getString("role"));
				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 등급 조회
	public List<Member> getMemberGrade() {
		List<Member> list = new ArrayList<>();
		Member member = null;
		try {
			conn();
			String sql = "SELECT member_name from winemember";
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setMemberPw(rs.getString("member_pw"));
				member.setMemberName(rs.getString("member_name"));
				member.setMemberTel(rs.getString("member_tel"));
				member.setMemberGrade(rs.getString("member_grade"));
				member.setMemeber_bonusRat(rs.getDouble("member_bonusRat"));
				member.setRole(rs.getString("role"));
				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 회원 등급 변경
	public int updateGrade() {
		int result = 0;
		try {
			conn();
			String sql = "UPDATE wineMember set memeber_grade = ? where member_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rs.getString("member_grade"));

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}

	// 회원 삭제
	public int deleteMember() {
		int result = 0;
		try {
			conn();
			String sql = "delete from wineMember where member_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rs.getString("member_id"));
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}

	public String getMemberGrade() {
		return null;
	}

}
