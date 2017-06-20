package io.renren.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * InnoDB free: 10240 kB
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-05-20 10:57:52
 */
public class CommentEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//食品名字
	private String foodname;
	//博客名字
	private String articlename;
	//发表人名字
	private String customername;
	//评论
	private String comment;
	//发布时间
	private String createTime;
	
	//用户头像
	private String customerimg;

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
	/**
	 * 设置：博客名字
	 */
	public void setArticlename(String articlename) {
		this.articlename = articlename;
	}
	/**
	 * 获取：博客名字
	 */
	public String getArticlename() {
		return articlename;
	}
	/**
	 * 设置：发表人名字
	 */
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	/**
	 * 获取：发表人名字
	 */
	public String getCustomername() {
		return customername;
	}
	/**
	 * 设置：评论
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	/**
	 * 获取：评论
	 */
	public String getComment() {
		return comment;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	
	public String getCustomerimg() {
		return customerimg;
	}
	public void setCustomerimg(String customerimg) {
		this.customerimg = customerimg;
	}
	@Override
	public String toString() {
		return "CommentEntity [id=" + id + ", foodname=" + foodname + ", articlename=" + articlename + ", customername="
				+ customername + ", comment=" + comment + ", createTime=" + createTime + "]";
	}

	
	
	
	
	
	
}
