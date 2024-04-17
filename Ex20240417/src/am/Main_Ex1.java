package am;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Main_Ex1 {

	public static void main(String[] args) throws Exception {
		// 환경설정 파일 읽기에 쓰인 스트림 준비
		Reader r = Resources.getResourceAsReader("am/config.xml");
		
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		
		SqlSessionFactory factory = builder.build(r);
		r.close();
		
		SqlSession ss = factory.openSession();
		List<EmpVO> list = ss.selectList("emp.all");
		
		for(int i=0; i<list.size();i++) {
			//리스트에 저장된 VO객체를 하나씩 얻어낸다.
			EmpVO vo = list.get(i);
			System.out.printf("%2s | %-6s | %s\r\n",vo.getEmpno(),vo.getEname(),vo.getJob());
		}
			System.out.printf("%d 명\r\n",list.size());
			ss.close();
	}

}
