package spring.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDao extends SqlSessionDaoSupport {
	public List<UserDto> allUserList(int perPage, int no) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("perPage", perPage);
		map.put("no", no);
		return getSqlSession().selectList("admin.allUserList", map);
	}

	public List<UserDto> leaveUserList(int perPage, int no) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("perPage", perPage);
		map.put("no", no);
		return getSqlSession().selectList("admin.leaveUserList", map);
	}

	public List<UserDto> allFoodUserList(int perPage, int no) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("perPage", perPage);
		map.put("no", no);
		return getSqlSession().selectList("admin.allFoodUserList", map);
	}

	public List<UserDto> leaveFoodUserList(int perPage, int no) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("perPage", perPage);
		map.put("no", no);
		return getSqlSession().selectList("admin.leaveFoodUserList", map);
	}
	public List<UserDto> adminList(int perPage, int no) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("perPage", perPage);
		map.put("no", no);
		return getSqlSession().selectList("admin.adminList", map);
	}

	public int allUserTotalCount() {
		return getSqlSession().selectOne("admin.allUserTotalCount");
	}

	public int leaveUserTotalCount() {
		return getSqlSession().selectOne("admin.leaveUserTotalCount");
	}
	
	public int allFoodUserTotalCount() {
		return getSqlSession().selectOne("admin.allFoodUserTotalCount");
	}

	public int leaveFoodUserTotalCount() {
		return getSqlSession().selectOne("admin.leaveFoodUserTotalCount");
	}
	
	public int adminListTotalCount() {
		return getSqlSession().selectOne("admin.adminListTotalCount");
	}

	public void userEnable(String email) {
		getSqlSession().update("admin.userEnable", email);
		return;
	}

	public void userDisable(String email) {
		getSqlSession().update("admin.userDisable", email);
		return;
	}

	public int adminCheck(String email) {
		return getSqlSession().selectOne("admin.adminCheck", email);
	}
	
	public void userUpdate(String email) {
		getSqlSession().update("admin.userUpdate",email);
		return;
	}
	
	public void adminUpdate(String email) {
		getSqlSession().update("admin.adminUpdate",email);
		return;
	}
}
