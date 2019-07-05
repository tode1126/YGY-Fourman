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
	
	public int allUserTotalCount() {
		return dao.allUserTotalCount();
	}
	
	public void UserDisable(String email) {
		dao.UserDisable(email);
		return;
	}
}
