package io.renren.entity;

import java.io.Serializable;
import java.util.Date;


public class BlogEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private String customername;
	//
	private String createtimeyear;
	//
	private String createtimemouth;
	//
	private String createtimeday;
	//博客名字
	private String bolgname;
	//博客内容
	private String blog;
	//图片路径
	private String headimg;
	//用户头像
	private String customerImg;
	//简介
	private String summary;

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
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	/**
	 * 获取：
	 */
	public String getCustomername() {
		return customername;
	}
	/**
	 * 设置：
	 */
	public void setCreatetimeyear(String createtimeyear) {
		this.createtimeyear = createtimeyear;
	}
	/**
	 * 获取：
	 */
	public String getCreatetimeyear() {
		return createtimeyear;
	}
	/**
	 * 设置：
	 */
	public void setCreatetimemouth(String createtimemouth) {
		this.createtimemouth = createtimemouth;
	}
	/**
	 * 获取：
	 */
	public String getCreatetimemouth() {
		return createtimemouth;
	}
	/**
	 * 设置：
	 */
	public void setCreatetimeday(String createtimeday) {
		this.createtimeday = createtimeday;
	}
	/**
	 * 获取：
	 */
	public String getCreatetimeday() {
		return createtimeday;
	}
	/**
	 * 设置：
	 */
	public void setBolgname(String bolgname) {
		this.bolgname = bolgname;
	}
	/**
	 * 获取：
	 */
	public String getBolgname() {
		return bolgname;
	}
	/**
	 * 设置：
	 */
	public void setBlog(String blog) {
		this.blog = blog;
	}
	/**
	 * 获取：
	 */
	public String getBlog() {
		return blog;
	}
	/**
	 * 设置：
	 */
	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}
	/**
	 * 获取：
	 */
	public String getHeadimg() {
		return headimg;
	}
	
	
	
	
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getCustomerImg() {
		return customerImg;
	}
	public void setCustomerImg(String customerImg) {
		this.customerImg = customerImg;
	}
	@Override
	public String toString() {
		return "BlogEntity [id=" + id + ", customername=" + customername + ", createtimeyear=" + createtimeyear
				+ ", createtimemouth=" + createtimemouth + ", createtimeday=" + createtimeday + ", bolgname=" + bolgname
				+ ", blog=" + blog + ", headimg=" + headimg + ", customerImg=" + customerImg + "]";
	}
	
	
	
	
	
	
}
