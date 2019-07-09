package spring.data.restraunt;

import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

public class RestrauntMenuDto {
	private int menu_pk;
	private int restraunt_rest_pk;
	private String menu_category;
	private String menu_name;
	private int menu_price;
	private String menu_desc;
	private String menu_imagefile;
	
	
	public int getMenu_pk() {
		return menu_pk;
	}
	public void setMenu_pk(int menu_pk) {
		this.menu_pk = menu_pk;
	}
	public int getRestraunt_rest_pk() {
		return restraunt_rest_pk;
	}
	public void setRestraunt_rest_pk(int restraunt_rest_pk) {
		this.restraunt_rest_pk = restraunt_rest_pk;
	}
	public String getMenu_category() {
		return menu_category;
	}
	public void setMenu_category(String menu_category) {
		this.menu_category = menu_category;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public int getMenu_price() {
		return menu_price;
	}
	public void setMenu_price(int menu_price) {
		this.menu_price = menu_price;
	}
	public String getMenu_desc() {
		return menu_desc;
	}
	public void setMenu_desc(String menu_desc) {
		this.menu_desc = menu_desc;
	}
	public String getMenu_imagefile() {
		return menu_imagefile;
	}
	public void setMenu_imagefile(String menu_imagefile) {
		this.menu_imagefile = menu_imagefile;
	}
}
