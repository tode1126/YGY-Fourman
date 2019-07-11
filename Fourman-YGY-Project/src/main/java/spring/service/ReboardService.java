package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.data.ReboardDao;


@Service
public class ReboardService {
	@Autowired
	private ReboardDao dao;
	
	
	 public int getTotalCount() { return dao.getTotalCount(); }
	
}
