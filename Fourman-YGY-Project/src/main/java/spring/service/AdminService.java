package spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.data.AdminDao;
import spring.data.UserDto;

@Service
public class AdminService {
	
	@Autowired
	private AdminDao dao;
	
	public List<UserDto> allUserList(int perPage,int no){
		return dao.allUserList(perPage,no);
	}
	public List<UserDto> leaveUserList(int perPage,int no){
		return dao.leaveUserList(perPage, no);
	}
	public List<UserDto> allFoodUserList(int perPage,int no){
		return dao.allFoodUserList(perPage,no);
	}
	public List<UserDto> leaveFoodUserList(int perPage,int no){
		return dao.leaveFoodUserList(perPage, no);
	}
	public List<UserDto> adminList(int perPage,int no){
		return dao.adminList(perPage, no);
	}
	public int allUserTotalCount() {
		return dao.allUserTotalCount();
	}
	
	public int leaveUserTotalCount() {
		return dao.leaveUserTotalCount();
	}
	public int allFoodUserTotalCount() {
		return dao.allFoodUserTotalCount();
	}
	
	public int leaveFoodUserTotalCount() {
		return dao.leaveFoodUserTotalCount();
	}
	public int adminListTotalCount() {
		return dao.adminListTotalCount();
	}
	public void userEnable(String email) {
		dao.userEnable(email);
		return;
	}
	
	public void userDisable(String email) {
		dao.userDisable(email);
		return;
	}
	
	public int adminCheck(String email) {
		return dao.adminCheck(email);
	}
	
	public void userUpdate(String email) {
		dao.userUpdate(email);
		return;
	}
	
	public void adminUpdate(String email) {
		dao.adminUpdate(email);
		return;
	}
}
