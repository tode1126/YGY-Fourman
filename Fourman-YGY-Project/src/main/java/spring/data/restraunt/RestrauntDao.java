package spring.data.restraunt;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class RestrauntDao extends SqlSessionDaoSupport {
	public void insertRestraunt(RestrauntDto dto) {
		getSqlSession().insert("restraunt.restrauntInsert", dto);
	}
}
