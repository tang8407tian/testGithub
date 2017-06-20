package io.renren.entity;

import java.io.Serializable;
import java.util.Date;


public class RecipematerailEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//原料名字
	private String materailname;
	//原料用量
	private String meterailnumber;
	//食品名字
	private String foodname;

	
	
	
	public RecipematerailEntity() {
		super();
	}
	public RecipematerailEntity(String materailname, String meterailnumber, String foodname) {
		super();
		this.materailname = materailname;
		this.meterailnumber = meterailnumber;
		this.foodname = foodname;
	}
	public RecipematerailEntity(String foodname) {
		super();
		this.foodname = foodname;
	}
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
	 * 设置：原料名字
	 */
	public void setMaterailname(String materailname) {
		this.materailname = materailname;
	}
	/**
	 * 获取：原料名字
	 */
	public String getMaterailname() {
		return materailname;
	}
	/**
	 * 设置：原料用量
	 */
	public void setMeterailnumber(String meterailnumber) {
		this.meterailnumber = meterailnumber;
	}
	/**
	 * 获取：原料用量
	 */
	public String getMeterailnumber() {
		return meterailnumber;
	}
	/**
	 * 设置：食品名字
	 */
	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}
	/**
	 * 获取：食品名字
	 */
	public String getFoodname() {
		return foodname;
	}
}
