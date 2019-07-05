package spring.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDao extends SqlSessionDaoSupport {
	public List<UserDto> allUserList(int perPage,int no){
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("perPage", perPage);
		map.put("no",no);
		return getSqlSession().selectList("admin.allUserList",map);
	}
	public int allUserTotalCount() {
		return getSqlSession().selectOne("admin.allUserTotalCount");
	}
	
	public void UserDisable(String email) {
		getSqlSession().update("admin.UserDisable",email);
		return;
	}
}
