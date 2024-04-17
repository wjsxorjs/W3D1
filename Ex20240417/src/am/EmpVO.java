package am;


public class EmpVO {
	// emp라는 테이블로부터 자원을 가져와서 객체화 시키는 클래스
	// 테이블로부터 가지고 올 컬럼명들을 멤버변수로 선언해야 한다.
	private String empno, ename, job;

	
	
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public void setJob(String job) {
		this.job = job;
	}

	
	
	public String getEmpno() {
		return empno;
	}
	public String getEname() {
		return ename;
	}
	public String getJob() {
		return job;
	}
	
	
	
	
}
