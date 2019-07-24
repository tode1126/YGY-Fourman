package spring.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import spring.data.restaurant.RestaurantDto;

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
		getSqlSession().update("admin.userUpdate", email);
		return;
	}

	public void adminUpdate(String email) {
		getSqlSession().update("admin.adminUpdate", email);
		return;
	}

	public List<UserDto> mailGetList(int target) {
		return getSqlSession().selectList("admin.mailGetList", target);
	}

	public List<UserDto> searchUser(UserSearchDto dto) {
		return getSqlSession().selectList("admin.searchUser", dto);
	}

	public List<UserDto> searchLeaveUser(UserSearchDto dto) {
		return getSqlSession().selectList("admin.searchLeaveUser", dto);
	}

	public List<UserDto> searchFoodUser(UserSearchDto dto) {
		return getSqlSession().selectList("admin.searchFoodUser", dto);
	}

	public List<UserDto> searchLeaveFoodUser(UserSearchDto dto) {
		return getSqlSession().selectList("admin.searchLeaveFoodUser", dto);
	}

	public int searchUserTotalCount(String targetEmail) {
		return getSqlSession().selectOne("admin.searchUserTotalCount", targetEmail);
	}

	public int searchLeaveUserTotalCount(String targetEmail) {
		return getSqlSession().selectOne("admin.searchLeaveUserTotalCount", targetEmail);
	}

	public int searchFoodUserTotalCount(String targetEmail) {
		return getSqlSession().selectOne("admin.searchFoodUserTotalCount", targetEmail);
	}

	public int searchLeaveFoodUserTotalCount(String targetEmail) {
		return getSqlSession().selectOne("admin.searchLeaveFoodUserTotalCount", targetEmail);
	}
	

	public List<RestaurantDto> allFoodList(int perPage, int no) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("perPage",perPage);
		map.put("no",no);
		return getSqlSession().selectList("admin.allFoodList",map);
	}

	public List<RestaurantDto> leaveFoodList(int perPage, int no) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("perPage",perPage);
		map.put("no",no);
		return getSqlSession().selectList("admin.leaveFoodList",map);
	}

	public List<RestaurantDto> searchAllFoodList() {
		return getSqlSession().selectList("admin.searchAllFoodList");
	}

	public List<RestaurantDto> searchLeaveFoodList() {
		return getSqlSession().selectList("admin.searchLeaveFoodList");
	}
	

	public void foodStateChange(RestaurantDto dto) {
		getSqlSession().update("admin.foodStateChange",dto);
		return;
	}

	public void foodLeaveChange(RestaurantDto dto) {
		getSqlSession().update("admin.foodLeaveChange",dto);
		return;
	}
	
	public int allFoodTotalCount() {
		return getSqlSession().selectOne("admin.allFoodTotalCount");
	}
	
	public int leaveFoodTotalCount() {
		return getSqlSession().selectOne("admin.leaveFoodTotalCount");
	}
	
	public int searchAllFoodTotalCount() {
		return getSqlSession().selectOne("admin.searchAllFoodTotalCount");
	}
	
	public int searchLeaveFoodTotalCount() {
		return getSqlSession().selectOne("admin.searchLeaveFoodTotalCount");
	}
	
	public int selectRestaurantCount(int rest_pk) {
		return getSqlSession().selectOne("admin.selectRestaurantCount",rest_pk);
	}
	
	public int userSelectCount(String email) {
		return getSqlSession().selectOne("admin.userSelectCount",email);
	}
}
