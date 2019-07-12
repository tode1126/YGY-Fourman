package spring.data.restraunt;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class RestrauntMenuDao extends SqlSessionDaoSupport{
	public void insertRestrauntMenu(RestrauntMenuDto rmdto) {
		getSqlSession().insert("restraunt.restraunt_menuInsert", rmdto);
	}
	public int selectCountRestrauntMenu(int restraunt_rest_pk) {
		return getSqlSession().selectOne("restraunt_menuCountSelect", restraunt_rest_pk);
	}
	public List<RestrauntMenuDto> selectRestrauntMenu(int restraunt_rest_pk) {
		return getSqlSession().selectList("restraunt_menuSelect", restraunt_rest_pk);
	}
}
