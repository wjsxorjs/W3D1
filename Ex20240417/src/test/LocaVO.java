package test;

public class LocaVO {
	// dept테이블로부터 데이터를 가져와서 객체화 시키기 위해 필요한 클래스
	// dept테이블에서 가져올 컬럼명을 멤버변수로 선언하자
	private String loc_code, city;

	public void setLoc_code(String loc_code) {
		this.loc_code = loc_code;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
	

	public String getLoc_code() {
		return loc_code;
	}

	public String getCity() {
		return city;
	}

	
}
