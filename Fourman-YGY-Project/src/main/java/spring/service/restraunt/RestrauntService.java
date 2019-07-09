package spring.service.restraunt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.data.restraunt.RestrauntDao;
import spring.data.restraunt.RestrauntDto;
import spring.data.restraunt.RestrauntMenuDao;
import spring.data.restraunt.RestrauntMenuDto;

@Service
public class RestrauntService {
	@Autowired
	private RestrauntDao rdao;
	@Autowired
	private RestrauntMenuDao rmdao;
	
	public void insertRestraunt(RestrauntDto dto) {
		rdao.insertRestraunt(dto);
	}
	public int selectRestPkByEmail(String email) {
		int rest_pk = rdao.selectRestPkByEmail(email);
		return rest_pk;
	}
	public void insertRestrauntMenu(RestrauntMenuDto rmdto) {
		rmdao.insertRestrauntMenu(rmdto);
	}
}
