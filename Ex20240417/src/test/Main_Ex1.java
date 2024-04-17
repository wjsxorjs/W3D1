package test;


import java.io.Reader;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Main_Ex1 {

	public static void main(String[] args) throws Exception {
		// 환경설정 파일(config.xml)과 연결되는 스트림 준비
		Reader r = Resources.getResourceAsReader("test/config.xml"); // < 중요하다.
		
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder(); // 세션을 만들기 위한 팩토리를 만들기 위한 빌더를 생성
		
		SqlSessionFactory factory = builder.build(r); // 세션을 만들기 위한 팩토리를 생성
		
		SqlSession session = factory.openSession(); // 세션을 생성
		
		
		List<LocaVO> list = session.selectList("loca.all");
		System.out.printf("%-2s | %-10s\r\n","code","도시명");
		for(int i=0; i<list.size(); i++) {
			LocaVO vo = list.get(i);
			System.out.printf("%4s | %-10s\r\n",vo.getLoc_code(),vo.getCity());
		}
		
		System.out.println();
		System.out.println();
		
		System.out.print("검색할 도시명: ");
		Scanner scan = new Scanner(System.in);
		String city = scan.nextLine().toUpperCase();
		
		
		
		List<LocaVO> list2 = session.selectList("loca.search_city",city);
		
		System.out.printf("[검색한 도시명 : %s]\r\n", city);
		System.out.printf("%-2s | %-10s\r\n","code","도시명");
		for(int i=0; i<list2.size(); i++) {
			LocaVO vo = list2.get(i);
			System.out.printf("%4s | %-10s\r\n",vo.getLoc_code(),vo.getCity());
		}
		
		
	}

}
