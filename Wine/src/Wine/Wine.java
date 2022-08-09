package Wine;

//1. 개별 조회( 국가 입력 ->품종 -> 레드,화이트 -> 가격대 입력->출력)
//2. 국가별 와인 특징 (프랑스, 이탈리아, 미국, 칠레)
//3. 국가별 최고가, 최저가, 최고평점, 최저평점
//4. 와인 추가
//5. 와인 삭제
//6. 종료
public class Wine {
	
	private String wineMenu; //와인 메뉴
	private int winePrice; //와인 가격
	private String wineExplain; //와인 설명
	private int wineSales; //와인 판매량
	private String country;	//국가
	private String varieties; //품종
	private String stores; // 판매처
	
	public String getWineMenu() {
		return wineMenu;
	}
	public void setWineMenu(String wineMenu) {
		this.wineMenu = wineMenu;
	}
	public int getWinePrice() {
		return winePrice;
	}
	public void setWinePrice(int winePrice) {
		this.winePrice = winePrice;
	}
	public String getWineExplain() {
		return wineExplain;
	}
	public void setWineExplain(String wineExplain) {
		this.wineExplain = wineExplain;
	}
	public int getWineSales() {
		return wineSales;
	}
	public void setWineSales(int wineSales) {
		this.wineSales = wineSales;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getVarieties() {
		return varieties;
	}
	public void setVarieties(String varieties) {
		this.varieties = varieties;
	}
	public String getStores() {
		return stores;
	}
	public void setStores(String stores) {
		this.stores = stores;
	}
}