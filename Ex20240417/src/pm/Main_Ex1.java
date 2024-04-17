package pm;


import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Main_Ex1 {

	public static void main(String[] args) throws Exception {
		// 환경설정 파일(config.xml)과 연결되는 스트림 준비
		Reader r = Resources.getResourceAsReader("pm/config.xml");
		
		// 우리가 필요한 객체는 SqlSession이다. 이것을 얻어내기 위해
		// SqlSessionFactory를 세워야하고 그러기 위해서는
		// SqlSessionFactoryBuilder가 있어야한다.
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		
		SqlSessionFactory factory = builder.build(r);
		r.close();
		
		// ----------- 위에까지는 한번만 수행하는 것이 유리하다 ------------------- //
		
		// 위에서 만든 공장(Factory)을 통해 SqlSession을 얻는다.	
		SqlSession ss = factory.openSession();
		// 위의 SqlSession이 있어야 그것을 통해 SQL문장을 호출한다.
		
		List<DeptVO> list = ss.selectList("dept.all");
		
		for(int i=0; i<list.size();i++) {
			//리스트에 저장된 VO객체를 하나씩 얻어낸다.
			DeptVO vo = list.get(i);
			System.out.printf("%2s | %-10s | %s\r\n",vo.getDeptno(),vo.getDname(),vo.getLoc_code());
		}
			System.out.printf("%d개 부서\r\n",list.size());
			ss.close();
	}

}
