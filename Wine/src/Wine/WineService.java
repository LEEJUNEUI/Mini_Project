package Wine;

import java.util.List;
import java.util.Scanner;

public class WineService {

	Scanner scn = new Scanner(System.in);

	// 와인 등록
	public void insertWine() {
		Wine wine = new Wine();
		int result = 0;

		System.out.println("와인명>");
		String wineName = scn.nextLine();
		System.out.println("와인 가격>");
		int winePrice = Integer.parseInt(scn.nextLine());
		System.out.println("와인 설명>");
		String wineExplain = scn.nextLine();
		System.out.println("와인 생산지>");
		String country = scn.nextLine();
		System.out.println("와인 품종>");
		String varieties = scn.nextLine();
		System.out.println("와인 종류>");
		String type = scn.nextLine();
		
		wine.setWineName(wineName);
		wine.setWinePrice(winePrice);
		wine.setWineExplain(wineExplain);
		wine.setCountry(country);
		wine.setVarieties(varieties);
		wine.setType(type);

		result = WineDAO.getInstance().insertWine(wine);

		if (result == 1) {
			System.out.println("등록 성공");

		} else {
			System.out.println("등록 실패");
		}
	}

	// 국가별 조회
	public void getCountry() {
		List<Wine> list = WineDAO.getInstance().getCountry();
		for (Wine wine : list) {
			System.out.println("===============================");
			System.out.println("| 와인 생산지 : " + wine.getCountry() + " |");
			System.out.println("| 와인 이름 : " + wine.getWineName() + " |");
			System.out.println("===============================");
		}
	}

	// 품종별 조회
	public void getVarieties() {
		List<Wine> list = WineDAO.getInstance().getVarieties();
		for (Wine wine : list) {
			System.out.println("===============================");
			System.out.println("| 와인 품종 : " + wine.getVarieties() + " |");
			System.out.println("| 와인 이름 : " + wine.getWineName() + " |");
			System.out.println("===============================");
		}
	}

	// 타입별 조회
	public void getType() {
		List<Wine> list = WineDAO.getInstance().getType();
		for (Wine wine : list) {
			System.out.println("===============================");
			System.out.println("| 와인 종류  : " + wine.getType() + " |");
			System.out.println("| 와인 이름 : " + wine.getWineName() + " |");
			System.out.println("===============================");
		}
	}

	// 가격별 조회
	public void getPrice() {
		List<Wine> list = WineDAO.getInstance().getPrice();
		for (Wine wine : list) {
			System.out.println("===============================");
			System.out.println("| 와인 가격  : " + wine.getWinePrice() + " |");
			System.out.println("| 와인 이름 : " + wine.getWineName() + " |");
			System.out.println("===============================");
		}
	}

	// 상세 조회
	public void getDetailWine() {
		List<Wine> list = WineDAO.getInstance().getDetailWine();
		for (Wine wine : list) {
			System.out.println("*****************************");
			System.out.println("와인 이름> " + wine.getWineName());
			System.out.println("와인 가격 > " + wine.getWinePrice());
			System.out.println("와인 설명> " + wine.getWineExplain());
			System.out.println("와인 판매량> " + wine.getWineSales());
			System.out.println("와인 생산지> " + wine.getCountry());
			System.out.println("와인 품종> " + wine.getVarieties());
			System.out.println("와인 종류> " + wine.getType());
			
			System.out.println("*****************************");
		}
	}

	// 와인 판매
	public void salesWine() {

		System.out.println("메뉴 입력> ");
		String wineName = scn.nextLine();
		System.out.println("수량 입력>");
		int wines = Integer.parseInt(scn.nextLine());
		
		int result = WineDAO.getInstance().getSalesWine(wineName, wines);
		if (result == 1) {
			System.out.println("판매 완료");
		} else {
			System.out.println("판매 실패");
		}
	}

	// 와인 수정
	public void changeWine() {
		System.out.println("수정할 와인>");
		String wineName = scn.nextLine();
		System.out.println("와인 가격 수정>");
		int winePrice = Integer.parseInt(scn.nextLine());

		int result = WineDAO.getInstance().changeWine(wineName, winePrice);
		if (result == 1) {
			System.out.println("수정 완료");
		} else {
			System.out.println("수정 실패");
		}
	}

	// 와인 매출
	public void calWine() {
		List<Wine> list = WineDAO.getInstance().getDetailWine();
		int sum = 0;
		for (Wine wine : list) {
			System.out.println("#######################");
			System.out.println("메뉴 : " + wine.getWineName());
			System.out.println("판매갯수 : " + wine.getWineSales());
			System.out.println("판매금액 : " + wine.getWinePrice() * wine.getWineSales());
			System.out.println("#######################");
			sum += wine.getWinePrice() * wine.getWineSales();
		}
		System.out.println("총 매출액 : " + sum + "원");
	}

	// 와인 삭제
	public void deleteWine() {
		System.out.println("메뉴 입력>");
		String wineName = scn.nextLine();

		int result = WineDAO.getInstance().deleteWine(wineName);
		if (result == 1) {
			System.out.println("삭제 완료");
		} else {
			System.out.println("삭제 실패");
		}
	}
}
