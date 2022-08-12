package Wine;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.DAO;
import member.MemberManage;

public class WineDAO extends DAO {

	private static WineDAO wineDao = null;

	private WineDAO() {

	}

	public static WineDAO getInstance() {
		if (wineDao == null) {
			wineDao = new WineDAO();
		}
		return wineDao;
	}

	// 6) 와인 등록
	public int insertWine(Wine wine) {
		int result = 0;
		try {
			conn();
			String sql = "insert into wine  values (?,?,?,?,?,?,wine_no_seq.nextval)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, wine.getWineName());
			pstmt.setInt(2, wine.getWinePrice());
			pstmt.setString(3, wine.getWineExplain());
			pstmt.setString(4, wine.getCountry());
			pstmt.setString(5, wine.getVarieties());
			pstmt.setString(6, wine.getType());

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
			String sql = "select wine_name,country from wine";
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				wine = new Wine();
				wine.setCountry(rs.getString("country"));
				wine.setWineName(rs.getString("wine_name"));
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
			String sql = "select wine_name,varieties from wine";
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				wine = new Wine();
				wine.setVarieties(rs.getString("varieties"));
				wine.setWineName(rs.getString("wine_name"));
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
			String sql = "select wine_name,type from wine";
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				wine = new Wine();
				wine.setType(rs.getString("type"));
				wine.setWineName(rs.getString("wine_name"));
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
			String sql = "select wine_name,wine_price from wine";
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				wine = new Wine();
				wine.setWinePrice(rs.getInt("wine_price"));
				wine.setWineName(rs.getString("wine_name"));
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
		ResultSet rs2 = null;

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
				wine.setCountry(rs.getString("country"));
				wine.setVarieties(rs.getString("varieties"));
				wine.setType(rs.getString("type"));
				int sales = 0;
				String sql1 = "select sum(wine_sales) sum from wineorder group by wine_num having wine_num = ?";
				pstmt = conn.prepareStatement(sql1);
				pstmt.setInt(1, rs.getInt("wine_num"));
				rs2 = pstmt.executeQuery();
				if (rs2.next()) {
					sales = rs2.getInt("sum");
				}
				wine.setWineSales(sales);
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
	public int getSalesWine(String wineName, int wines) {
		int result = 0;
		int originalWinePrice = 0;
		double winePrice = 0;
		int wineNum = 0;
		try {
			conn();
			String sql1 = "select wine_price,wine_num from wine where wine_name = ?";
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1, wineName);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				originalWinePrice = rs.getInt("wine_price");
				wineNum = rs.getInt("wine_num");
			}

			winePrice = (1 - MemberManage.mem.getMember_saleRat()) * originalWinePrice;

			String sql2 = "insert into wineorder values(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, wineNum);
			pstmt.setString(2, MemberManage.mem.getMemberName());
			pstmt.setDouble(3, winePrice * wines);
			pstmt.setInt(4, wines);
			pstmt.setInt(5, originalWinePrice * wines);
			pstmt.setDouble(6, MemberManage.mem.getMember_saleRat() * originalWinePrice * wines);
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("없는 와인입니다.");
		} finally {
			disconnect();
		}
		return result;

	}

	// 9) 와인 수정
	public int changeWine(String wineName, int winePrice) {
		int result = 0;
		try {
			conn();
			String sql = "update wine set wine_price = ? where wine_name = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, winePrice);
			pstmt.setString(2, wineName);

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}

	// 11) 와인 삭제
	public int deleteWine(String wineName) {
		int result = 0;
		try {
			conn();
			String sql1 = "delete from wineorder where wine_num = (select wine_num from wine where wine_name = ?)";
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1, wineName);
			result = pstmt.executeUpdate();

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
