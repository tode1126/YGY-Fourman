package spring.data.restraunt;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class RestrauntDao extends SqlSessionDaoSupport {
	public void insertRestraunt(RestrauntDto dto) {
		getSqlSession().insert("restraunt.restrauntInsert", dto);
	}
	
	public int selectRestPkByEmail(String email) {
		int rest_pk = getSqlSession().selectOne("restraunt.restraunt_pkByEmailSelect", email);
		return rest_pk;
	}
}
