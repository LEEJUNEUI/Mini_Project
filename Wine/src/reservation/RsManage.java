package reservation;

import java.util.ArrayList;
import java.util.List;

import common.DAO;

public class RsManage extends DAO {

	private static RsManage rm = new RsManage();

	private RsManage() {

	}

	public static RsManage getInstance() {
		return rm;
	}
	
	//예약 손님 조회
	public List<Reservation> getRsMemberList() {
		List<Reservation> list = new ArrayList<>();
		Reservation reservation = null;
		try {
			conn();
			String sql = "Select * from reservation";
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				reservation = new Reservation();
				reservation.setRsMemberName(rs.getString("RsMember_name"));
				reservation.setRsMemberTel(rs.getString("RsMember_tel"));
				list.add(reservation);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
	}
	
	// 예약 손님 등록
		public int registRsMember(Reservation reservation) {
			int result = 0;
			try {
				conn();
				String sql = "insert into reservation (Rsmember_name, Rsmember_tel) values (?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, reservation.getRsMemberName());
				pstmt.setString(2, reservation.getRsMemberTel());

				result = pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				disconnect();
			}
			return result;
		}
		
	// 예약 취소
		public int deleteReserve(String memberName) {
		      int result = 0;
		      try {
		         conn();
		         String sql = "delete from reservation where rsmember_name = ?";
		         pstmt = conn.prepareStatement(sql);
		         pstmt.setString(1, memberName);
		         
		         result = pstmt.executeUpdate();
		         
		      } catch(Exception e) {
		         e.printStackTrace();
		      } finally {
		         disconnect();
		      }
		      return result;
		   }
		

	

}
