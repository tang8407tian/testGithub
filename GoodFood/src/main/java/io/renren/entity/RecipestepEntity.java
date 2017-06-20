package io.renren.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * InnoDB free: 10240 kB
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-05-19 18:54:14
 */
public class RecipestepEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private String foodstep;
	//
	private String foodname;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setFoodstep(String foodstep) {
		this.foodstep = foodstep;
	}
	/**
	 * 获取：
	 */
	public String getFoodstep() {
		return foodstep;
	}
	/**
	 * 设置：
	 */
	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}
	/**
	 * 获取：
	 */
	public String getFoodname() {
		return foodname;
	}
}
