package spring.service.restraunt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.data.restraunt.RestrauntDao;
import spring.data.restraunt.RestrauntDto;

@Service
public class RestrauntService {
	@Autowired
	private RestrauntDao dao;
	
	public void insertRestraunt(RestrauntDto dto) {
		dao.insertRestraunt(dto);
	}
}
