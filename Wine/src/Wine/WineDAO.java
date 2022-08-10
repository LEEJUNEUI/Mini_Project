package Wine;

import java.util.ArrayList;
import java.util.List;

import common.DAO;

public class WineDAO extends DAO {

	private static WineDAO wineDao = null;

	private WineDAO() {

	}

	public static WineDAO getInstance() {
		return wineDao == null ? wineDao = new WineDAO() : wineDao;
	}

	// 6) 와인 등록
	public int insertWine(Wine wine) {
		int result = 0;
		try {
			conn();
			String sql = "insert into product values (?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, wine.getWineName());
			pstmt.setInt(2, wine.getWinePrice());
			pstmt.setString(3, wine.getWineExplain());
			pstmt.setInt(4, wine.getWineSales());
			pstmt.setString(5, wine.getCountry());
			pstmt.setString(6, wine.getVarieties());
			pstmt.setString(7, wine.getType());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}

	// 7-1) 국가별 조회
	public List<Wine> getCountry() {
		List<Wine> list = new ArrayList<>();
		Wine wine = null;
		try {
			conn();
			String sql = "select country from wine";
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				wine = new Wine();
				wine.setCountry(rs.getString("country"));
				list.add(wine);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 7-2) 품종별 조회
	public List<Wine> getVarieties() {
		List<Wine> list = new ArrayList<>();
		Wine wine = null;
		try {
			conn();
			String sql = "select varieties from wine";
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				wine = new Wine();
				wine.setCountry(rs.getString("varieties"));
				list.add(wine);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 7-3) 타입별 조회
	public List<Wine> getType() {
		List<Wine> list = new ArrayList<>();
		Wine wine = null;
		try {
			conn();
			String sql = "select type from wine";
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				wine = new Wine();
				wine.setCountry(rs.getString("type"));
				list.add(wine);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 7-4) 가격별 조회
	public List<Wine> getPrice() {
		List<Wine> list = new ArrayList<>();
		Wine wine = null;
		try {
			conn();
			String sql = "select wine_price from wine";
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				wine = new Wine();
				wine.setCountry(rs.getString("price"));
				list.add(wine);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 7-5) 상세 조회
	public List<Wine> getDetailWine() {
		List<Wine> list = new ArrayList<>();
		Wine wine = null;
		try {
			conn();
			String sql = "select * from wine";
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				wine = new Wine();
				wine.setWineName(rs.getString("wine_name"));
				wine.setWinePrice(rs.getInt("wine_price"));
				wine.setWineExplain(rs.getString("wine_explain"));
				wine.setWineSales(rs.getInt("wine_sales"));
				wine.setCountry(rs.getString("country"));
				wine.setVarieties(rs.getString("varieties"));
				wine.setType(rs.getString("type"));
				list.add(wine);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return list;
	}

	// 8) 와인 판매
	public int getSalesWine(String wineName) {
		int result = 0;
		try {
			conn();
			String sql = "update wine set wine_Sales = wine_sales+1 where wine_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, wineName);
			
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;

	}

	// 9) 와인 수정
	public int changeWine(int winePrice) {
		int result = 0;
		try {
			conn();
			String sql = "update wine set wine_price = ? where wine_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, winePrice);
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return result;
	}
//	
//	// 10 와인 매출
//	public int calWine(String wineSales) {
//		int result = 0;
//		try {
//			conn();
//			String sql = "update wine set wine_Sales = wine_sales+1 where wine_name = ?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, wineSales);
//			
//			result = pstmt.executeUpdate();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			disconnect();
//		}
//		return result;
//
//	}
	

	// 11) 와인 삭제
	public int deleteWine(String wineName) {
		int result = 0;
		try {
			conn();
			String sql = "delete from wine where wine_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, wineName);

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}

}
