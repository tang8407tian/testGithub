package io.renren.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * InnoDB free: 10240 kB
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-05-20 10:58:18
 */
public class RecipeimgEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//美食名字
	private String imgfoodname;
	//图片存储路径
	private String imgfilepath;
	
	
	
	
	


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
	 * 设置：美食名字
	 */
	public void setImgfoodname(String imgfoodname) {
		this.imgfoodname = imgfoodname;
	}
	/**
	 * 获取：美食名字
	 */
	public String getImgfoodname() {
		return imgfoodname;
	}
	/**
	 * 设置：图片存储路径
	 */
	public void setImgfilepath(String imgfilepath) {
		this.imgfilepath = imgfilepath;
	}
	/**
	 * 获取：图片存储路径
	 */
	public String getImgfilepath() {
		return imgfilepath;
	}
}
