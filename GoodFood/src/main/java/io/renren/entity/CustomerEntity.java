package io.renren.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * InnoDB free: 10240 kB
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-05-19 11:56:33
 */
public class CustomerEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//账号
	private String customerName;
	//密码
	private String customerPassword;
	//重复密码
	private String repeatCustomerPassword;
	
	//邮箱
	private String customweEmail;

	//头像
	private String headimg;
	
	//昵称
	private String nickname;
	
	//喜欢的食谱
	private String likerecipe;
	
	//喜欢的厨具
	private String likekitchenware;
	
	//喜欢的调味品
	private String likeseasoning;
	
	//会员状态（管理员/普通用户）
	private Integer status;
	

	
	
	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public String getCustomerName() {
		return customerName;
	}




	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}




	public String getCustomerPassword() {
		return customerPassword;
	}




	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}




	public String getRepeatCustomerPassword() {
		return repeatCustomerPassword;
	}




	public void setRepeatCustomerPassword(String repeatCustomerPassword) {
		this.repeatCustomerPassword = repeatCustomerPassword;
	}




	public String getCustomweEmail() {
		return customweEmail;
	}




	public void setCustomweEmail(String customweEmail) {
		this.customweEmail = customweEmail;
	}




	public String getHeadimg() {
		return headimg;
	}




	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}




	public String getNickname() {
		return nickname;
	}




	public void setNickname(String nickname) {
		this.nickname = nickname;
	}




	public String getLikerecipe() {
		return likerecipe;
	}




	public void setLikerecipe(String likerecipe) {
		this.likerecipe = likerecipe;
	}




	public String getLikekitchenware() {
		return likekitchenware;
	}




	public void setLikekitchenware(String likekitchenware) {
		this.likekitchenware = likekitchenware;
	}




	public String getLikeseasoning() {
		return likeseasoning;
	}




	public void setLikeseasoning(String likeseasoning) {
		this.likeseasoning = likeseasoning;
	}




	public Integer getStatus() {
		return status;
	}




	public void setStatus(Integer status) {
		this.status = status;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	@Override
	public String toString() {
		return "CustomerEntity [id=" + id + ", customerName=" + customerName + ", customerPassword=" + customerPassword
				+ ", repeatCustomerPassword=" + repeatCustomerPassword + ", customweEmail=" + customweEmail
				+ ", headimg=" + headimg + ", nickname=" + nickname + ", likerecipe=" + likerecipe
				+ ", likekitchenware=" + likekitchenware + ", likeseasoning=" + likeseasoning + ", status=" + status
				+ "]";
	}
	
	
	
	
}
