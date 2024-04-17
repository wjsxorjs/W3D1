package test_extra;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Main_Test1 {

	public static void main(String[] args) throws Exception {
		Reader r = Resources.getResourceAsReader("test_extra/config.xml");
		
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		
		SqlSessionFactory factory = builder.build(r);
		
		SqlSession sqlSession = factory.openSession();
		
		
		
		List<DeptLocaVO> list = sqlSession.selectList("deptLoca.all");
		for(int i=0; i<list.size(); i++) {
			DeptLocaVO vo = list.get(i);
			System.out.printf("부서번호: %-5s | 부서명: %-10s | 도시명: %-10s\r\n",vo.getDeptno(),vo.getDname(),vo.getCity());
		}
		
		System.out.println();
		Scanner scan = new Scanner(System.in);
		System.out.print("검색할 부서명 : ");
		
		String dname = scan.nextLine().toUpperCase();
		List<DeptLocaVO> list2 = sqlSession.selectList("deptLoca.search_name",dname);
		
		System.out.printf("[검색한 부서명: %s]\r\n",dname);
		for(int i=0; i<list2.size(); i++) {
			DeptLocaVO vo = list2.get(i);
			System.out.printf("부서번호: %-5s | 부서명: %-10s | 도시명: %-10s\r\n",vo.getDeptno(),vo.getDname(),vo.getCity());
		}
		
		
	}

}
