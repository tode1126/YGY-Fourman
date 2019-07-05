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
	public List<UserDto> leaveUserList(int perPage,int no){
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("perPage", perPage);
		map.put("no",no);
		return getSqlSession().selectList("admin.leaveUserList",map);
	}
	public int allUserTotalCount() {
		return getSqlSession().selectOne("admin.allUserTotalCount");
	}
	public int leaveUserTotalCount() {
		return getSqlSession().selectOne("admin.leaveUserTotalCount");
	}
	public void userEnable(String email) {
		getSqlSession().update("admin.userEnable",email);
		return;
	}
	
	public void userDisable(String email) {
		getSqlSession().update("admin.userDisable",email);
		return;
	}
	public int adminCheck(String email,String pass) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("email", email);
		map.put("pass", pass);
		return getSqlSession().selectOne("admin.adminCheck",map);
	}
}
