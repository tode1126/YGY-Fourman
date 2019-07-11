package spring.data;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository  //xml 에 자동 등록
public class ReboardDao extends SqlSessionDaoSupport{
	public int getTotalCount()
	{
		int n=getSqlSession().selectOne("reboard.reboardTotalCount");
		return n;
	}
}
