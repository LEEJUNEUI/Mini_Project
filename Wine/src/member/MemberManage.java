package member;

import java.util.ArrayList;
import java.util.List;

import common.DAO;

public class MemberManage extends DAO {
	public static Member mem = null;
	// 싱글톤
	private static MemberManage mm = new MemberManage();

	private MemberManage() {

	}

	public static MemberManage getInstance() {
		return mm;
	}

	// 로그인 메소드
	public Member loginInfo(String id) {
		try {
			conn();
			String sql = "select * from winemember where member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				mem = new Member();
				mem.setMemberId(rs.getString("member_id"));
				mem.setMemberPw(rs.getString("member_pw"));
				mem.setMemberName(rs.getString("member_name"));
				mem.setMemberTel(rs.getString("member_tel"));
				mem.setMemberGrade(rs.getString("member_grade"));
				mem.setMember_saleRat(rs.getDouble("member_saleRat"));
				mem.setRole(rs.getString("role"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return mem;
	}

	// 회원 등록 메소드
	public int registMember(Member member) {
		int result = 0;
		try {
			conn();
			String sql = "insert into winemember (member_id,member_pw, member_name, member_tel,member_grade,member_saleRat, role) values (?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getMemberTel());
			pstmt.setString(5, member.getMemberGrade());
			pstmt.setDouble(6, member.getMember_saleRat());
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
				member.setMember_saleRat(rs.getDouble("member_saleRat"));
				
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
	public List<Member> getMemberList(String name) {
		List<Member> list = new ArrayList<>();
		Member member = null;
		try {
			conn();
			String sql = "SELECT member_id,member_pw,member_name,member_tel,"
					+ "member_grade,member_saleRat from winemember " + "where member_name like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + name + "%");

			rs = pstmt.executeQuery();

			if (rs.next()) {
				member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setMemberPw(rs.getString("member_pw"));
				member.setMemberName(rs.getString("member_name"));
				member.setMemberTel(rs.getString("member_tel"));
				member.setMemberGrade(rs.getString("member_grade"));
				member.setMember_saleRat(rs.getDouble("member_saleRat"));
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
	public List<Member> getMemberGrade(String grade) {
		List<Member> list = new ArrayList<>();
		Member member = null;
		try {
			conn();
			String sql = "SELECT member_name,member_grade,member_saleRat from winemember where member_name like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + grade + "%");

			rs = pstmt.executeQuery();

			if (rs.next()) {
				member = new Member();
				member.setMemberName(rs.getString("member_name"));
				member.setMemberGrade(rs.getString("member_grade"));
				member.setMember_saleRat(rs.getDouble("member_saleRat"));
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
	// 회원 수정
	public int updateGrade(Member member) {
		int result = 0;
		try {
			conn();
			String sql = "update winemember set member_grade = ? , member_saleRat = ?  where member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberGrade());
			pstmt.setDouble(2, member.getMember_saleRat());
			pstmt.setString(3, member.getMemberId());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}

	// 회원 삭제
	public int deleteMember(String memberId) {
		int result = 0;
		try {
			conn();
			String sql = "delete from winemember where member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}

}
