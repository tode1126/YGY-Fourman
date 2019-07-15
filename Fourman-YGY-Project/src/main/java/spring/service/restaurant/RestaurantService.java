package spring.service.restaurant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.data.restaurant.RestaurantDao;
import spring.data.restaurant.RestaurantDto;
import spring.data.restaurant.RestaurantMenuDao;
import spring.data.restaurant.RestaurantMenuDto;

@Service
public class RestaurantService {
	@Autowired
	private RestaurantDao rdao;
	@Autowired
	private RestaurantMenuDao rmdao;
	
	public void insertRestaurant(RestaurantDto dto) {
		rdao.insertRestaurant(dto);
	}
	public int selectRestPkByEmail(String email) {
		int rest_pk = rdao.selectRestPkByEmail(email);
		return rest_pk;
	}
	public List<RestaurantDto> selectRestaurantListByEmail(String email) {
		return rdao.selectRestaurantListByEmail(email);
	}
	public void insertRestaurantMenu(RestaurantMenuDto rmdto) {
		rmdao.insertRestaurantMenu(rmdto);
	}
	public int selectCountRestaurantMenu(int Restaurant_rest_pk) {
		return rmdao.selectCountRestaurantMenu(Restaurant_rest_pk);
	}
	public List<RestaurantMenuDto> selectRestaurantMenu(int Restaurant_rest_pk) {
		return rmdao.selectRestaurantMenu(Restaurant_rest_pk);
	}
}
