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
public class RecipebasicEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//食物名字
	private String foodname;
	//准备时间
	private String preparationtime;
	//制作时间
	private String makingtime;
	
	//难易程度
	private String thedefficulty;
	//分享人数
	private Integer sharenumber;
	//制作人
	private String provider;
	//食品简介
	private String introduce;
	
	//图片存储路径
	private String imgfilepath;
	
	//菜谱类别
	private String recipeType;
	
	
	
	
	
	
	
	@Override
	public String toString() {
		return "RecipebasicEntity [id=" + id + ", foodname=" + foodname + ", preparationtime=" + preparationtime
				+ ", makingtime=" + makingtime + ", thedefficulty=" + thedefficulty + ", sharenumber=" + sharenumber
				+ ", provider=" + provider + ", introduce=" + introduce + ", imgfilepath=" + imgfilepath
				+ ", recipeType=" + recipeType + "]";
	}
	public String getImgfilepath() {
		return imgfilepath;
	}
	public void setImgfilepath(String imgfilepath) {
		this.imgfilepath = imgfilepath;
	}
	/**
	 * 设置：
	 */
	public void setMakingtime(String makingtime) {
		this.makingtime = makingtime;
	}
	/**
	 * 获取：
	 */
	public String getMakingtime() {
		return makingtime;
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
	 * 设置：食物名字
	 */
	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}
	/**
	 * 获取：食物名字
	 */
	public String getFoodname() {
		return foodname;
	}
	/**
	 * 设置：准备时间
	 */
	public void setPreparationtime(String preparationtime) {
		this.preparationtime = preparationtime;
	}
	/**
	 * 获取：准备时间
	 */
	public String getPreparationtime() {
		return preparationtime;
	}
	/**
	 * 设置：难易程度
	 */
	public void setThedefficulty(String thedefficulty) {
		this.thedefficulty = thedefficulty;
	}
	/**
	 * 获取：难易程度
	 */
	public String getThedefficulty() {
		return thedefficulty;
	}
	/**
	 * 设置：分享人数
	 */
	public void setSharenumber(Integer sharenumber) {
		this.sharenumber = sharenumber;
	}
	/**
	 * 获取：分享人数
	 */
	public Integer getSharenumber() {
		return sharenumber;
	}
	/**
	 * 设置：制作人
	 */
	public void setProvider(String provider) {
		this.provider = provider;
	}
	/**
	 * 获取：制作人
	 */
	public String getProvider() {
		return provider;
	}
	/**
	 * 设置：食品简介
	 */
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	/**
	 * 获取：食品简介
	 */
	public String getIntroduce() {
		return introduce;
	}


	public String getRecipeType() {
		return recipeType;
	}


	public void setRecipeType(String recipeType) {
		this.recipeType = recipeType;
	}
	
	
	
}
