package spring.data;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends SqlSessionDaoSupport {
	public int userSelectCount(String email) {
		int n = getSqlSession().selectOne("user.userSelectCount",email);
		return n;
	}
	public UserDto userGradeCheck(String email,String pass) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("email", email);
		map.put("pass",pass);
		UserDto n = getSqlSession().selectOne("user.userGradeCheck", map);
		return n;
	}
}
