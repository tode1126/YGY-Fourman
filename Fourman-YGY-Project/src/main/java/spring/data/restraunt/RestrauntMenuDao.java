package spring.data.restraunt;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class RestrauntMenuDao extends SqlSessionDaoSupport{
	public void insertRestrauntMenu(RestrauntMenuDto rmdto) {
		getSqlSession().insert("restraunt.restraunt_menuInsert", rmdto);
	}
}
