package spring.data.restaurant;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class RestaurantIntroDao extends SqlSessionDaoSupport {
	public int selectIsRestaurantIntro (int restaurant_rest_pk) {
		return getSqlSession().selectOne("restaurant.is_restaurant_introCountSelect", restaurant_rest_pk);
	}
	public void insertRestaurantIntro (RestaurantIntroDto ridto) {
		getSqlSession().insert("restaurant_introInsert", ridto);
	}
	public void insertRestaurantIntroImage (RestaurantIntroImageDto riimgdto) {
		getSqlSession().insert("restaurant_intro_imageInsert", riimgdto);
	}
	public RestaurantIntroDto selectOneRestaurantIntro (int restaurant_rest_pk) {
		return getSqlSession().selectOne("restaurant_introOneSelect", restaurant_rest_pk);
	}
	
}
